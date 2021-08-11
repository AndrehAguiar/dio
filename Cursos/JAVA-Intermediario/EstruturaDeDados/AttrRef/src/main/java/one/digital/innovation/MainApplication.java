package one.digital.innovation;

public class MainApplication {

    public static void main(String[] args) {
        int a = 1;
        int b = a;

        System.out.println("int 'a'= " + a + ", int 'b'= " + b);
        a = 2;
        System.out.println("int 'a'= " + a + ", int 'b'= " + b);

        Obj aObj = new Obj(1);
        Obj bObj = aObj;

        System.out.println("aObj= " + aObj + ", bObj= " + bObj);
        aObj.setNum(2);
        System.out.println("aObj= " + aObj + ", bObj= " + bObj);

    }

}
