package graph;

import graph.bipertiteGraph.BipertiteBFS;
import graph.bipertiteGraph.BipertiteDFS;
import graph.connectedComponents.ConnectedBFS;
import graph.connectedComponents.ConnectedDFS;
import graph.cycleDetection.undirected.CycleBFS;
import graph.cycleDetection.undirected.CycleDFS;
import graph.cycleDetection.undirected.Pair;
import graph.shortestPath.unweighted.ShortestPathBFS;
import graph.shortestPath.unweighted.ShortestPathDFS;
import graph.shortestPath.weighted.ShortestPathBFSW;
import graph.shortestPath.weighted.ShortestPathDFSW;
import graph.topologicalSort.TopoBFS;
import graph.topologicalSort.TopoDFS;
import graph.traversal.BFS;
import graph.traversal.DFS;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public static void main(String[] args) {


//     undirected graph
        int n = 8;
        List<List<Integer>> undirected = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            undirected.add(new ArrayList<>());
//     1-2
        undirected.get(1).add(2);
        undirected.get(2).add(1);
//         1-3
        undirected.get(1).add(3);
        undirected.get(3).add(1);
//         2-5
        undirected.get(2).add(5);
        undirected.get(5).add(2);
//      5-4
        undirected.get(5).add(4);
        undirected.get(4).add(5);
//        3-4
        undirected.get(3).add(4);
        undirected.get(4).add(3);

//        6-7
        undirected.get(6).add(7);
        undirected.get(7).add(6);
        System.out.println(undirected);

        int[][] mat = new int[n][n];

        mat[1][2] = 1;
        mat[2][1] = 1;
        mat[1][3] = 1;
        mat[3][1] = 1;
        mat[2][5] = 1;
        mat[5][2] = 1;
        mat[5][4] = 1;
        mat[4][5] = 1;
        mat[3][4] = 1;
        mat[4][3] = 1;

//     directed graph
        int n1 = 6;
        List<List<Integer>> directed = new ArrayList<>();
        for (int i = 0; i < n1; i++)
            directed.add(new ArrayList());
        for (int i = 0; i < n1; i++) {
            directed.get(0).add(1);
            directed.get(0).add(5);

            directed.get(1).add(2);
            directed.get(1).add(4);

            directed.get(3).add(2);

            directed.get(3).add(1);
            directed.get(3).add(0);

            directed.get(3).add(4);

            directed.get(5).add(4);


        }


//    directed weighted graph
        int n3 = 5;
        ArrayList<ArrayList<Pair>> dwg = new ArrayList<ArrayList<Pair>>();
        for (int i = 0; i < n3; i++)
            dwg.add(new ArrayList());

        dwg.get(0).add(new Pair(1, 5));
        dwg.get(0).add(new Pair(4, 1));
        dwg.get(1).add(new Pair(2, 2));
        dwg.get(4).add(new Pair(2, 2));
        dwg.get(4).add(new Pair(3, 5));
        dwg.get(3).add(new Pair(2, 3));


//     traversal
        System.out.println("BFS");
        BFS bt = new BFS();
        bt.bfs(undirected, n);

        System.out.println("\n\n" + "DFS");
        DFS dt = new DFS();
        dt.dfs(undirected, n);

//     connected components
        ConnectedBFS cb = new ConnectedBFS();
        ConnectedDFS cd = new ConnectedDFS();
        System.out.println("\n\nNumber of connected Components using BFS : " + cb.numberOfConnectedComponents(undirected, n));
        System.out.println("Number of connected Components using DFS : " + cd.numberOfConnectedComponents(undirected, n));

//     cycle detection
        CycleBFS cyb = new CycleBFS();
        CycleDFS cyd = new CycleDFS();
        System.out.println(cyb.cycleDetection(undirected, n));
        System.out.println(cyd.cycleDetection(undirected, n));

//    Bipertite Graph
        BipertiteBFS bb = new BipertiteBFS();
        BipertiteDFS bd = new BipertiteDFS();
        System.out.println("Is Bipertite using bfs : " + bb.isBipertite(undirected, n));
        System.out.println("Is Bipertite using dfs : " + bd.isBipertite(undirected, n));


//     topological sort
        TopoBFS tb = new TopoBFS();
        TopoDFS td = new TopoDFS();
        System.out.println("topological sort using bfs: ");
        tb.topoBFS(directed, n1);
        System.out.println("topological sort using dfs: ");
        td.topoDFS(directed, n1);

//     shortest path in unweighted graph to all nodes
        ShortestPathBFS spb = new ShortestPathBFS();
        ShortestPathDFS spd = new ShortestPathDFS();
        System.out.println("shortest path in unweighted graph to all nodes using BFS");
        spb.shortestPathBFS(directed, n1);
        System.out.println("shortest path in unweighted graph to all nodes using DFS");
        spd.shortestPathDFS(directed, n1);

//     shortest path in weighted graph to all nodes
        ShortestPathBFSW spdw = new ShortestPathBFSW();
        ShortestPathDFSW spbw = new ShortestPathDFSW();
        System.out.println("shortest path in weighted graph to all nodes using BFS");
        spdw.shortestPathBFS(dwg, n3);
        System.out.println("shortest path in weighted graph to all nodes using DFS");
        spbw.shortestPathDFS(dwg, n3);


    }
}
