package queue;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class FilaBanco {
    public static void main(String[] args) {
        Queue<String>filaBanco = new LinkedList<>();

        filaBanco.add("Pamela");
        filaBanco.add("Patrícia");
        filaBanco.add("Roberto");
        filaBanco.add("Flávio");
        filaBanco.add("Andreson");

        System.out.println(filaBanco);

        String clienteDaVez = filaBanco.poll();
        System.out.println(clienteDaVez);
        System.out.println(filaBanco);

        String firstClient = filaBanco.peek();
        System.out.println(firstClient);
        System.out.println(filaBanco);

        String firstOrError = filaBanco.element();
        System.out.println(firstOrError);
        System.out.println(filaBanco);
        //filaBanco.clear();
        // filaBanco.isEmpty();
        System.out.println(firstOrError);
        System.out.println(filaBanco);
        firstOrError = filaBanco.element();
        System.out.println(firstOrError);

        for(String client: filaBanco){
            System.out.println(client);
        }

        Iterator<String> iteratorFilaBanco = filaBanco.iterator();

        while(iteratorFilaBanco.hasNext()){
            System.out.println("------> "+iteratorFilaBanco.next());
        }

        System.out.println(filaBanco.size());
        System.out.println(filaBanco.isEmpty());

        //Collections.sort(filaBanco);

    }
}
