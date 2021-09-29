package one.digital.innovation;

public class MainApplication {
    public static void main(String[] args) {
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();

        doublyLinkedList.add("test1");
        doublyLinkedList.add("test2");
        doublyLinkedList.add("test3");
        doublyLinkedList.add("test4");
        doublyLinkedList.add("test5");
        doublyLinkedList.add("test6");
        System.out.println(doublyLinkedList);

        System.out.println(doublyLinkedList.get(3));
        doublyLinkedList.remove(3);
        doublyLinkedList.add(3, "99");
        System.out.println(doublyLinkedList);
    }
}
