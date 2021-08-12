package one.digital.innovation;

public class DoublyLinkedList<T> {

    private DoubleNode<T> firstNode;
    private DoubleNode<T> lastNode;
    private int listSize;

    public DoublyLinkedList() {
        this.firstNode = null;
        this.lastNode = null;
        this.listSize = 0;
    }

    public int size() {
        return this.listSize;
    }

    public T get(int index) {
        return this.getNode(index).getData();
    }

    public void add(T data) {
        DoubleNode<T> newNode = new DoubleNode<>(data);
        newNode.setNextNode(null);
        newNode.setPreviousNode(this.lastNode);

        if (this.firstNode == null)
            this.firstNode = newNode;

        if (this.lastNode != null)
            this.lastNode.setNextNode(newNode);

        this.lastNode = newNode;
        this.listSize++;
    }

    public void add(int index, T data) {
        DoubleNode<T> tempNode = getNode(index);
        DoubleNode<T> newNode = new DoubleNode<>(data);
        newNode.setNextNode(tempNode);

        if (newNode.getNextNode() != null) {
            newNode.setPreviousNode(tempNode.getPreviousNode());
            newNode.getNextNode().setPreviousNode(newNode);
        } else {
            newNode.setPreviousNode(this.lastNode);
            this.lastNode = newNode;

        }
        if (index == 0) {
            this.firstNode = newNode;

        } else {
            newNode.getPreviousNode().setNextNode(newNode);

        }
        this.listSize++;
    }

    public void remove(int index) {
        if (index == 0) {
            this.firstNode = this.firstNode.getNextNode();

            if (this.firstNode != null)
                this.firstNode.setPreviousNode(null);

        } else {
            DoubleNode<T> tempNode = this.getNode(index);
            tempNode.getPreviousNode().setNextNode(tempNode.getNextNode());

            if (tempNode != this.lastNode) {
                tempNode.getNextNode().setPreviousNode(tempNode.getPreviousNode());

            } else {
                this.lastNode = tempNode;

            }
        }
        this.listSize--;
    }

    @Override
    public String toString() {
        String returnStr = "#####################\n";
        DoubleNode<T> tempNode = this.firstNode;
        for (int i = 0; i < this.size(); i++) {
            returnStr += "[Node{data= " + tempNode.getData() + "}] <-|-> ";
            tempNode = tempNode.getNextNode();
        }
        returnStr += "null\n";
        returnStr += "#####################\n";
        return returnStr;
    }

    private DoubleNode<T> getNode(int index) {
        DoubleNode<T> tempNode = this.firstNode;

        for (int i = 0; (i < index) && (tempNode != null); i++) {
            tempNode = tempNode.getNextNode();

        }
        return tempNode;
    }
}
