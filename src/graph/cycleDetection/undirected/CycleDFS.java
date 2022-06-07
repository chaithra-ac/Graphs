package graph.cycleDetection.undirected;

import java.util.ArrayList;
import java.util.List;

public class CycleDFS {
    public int cycleDetection(List<ArrayList<Integer>> list, int n) {
        boolean[] v = new boolean[n+1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                v[i] = true;
                if (isCycle(list, v, i, -1))
                    count++;
            }
        }
        return count;
    }

    private boolean isCycle(List<ArrayList<Integer>> list, boolean[] v, int node, int parent) {
        v[node] = true;
        for (Integer adj : list.get(node)) {
            if (!v[adj]) {
                if (isCycle(list, v, adj, node)) return true;
            } else {
                if (adj != parent)
                    return true;

            }
        }
        return false;
    }
}
