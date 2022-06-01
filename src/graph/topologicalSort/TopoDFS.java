package graph.topologicalSort;

import java.util.*;

public class TopoDFS {
    public void topoDFS(List<List<Integer>> list, int n) {
        Stack<Integer>stack=new Stack<>();
        boolean[]b=new boolean[n];
        for (int i = 0; i < n; i++) {
        if(!b[i])
            dfs(i,list,stack,b);
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
        System.out.println();
    }

    private void dfs(int i, List<List<Integer>> list, Stack<Integer> stack,boolean[]b) {
        b[i]=true;
        for(int adj:list.get(i)){
            if(!b[adj])
                dfs(adj, list, stack, b);
        }
        stack.push(i);
    }
}
