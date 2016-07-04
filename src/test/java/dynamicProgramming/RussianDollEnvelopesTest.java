package dynamicProgramming;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/18/2016.
 * [5,4],[6,4],[6,7],[2,3]
 */
public class RussianDollEnvelopesTest {

    int[][] input ;

    @Before
    public void setUp(){
        try {
            Scanner read = new Scanner(new File("src/test/resources/RussianDollInput.txt"));
            List<Integer[]> list = new ArrayList<>();
            while (read.hasNext()) {
                Integer[] envelop = new Integer[2];
                envelop[0] = read.nextInt();
                envelop[1] = read.nextInt();
                list.add(envelop);
            }
            int size = list.size();

            input = new int[size][2];

            for (int i = 0; i < input.length; i++) {
                input[i][0] = list.get(i)[0];
                input[i][1] = list.get(i)[1];
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void maxEnvelopes() throws Exception {
      // int max = RussianDollEnvelopes.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
       // assertEquals(max,3);
    }

    @Test
    public void getMaxEnvelop() throws Exception {
        System.out.println(RussianDollEnvelopes.maxEnvelopes(input));
    }

}