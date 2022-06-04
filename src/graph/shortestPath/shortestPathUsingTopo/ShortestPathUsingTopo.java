package graph.shortestPath.shortestPathUsingTopo;

import graph.cycleDetection.undirected.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShortestPathUsingTopo {
    public void shortestPath(List<ArrayList<Pair>> list, int n, int source) {
        Stack<Integer> stack = new Stack<>();
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!b[i])
                topo(i, list, stack, b);
        }
        int[] distance = new int[n];
        for (int i = 1; i < n; i++)
            distance[i] = 999;
        distance[source] = 0;
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (distance[node] != 999)
                for (Pair adj : list.get(node)) {
                    if (distance[adj.node] > distance[node] + adj.parent)
                        distance[adj.node] = distance[node] + adj.parent;
                }
        }
        for (int i = 0; i < n; i++)
            System.out.print(distance[i] + " ");
        System.out.println();
    }

    private void topo(int i, List<ArrayList<Pair>> list, Stack<Integer> stack, boolean[] b) {
        b[i] = true;
        for (Pair adj : list.get(i)) {
            if (!b[adj.node])
                topo(adj.node, list, stack, b);
        }
        stack.push(i);
    }


}
