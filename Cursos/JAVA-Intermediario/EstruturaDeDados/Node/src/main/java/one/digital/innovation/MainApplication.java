package one.digital.innovation;

public class MainApplication {
    public static void main(String[] args) {

        Node node1 = new Node("Content node1");

        Node node2 = new Node("Content node2");
        node1.setNextNode(node2);

        Node node3 = new Node("Content node3");
        node2.setNextNode(node3);

        Node node4 = new Node("Content node4");
        node3.setNextNode(node4);

        System.out.println(node1);
        System.out.println(node1.getNextNode());
        System.out.println(node2.getNextNode());
        System.out.println(node3.getNextNode());
        System.out.println(node4.getNextNode());
    }
}
