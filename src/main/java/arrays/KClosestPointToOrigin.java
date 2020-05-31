package arrays;

import java.util.*;
//https://leetcode.com/problems/k-closest-points-to-origin/submissions/

public class KClosestPointToOrigin {public int[][] kClosest(int[][] points, int K) {

    PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(new DistanceComparator() );

    for(int[] point : points) {
        Pair<Integer, Integer> pointPair = new Pair<> (point[0], point[1]);
        heap.add(pointPair);

        if(heap.size() > K) {
            heap.poll();
        }
    }

    int[][] result = new int[K][2];
    int index = 0;

    while(heap.size() > 0) {

        int[] arr = new int[2];
        Pair<Integer, Integer> point = heap.poll();

        arr[0] = point.getKey();
        arr[1] = point.getValue();

        result[index++] = arr;
    }

    return result;
}

}

class DistanceComparator implements Comparator<Pair<Integer, Integer>> {

    private double getDistance(Pair<Integer, Integer> point) {
        return(Math.sqrt(Math.pow(point.getKey(), 2) + Math.pow(point.getValue(), 2)));
    }

    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {

        double diff = getDistance(p1) - getDistance(p2);

        if(diff < 0) {
            return 1;
        } else {
            return -1;
        }
    }
}

class Pair<T, P> {
    private T key;
    private P value;

    public Pair(T key, P value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public P getValue() {
        return value;
    }

    public void setValue(P value) {
        this.value = value;
    }
}