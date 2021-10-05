package com.sigom.Graphs;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {
    public static void main(String[] args){

        IGraph g = new GraphImpl();
        g.addEdge("A", "C", false);
        g.addEdge("A", "B", false);
        g.addEdge("C", "D", false);
        g.addEdge("D", "A", false);
        g.addEdge("B", "D", false);
        System.out.println(g.print());


        String[] employeesInput = {
                "Richard",
                "Erlich",
                "Monica",
                "Dinesh",
                "Carla"
        };
        String[] friendshipsInput = {
                "Richard,Erlich",
                "Richard,Monica",
                "Erlich,Dinesh"
        };

        IGraph ripley = new GraphImpl();
        for(String emp: employeesInput){
            ripley.addVertex(emp);
        }
        for(String rel: friendshipsInput){
            String[] friend = rel.split(",");
            ripley.addEdge(friend[0], friend[1], false);
        }

        System.out.println("is Richard friend of Carla? " + ripley.hasEdge("Richard", "Carla") );
        System.out.println("is Richard friend of Monica? " + ripley.hasEdge("Richard", "Monica") );
    }
}
