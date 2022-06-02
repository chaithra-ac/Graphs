package graph.shortestPath.unweighted;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathBFS {
    public void shortestPathBFS(List<List<Integer>> list, int n) {
        boolean[] b = new boolean[n];
        int[] distance = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++)
            distance[i] = 999;
        for (int i = 0; i < n; i++) {
            if (!b[i]) {
                q.add(i);
                b[i] = true;
            }
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int adj : list.get(node)) {
                    if (!b[adj]) {
                        b[adj] = true;
                        q.add(adj);
                    }
                    if ((distance[node] + 1) < distance[adj])
                        distance[adj] = distance[node] + 1;
                }
//                   System.out.println(q);
            }

        }
        for (int j = 0; j < distance.length; j++)
            System.out.print(distance[j] + " ");

        System.out.println();
    }
}
