package yoo.hackerrank.practice.testcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrganizingContainersOfBallsTestCase {

    public static List<List<Integer>> createContainerThirdExample() {
        List<List<Integer>> container = new ArrayList<>();
        container.add(Arrays.asList(1, 1));
        container.add(Arrays.asList(1, 1));
        return container;
    }

    public static List<List<Integer>> createContainerByFirstExample() {
        List<List<Integer>> container = new ArrayList<>();
        container.add(Arrays.asList(1, 3 ,1));
        container.add(Arrays.asList(2, 1 ,2));
        container.add(Arrays.asList(3, 3 ,3));
        return container;
    }

    public static List<List<Integer>> createContainerBySecondExample() {
        List<List<Integer>> container = new ArrayList<>();
        container.add(Arrays.asList(0, 2, 1));
        container.add(Arrays.asList(1, 1, 1));
        container.add(Arrays.asList(2, 0, 0));
        return container;
    }
}
