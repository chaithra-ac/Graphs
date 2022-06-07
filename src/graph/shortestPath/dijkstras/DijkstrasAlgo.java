package graph.shortestPath.dijkstras;

import graph.cycleDetection.undirected.Pair;

import java.util.*;

public class DijkstrasAlgo {

    public void dijShortestPath(List<ArrayList<Pair>> list, int n, int source) {
        int[] distance = new int[n];

        Arrays.fill(distance, 999);
        distance[source] = 0;

        PriorityQueue<Pair> q = new PriorityQueue(n, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.parent > o2.parent) return -1;
                else if (o1.parent < o2.parent) return -1;
                else return 0;
            }
        });
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair node = q.poll();
            for (Pair adj : list.get(node.node)) {
                if (distance[adj.node] > (node.parent + adj.parent)) {
                    distance[adj.node] = node.parent + adj.parent;
                    q.add(new Pair(adj.node, distance[adj.node]));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println();

    }
}
