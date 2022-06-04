package graph.shortestPath.weighted;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathDFSW {
    public void shortestPathDFS(List<ArrayList<Pair>> list, int n, int source) {
        boolean[] b = new boolean[n];
        int[] distance = new int[n];
        for (int i = 1; i < n; i++)
            distance[i] = 999;
        distance[source] = 0;
        dfs(b, distance, 0, list);

        for (int i = 0; i < n; i++)
            System.out.print(distance[i] + " ");
        System.out.println();

    }

    private void dfs(boolean[] b, int[] distance, int node, List<ArrayList<Pair>> list) {
        b[node] = true;
        for (Pair adj : list.get(node)) {
            if (distance[adj.node] > distance[node] + adj.parent)
                distance[adj.node] = distance[node] + adj.parent;
            if (!b[adj.node]) {
                dfs(b, distance, adj.node, list);
            }
        }
    }
}
