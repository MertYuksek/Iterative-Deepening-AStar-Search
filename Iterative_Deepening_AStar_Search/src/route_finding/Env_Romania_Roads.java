package route_finding;

import graph_impl.Graph;

import java.util.HashMap;

public class Env_Romania_Roads {

    private Graph<Node> graph = new Graph();

    public Env_Romania_Roads() {
        createRomaniaEnv();
    }

    private void createRomaniaEnv()
    {

        Node Arad = new Node(State.Arad);
        Node Zerind = new Node(State.Zerind);
        Node Timisoara = new Node(State.Timisoara);
        Node Sibiu = new Node(State.Sibiu);
        Node Oradea = new Node(State.Oradea);
        Node Lugoj = new Node(State.Lugoj);
        Node Fagaras = new Node(State.Fagaras);
        Node Rimnicu_Vilcea = new Node(State.Rimnicu_Vilcea);
        Node Bucharest = new Node(State.Bucharest);
        Node Pitesti = new Node(State.Pitesti);
        Node Craiova = new Node(State.Craiova);
        Node Mehadia = new Node(State.Mehadia);
        Node Drobeta = new Node(State.Drobeta);

        graph.addEdge(Arad, Zerind, 75, true);
        graph.addEdge(Arad, Sibiu, 140, true);
        graph.addEdge(Arad, Timisoara, 118, true);
        graph.addEdge(Zerind, Oradea, 71, true);
        graph.addEdge(Sibiu, Fagaras, 99, true);
        graph.addEdge(Sibiu, Rimnicu_Vilcea, 80, true);
        graph.addEdge(Timisoara, Lugoj, 111, true);
        graph.addEdge(Oradea, Sibiu, 151, true);
        graph.addEdge(Fagaras, Bucharest, 211, true);
        graph.addEdge(Rimnicu_Vilcea, Pitesti, 97, true);
        graph.addEdge(Rimnicu_Vilcea, Craiova, 146, true);
        graph.addEdge(Lugoj, Mehadia, 70, true);
        graph.addEdge(Mehadia, Drobeta, 75, true);
        graph.addEdge(Drobeta, Craiova,120, true);
        graph.addEdge(Craiova, Pitesti, 138, true);
        graph.addEdge(Pitesti, Bucharest, 101, true);

        //System.out.println(graph);
    }

    private HashMap<State,Double> heuristic()
    {
        HashMap<State,Double> hashMap = new HashMap<>();
        hashMap.put(State.Arad,366.0);
        hashMap.put(State.Bucharest,0.0);
        hashMap.put(State.Craiova,160.0);
        hashMap.put(State.Drobeta,242.0);
        hashMap.put(State.Fagaras,176.0);
        hashMap.put(State.Lugoj,244.0);
        hashMap.put(State.Mehadia,241.0);
        hashMap.put(State.Oradea,380.0);
        hashMap.put(State.Pitesti,100.0);
        hashMap.put(State.Rimnicu_Vilcea,193.0);
        hashMap.put(State.Sibiu,253.0);
        hashMap.put(State.Timisoara,329.0);
        hashMap.put(State.Zerind,374.0);
        return hashMap;
    }

    public HashMap<State,Double> getHeuristic()
    {
        return heuristic();
    }

    public Graph<Node> getGraph() {
        return graph;
    }
}
