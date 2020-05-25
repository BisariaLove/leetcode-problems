package backtracking;

import java.util.*;
/*
* explanation: https://medium.com/@timtim305/leetcode-22-generate-parenthesis-60ecd6c7ea8e
* question: https://leetcode.com/problems/generate-parentheses
* */
public class HenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        generateStrings(result, "", 0,0,n);

        return result;
    }

    private void generateStrings(List<String> result, String sequence, int open, int close, int max) {

        if(max*2 == sequence.length()) {
            result.add(sequence);
            return;
        }

        if(open<max) {
            generateStrings(result, sequence+'(', open+1, close, max);
        }

        if(close< open) {
            generateStrings(result, sequence+')', open, close+1, max);
        }
    }
}
