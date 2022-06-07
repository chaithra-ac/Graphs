package graph.shortestPath.bellmanford;

import java.util.Arrays;

//doesnt work for undirected
public class BellmanAlgo {
    public void bellShortestPath(int[][] graph, int n, int source) {
        int[] distance = new int[n];
        Arrays.fill(distance, 999);
        distance[source] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (distance[graph[j][0]] != 999 && distance[graph[j][0]] + graph[j][2] < distance[graph[j][1]])
                    distance[graph[j][1]] = distance[graph[j][0]] + graph[j][2];
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (distance[graph[i][0]] != 999 && distance[graph[i][0]] + graph[i][2] < distance[graph[i][1]]) {
                System.out.print("Negative cycle detected so, cant have a shortest path");
                return;
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println();

    }
}
