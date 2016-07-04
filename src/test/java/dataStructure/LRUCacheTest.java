package dataStructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/25/2016.
 */
public class LRUCacheTest {

    LRUCache<Integer,Integer> cache;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void get() throws Exception {
        cache = new LRUCache<>(12);
        for (int i = 0; i < 12; i++) {
            cache.set(i, i);
        }
        cache.set(6, 6);
        cache.set(8, 8);
        Set<Map.Entry<Integer, Integer>> entries = cache.entrySet();

        Integer[] results = new Integer[]{0,1,2,3,4,5,7,9,10,11,6,8,12,15};
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : entries) {
            assertEquals(results[index++], entry.getKey());
        }
        cache.set(12, 12);
        cache.set(15, 15);
        index = 2;
        for (Map.Entry<Integer, Integer> entry : entries) {
            assertEquals(results[index++], entry.getKey());
        }
    }

}