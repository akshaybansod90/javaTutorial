package math;

/**
 * Created by Akshay on 6/12/2016.
 */
public class SumOfFibonacci {

    public static int sumOfFibo(int limit){

        int a=0,b=1,sum=1;
        while (a+b<limit){
            b = a + b;
            a = b-a;
            sum += b;
        }
        return sum;
    }
}
