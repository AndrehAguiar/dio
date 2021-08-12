package one.digital.innovation;

public class SinglyLinkedList<T> {

    private Node refNode;

    public SinglyLinkedList() {
        this.refNode = null;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.isEmpty()) {
            this.refNode = newNode;
            return;
        }
        Node<T> tempNode = this.refNode;
        for (int i = 0; i < this.size() - 1; i++) {
            tempNode = tempNode.getNextNode();
        }
        tempNode.setNextNode(newNode);
    }

    public int size() {
        int listSize = 0;
        Node<T> tempNode = this.refNode;
        while (true) {
            if (tempNode != null) {
                listSize++;
                if (tempNode.getNextNode() != null) {
                    tempNode = tempNode.getNextNode();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return listSize;
    }

    public boolean isEmpty() {
        return this.refNode == null;
    }

    public T get(int index) {
        return getRefNode(index).getData();
    }

    public T remove(int index) {
        Node<T> nodeToRemove = this.getRefNode(index);
        if (index == 0) {
            this.refNode = nodeToRemove.getNextNode();
            return nodeToRemove.getData();
        }
        Node<T> previousNode = getRefNode(index - 1);
        previousNode.setNextNode(nodeToRemove.getNextNode());
        return nodeToRemove.getData();
    }

    @Override
    public String toString() {
        String returnStr = "#################\n";
        Node<T> tempNode = this.refNode;
        for (int i = 0; i < this.size(); i++) {
            returnStr += "Node{data= " + tempNode.getData() + "} |--> ";
            tempNode = tempNode.getNextNode();
        }
        returnStr += "null\n";
        returnStr += "#################";
        return returnStr;
    }

    private void ifExists(int index) {
        int listSize = this.size() - 1;
        if (index > listSize) {
            throw new IndexOutOfBoundsException(
                    "Node with index " + index + " not found.\n" +
                            "The last index is " + listSize
            );
        }
    }

    private Node<T> getRefNode(int index) {
        this.ifExists(index);
        Node<T> tempNode = this.refNode;
        Node<T> returnNode = null;

        for (int i = 0; i <= index; i++) {
            returnNode = tempNode;
            tempNode = tempNode.getNextNode();
        }
        return returnNode;

    }

}
