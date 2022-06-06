package graph.shortestPath.weighted;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathDFSW {
    public void shortestPathDFS(List<ArrayList<Pair>> list, int n, int source) {
        int[] distance = new int[n];
        for (int i = 1; i < n; i++)
            distance[i] = 999;
        dfs( distance, 0, list);

        for (int i = 0; i < n; i++)
            System.out.print(distance[i] + " ");
        System.out.println();

    }

    private void dfs( int[] distance, int node, List<ArrayList<Pair>> list) {
        for (Pair adj : list.get(node)) {
            if (distance[adj.node] > distance[node] + adj.parent){
                distance[adj.node] = distance[node] + adj.parent;
                dfs( distance, adj.node, list);
            }
        }
    }
}
