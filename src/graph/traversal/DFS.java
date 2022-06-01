package graph.traversal;

import java.util.List;

public class DFS {
    public void dfs(List<List<Integer>> list, int n) {
        int count=0;
        boolean[]v=new boolean[n];
        for(int i=1;i<n;i++) {
            if (!v[i]) {
                v[i] = true;
                compute(list, v, i);
            }
        }
    }

    private void compute(List<List<Integer>> list, boolean[] v, int i) {
//        int temp=i;
        System.out.print(i+" ");
        for(Integer adj:list.get(i)){
            if(!v[adj]){
                v[adj]=true;
                compute(list,v,adj);
            }
        }
    }
}
