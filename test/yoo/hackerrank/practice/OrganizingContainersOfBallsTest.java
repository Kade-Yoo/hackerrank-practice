package yoo.hackerrank.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("OrganizingContainersOfBalls")
class OrganizingContainersOfBallsTest {

    @Test
    @DisplayName("샘플 예제 1")
    void 샘플_예제_1() {
        List<List<Integer>> containerByFirstExample = createContainerByFirstExample();
        String result = OrganizingContainersOfBalls.organizingContainers(containerByFirstExample);
        assertEquals(result, "Impossible");
    }

    @Test
    @DisplayName("샘플 예제 2")
    void 샘플_예제_2() {
        List<List<Integer>> containerBySecondExample = createContainerBySecondExample();
        String result = OrganizingContainersOfBalls.organizingContainers(containerBySecondExample);
        assertEquals(result, "Possible");
    }

    @Test
    @DisplayName("샘플 예제 3")
    void 샘플_예제_3() {
        List<List<Integer>> containerThirdExample = createContainerThirdExample();
        String result = OrganizingContainersOfBalls.organizingContainers(containerThirdExample);
        assertEquals(result, "Possible");
    }

    List<List<Integer>> createContainerThirdExample() {
        List<List<Integer>> container = new ArrayList<>();
        container.add(Arrays.asList(1, 1));
        container.add(Arrays.asList(1, 1));
        return container;
    }

    List<List<Integer>> createContainerByFirstExample() {
        List<List<Integer>> container = new ArrayList<>();
        container.add(Arrays.asList(1, 3 ,1));
        container.add(Arrays.asList(2, 1 ,2));
        container.add(Arrays.asList(3, 3 ,3));
        return container;
    }

    List<List<Integer>> createContainerBySecondExample() {
        List<List<Integer>> container = new ArrayList<>();
        container.add(Arrays.asList(0, 2, 1));
        container.add(Arrays.asList(1, 1, 1));
        container.add(Arrays.asList(2, 0, 0));
        return container;
    }
}