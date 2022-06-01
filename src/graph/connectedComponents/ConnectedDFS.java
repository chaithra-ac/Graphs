package graph.connectedComponents;

import java.util.List;

public class ConnectedDFS {
    public int numberOfConnectedComponents(List<List<Integer>> list, int n) {
        int count=0;
        boolean[]v=new boolean[n];
       for(int i=1;i<n;i++){
          if(!v[i]) {
              v[i] = true;
              count++;
              DFS(list, v, i);
          }
       }
        return count;
    }

    private void DFS(List<List<Integer>> list, boolean[] v, int i) {
//        int temp=i;
        for(Integer adj:list.get(i)){
            if(!v[adj]){
                v[adj]=true;
                DFS(list,v,adj);
            }
        }
    }
}
