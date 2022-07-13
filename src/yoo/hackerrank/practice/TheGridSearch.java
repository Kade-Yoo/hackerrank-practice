package yoo.hackerrank.practice;

import java.util.List;

/**
 * The Grid Search
 *
 * Function Description
 * string G[R]: the grid to search
 * string P[r]: the pattern to search for
 *
 * Input Format
 *
 * The first line contains an integer t, the number of test cases.
 *
 * Each of the t test cases is represented as follows:
 * The first line contains two space-separated integers R and C, the number of rows in the search grid G and the length of each row string.
 * This is followed by R lines, each with a string of C digits that represent the grid .
 * The following line contains two space-separated integers, r and c, the number of rows in the pattern grid P and the length of each pattern row string.
 * This is followed by r lines, each with a string of c digits that represent the pattern grid P.
 *
 * Returns
 * string: either YES or NO
 *
 * Constraints
 * 1 <= t <= 5
 * 1 <= R, r, C, c <= 1000
 * 1 <= r <= R
 * 1 <= c <= C
 */
public class TheGridSearch {

    public static String searchGrid(List<String> grid, List<String> pattern) {
        TheGridSearchInput theGridSearchInput = new TheGridSearchInput(grid, pattern);

        for (int gridIdx = 0; gridIdx < theGridSearchInput.getGridSize(); gridIdx++) {
            if (isContainPatternInnerGridByPosition(theGridSearchInput.getGridSize(), theGridSearchInput.getPatternSize(), gridIdx)) {
                return YesOrNo.NO.getDescription();
            }

            char[] chars = theGridSearchInput.getGridCharsByIdx(gridIdx);
            int gridCharsSizeByIdx = theGridSearchInput.getGridCharsSizeByIdx(gridIdx);
            for (int gridCharIdx = 0; gridCharIdx < gridCharsSizeByIdx; gridCharIdx++) {
                if (chars[gridCharIdx] != theGridSearchInput.getFirstRowAndFirstColumCharOfPattern()) {
                    continue;
                }

                if (isContainPatternInnerGridByPosition(gridCharsSizeByIdx ,theGridSearchInput.getFirstRowSizeOfPattern() ,gridCharIdx)) {
                    break;
                }

                if (isContainPatternInnerGrid(theGridSearchInput, gridIdx, gridCharIdx)) {
                    return YesOrNo.YES.getDescription();
                }
            }
        }

        return YesOrNo.NO.getDescription();
    }

    /**
     * Grid 내부에 Pattern이 포함되어 있는지 여부 조회
     *
     * @param theGridSearchInput grid, pattern
     * @param gridIdx grid 인덱스
     * @param gridCharIdx grid 문자열 idx
     * @return Grid 내부에 Pattern이 포함되어 있는지 여부
     */
    private static boolean isContainPatternInnerGrid(TheGridSearchInput theGridSearchInput, int gridIdx, int gridCharIdx) {
        for (int patternIdx = 0; patternIdx < theGridSearchInput.getPatternSize(); patternIdx++) {
            char[] patternChars = theGridSearchInput.getPatternCharsByIdx(patternIdx);
            for (int patternCharIdx = 0; patternCharIdx < theGridSearchInput.getPatternCharsSizeByIdx(patternIdx); patternCharIdx++) {
                if (patternChars[patternCharIdx] != theGridSearchInput.getGridRowCharByIdx(gridIdx + patternIdx, gridCharIdx + patternCharIdx)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Grid의 특정 위치에서 Pattern이 속할 수 있는지 여부 확인
     *
     * @param gridSize grid 사이즈
     * @param patternSize pattern 사이즈
     * @param idx grid 인덱스
     * @return Grid의 특정 위치에서 pattern이 속할 수 있는지 여부
     */
    private static boolean isContainPatternInnerGridByPosition(int gridSize, int patternSize, int idx) {
        return (gridSize - idx) < patternSize;
    }

    public static class TheGridSearchInput {
        private final List<String> grid;
        private final List<String> pattern;

        public TheGridSearchInput(List<String> grid, List<String> pattern) {
            this.grid = grid;
            this.pattern = pattern;
        }

        public List<String> getGrid() {
            return this.grid;
        }

        public List<String> getPattern() {
            return this.pattern;
        }

        public int getGridSize() {
            return this.grid.size();
        }

        public int getPatternSize() {
            return this.pattern.size();
        }

        public char[] getGridCharsByIdx(int idx) {
            return this.grid.get(idx).toCharArray();
        }

        public int getGridCharsSizeByIdx(int idx) {
            return getGridCharsByIdx(idx).length;
        }

        public char[] getPatternCharsByIdx(int idx) {
            return this.pattern.get(idx).toCharArray();
        }

        public int getPatternCharsSizeByIdx(int idx) {
            return getPatternCharsByIdx(idx).length;
        }

        public String getFirstRowOfPattern() {
            return this.pattern.get(0);
        }

        public char getFirstRowAndFirstColumCharOfPattern() {
            return this.getFirstRowOfPattern().charAt(0);
        }

        public int getFirstRowSizeOfPattern() {
            return this.getFirstRowOfPattern().length();
        }

        public String getGridRowByIdx(int idx) {
            return this.grid.get(idx);
        }

        public char getGridRowCharByIdx(int rowIdx, int columnIdx) {
            return getGridRowByIdx(rowIdx).charAt(columnIdx);
        }
    }

    public enum YesOrNo {
        YES("YES")
        ,NO("NO");

        private final String description;

        YesOrNo(String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }
}
