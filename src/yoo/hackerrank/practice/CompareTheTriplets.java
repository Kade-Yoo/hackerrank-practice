package yoo.hackerrank.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Compare The Triplets
 *
 * Alice와 Bob의 도전에 등급을 매깁니다.
 * 평가항목은 정확성, 독창성, 어려움입니다.
 * 3가지 항목을 평가하여 검토자들이 비교를 합니다.
 *
 * 조건 : 1 <= score <= 100
 *
 * 문제 링크 : https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class CompareTheTriplets {

    /**
     * Alice와 Bob의 도전 등급 비교
     *
     * @param a Alice 점수
     * @param b Bob 점수
     * @return Alice와 Bob의 좋게 평가 받은 count
     */
    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aliceScoresCnt = 0;
        int bobScoresCnt = 0;

        for (int index = 0; index < a.size(); index++) {
            Integer aliceScore = a.get(index);
            Integer bobScore = b.get(index);

            if (Objects.equals(aliceScore, bobScore)) {
                continue;
            }

            if (aliceScore > bobScore) {
                aliceScoresCnt++;
            }

            if (aliceScore < bobScore) {
                bobScoresCnt++;
            }
        }

        return Arrays.asList(aliceScoresCnt, bobScoresCnt);
    }
}
