package graph.cycleDetection.undirected;

import java.util.List;

public class CycleDFS {
    public int cycleDetection(List<List<Integer>> list, int n) {
        boolean[] v = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!v[i]) {
                v[i] = true;
                if (isCycle(list, v, i, -1))
                    count++;
            }
        }
        return count;
    }

    private boolean isCycle(List<List<Integer>> list, boolean[] v, int node, int parent) {

        for (Integer adj : list.get(node)) {
            if (v[adj] && adj != parent) {
                return true;
            }
            if (!v[adj]) {
                v[adj] = true;
                isCycle(list, v, adj, node);
            }
        }
        return false;
    }
}
