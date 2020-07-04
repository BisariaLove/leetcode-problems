package graph;

//https://leetcode.com/problems/reconstruct-itinerary/
//Explanation - https://www.youtube.com/watch?v=j31ZOupyrAs&t=1013s

import java.util.*;
public class ReconstructItenaray {

    private void dfs(Map<String, PriorityQueue<String>> adj, LinkedList<String> result, String s) {

        PriorityQueue<String> pq = adj.get(s);

        while(pq != null && !pq.isEmpty()) {

            String v = pq.poll();
            dfs(adj, result, v);
        }

        result.addFirst(s);
    }

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> adj = new HashMap();

        for(List<String> ticket : tickets) {
            PriorityQueue<String> pq = adj.getOrDefault(ticket.get(0), new PriorityQueue());
            pq.add(ticket.get(1));

            adj.put(ticket.get(0), pq);
        }

        LinkedList<String> result = new LinkedList();

        dfs(adj, result, "JFK");

        return result;
    }
}
