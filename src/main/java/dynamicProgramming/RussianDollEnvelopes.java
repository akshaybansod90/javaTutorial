package dynamicProgramming;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by Akshay on 6/12/2016.
 */
public class RussianDollEnvelopes {


    private static Map<int[], Integer> memo = new HashMap<>();

    public static int getMaxEnvelopes(int[][] envelopes){

        for (int i = 0; i < envelopes.length; i++) {
            
        }

        return 0;
    }

    public static int getMax(int[][] envelopes,int[] parent){

        return 0;
    }


    public static int maxEnvelopes(int[][] envelopes) throws Exception {
        Arrays.sort(envelopes,(o1, o2) -> {
            int diff = o1[0] - o2[0];
            if (diff == 0) {
                diff = o1[1] - o2[1];
            }
            return diff;
        });
        Map<int[], Integer> memo = new HashMap<>();
        Integer overallMax = 0;
        for (int i = 0; i < envelopes.length; i++) {
            int[] outerEnvelop =  envelopes[i];
            Integer max = 0;
            for (int j = i - 1; j >= 0; j--) {
                int[] innerEnvelop = envelopes[j];
                if (outerEnvelop[0]>innerEnvelop[0] && outerEnvelop[1]>innerEnvelop[1]) {
                    Integer cost = memo.get(innerEnvelop);
                    if (max < cost) {
                        max = cost;
                    }
                }
            }
            max++; // including outer envelop
            memo.put(outerEnvelop, max);
            if (overallMax < max) {
                overallMax = max;
            }
        }
        return overallMax;
    }

}
