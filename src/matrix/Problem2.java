package matrix;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {

    static enum DIRECTION{
        LEFT, RIGHT, UP, DOWN;

        public static DIRECTION nextDirection(DIRECTION direction){
            if(direction == DIRECTION.LEFT){
                return UP;
            }
            if(direction == DIRECTION.RIGHT){
                return DOWN;
            }
            if(direction == DIRECTION.UP){
                return RIGHT;
            }
            return LEFT;
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;

        int top =0,bottom = m-1,left = 0,right = n-1;

        List<Integer> list = new ArrayList<>();

        DIRECTION direction = DIRECTION.RIGHT;
        for(int count = m*n; count > 0;){

            switch(direction){
                case RIGHT:
                    for(int i = left; i <= right; i++){
                        list.add(matrix[top][i]);
                        count--;
                    }
                    top++;
                    break;
                case DOWN:
                    for(int i = top; i <= bottom; i++){
                        list.add(matrix[i][right]);
                        count--;
                    }
                    right--;
                    break;
                case LEFT:
                    for(int i = right; i >= left; i--){
                        list.add(matrix[bottom][i]);
                        count--;
                    }
                    bottom--;
                    break;
                case UP:
                    for(int i = bottom; i >= top; i--){
                        list.add(matrix[i][left]);
                        count--;
                    }
                    left++;
                    break;
            }

            direction = DIRECTION.nextDirection(direction);
        }
        System.out.println(list);
        return list;
    }
}
