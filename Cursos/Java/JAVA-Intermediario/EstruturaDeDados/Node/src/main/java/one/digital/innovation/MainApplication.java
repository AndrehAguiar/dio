package one.digital.innovation;

public class MainApplication {
    public static void main(String[] args) {

        Node<String> node1 = new Node<>("Content node1");

        Node<String> node2 = new Node<>("Content node2");
        node1.setNextNode(node2);

        Node<String> node3 = new Node<>("Content node3");
        node2.setNextNode(node3);

        Node<String> node4 = new Node<>("Content node4");
        node3.setNextNode(node4);

        System.out.println(node1);
        System.out.println(node1.getNextNode());
        System.out.println(node1.getNextNode().getNextNode());
        System.out.println(node1.getNextNode().getNextNode().getNextNode());
        System.out.println(node1.getNextNode().getNextNode().getNextNode().getNextNode());
    }
}
