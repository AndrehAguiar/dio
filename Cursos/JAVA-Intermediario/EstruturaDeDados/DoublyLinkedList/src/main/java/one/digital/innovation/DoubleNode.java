package one.digital.innovation;

public class DoubleNode<T> {

    private T data;
    private DoubleNode<T> nextNode;
    private DoubleNode<T> previousNode;

    public DoubleNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoubleNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DoubleNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoubleNode<T> previousNode) {
        this.previousNode = previousNode;
    }

    @Override
    public String toString() {
        return "DoubleNode{" +
                "data=" + data +
                '}';
    }
}
