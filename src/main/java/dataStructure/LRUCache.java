package dataStructure;

import java.util.*;

/**
 * Created by Akshay on 6/24/2016.
 */
public class LRUCache<K,V>{
    private final int CAPACITY;
    private LinkedHashMap<K,V> cache;

    public LRUCache(int capacity) {
        CAPACITY = capacity;
        cache = new LinkedHashMap<K, V>(CAPACITY+1,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
                return size()>CAPACITY;
            }
        };
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void set(K key, V value) {
        cache.put(key, value);
    }

    public Set<Map.Entry<K, V>> entrySet(){
        return cache.entrySet();
    }


}
