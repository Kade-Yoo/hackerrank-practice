package yoo.hackerrank.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("MigratoryBirds테스트")
class MigratoryBirdsTest {

    @Test
    @DisplayName("샘플 예제 1")
    void 샘플_예제_1() {
        List<Integer> firstSample = createFirstSample();
        int fristSampleResult = MigratoryBirds.migratoryBirds(firstSample);
        assertEquals(fristSampleResult, 4);
    }

    @Test
    @DisplayName("샘플 예제 2")
    void 샘플_예제_2() {
        List<Integer> secondSample = createSecondSample();
        int secondSampleResult = MigratoryBirds.migratoryBirds(secondSample);
        assertEquals(secondSampleResult, 3);
    }

    List<Integer> createFirstSample() {
        return new ArrayList<>(Arrays.asList(1, 4 ,4 ,4 ,5 ,3));
    }

    List<Integer> createSecondSample() {
        return new ArrayList<>(Arrays.asList(1 ,2 ,3 ,4 ,5 ,4 ,3 ,2 ,1 ,3 ,4));
    }
}