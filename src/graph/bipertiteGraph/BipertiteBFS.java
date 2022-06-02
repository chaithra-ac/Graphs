package graph.bipertiteGraph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipertiteBFS {

    public boolean isBipertite(List<List<Integer>> list, int n) {
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            if (v[i] == 0) {
                v[i] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int adj : list.get(node)) {
                        if (v[adj] == v[node]) return false;
                        else if (v[adj] == 0) {
                            v[adj] = -v[node];
                            q.add(adj);
                        }
                    }
                }
            }
        }
        return true;
    }
}
