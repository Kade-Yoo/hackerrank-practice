package yoo.hackerrank.practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CompareTheTripletsTest {

    private CompareTheTriplets compareTheTriplets;

    @BeforeEach
    public void init() {
        compareTheTriplets = new CompareTheTriplets();
    }

    @Test
    @DisplayName("밥이 1번 더 좋은 등급을 받았을 때 성공")
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
    @DisplayName("밥이 1번 더 좋은 등급을 받았을 때 실패")
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
    @DisplayName("밥이 2번 더 좋은 등급을 받았을 때")
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
    @DisplayName("밥이 2번 더 좋은 등급을 받았을 때")
    public void 밥이_2번_이김_X() {
        // given
        List<Integer> aliceScores = Arrays.asList(3, 4, 5);
        List<Integer> bobScores = Arrays.asList(4, 5, 5);

        // when
        List<Integer> result = compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    @DisplayName("앨리스 1번 밥 2번 더 좋은 등급을 받았을 때")
    public void 앨리스_1번_밥_2번_좋은_등급_O() {
        // given
        List<Integer> aliceScores = Arrays.asList(5, 4, 5);
        List<Integer> bobScores = Arrays.asList(4, 5, 6);

        // when
        List<Integer> result = compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertEquals(Arrays.asList(1, 2), result);
    }

    @Test
    @DisplayName("앨리스 1번 밥 2번 더 좋은 등급을 받았을 때")
    public void 앨리스_1번_밥_2번_좋은_등급_X() {
        // given
        List<Integer> aliceScores = Arrays.asList(5, 4, 5);
        List<Integer> bobScores = Arrays.asList(4, 5, 6);

        // when
        List<Integer> result = compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertEquals(Arrays.asList(2, 1), result);
    }

    @Test
    @DisplayName("앨리스가 예외 등급을 받았을 때")
    public void 앨리스가_조건에맞지않은_등급() {
        // given
        List<Integer> aliceScores = Arrays.asList(0, 4, 5);
        List<Integer> bobScores = Arrays.asList(4, 5, 6);

        // when
        Executable executable = () -> compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertThrows(RuntimeException.class, executable);
    }

    @Test
    @DisplayName("밥이 예외 등급을 받았을 때")
    public void 밥이_조건에맞지않은_등급() {
        // given
        List<Integer> aliceScores = Arrays.asList(3, 4, 5);
        List<Integer> bobScores = Arrays.asList(0, 5, 6);

        // when
        Executable executable = () -> compareTheTriplets.compareTriplets(aliceScores, bobScores);

        // then
        assertThrows(RuntimeException.class, executable);
    }
}