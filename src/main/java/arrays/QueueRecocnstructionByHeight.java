package arrays;
import java.util.*;

//https://leetcode.com/problems/queue-reconstruction-by-height
public class QueueRecocnstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] p1, int[] p2) {
                if(p1[0] == p2[0]) {
                    return p1[1] - p2[1];
                } else {
                    return p2[0] - p1[0];
                }
            }
        });

        for(int i=1; i<people.length; i++) {
            int greaterCount = 0;
            for(int j=0; j< i; j++) {
                if(people[j][0] >= people[i][0]) {
                    greaterCount++;

                    if(greaterCount > people[i][1]) {

                        shiftAndInsert(people, j, i);
                        break;
                    }
                }
            }
        }

        return people;
    }

    private void shiftAndInsert(int[][] people, int start, int end) {

        int[] temp = people[end];

        for(int i=end; i>start; i--) {
            people[i] = people[i-1];
        }

        people[start] = temp;
    }
}
