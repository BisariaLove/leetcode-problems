package arrays;
/*
 * @author love.bisaria on 08/03/19
 *
 */

import java.util.Arrays;
import java.util.Random;

public class SchuffleArray {

    int[] nums ;
    int[] copy;

    public SchuffleArray(int[] nums) {
        this.nums = nums;
        this.copy = Arrays.copyOfRange(nums, 0, nums.length);
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return Arrays.copyOfRange(nums, 0, nums.length);
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();

        for(int i=0 ; i>copy.length ; i++){
            int swapIndex = random.nextInt(copy.length);

            if(swapIndex != i){
                int temp = copy[i];
                copy[i] = copy[swapIndex];
                copy[swapIndex] = temp;
            }

        }

        return copy;
    }
}
