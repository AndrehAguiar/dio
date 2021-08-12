package one.digital.innovation;

public class Stack {

    private Node refNode;

    public Stack() {
        this.refNode = null;
    }

    public Node pop() {
        if (!this.isEmpty()) {
            Node nodePoped = refNode;
            refNode = refNode.getNextNode();
            return nodePoped;
        }
        return null;
    }

    public void push(Node newNode) {
        Node tempNode = refNode;
        refNode = newNode;
        refNode.setNextNode(tempNode);
    }

    public Node top() {
        return refNode;
    }

    public boolean isEmpty() {
        return refNode == null;
    }

    @Override
    public String toString() {
        String returnStr = "----------------\n";
        returnStr += "     Stack\n";
        returnStr += "----------------\n";

        Node tempNode = refNode;

        while (true) {
            if (tempNode != null) {
                returnStr += "[Node{data = " + tempNode.getData() + "}]\n";
                tempNode = tempNode.getNextNode();
            } else {
                break;
            }
        }
        returnStr += "================\n";
        return returnStr;
    }
}
