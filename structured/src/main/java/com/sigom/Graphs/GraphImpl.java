package com.sigom.Graphs;

import java.util.*;


public class GraphImpl<T> implements IGraph{

    private Map<String, List<String>> map = new HashMap<>();

    @Override
    public void addVertex(String s) {
       map.put(s, new ArrayList<String>());
    }

    @Override
    public void addEdge(String source, String destination, boolean bidirectional) {
         if(!map.containsKey(source) ) {
            addVertex(source);
         }
         if(!map.containsKey(destination)){
             addVertex(destination);
         }
         map.get(source).add(destination);
         if (bidirectional){
             map.get(destination).add(source);
         }
    }

    @Override
    public void getVertexCount() {
        System.out.println("Number of vertex = " + map.keySet().size());
    }

    @Override
    public void getEdgesCount(boolean bidirection) {
          int counter = 0;
          for(String c : map.keySet()){
              counter = counter + map.get(c).size();
          }
          if(bidirection){
              counter = counter/2;
          }
          System.out.println("Number of edges = " + counter);

    }

    @Override
    public void hasVertex(String s) {
          boolean exist = map.containsKey(s);
          if (exist){
              System.out.println("The object [" + s + "] " + "exist");
          } else {
              System.out.println(s + " do not exist ");
          }
    }

    @Override
    public String hasEdge(String s, String d) {
        return map.get(s).contains(d)? "Yes" : "No";
    }

    @Override
    public String print() {
        StringBuilder str = new StringBuilder();
        for (String ver : map.keySet()){
            str.append("["+ver+"] -> ");
            for(String edg : map.get(ver)){
                str.append(edg + ", ");
            }
            str.append("\n");
        }
        return str.toString();
    }
}
