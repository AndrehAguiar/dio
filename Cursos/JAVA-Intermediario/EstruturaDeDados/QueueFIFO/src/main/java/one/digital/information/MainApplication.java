package one.digital.information;

public class MainApplication {
    public static void main(String[] args) {

        Queue queue = new Queue();

        System.out.println(queue.isEmpty());

        queue.enqueue(new Node("first"));
        queue.enqueue(new Node("second"));
        queue.enqueue(new Node("third"));
        queue.enqueue(new Node("fourth"));
        queue.enqueue(new Node("fifth"));
        System.out.println(queue);

        System.out.println(queue.dequeue());

        System.out.println(queue);
        queue.enqueue(new Node("last"));
        System.out.println(queue);

        System.out.println(queue.first());
        System.out.println(queue);

        System.out.println(queue.isEmpty());
    }
}
