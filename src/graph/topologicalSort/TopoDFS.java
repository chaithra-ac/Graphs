package graph.topologicalSort;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopoDFS {
    public void topoDFS(List<ArrayList<Integer>> list, int n) {
        Stack<Integer> stack = new Stack<>();
        boolean[] b = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!b[i])
                dfs(i, list, stack, b);
        }
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }

    private void dfs(int i, List<ArrayList<Integer>> list, Stack<Integer> stack, boolean[] b) {
        b[i] = true;
        for (int adj : list.get(i)) {
            if (!b[adj])
                dfs(adj, list, stack, b);
        }
        stack.push(i);
    }
}
