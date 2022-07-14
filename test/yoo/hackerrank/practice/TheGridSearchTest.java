package yoo.hackerrank.practice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import yoo.hackerrank.practice.testcase.TheGridSearchTestCase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TheGridSearchTest {

    @Test
    @DisplayName("첫번째 예제")
    void 첫번째_예제() {
        List<String> grid = TheGridSearchTestCase.getGridFirstExample();
        List<String> pattern = TheGridSearchTestCase.getPatternFirstExample();

        String result = TheGridSearch.searchGrid(grid, pattern);
        assertEquals(result, "YES");
    }

    @Test
    @DisplayName("두번째 예제")
    void 두번쨰_예제() {
        List<String> grid = TheGridSearchTestCase.getGridSecondExample();
        List<String> pattern = TheGridSearchTestCase.getPatternSecondExample();

        String result = TheGridSearch.searchGrid(grid, pattern);
        assertEquals(result, "NO");
    }

    @Test
    @DisplayName("세번째 예제")
    void 세번쨰_예제() {
        List<String> grid = TheGridSearchTestCase.getGridThirdExample();
        List<String> pattern = TheGridSearchTestCase.getPatternThirdExample();

        String result = TheGridSearch.searchGrid(grid, pattern);
        assertEquals(result, "NO");
    }

    @Test
    @DisplayName("네번째 예제")
    void 네번째_예제() {
        List<String> grid = TheGridSearchTestCase.getGridFourthExample();
        List<String> pattern = TheGridSearchTestCase.getPatternFourthExample();

        String result = TheGridSearch.searchGrid(grid, pattern);
        assertEquals(result, "YES");
    }
}