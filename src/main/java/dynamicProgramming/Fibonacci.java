package dynamicProgramming;
/*
 * @author love.bisaria on 28/02/19
 *
 * Program Description - https://leetcode.com/problems/fibonacci-number/
 */

public class Fibonacci {

    public int fib(int N) {

        if(N==0) return 0;
        if(N==1) return 1;

        int i=2;
        int a=0,b=1;

        while(i<=N){
            int c = a+b;
            a=b;
            b=c;
            i++;
        }

        return b;

    }
}
