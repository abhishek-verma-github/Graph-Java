package com.abhishek.verma;

import java.lang.Integer;


public class VertexNode<T> {
    public String identifier;
    public T value;
    public VertexNode parent = null;
    public Integer d = Integer.MAX_VALUE;
    public Integer f = Integer.MAX_VALUE;
    public String color = colors.WHITE;
    public String property_color = colors.WHITE;


    public VertexNode(String identifier, T value ){
        this.identifier = identifier;
        this.value = value;

        this.parent = null;
        this.d = Integer.MAX_VALUE;
        this.f = Integer.MAX_VALUE;
        this.color = colors.WHITE;
        this.property_color = colors.WHITE;

    }

    @Override
    public String toString(){
        String s = "Vertex[Identifier=" + this.identifier + " , Value=" + this.value.toString();
        return s;
    }

    @Override
    public boolean equals(Object o){
        VertexNode other = (VertexNode) o;
        if(this.identifier.equals(other.identifier)) return true;
        else{
            return false;
        }
    }

}

