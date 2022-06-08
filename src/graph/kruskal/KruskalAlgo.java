package graph.kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KruskalAlgo {


    public void kruskalAlgo(int[][] wg, int w) {
        Arrays.sort(wg, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int[] priority = new int[w + 1];
        int[] parent = new int[w + 1];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        for (int[] i : wg) {
            if (parent(i[0], parent) != parent(i[1], parent)) {
                list.add(i);
                union(i[0], i[1], parent, priority);
            }

        }
        for (int[] i : list)
            System.out.print(Arrays.toString(i));
    }

    private void union(int u, int v, int[] parent, int[] priority) {
        int p1 = parent(u, parent);
        int p2 = parent(v, parent);
        if (priority[p1] < priority[p2])
            parent[p1] = p2;
        else if (priority[p1] > priority[p2])
            parent[p2] = p1;
        else {
            parent[p1] = p2;
            priority[p2]++;
        }

    }

    private int parent(int i, int[] parent) {
        if (i == parent[i]) return i;
        return parent[i] = parent(parent[i], parent);
    }
}
