package yoo.hackerrank.practice;

import java.util.Arrays;
import java.util.List;

/**
 * Compare The Triplets
 *
 * Alice와 Bob의 도전에 등급을 매깁니다.
 * 평가항목은 정확성, 독창성, 어려움입니다.
 * 3가지 항목을 평가하여 검토자들이 비교를 합니다.
 *
 * 조건 : 1 <= rate <= 100
 * 리팩토링
 * 1차 목표 : 클래스와 메소드가 한 개의 책임만 가질 수 있도록 분리
 *
 * 문제 링크 : https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTheTriplets {

    private final int FIRST_INDEX = 0;
    private final int EVALUATE_TYPE_CNT = 3;

    /**
     * Alice와 Bob의 도전 등급 비교
     *
     * @param a Alice rate
     * @param b Bob rate
     * @return Alice와 Bob의 좋게 평가 받은 count
     */
    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceResultCnt = 0, bobResultCnt = 0;

        for (int index = FIRST_INDEX; index < EVALUATE_TYPE_CNT; index++) {
            this.validateConstraint(a.get(index), b.get(index));

            int aliceRate = a.get(index), bobRate = b.get(index);
            boolean isAliceLargerThanBob = CompareTheTripletsUtils.isAliceLargerThanBob(aliceRate, bobRate);
            aliceResultCnt = executeWhenAliceLargetThanBob(aliceResultCnt, isAliceLargerThanBob);

            boolean isBobLargerThanAlice = CompareTheTripletsUtils.isBobLargerThanAlice(aliceRate, bobRate);
            bobResultCnt = executeWhenAliceLargetThanBob(bobResultCnt, isBobLargerThanAlice);
        }

        return Arrays.asList(aliceResultCnt, bobResultCnt);
    }

    /**
     * A가 B보다 등급이 클 때 수행 메소드
     *
     * @param largerCnt A가 B보다 등급이 큰 횟수
     * @param isALargerThanB A가 B보다 등급이 큰지 여부
     * @return A가 B보다 등급이 클 때 로직 수행한 결과
     */
    private int executeWhenAliceLargetThanBob(int largerCnt, boolean isALargerThanB) {
        int resultRateCnt = 0;
        if (isALargerThanB) {
            resultRateCnt = largerCnt + 1;
        }

        return resultRateCnt;
    }

    /**
     * 1 <= rate <= 100 제약 사항 검증
     *
     * @param aliceRate 앨리스의 등급
     * @param bobRate 밥의 등급
     */
    private void validateConstraint(Integer aliceRate, Integer bobRate) {
        if (CompareTheTripletsUtils.isNotRatingConstraint(aliceRate)) {
            throw new RuntimeException("Alice의 등급을 잘못 입력하였습니다.");
        }

        if (CompareTheTripletsUtils.isNotRatingConstraint(bobRate)) {
            throw new RuntimeException("Bob의 등급을 잘못 입력하였습니다.");
        }
    }

    /**
     * CompareTheTriplets의 Utils
     */
    public static class CompareTheTripletsUtils {

        /**
         * 등급이 1보다 크거나 100보다 작은지 여부
         *
         * @param rate 등급
         * @return 등급이 1보다 크거나 100보다 작은지 여부
         */
        public static boolean isRatingConstraint(Integer rate) {
            return rate >= 1 && rate <= 100;
        }

        public static boolean isNotRatingConstraint(Integer rate) {
            return !isRatingConstraint(rate);
        }

        /**
         * 밥이 앨리스보다 등급이 큰지 여부
         *
         * @param aliceRate 앨리스 등급
         * @param bobRate 밥 등급
         * @return 밥이 앨리스보다 등급이 큰지 여부
         */
        public static boolean isBobLargerThanAlice(Integer aliceRate, Integer bobRate) {
            return aliceRate < bobRate;
        }

        /**
         * 앨리스보다 밥이 등급이 큰지 여부
         *
         * @param aliceRate 앨리스 등급
         * @param bobRate 밥 등급
         * @return 앨리스보다 밥이 등급이 큰지 여부
         */
        public static boolean isAliceLargerThanBob(Integer aliceRate, Integer bobRate) {
            return aliceRate > bobRate;
        }
    }
}
