package dataStructure.graph.problems;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/14/2016.
 */
public class CityPlannerTest {

    CityPlanner planner ;

    @Before
    public void setUp() throws Exception {
        planner = new CityPlanner(7);
        planner.buildRoad(0, 1);
        planner.buildRoad(0, 2);
        planner.buildRoad(1, 2);
        planner.buildRoad(6, 3);
        planner.buildRoad(5, 4);
        planner.buildRoad(3, 1);
    }

    @Test
    public void isRoadExist() throws Exception {
        assertTrue(planner.isRoadExist(0,6));
    }

}