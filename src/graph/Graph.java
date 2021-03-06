package graph;

import graph.bipertiteGraph.BipertiteBFS;
import graph.bipertiteGraph.BipertiteDFS;
import graph.connectedComponents.ConnectedBFS;
import graph.connectedComponents.ConnectedDFS;
import graph.cycleDetection.undirected.CycleBFS;
import graph.cycleDetection.undirected.CycleDFS;
import graph.cycleDetection.undirected.Pair;
import graph.kruskal.KruskalAlgo;
import graph.prims.PrimsAlgo;
import graph.shortestPath.bellmanford.BellmanAlgo;
import graph.shortestPath.dijkstras.DijkstrasAlgo;
import graph.shortestPath.shortestPathUsingTopo.ShortestPathUsingTopo;
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
        int n = 7;
        List<ArrayList<Integer>> undirected = new ArrayList<>();
        for (int i = 0; i <= n; i++)
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


//        undirected weighted graph
        List<ArrayList<Pair>> undwg = new ArrayList<>();
        for (int i = 0; i <=n; i++)
            undwg.add(new ArrayList<>());
//        1-2
        undwg.get(1).add(new Pair(2, 3));
        undwg.get(2).add(new Pair(1, 3));
//        1-3
        undwg.get(1).add(new Pair(3, 5));
        undwg.get(3).add(new Pair(1, 5));
//        2-5
        undwg.get(2).add(new Pair(5, 7));
        undwg.get(5).add(new Pair(2, 7));
//        5-4
        undwg.get(5).add(new Pair(4, 9));
        undwg.get(4).add(new Pair(5, 9));
//        3-4
        undwg.get(3).add(new Pair(4, 1));
        undwg.get(4).add(new Pair(3, 1));

//        6-7
        undwg.get(6).add(new Pair(7, 8));
        undwg.get(7).add(new Pair(6, 8));

//     directed graph
        int n1 = 6;
        List<ArrayList<Integer>> directed = new ArrayList<>();
        for (int i = 0; i < n1; i++)
            directed.add(new ArrayList());
        directed.get(0).add(1);
        directed.get(0).add(5);

        directed.get(1).add(2);
        directed.get(1).add(4);

        directed.get(3).add(2);

        directed.get(3).add(1);
        directed.get(3).add(0);

        directed.get(3).add(4);

        directed.get(5).add(4);


//    directed weighted graph
        int n3 = 5;
        List<ArrayList<Pair>> dwg = new ArrayList<>();
        for (int i = 0; i < n3; i++)
            dwg.add(new ArrayList());

        dwg.get(0).add(new Pair(1, 5));
        dwg.get(0).add(new Pair(4, 1));
        dwg.get(1).add(new Pair(2, 2));
        dwg.get(4).add(new Pair(2, 2));
        dwg.get(4).add(new Pair(3, 5));
        dwg.get(3).add(new Pair(2, 3));

//        Negative weighted graph
        int[][] nwg = {{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, -2}};
        int nw = 6;

//        weighted graph
        int[][] wg = {{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, 3}, {1, 2, 2}, {3, 4, 2}, {2, 4, 2}};
        int w = 6;
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
        System.out.println("Number of cycles using BFS : " + cyb.cycleDetection(undirected, n));
        System.out.println("Number of cycles using DFS : " + cyd.cycleDetection(undirected, n));

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
        spb.shortestPathBFS(directed, n1, 0);
        System.out.println("shortest path in unweighted graph to all nodes using DFS");
        spd.shortestPathDFS(directed, n1, 0);

//     shortest path in weighted graph to all nodes
        ShortestPathBFSW spdw = new ShortestPathBFSW();
        ShortestPathDFSW spbw = new ShortestPathDFSW();
        System.out.println("shortest path in weighted graph to all nodes using BFS");
        spdw.shortestPathBFS(dwg, n3, 0);
        System.out.println("shortest path in weighted graph to all nodes using DFS");
        spbw.shortestPathDFS(dwg, n3, 0);

//        shortest path using topological sort in DAG
        ShortestPathUsingTopo spt = new ShortestPathUsingTopo();
        System.out.println("shortest path in weighted graph to all nodes using topological sort");
        spt.shortestPath(dwg, n3, 0);

//        Dijkstras Algorithm
        DijkstrasAlgo dij = new DijkstrasAlgo();
        System.out.println("shortest path in weighted graph to all nodes using Dijkstras Algorithm");
        dij.dijShortestPath(dwg, n3, 0);

//        Bellman ford Algorithm
        BellmanAlgo bell = new BellmanAlgo();
        System.out.println("shortest path in weighted graph to all nodes using Bellman ford Algorithm");
        bell.bellShortestPath(nwg, nw, 0);

//        Prims algorithm
        PrimsAlgo pa = new PrimsAlgo();
        System.out.println("Minimum spanning tree of the graph using Prims Algorithm");
        pa.primsAlgo(undwg, n);

//      Kruskal Algorithm
        KruskalAlgo ka = new KruskalAlgo();
        System.out.println("Minimum spanning tree of the graph using Kruskal Algorithm");
        ka.kruskalAlgo(wg, w);

    }
}
