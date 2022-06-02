package graph.shortestPath.unweighted;

import java.util.List;

public class ShortestPathDFS {
    public void shortestPathDFS(List<List<Integer>> list, int n) {
        boolean[] b = new boolean[n];
        int[] distance = new int[n];
        for (int i = 1; i < n; i++)
            distance[i] = 999;
        distance[0]=0;
        for (int i = 0; i < n; i++) {
            if (!b[i])
                dfs(b, distance, i, list);
        }
        for (int i = 0; i < n; i++)
            System.out.print(distance[i]+" ");
        System.out.println();

        }

    private void dfs(boolean[] b, int[] distance, int node, List<List<Integer>> list) {
    b[node]=true;
    for(int adj:list.get(node)){
        if(distance[adj]>distance[node]+1)
            distance[adj]=distance[node]+1;
        if(!b[adj]){
            dfs(b,distance,adj,list);
        }

    }
    }
}
