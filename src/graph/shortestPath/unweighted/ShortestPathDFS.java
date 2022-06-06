package graph.shortestPath.unweighted;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathDFS {
    public void shortestPathDFS(List<ArrayList<Integer>> list, int n, int source) {
        int[] distance = new int[n];
        for (int i = 1; i < n; i++)
            distance[i] = 999;
        distance[source]=0;
        dfs( distance, source, list);

        for (int i = 0; i < n; i++)
            System.out.print(distance[i]+" ");
        System.out.println();

        }

    private void dfs( int[] distance, int node, List<ArrayList<Integer>> list) {
    for(int adj:list.get(node)){
        if(distance[adj]>distance[node]+1){
            distance[adj]=distance[node]+1;
            dfs(distance,adj,list);
        }

    }
    }
}
