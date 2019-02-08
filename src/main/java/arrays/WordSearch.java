package arrays;
/*
 * @author love.bisaria on 08/02/19
 *
 * Problem Description - https://leetcode.com/problems/word-search/
 * Explanation - https://www.youtube.com/watch?v=hjS8I5gP8nQ
 *
 */

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {

        for(int row=0 ; row<board.length ; row++){
            for(int column=0 ; column<board[0].length; column++){
                if(helper(board, word, row, column, 0)) return true;
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, String word, int row, int column, int index){

        if(index == word.length()) return true;

        if( row<0 || column<0 || row>=board.length || column>=board[0].length) return false;

        if(board[row][column] != word.charAt(index)) return false;

        board[row][column] = '\0';

        if(helper(board, word, row+1, column, index+1)
                || helper(board, word, row, column+1, index+1)
                || helper(board, word, row-1, column, index+1)
                || helper(board, word, row, column-1, index+1)) return true;

        board[row][column] = word.charAt(index);
        return false;

    }


    public static void main(String[] args){

        char[][] board= {{'A','B','C','E'}
                       , {'S','F','C','S'}
                       , {'A','D','E','E'}};

        assertTrue(exist(board, "ABCCED"));

        char[][] board2= {{'A','B','C','E'}
                , {'S','F','C','S'}
                , {'A','D','E','E'}};
        assertTrue(exist(board2, "SEE"));

        char[][] board3 = {{'A','B','C','E'}
                , {'S','F','C','S'}
                , {'A','D','E','E'}};

        assertFalse(exist(board, "ABCB"));
    }

}
