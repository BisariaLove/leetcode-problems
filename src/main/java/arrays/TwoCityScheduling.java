package arrays;

import java.util.*;
//https://leetcode.com/problems/two-city-scheduling/

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, new Comparator<int[]>(){

            public int compare(int[] o1, int[] o2) {
                return (o1[0]- o1[1]) - (o2[0] - o2[1]);
            }
        });

        int totalCost = 0;
        int n = costs.length/2;

        for(int i=0, j=n; i<n && j<costs.length; i++, j++) {
            totalCost += costs[i][0] + costs[j][1];
        }

        return totalCost;
    }
}
