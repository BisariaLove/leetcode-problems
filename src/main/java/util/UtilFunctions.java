package util;
/*
 * @author love.bisaria on 02/03/19
 */

import java.util.*;

public final class UtilFunctions {

    public static Set<String> generateAllSubstrings(String s){
        Set<String> substrings = new HashSet();

        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length();j++){
                substrings.add(s.substring(i,j+1));
            }
        }

        return substrings;
    }

    public static void main(String[] args){
        Set<String> result = generateAllSubstrings("for");

        System.out.println("Result: " + result);
    }
}
