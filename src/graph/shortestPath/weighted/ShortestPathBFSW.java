package graph.shortestPath.weighted;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBFSW {
    public void shortestPathBFS(List<ArrayList<Pair>> list, int n, int source) {
        int[] distance = new int[n];
        for (int i = 1; i < n; i++)
            distance[i] = 999;
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
        for (int i : distance)
            System.out.print(i + " ");
        System.out.println();

    }
}
