package one.digital.innovation;

public class Node {

    private String content;
    private Node nextNode;

    public Node(String content) {
        this.nextNode = null;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
                "content='" + content + '\'' +
                '}';
    }
}
