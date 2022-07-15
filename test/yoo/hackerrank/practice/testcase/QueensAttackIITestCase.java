package yoo.hackerrank.practice.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensAttackIITestCase {

    public static List<List<Integer>> createSecondExample() {
        List<List<Integer>> obstacles = new ArrayList<>();
        obstacles.add(Arrays.asList(5, 5));
        obstacles.add(Arrays.asList(4, 2));
        obstacles.add(Arrays.asList(2, 3));
        return obstacles;
    }
}
