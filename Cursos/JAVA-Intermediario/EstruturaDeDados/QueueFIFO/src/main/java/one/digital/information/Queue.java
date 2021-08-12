package one.digital.information;

public class Queue {

    private Node refNode;

    public Queue() {
        this.refNode = null;
    }

    public void enqueue(Node newNode) {
        newNode.setNextNode(refNode);
        refNode = newNode;
    }

    public Node dequeue() {
        if (!this.isEmpty()) {
            Node firstNode = refNode;
            Node tempNode = refNode;

            while (true) {
                if (firstNode.getNextNode() != null) {
                    tempNode = firstNode;
                    firstNode = firstNode.getNextNode();

                } else {
                    tempNode.setNextNode(null);
                    break;

                }
            }
            return firstNode;
        }
        return null;
    }

    public Node first() {
        if (!this.isEmpty()) {
            Node firstNode = refNode;
            while (true) {
                if (firstNode.getNextNode() != null) {
                    firstNode = firstNode.getNextNode();
                } else {
                    break;
                }
            }
            return firstNode;
        }
        return null;
    }

    public boolean isEmpty() {
        return refNode == null;
    }

    @Override
    public String toString() {
        Node tempNode = refNode;
        String returnStr = "|################|\n";
        returnStr += "       Queue\n";
        returnStr += "|----------------|>\n";

        if (refNode != null) {
            while (true) {
                returnStr += "[Node{object= ";
                returnStr += tempNode.getData();
                returnStr += "}] |---> ";

                if (tempNode.getNextNode() != null) {
                    tempNode = tempNode.getNextNode();

                } else {
                    returnStr += "null\n";
                    returnStr += "|================|>\n";
                    break;
                }
            }
        } else {
            returnStr = "null";
        }
        return returnStr;
    }

}
