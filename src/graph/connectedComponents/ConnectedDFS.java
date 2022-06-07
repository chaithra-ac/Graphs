package graph.connectedComponents;

import java.util.ArrayList;
import java.util.List;

public class ConnectedDFS {
    public int numberOfConnectedComponents(List<ArrayList<Integer>> list, int n) {
        int count = 0;
        boolean[] v = new boolean[n+1];
        for (int i = 1; i <=n; i++) {
            if (!v[i]) {
                v[i] = true;
                count++;
                DFS(list, v, i);
            }
        }
        return count;
    }

    private void DFS(List<ArrayList<Integer>> list, boolean[] v, int i) {
        for (Integer adj : list.get(i)) {
            if (!v[adj]) {
                v[adj] = true;
                DFS(list, v, adj);
            }
        }
    }
}
