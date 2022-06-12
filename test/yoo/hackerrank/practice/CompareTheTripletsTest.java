package yoo.hackerrank.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareTheTripletsTest {

    private CompareTheTriplets compareTheTriplets;

    @BeforeEach
    public void init() {
        compareTheTriplets = new CompareTheTriplets();
    }

    @Test
    @DisplayName("밥이 1번 더 큰 점수로 이겼을 때 성공")
    public void 밥이_1번_이김_O() {
        // given
        List<Integer> aliceScores = Arrays.asList(3, 4, 5);
        List<Integer> bobScores = Arrays.asList(4, 4, 5);

        // when
        List<Integer> result = compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertEquals(Arrays.asList(0, 1), result);
    }

    @Test
    @DisplayName("밥이 1번 더 큰 점수로 이겼을 때 실패")
    public void 밥이_1번_이김_X() {
        // given
        List<Integer> aliceScores = Arrays.asList(3, 4, 5);
        List<Integer> bobScores = Arrays.asList(4, 4, 5);

        // when
        List<Integer> result = compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertEquals(Arrays.asList(1, 0), result);
    }

    @Test
    @DisplayName("밥이 2번 더 큰 점수로 이겼을 때")
    public void 밥이_2번_이김_O() {
        // given
        List<Integer> aliceScores = Arrays.asList(3, 4, 5);
        List<Integer> bobScores = Arrays.asList(4, 5, 5);

        // when
        List<Integer> result = compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertEquals(Arrays.asList(0, 2), result);
    }

    @Test
    @DisplayName("밥이 2번 더 큰 점수로 이겼을 때")
    public void 밥이_2번_이김_X() {
        // given
        List<Integer> aliceScores = Arrays.asList(3, 4, 5);
        List<Integer> bobScores = Arrays.asList(4, 5, 5);

        // when
        List<Integer> result = compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertEquals(Arrays.asList(1, 2), result);
    }
}