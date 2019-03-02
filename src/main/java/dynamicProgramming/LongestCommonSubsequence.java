package dynamicProgramming;
/*
 * @author love.bisaria on 02/03/19
 */

import java.util.Arrays;

public class LongestCommonSubsequence {

    // Complete the longestCommonSubsequence function below.
    static int[] longestCommonSubsequence(int[] a, int[] b) {
        int row = a.length+1;
        int column = b.length+1;


        int[][] result = new int[row][column];

        //create bottom up matrix
        for(int i=1; i<row; i++){
            for (int j=1; j<column; j++){
                if(a[i-1] == b[j-1]){
                    result[i][j] = result[i-1][j-1]+1;
                }else{
                    result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }

        //actual sequence
        int i=(row-1);
        int j=(column-1);

        int index = result[i][j];
        int[] subsequence = new int[result[i][j]];

        while(i>=1 &&j>=1){
            if(result[i][j] == result[i][j-1]){
                j--;
            } else if(result[i][j] == result[i-1][j]){
                i--;
            }else{
                subsequence[--index] = a[i-1];
                i--;
                j--;
            }

        }
        return subsequence;
    }


    public static void main(String[] args){
        int[] answer = longestCommonSubsequence(new int[]{1,2,3,4,1}, new int[]{3, 4, 1, 2, 1, 3});
        System.out.println("Answer: " + Arrays.toString(answer));

    }
}
