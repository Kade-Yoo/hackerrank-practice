package yoo.hackerrank.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;

/**
 * Queen's Attack II
 *
 * Function Description
 *
 * Complete the queensAttack function in the editor below.
 *
 * queensAttack has the following parameters:
 * - int n: the number of rows and columns in the board
 * - nt k: the number of obstacles on the board
 * - int r_q: the row number of the queen's position
 * - int c_q: the column number of the queen's position
 * - int obstacles[k][2]: each element is an array of 2 integers, the row and column of an obstacle
 *
 * Returns
 * int: the number of squares the queen can attack
 *
 * Input Format
 * The first line contains two space-separated integers n and k, the length of the board's sides and the number of obstacles.
 * The next line contains two space-separated integers r and c, the queen's row and column position.
 * Each of the next k lines contains two space-separated integers r[i] and c[i] , the row and column position of obstacle[i].
 *
 * Constraints
 * 0 < n <= 10^5
 * 0 <= k <= 10^5
 * A single cell may contain more than one obstacle.
 * There will never be an obstacle at the position where the queen is located
 *
 * 1차 time limit 4건 발생
 * 2차 방법은 장애물이 존재할 때 해당 장애물까지 count를 더해서 합을 구한다 -> 1차 때 푼 이동하는 로직이 없어진다
 *
 * 변경 사항
 * 7.21 : 각 방향별 장애물 존재여부 체크 Enum구현
 */
public class QueensAttackII {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int resultCnt = 0;
        List<Position> eightPosition = getEightPosition();

        for (Position position : eightPosition) {
            if (isObstacles(obstacles, r_q, c_q)) {
                break;
            }

            // TODO : count 계산 공식 추가
        }

        return resultCnt;
    }

    /**
     * 장애물 여부
     *
     * @param obstacles 장애물 위치
     * @param x 현재 위치 x좌표
     * @param y 현재 위치 y좌표
     * @return 장애물 여부
     */
    private static boolean isObstacles(List<List<Integer>> obstacles, int x, int y) {
        for (int obstacleIdx = 0; obstacleIdx < obstacles.size(); obstacleIdx++) {
            Integer obstacleX = obstacles.get(obstacleIdx).get(0);
            Integer obstacleY = obstacles.get(obstacleIdx).get(1);

            // TODO : 장애물 존재여부 추가
        }

        return false;
    }

    public static class Position {
        private final int x;
        private final int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public enum PositionEnum {

        UP(1, (nowPosition, inputPosition) -> nowPosition.getY() == inputPosition.getY() && inputPosition.getX() > nowPosition.getX()),
        UPPER_RIGHT(2, (nowPosition, inputPosition) -> inputPosition.getX() == inputPosition.getY() && inputPosition.getX() > nowPosition.getX() && inputPosition.getY() > nowPosition.getY()),
        RIGHT(3, (nowPosition, inputPosition) -> inputPosition.getY() > nowPosition.getY() && inputPosition.getX() == nowPosition.getX()),
        BOTTOM_RIGHT(4, (nowPosition, inputPosition) -> inputPosition.getX() == -(inputPosition.getY()) && inputPosition.getX() == nowPosition.getX() && inputPosition.getY() < nowPosition.getY()),
        BOTTOM(5, (nowPosition, inputPosition) -> inputPosition.getY() == nowPosition.getY() && inputPosition.getX() < nowPosition.getX()),
        BOTTOM_LEFT(6, (nowPosition, inputPosition) -> inputPosition.getY() == inputPosition.getX() && inputPosition.getX() < nowPosition.getX() && inputPosition.getY() < nowPosition.getY()),
        LEFT(7, (nowPosition, inputPosition) -> inputPosition.getX() == nowPosition.getX() && inputPosition.getY() == nowPosition.getY()),
        UPPER_LEFT(8, (nowPosition, inputPosition) -> inputPosition.getY() == -(inputPosition.getX()) && inputPosition.getX() < nowPosition.getX() && inputPosition.getY() > nowPosition.getY());

        private final int positionNo;
        private final BiPredicate<Position, Position> positionPredicate;

        PositionEnum(int positionNo, BiPredicate<Position, Position> positionPredicate) {
            this.positionNo = positionNo;
            this.positionPredicate = positionPredicate;
        }

        public int getPositionNo() {
            return this.positionNo;
        }

        public BiPredicate<Position, Position> getPositionPredicate() {
            return this.positionPredicate;
        }

        public BiPredicate<Position, Position> getPositionPredicateByNo(int positionNo) {
            Optional<PositionEnum> positionEnumOptional = Arrays.stream(values()).filter(positionEnum -> positionEnum.getPositionNo() == positionNo).findFirst();
            return positionEnumOptional.orElseThrow().getPositionPredicate();
        }
    }

    private static List<Position> getEightPosition() {
        return Arrays.asList(new Position(-1, 1), new Position(0, 1), new Position(1, 1)
        , new Position(1, 0), new Position(1, -1), new Position(0, -1)
        , new Position(-1, -1), new Position(-1, 0));
    }
}
