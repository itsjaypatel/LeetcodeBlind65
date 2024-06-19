package matrix;

public class Problem4 {

    //    Link: https://leetcode.com/problems/word-search/description/

    public static void main(String[] args) {

        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean ans = new Problem4().exist(board,"ABCCED");
        System.out.println(ans);
    }

    public boolean exist(char[][] board, String word) {

        /*
        * Approch - Backtracking
        * L = length of word
        * TC - O(M*N*4^L)
        * SC - O(L) -> due to recursive stack space
        * */


        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && exist(i,j,0,board,word)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean exist(int row, int col, int index, char[][] board, String word) {
        if(index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }



        char original = board[row][col];
        board[row][col] = '#';

        int[] direction = {-1, 0, 1, 0,-1};

        for (int d = 0; d < 4; d++) {
            int newRow = row + direction[d];
            int newCol = col + direction[d + 1];
            if(exist(newRow,newCol,index+1,board,word)) {
                return true;
            }
        }
        board[row][col] = original;
        return false;
    }
}
