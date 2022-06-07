package graph.shortestPath.weighted;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathDFSW {
    public void shortestPathDFS(List<ArrayList<Pair>> list, int n, int source) {
        int[] distance = new int[n];
        Arrays.fill(distance,999);
            distance[source] =0;
        dfs( distance, 0, list);

        System.out.println(Arrays.toString(distance));
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
