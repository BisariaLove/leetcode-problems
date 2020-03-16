package graph;
import java.util.*;

/*
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        Map<Integer, Set<Integer>> prereqToMap = toMap(prerequisites);

        for(int i=0; i<numCourses ; i++) {
            if(hasCycle(visiting, visited, i, prereqToMap)) {

                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(boolean[] visiting, boolean[] visited, int courseId, Map<Integer, Set<Integer>> prereqToMap) {

        if(visiting[courseId]) {
            return true;
        }

        if(visited[courseId]) {
            return false;
        }

        visiting[courseId] = true;

        if(prereqToMap.containsKey(courseId)) {

            for(int elem : prereqToMap.get(courseId)) {
                if(hasCycle (visiting, visited, elem, prereqToMap)) {
                    return true;
                }
            }
        }

        visited[courseId] = true;
        visiting[courseId] = false;

        return false;
    }

    public Map<Integer, Set<Integer>> toMap(int[][] prerequisites) {
        Map<Integer, Set<Integer>> prerequisitesMap = new HashMap();

        for(int i=0; i<prerequisites.length; i++) {
            Set<Integer> curLis = null;
            if(prerequisitesMap.containsKey(prerequisites[i][0])) {
                curLis = prerequisitesMap.get(prerequisites[i][0]);
            } else {
                curLis = new HashSet();
            }

            curLis.add(prerequisites[i][1]);
            prerequisitesMap.put(prerequisites[i][0], curLis);
        }
        return prerequisitesMap;
    }
}
