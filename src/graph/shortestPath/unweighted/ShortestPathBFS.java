package graph.shortestPath.unweighted;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBFS {
    public void shortestPathBFS(List<ArrayList<Integer>> list, int n, int source) {
        boolean[] b = new boolean[n];
        int[] distance = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++)
            distance[i] = 999;
        distance[source] = 0;
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
        for (int j = 0; j < distance.length; j++)
            System.out.print(distance[j] + " ");

        System.out.println();
    }
}
