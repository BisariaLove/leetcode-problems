package arrays;

//https://leetcode.com/problems/prison-cells-after-n-days/
//Explanation - https://www.youtube.com/watch?v=XaayRYdKG0I
public class PrisonAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int N) {


        Map<String, Integer> memo = new HashMap();

        for(int i=0; i<N; i++) {
            String s = Arrays.toString(cells);


            if(memo.containsKey(s)) {
                int loopLength = i - memo.get(s);
                int remainingDays = (N-i) % loopLength;

                return prisonAfterNDays(cells, remainingDays);
            } else {
                memo.put(s, i);

                int prev = cells[0];
                for(int j=1;j<7; j++) {
                    int cur = cells[j];
                    int next = cells[j+1];

                    cells[j] = 1-(prev ^ next);

                    prev = cur;
                }
            }

            cells[0]=0;
            cells[7]=0;

        }

        return cells;
    }
}
