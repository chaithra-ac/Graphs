package graph.prims;

import graph.cycleDetection.undirected.Pair;

import java.util.*;

public class PrimsAlgo {
    public void primsAlgo(List<ArrayList<Pair>> list, int n) {
        PriorityQueue<Pair> q = new PriorityQueue<>(n, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.parent - o2.parent;
            }
        });
        int[] parent = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        int[] key = new int[n + 1];
        Arrays.fill(key, 999);
        parent[1] = -1;
        key[1] = 0;
        q.add(new Pair(1, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            vis[p.node] = true;
            for (Pair adj : list.get(p.node)) {
                if (!vis[adj.node] && adj.parent < key[adj.node]) {
                    key[adj.node] = adj.parent;
                    parent[adj.node] = p.node;
                    q.add(adj);
                }
            }
        }

        for (int i = 1; i < key.length; i++)
            System.out.print("[" + key[i] + " ," + i + "]");
        System.out.println();
    }
}
