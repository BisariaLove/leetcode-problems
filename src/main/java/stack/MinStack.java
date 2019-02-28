package stack;
/*
 * @author love.bisaria on 27/02/19
 *
 * Problem Description - https://leetcode.com/problems/min-stack/
 */

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    /** initialize your data structure here. */
    private List<Integer> stack = new ArrayList();
    private List<Integer> minStack = new ArrayList();

    public MinStack() {}

    public void push(int x) {
        stack.add(x);

        int min = getMin();

        if(min >= x){
            minStack.add(x);
        }
    }

    public void pop() {
        if(stack.size() == 0){
            return;
        }

        int index = stack.size()-1;

        int num = stack.get(index);
        stack.remove(index);

        if(num == getMin()){

            minStack.remove(minStack.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        if(minStack.size() == 0) return Integer.MAX_VALUE;
        return minStack.get(minStack.size()-1);
    }

}
