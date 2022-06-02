package graph.cycleDetection.undirected;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleBFS {
    public int cycleDetection(List<List<Integer>> list, int n) {
        int count = 0;
        boolean[] v = new boolean[n];
        for (int i = 1; i < n; i++) {
            if (!v[i]) {
                if (isCycle(list, v, i, -1)) count++;
            }
        }
        return count;
    }

    private boolean isCycle(List<List<Integer>> list, boolean[] v, int node, int parent) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, parent));
        v[node] = true;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int adj : list.get(p.node)) {
                if (v[adj] && adj != p.parent) {
                    return true;
                }

                if (!v[adj]) {
                    v[adj] = true;
                    q.add(new Pair(adj, p.node));
                }
            }
        }
        return false;
    }
}

