package graph.bipertiteGraph;


import java.util.List;

public class BipertiteDFS {

    public boolean isBipertite(List<List<Integer>> list, int n) {
        int[] v = new int[n];
        for (int i = 1; i < n; i++) {
            if (v[i] == 0 && (!compute(list, n, i, v, 1)))
                return false;
        }

        return true;
    }

    private boolean compute(List<List<Integer>> list, int n, int node, int[] v, int color) {
        v[node] = color;
        for (Integer adj : list.get(node)) {
            if (v[adj] == -color) continue;
            if (v[adj] == color || (!compute(list, n, adj, v, -color)))
                return false;
        }
        return true;
    }
}
