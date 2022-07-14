package yoo.hackerrank.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yoo.hackerrank.practice.testcase.OrganizingContainersOfBallsTestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("OrganizingContainersOfBalls")
class OrganizingContainersOfBallsTest {

    @Test
    @DisplayName("샘플 예제 1")
    void 샘플_예제_1() {
        List<List<Integer>> containerByFirstExample = OrganizingContainersOfBallsTestCase.createContainerByFirstExample();
        String result = OrganizingContainersOfBalls.organizingContainers(containerByFirstExample);
        assertEquals(result, "Impossible");
    }

    @Test
    @DisplayName("샘플 예제 2")
    void 샘플_예제_2() {
        List<List<Integer>> containerBySecondExample = OrganizingContainersOfBallsTestCase.createContainerBySecondExample();
        String result = OrganizingContainersOfBalls.organizingContainers(containerBySecondExample);
        assertEquals(result, "Possible");
    }

    @Test
    @DisplayName("샘플 예제 3")
    void 샘플_예제_3() {
        List<List<Integer>> containerThirdExample = OrganizingContainersOfBallsTestCase.createContainerThirdExample();
        String result = OrganizingContainersOfBalls.organizingContainers(containerThirdExample);
        assertEquals(result, "Possible");
    }
}