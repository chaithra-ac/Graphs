package graph.topologicalSort;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoBFS {
    public void topoBFS(List<ArrayList<Integer>> list, int n) {
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int adj : list.get(i))
                indegree[adj]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int adj : list.get(node)) {
                indegree[adj]--;
                if (indegree[adj] == 0)
                    q.add(adj);
            }
        }

        System.out.println();

    }

}
