package dataStructure;

import javafx.beans.binding.ObjectExpression;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Akshay on 6/12/2016.
 */
public class BiMap<K, V> implements Map<K, V> {

    private final float LOAD_FACTOR;
    private int capacity = 16;
    private int size = 0;

    private BiEntry<K, V> entrySetKey[];
    private BiEntry<V, K> entrySetValue[];

    public BiMap() {
        this(16);
    }

    public BiMap(int capacity) {
        this(capacity, .75f);
    }

    public BiMap(int capacity, float LOAD_FACTOR) {
        this.capacity = capacity;
        this.LOAD_FACTOR = LOAD_FACTOR;
        entrySetKey = new BiEntry[capacity];
        entrySetValue = new BiEntry[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int entryIndex = Objects.hashCode(key) % capacity;
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        int i = hash(key) & (entrySetKey.length - 1);
        return entrySetKey[i] == null ? null : entrySetKey[i].value;
    }

    @Override
    public V put(K key, V value) {
        return putVal(key, value);
    }

    private V putVal(K key, V value) {
        int keyHash = hash(key);
        BiEntry<K, V> entry;
        int n = this.entrySetKey.length;
        int i = keyHash & (n - 1);
        if ((entry = entrySetKey[i]) == null) {
            entrySetKey[i] = new BiEntry<>(keyHash, key, value, null);
        } else {
            BiEntry<K, V> p;
            if (entry.hash == keyHash && Objects.equals(key, entry.key)) {
                p = entry;
            } else {
                while (true) {
                    if ((p = entry.next) == null) {
                        entry.next = new BiEntry<>(keyHash, key, value, null);
                        break;
                    }
                    if (p.hash == keyHash && Objects.equals(key, p.key)) {
                        break;
                    }
                    entry = p;
                }
            }
            if (p != null) {
                V oldValue = p.value;
                p.value = value;
                return oldValue;
            }
        }
        ++size;
        return null;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    final class BiEntry<K, V> implements Entry<K, V> {
        final int hash;
        private final K key;
        private V value;
        BiEntry<K, V> next;

        public BiEntry(int hash, K key, V value, BiEntry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V prev = this.value;
            this.value = value;
            return prev;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BiEntry<?, ?> biEntry = (BiEntry<?, ?>) o;

            if (key != null ? !key.equals(biEntry.key) : biEntry.key != null) return false;
            return value != null ? value.equals(biEntry.value) : biEntry.value == null;

        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }

}
