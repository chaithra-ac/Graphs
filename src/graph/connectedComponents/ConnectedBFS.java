package graph.connectedComponents;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedBFS {

    public int numberOfConnectedComponents(List<List<Integer>> list, int n) {
        boolean[] v = new boolean[n];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (!v[i]) {
                count++;
                BFS(v, list, i);
            }
        }
        return count;
    }

    private void BFS(boolean[] v, List<List<Integer>> list, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        v[node] = true;
        while (!q.isEmpty()) {
            Integer temp = q.poll();
            for (Integer adj : list.get(temp)) {
                if (!v[adj]) {
                    v[adj] = true;
                    q.add(adj);
                }
            }
        }
    }
}
