package stack;
/*
 * @author love.bisaria on 27/02/19
 *
 * Problem Description - https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 */

import java.util.*;

public class ReversePolishNotation {

    static Set<String> operators = new HashSet<String>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack();

        for(String token : tokens){
            if(operators.contains(token)){
                int a = stack.pop();
                int b = stack.pop();

                switch(token){
                    case "+" : stack.push(a+b); break;
                    case "-" : stack.push(b-a); break;
                    case "*" : stack.push(a*b); break;
                    case "/" : stack.push((a==0||b==0)?0:(b/a)); break;
                }
            } else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
