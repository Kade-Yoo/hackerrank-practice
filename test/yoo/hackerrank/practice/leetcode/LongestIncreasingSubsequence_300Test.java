package yoo.hackerrank.practice.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yoo.hackerrank.practice.testcase.LongestIncreasingSubsequenceTestCase;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequence_300Test {

    private LongestIncreasingSubsequence_300 longestIncreasingSubsequence300;

    @BeforeEach
    void init() {
        longestIncreasingSubsequence300 = new LongestIncreasingSubsequence_300();
    }

    @Test
    void 첫번째_예제() {
        int result = longestIncreasingSubsequence300.lengthOfLIS(LongestIncreasingSubsequenceTestCase.testCase1);
        assertEquals(4, result);
    }

    @Test
    void 두번째_예제() {
        int result = longestIncreasingSubsequence300.lengthOfLIS(LongestIncreasingSubsequenceTestCase.testCase2);
        assertEquals(4, result);
    }

    @Test
    void 세번째_예제() {
        int result = longestIncreasingSubsequence300.lengthOfLIS(LongestIncreasingSubsequenceTestCase.testCase3);
        assertEquals(1, result);
    }
}