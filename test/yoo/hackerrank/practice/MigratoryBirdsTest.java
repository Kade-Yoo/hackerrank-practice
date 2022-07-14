package yoo.hackerrank.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yoo.hackerrank.practice.testcase.MigratoryBirdsTestCase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("MigratoryBirds테스트")
class MigratoryBirdsTest {

    @Test
    @DisplayName("샘플 예제 1")
    void 샘플_예제_1() {
        List<Integer> firstSample = MigratoryBirdsTestCase.createFirstSample();
        int fristSampleResult = MigratoryBirds.migratoryBirds(firstSample);
        assertEquals(fristSampleResult, 4);
    }

    @Test
    @DisplayName("샘플 예제 2")
    void 샘플_예제_2() {
        List<Integer> secondSample = MigratoryBirdsTestCase.createSecondSample();
        int secondSampleResult = MigratoryBirds.migratoryBirds(secondSample);
        assertEquals(secondSampleResult, 3);
    }
}