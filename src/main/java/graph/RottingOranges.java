package graph;

import javafx.util.Pair;
import java.util.*;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
    public int orangesRotting(int[][] grid) {

        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        int freshOranges = 0;

        int ROWS = grid.length;
        int COLS = grid[0].length;

        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {

                if(grid[r][c] == 2) {
                    queue.add(new Pair(r, c));
                }
                else if(grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }

        //Mark the level
        queue.add(new Pair(-1, -1));

        int min = -1;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.remove();

            int ro = p.getKey();
            int col = p.getValue();

            if(ro == -1) {
                min++;

                if(!queue.isEmpty()) {
                    queue.add(new Pair(-1, -1));
                }
            } else {
                for(int[] d : directions) {
                    int neighborRow = ro + d[0];
                    int neighborCol = col + d[1];

                    if (neighborRow >= 0 && neighborRow < ROWS &&
                            neighborCol >= 0 && neighborCol < COLS) {
                        if (grid[neighborRow][neighborCol] == 1) {

                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;

                            queue.add(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }


        }

        return freshOranges == 0 ? min : -1;
    }
}
