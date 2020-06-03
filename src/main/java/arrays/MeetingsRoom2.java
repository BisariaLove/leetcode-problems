package arrays;
import java.util.*;

//https://leetcode.com/problems/meeting-rooms-ii

//sort by start time
//min heap compare by end time.

public class MeetingsRoom2 {
    public int minMeetingRooms(int[][] intervals) {

        List<Interval> intervalList = new ArrayList();

        for (int[] interval : intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }

        //sort the intervals
        Collections.sort(intervalList, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start) {
                    return i2.end - i1.end;
                }
                return (i1.start - i2.start);
            }
        });

        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>(){

            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });

        for(Interval interval : intervalList) {


            if(queue.size() > 0 && queue.peek().end <= interval.start) {
                queue.poll();
            }
            queue.add(interval);
        }

        return queue.size();

    }
}

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}