package route_finding;

import graph_impl.Destination;
import graph_impl.Graph;

import java.util.*;

public class Search_Agent {

    private Graph<Node> tGraph;
    private HashMap<State,Double> heuristic;

    public Search_Agent(Graph tGraph)
    {
        this.tGraph = tGraph;
    }

    public Search_Agent(Graph<Node> tGraph, HashMap<State, Double> heuristic) {
        this.tGraph = tGraph;
        this.heuristic = heuristic;
    }

    public void Iterative_Deepening_AStar_Search(State initialState, State goalState)
    {
        Comparator<Node> c = (o1, o2) ->
                (int) ((o1.getPathCost()+heuristic(o1)) -
                        (o2.getPathCost()+heuristic(o2)));

        PriorityQueue<Node> frontier = new PriorityQueue<>(c);
        Node parentNode = findNode(initialState);
        Node initialNode = parentNode;

        if(parentNode.getState() == goalState)
        {
            printPath(parentNode,parentNode);
            return;
        }
        else if(parentNode == null){
            System.out.println("Initial state is null!");
            return;
        }

        parentNode.setParentNode(parentNode);
        parentNode.setKey(parentNode);
        parentNode.setVisited(0);
        frontier.add(parentNode);

        double treshold = parentNode.getPathCost() +
                heuristic(parentNode);

        int isCylce = 0;
        List<Destination<Node>> list;
        Node ndParent;

        while (!frontier.isEmpty())
        {
            ndParent = frontier.poll();
            System.out.println("NDParent " + ndParent.getState());
            list = tGraph.getAdjacencies(ndParent.getKey());

            double heuristicValue = heuristic(ndParent);
            System.out.println("Value :" + (ndParent.getPathCost() + heuristicValue));
            System.out.println("Treshold : " + treshold);
            if(ndParent.getPathCost() + heuristicValue > treshold)
            {
                treshold = heuristicValue + ndParent.getPathCost();
                System.out.println("New Treshold : " + treshold);
                frontier.clear();
                isCylce++;
                initialNode.setPathCost(0);
                initialNode.setVisited(isCylce);
                frontier.add(initialNode);
                continue;
            }
            else if(ndParent.getState() == goalState)
            {
                printPath(ndParent,initialNode);
                return;
            }

            if(list != null)
            {
                for (Destination<Node> node : list)
                {
                    node.getT().setPathCost(ndParent.getPathCost()+
                            node.getWeight());
                    if(ndParent.getParentNode().getState() !=
                            node.getT().getState())
                    {
                        node.getT().setParentNode(ndParent);
                    }

                    if(!node.getT().isVisited(isCylce))
                    {
                        frontier.add(node.getT());
                        node.getT().setVisited(isCylce);
                    }
                }
                System.out.println(frontier);
            }
        }
        System.out.println("No Path!!!");
    }

    private double heuristic(Node nd)
    {
        return heuristic.get(nd.getState());
    }

    private void printPath(Node parentNode, Node initialNode)
    {
        StringBuilder builder = new StringBuilder();
        while (parentNode.getState() != initialNode.getState())
        {
            builder.append(parentNode.getState()+" <-- ");
            parentNode = parentNode.getParentNode();
        }
        builder.append(initialNode.getState());
        System.out.println(builder);
    }

    private Node findNode(State state)
    {
        for (Object node : tGraph.keySet())
        {
            if(((Node)node).getState() == state)
            {
                return (Node) node;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Env_Romania_Roads env_romania_roads = new Env_Romania_Roads();
        Search_Agent agent = new Search_Agent(env_romania_roads.getGraph(),
                env_romania_roads.getHeuristic());

        agent.Iterative_Deepening_AStar_Search(State.Arad,State.Bucharest);
    }
}
