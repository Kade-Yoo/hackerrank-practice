package yoo.hackerrank.practice;

import java.util.Arrays;
import java.util.List;

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
 */
public class QueensAttackII {

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int resultCnt = 0;
        List<Position> eightPosition = getEightPosition();

        for (Position position : eightPosition) {
            Position quuenPosition = new Position(r_q, c_q);

            while(true) {
                int x = quuenPosition.setXAndGet(position.getX());
                int y = quuenPosition.setYAndGet(position.getY());

                if (isLimitedPosition(n, x, y)) {
                    break;
                }

                if (isObstacles(obstacles, x, y)) {
                    break;
                }

                resultCnt++;
            }
        }

        return resultCnt;
    }

    private static boolean isObstacles(List<List<Integer>> obstacles, int x, int y) {
        for (List<Integer> obstacle : obstacles) {
            Integer obstacleX = obstacle.get(0);
            Integer obstacleY = obstacle.get(1);

            // 장애물 포지션 체크
            if (x == obstacleX && y == obstacleY) {
                return true;
            }
        }
        return false;
    }

    private static boolean isLimitedPosition(int n, int x, int y) {
        return x <= 0 || x > n || y <= 0 || y > n;
    }

    public static class Position {
        private int x;
        private int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        /**
         * 복사가 왜 안될까?
         * @param position
         */
        public Position(Position position) {
            new Position(position.getX(), position.getY());
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int setXAndGet(int x) {
            return this.x = (this.x + x);
        }

        public int setYAndGet(int y) {
            return this.y = (this.y + y);
        }
    }

    private static List<Position> getEightPosition() {
        return Arrays.asList(new Position(-1, 1), new Position(0, 1), new Position(1, 1)
        , new Position(1, 0), new Position(1, -1), new Position(0, -1)
        , new Position(-1, -1), new Position(-1, 0));
    }
}
