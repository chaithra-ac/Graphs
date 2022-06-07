package graph.shortestPath.unweighted;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestPathDFS {
    public void shortestPathDFS(List<ArrayList<Integer>> list, int n, int source) {
        int[] distance = new int[n];
        Arrays.fill(distance,999);
        distance[source] =0;
        dfs( distance, source, list);

        System.out.println(Arrays.toString(distance));
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
