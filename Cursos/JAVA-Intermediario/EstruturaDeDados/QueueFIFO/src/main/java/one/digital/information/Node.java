package one.digital.information;

public class Node {

    private Object data;
    private Node nextNode;

    public Node() {
        this.nextNode = null;
    }

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
