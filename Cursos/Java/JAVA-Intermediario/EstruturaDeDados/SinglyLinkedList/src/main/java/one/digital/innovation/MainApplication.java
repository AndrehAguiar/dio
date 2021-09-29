package one.digital.innovation;

public class MainApplication {
    public static void main(String[] args) {

        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.add("test1");
        singlyLinkedList.add("test2");
        singlyLinkedList.add("test3");
        singlyLinkedList.add("test4");

        System.out.println(singlyLinkedList.get(0));
        System.out.println(singlyLinkedList.get(1));
        System.out.println(singlyLinkedList.get(2));
        System.out.println(singlyLinkedList.get(3));
        System.out.println(singlyLinkedList);

        System.out.println(singlyLinkedList.remove(3));
        System.out.println(singlyLinkedList);

    }
}
