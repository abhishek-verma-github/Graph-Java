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
        return '['+from_node.toString()+','+to_node.toString()+']';
    }

    @Override
    public int hashCode(){
        return 89 + from_node.hashCode() + to_node.hashCode();
    }

    @Override
    public boolean equals(Object other){

        if(!(other instanceof Weight )) return false;
        Weight<T,S> o = (Weight<T,S>) other;
        if(this == o) return true;
        return (from_node.toString().compareTo(o.from_node.toString()) == 0)
                        && (to_node.toString().compareTo(o.to_node.toString()) == 0);
    }
}
