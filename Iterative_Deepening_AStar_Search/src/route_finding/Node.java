package route_finding;

public class Node {

    private State state;
    private Node parentNode;
    private double pathCost;
    private int visited = -1;
    private Node Key = this;

    public Node(State state) {
        this.state = state;
    }

    public Node(State state, Node parentNode, double pathCost, Node key) {
        this.state = state;
        this.parentNode = parentNode;
        this.pathCost = pathCost;
        Key = key;
    }

    public void setKey(Node key) {
        Key = key;
    }

    public State getState() {
        return state;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public double getPathCost() {
        return pathCost;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public void setPathCost(double pathCost) {
        this.pathCost = pathCost;
    }

    public Node getKey() {
        return Key;
    }

    public boolean isVisited(int limitSize) {
        return visited == limitSize;
    }

    public int getVisited() {
        return visited;
    }

    public void setVisited(int visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                '}';
    }
}
