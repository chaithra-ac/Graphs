package graph.traversal;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    public void dfs(List<ArrayList<Integer>> list, int n) {
        boolean[] v = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!v[i]) {
                v[i] = true;
                compute(list, v, i);
            }
        }
    }

    private void compute(List<ArrayList<Integer>> list, boolean[] v, int i) {
        System.out.print(i + " ");
        for (Integer adj : list.get(i)) {
            if (!v[adj]) {
                v[adj] = true;
                compute(list, v, adj);
            }
        }
    }
}
