package lists;
import java.util.*;

//https://leetcode.com/articles/insert-delete-getrandom-o1/

public class InsertDeleteGetRandom {

    List<Integer> lis ;
    Map<Integer, Integer> map;
    Random rand ;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        lis = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        lis.add(val);
        map.put(val, lis.size() - 1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer idx = map.get(val);

        if(idx == null) return false;

        int lastElement = lis.get(lis.size()-1);

        lis.set(idx, lastElement);
        map.put(lastElement, idx);

        lis.remove(lis.size()-1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return lis.get(rand.nextInt(lis.size()));
    }
}
