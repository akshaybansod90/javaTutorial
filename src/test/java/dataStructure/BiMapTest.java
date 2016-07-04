package dataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/26/2016.
 */
public class BiMapTest {

    @Test
    public void biMapTest() {
        BiMap<Integer, String> biMap = new BiMap<>();
        biMap.put(1, "1");
        biMap.put(2, "2");
        biMap.put(3, "3");
        biMap.put(1, "1-New");
        System.out.println(biMap.size());
    }

}