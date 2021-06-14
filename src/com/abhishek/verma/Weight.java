package com.abhishek.verma;

public class Weight<T,S>{

    public T from_node;
    public S to_node;

    public Weight(T from, S to){
        this.from_node = from;
        this.to_node = to;
    }

    @Override
    public String toString(){
        return new String('['+from_node.toString()+','+to_node.toString()+']');
    }
}
