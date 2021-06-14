package com.abhishek.verma;
import java.util.*;
import java.lang.Integer;

public class Graph {

    private boolean undirected;
    private boolean weighted;

    public ArrayList<VertexNode<Integer>> vertices;
    public HashMap<String,ArrayList<String>> edges;
    public HashMap<Weight<String,String>,Integer> weights;
    public HashMap<String,VertexNode<Integer>> vertices_hashmap;

    public Graph(boolean undirected, boolean weighted){
        this.undirected = undirected;
        this.weighted = weighted;
        if(this.weighted){
            this.weights = new HashMap<>();
        }

        this.vertices = new ArrayList<>();
        this.edges = new HashMap<>();
        this.vertices_hashmap = new HashMap<>();

    }

    public void addNode(String identifier, Integer value){
        VertexNode<Integer> new_node = new VertexNode<>(identifier, value);
        vertices.add(new_node);
        vertices_hashmap.put(new_node.identifier,new_node);
    }

    public ArrayList<VertexNode<Integer>> getVertices(){
        return this.vertices;
    }

    private VertexNode<Integer> getNodeFromIdentifier(String identifier){
        VertexNode<Integer> node = vertices_hashmap.get(identifier);
        return node;
    }

    public void addEdge(String from_node, String to_node, Integer weight){

        edges.putIfAbsent(from_node, new ArrayList<>());
        edges.get(from_node).add(to_node);

        if(!(weight == null)){
            Weight<String,String> w = new Weight<>(from_node, to_node);
            weights.put(w, weight);
        }
    }

    public ArrayList<String> getAdjacentVertices(String node_identifier){
        ArrayList<String> vertices_list = (ArrayList<String>) edges.getOrDefault(node_identifier, new ArrayList<String>());
        return vertices_list;
    }

    public HashMap<String,ArrayList<String>> getEdges(){
        return this.edges;
    }

    public HashMap<Weight<String,String>,Integer> getWeights(){
        return this.weights;
    }


    public Optional<ArrayList<String>> BFS(String source_identifier){

        ArrayList<String> bfs = new ArrayList<>();

        for(VertexNode<Integer> u: this.vertices){
            u.color = colors.WHITE;
            u.d = Integer.MAX_VALUE;
            u.parent = null;
        }

        VertexNode<Integer> s = getNodeFromIdentifier(source_identifier);
        s.color = colors.GRAY;
        s.d = 0;
        s.parent = null;

        ArrayList<VertexNode<Integer>> queue = new ArrayList<>();
        queue.add(s);
        while(!queue.isEmpty()){
            VertexNode<Integer> u = queue.get(0);
            queue.remove(0);

            for(String v_identifier:getAdjacentVertices(u.identifier)){
                VertexNode<Integer> v = getNodeFromIdentifier(v_identifier);
                if(v.color == colors.WHITE){
                    v.parent = u;
                    v.color = colors.GRAY;
                    v.d = u.d + 1;
                    queue.add(v);
                }
            }
            u.color = colors.BLACK;
            bfs.add(u.identifier);

        }

//        String bfs_result = String.join(", ", bfs );


        Optional<ArrayList<String>> opt = Optional.ofNullable(bfs);
        return opt;
    }


    private void DFSVisit(VertexNode<Integer> u, int time, ArrayList<String> l){
        time++;
        u.d = time ;
        u.color = colors.GRAY;

        ArrayList<String> adju = getAdjacentVertices(u.identifier);

        for(String v_identifier : adju){
            VertexNode<Integer> v = getNodeFromIdentifier(v_identifier);
            if(v.color == colors.WHITE){
                v.parent = u;
                DFSVisit(v,time,l);

            }
        }

        time++;
        u.f = time;
        u.color = colors.BLACK;
        l.add(u.identifier);
    }

    public Optional<ArrayList<ArrayList<String>>> DFS(boolean return_forest){

        ArrayList<ArrayList<String>> forest = new ArrayList<>();

        Integer time = 0;

        for(VertexNode<Integer> u : getVertices()){
            u.color = colors.WHITE;
            u.d = 0;
            u.d = 0;
            u.parent = null;
        }

        for(VertexNode<Integer> u : getVertices()){
            if(u.color == colors.WHITE){
                ArrayList<String> l = new ArrayList<>();
                DFSVisit(u,time,l);
                forest.add(l);
            }
        }


        Optional<ArrayList<ArrayList<String>>> opt = Optional.ofNullable(forest);
        return opt;

    }


}
