package com.sigom.Graphs;


public class Main {
    public static void main(String[] args){

//        IGraph g = new GraphImpl();
//        g.addEdge("A", "C", false);
//        g.addEdge("A", "B", false);
//        g.addEdge("C", "D", false);
//        g.addEdge("D", "A", false);
//        g.addEdge("B", "D", false);
//        System.out.println(g.print());


        String[] employeesInput = {
                "Richard",
                "Erin",
                "Monica",
                "Dinesh",
                "Carla",
                "Piero"
        };
        String[] friendshipsInput = {
                "Richard,Monica",
                "Richard,Erin",
                "Erin,Dinesh",
                "Monica,Carla",
                "Carla,Piero"
        };

        IGraph ripley = new GraphImpl();
        ripley.buildGraph(employeesInput, friendshipsInput);
        System.out.println(ripley.print());
        System.out.println(ripley.BFS("Richard"));
        System.out.println(ripley.DFS("Richard"));
        ripley.printRelationship();
//        for(String emp: employeesInput){
//            ripley.addVertex(emp);
//        }
//        for(String rel: friendshipsInput){
//            String[] friend = rel.split(",");
//            ripley.addEdge(friend[0], friend[1], false);
//        }
//
//        System.out.println("is Richard friend of Carla? " + ripley.hasEdge("Richard", "Carla") );
//        System.out.println("is Richard friend of Monica? " + ripley.hasEdge("Richard", "Monica") );



    }
}
