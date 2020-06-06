package arrays;
//https://leetcode.com/problems/random-pick-with-weight
//Explanation -  https://www.youtube.com/watch?v=v-_aEMtgnkI
public class RandomPickWithWeight {

    private int[] w_cum;
    private int sum;

    public RandomPickWithWeight(int[] w) {
        this.w_cum = new int[w.length];
        this.sum = 0;

        for(int i=0; i<w.length; i++) {
            sum += w[i];
            w_cum[i] = this.sum;
        }
    }

    public int pickIndex() {
        int idx = (int)(Math.random()*sum);
        return search(idx + 1);
    }

    public int search(int value) {
        int s = 0;
        int e = w_cum.length-1;

        while(s < e) {
            int mid = s + (e-s)/2;

            if(w_cum[mid] < value) {
                s = mid+1;
            } else {
                e = mid;
            }
        }

        return s;
    }
}
