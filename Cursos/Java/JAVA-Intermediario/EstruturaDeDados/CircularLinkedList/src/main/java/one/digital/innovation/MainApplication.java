package one.digital.innovation;

public class MainApplication {
    public static void main(String[] args) {
        CircularLinkedList<String> circularLinkedList = new CircularLinkedList<>();

        System.out.println("List is empty? " + circularLinkedList.isEmpty());
        circularLinkedList.add("n0");
        System.out.println(circularLinkedList);
        System.out.println("List is empty? " + circularLinkedList.isEmpty());

        circularLinkedList.remove(0);
        System.out.println(circularLinkedList);
        System.out.println("List is empty? " + circularLinkedList.isEmpty());

        circularLinkedList.add("n1");
        System.out.println(circularLinkedList);

        circularLinkedList.add("n2");
        circularLinkedList.add("n3");
        System.out.println(circularLinkedList);

        System.out.println(circularLinkedList.get(0));
        System.out.println(circularLinkedList.get(1));
        System.out.println(circularLinkedList.get(2));

        System.out.println(circularLinkedList.get(3));

        for (int i = 0; i < 20; i++) {
            System.out.print(circularLinkedList.get(i) + " |--> ");
        }
    }
}
