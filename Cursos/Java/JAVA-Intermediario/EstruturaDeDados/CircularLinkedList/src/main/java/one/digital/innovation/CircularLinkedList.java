package one.digital.innovation;

public class CircularLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int listSize;

    public CircularLinkedList() {
        this.tail = null;
        this.head = null;
        this.listSize = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.isEmpty()) {
            this.head = newNode;
            this.tail = this.head;
            this.head.setNextNode(this.tail);

        } else {
            newNode.setNextNode(this.tail);
            this.head.setNextNode(newNode);
            this.tail = newNode;

        }
        this.listSize++;
    }

    public void remove(int index) {
        if (index >= this.listSize)
            throw new IndexOutOfBoundsException("Node not found with index " +
                    index + "\nThe last index is " + (this.listSize - 1));

        Node<T> tempNode = this.tail;
        if (index == 0) {
            this.tail = this.tail.getNextNode();
            this.head.setNextNode(this.tail);

        } else if (index == 1) {
            this.tail.setNextNode(this.tail.getNextNode().getNextNode());

        } else {
            for (int i = 0; i < index - 1; i++)
                tempNode = tempNode.getNextNode();

            tempNode.setNextNode(tempNode.getNextNode().getNextNode());
        }

        this.listSize--;
    }

    public boolean isEmpty() {
        return this.listSize == 0;
    }

    public int size() {
        return this.listSize;
    }

    public T get(int index) {
        return this.getNode(index).getData();
    }

    private Node<T> getNode(int index) {
        if (this.isEmpty())
            throw new IndexOutOfBoundsException("The list is empty!");

        if (index == 0)
            return this.tail;

        Node<T> tempNode = this.tail;
        for (int i = 0; (i < index) && (tempNode != null); i++)
            tempNode = tempNode.getNextNode();

        return tempNode;
    }

    @Override
    public String toString() {
        String returnStr = "\n##############\n";
        returnStr += "|-->";
        Node<T> tempNode = this.tail;

        for (int i = 0; i < this.size(); i++) {
            returnStr += "[Node{data= " + tempNode.getData() + "}] |-->";
            tempNode = tempNode.getNextNode();

        }
        returnStr += !this.isEmpty() ?
                "|| Back to tail |--> " :
                "[]";
        returnStr += "\n##############\n";
        return returnStr;
    }
}
