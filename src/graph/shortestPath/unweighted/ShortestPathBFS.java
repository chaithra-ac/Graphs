package graph.shortestPath.unweighted;

import graph.cycleDetection.undirected.Pair;

import java.util.*;

public class ShortestPathBFS {
    public void shortestPathBFS(List<ArrayList<Integer>> list, int n, int source) {
        int[] distance = new int[n];
        Arrays.fill(distance,999);
        distance[source] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int adj : list.get(node)) {
                if ((distance[node] + 1) < distance[adj]) {
                    distance[adj] = distance[node] + 1;
                    q.add(adj);
                }

            }

        }
        System.out.println(Arrays.toString(distance));

        System.out.println();
    }
}
