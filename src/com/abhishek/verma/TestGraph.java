package com.abhishek.verma;

import com.abhishek.verma.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class TestGraph {

    public static void main(String[] args){

        // test graph:

        Graph g = new Graph(false,true);

        g.addNode("A",1);
        g.addNode("B",2);
        g.addNode("C",3);
        g.addNode("D",4);
        g.addNode("E",2);

        g.addEdge("A","B",4);
        g.addEdge("B","C",1);
        g.addEdge("C","A",4);
        g.addEdge("D","E",1);
        g.addEdge("B","E",5);
        g.addEdge("C","D",5);

        ArrayList<String> adv = g.getAdjacentVertices("B");

        adv.forEach(s -> System.out.print(s+' '));
        System.out.println();

        HashMap<Weight<String,String>,Integer> ws = g.getWeights();

        for(Map.Entry<Weight<String,String>,Integer> m: ws.entrySet()){
            System.out.println(m.getKey().toString() + "," + m.getValue());
        }


        Optional<ArrayList<String>> bfs = g.BFS("A");

        bfs.ifPresent(s -> System.out.print(s+", "));


        Optional<ArrayList<ArrayList<String>>> dfs = g.DFS(true);

        dfs.ifPresent(s->System.out.print(s+", "));

    }

}
