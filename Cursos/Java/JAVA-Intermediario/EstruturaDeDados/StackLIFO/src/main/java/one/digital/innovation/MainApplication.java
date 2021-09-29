package one.digital.innovation;

public class MainApplication {
    public static void main(String[] args) {

        Stack stackLIFO = new Stack();

        System.out.println(stackLIFO.isEmpty());

        stackLIFO.push(new Node(1));
        stackLIFO.push(new Node(2));
        stackLIFO.push(new Node(3));
        stackLIFO.push(new Node(4));
        stackLIFO.push(new Node(5));
        stackLIFO.push(new Node(6));

        System.out.println(stackLIFO);

        System.out.println(stackLIFO.pop());
        System.out.println(stackLIFO);

        System.out.println(stackLIFO.pop());
        stackLIFO.push(new Node(99));
        System.out.println(stackLIFO);

        System.out.println(stackLIFO.isEmpty());
    }
}
