package graph.shortestPath.weighted;

import graph.cycleDetection.undirected.Pair;

import java.util.*;

public class ShortestPathBFSW {
    public void shortestPathBFS(List<ArrayList<Pair>> list, int n, int source) {
        int[] distance = new int[n];
        Arrays.fill(distance,999);
        distance[source] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Pair adj : list.get(node)) {
                if (distance[adj.node] > distance[node] + adj.parent){
                    distance[adj.node] = distance[node] + adj.parent;
                    q.add(adj.node);
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println();

    }
}
