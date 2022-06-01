package graph.traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public void bfs(List<List<Integer>> list, int n) {
        boolean[]v=new boolean[n];
        for(int i=1;i<n;i++){
            if(!v[i])
                compute(v, list,i);
        }
    }

    private void compute(boolean[] v, List<List<Integer>> list,int node) {
        Queue<Integer>q=new LinkedList<>();
        q.add(node);
        v[node]=true;
        while(!q.isEmpty()){
            Integer temp=q.poll();
            System.out.print(temp+" ");
            for(Integer adj:list.get(temp)){
                if(!v[adj]){
                    v[adj]=true;
                    q.add(adj);
                }
            }
        }
    }}
