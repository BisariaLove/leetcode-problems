package graph;
/*
 * @author love.bisaria on 17/02/19
 * Problem Description - https://leetcode.com/problems/word-ladder/
 */

import org.junit.Assert;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet(wordList);

        Queue<WordCountNode> queue = new LinkedList();
        queue.add(new WordCountNode(beginWord, 1));

        Set<String> visited = new HashSet();

        while(!queue.isEmpty()){

            WordCountNode current = queue.remove();

            if(current.word.equals(endWord)){
                return current.count;
            }


            Set<String> neighbors = getNeighbhors(current.word, dictionary);

            for(String neighbor: neighbors){
                if(!visited.contains(neighbor)){
                    queue.add(new WordCountNode(neighbor, current.count+1));
                }
            }

            visited.add(current.word);

        }

        return 0;
    }


    public static Set<String> getNeighbhors(String word, Set<String> dictionary){
        Set<String> neighbors = new HashSet();

        for(int i=0; i<word.length() ; i++){
            char currentChar = word.charAt(i);
            char[] charArr = word.toCharArray();

            for(char ch = 'a' ; ch < 'z' ; ch++){
                if(ch !=  currentChar){
                    charArr[i] = ch;

                    String proposedNeighbor = new String(charArr);

                    if(dictionary.contains(proposedNeighbor)){
                        neighbors.add(proposedNeighbor);
                    }
                }
            }
            charArr[i] = currentChar;
        }

        return neighbors;
    }

    class WordCountNode{
        String word;
        int count;

        public WordCountNode(String word, int count){
            this.word = word;
            this.count = count;
        }

    }

    public static void main(String[] args){

        WordLadder obj  = new WordLadder();
        Assert.assertTrue(obj.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")) == 5);
    }
}
