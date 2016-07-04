package math;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/12/2016.
 */
public class SumOfFibonacciTest {
    @Test
    public void sumOfFibo() throws Exception {
        assertTrue(SumOfFibonacci.sumOfFibo(4)==7);
        assertTrue(SumOfFibonacci.sumOfFibo(3)==4);
    }

}