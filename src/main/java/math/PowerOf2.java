package math;
//

public class PowerOf2 {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;

        if(n%2 !=0) return false;

        int i=1;
        double cur = 0;
        while((cur = Math.pow(2,i)) < n) i++;



        if(cur == n) return true;

        return false;
    }
}
