package one.digitalIinnovation.tipos.primitivos;

public class Primitivos {

    public static void main(String[] args) {
        // INTEIROS

        //byte nullByte = null;

        byte b;                             // 8 bits
        byte b1 = 127;                      // MAX
        byte b2 = -128;                     // MIN
        //byte b3 = 129;                    // to large


        char c;                             // 16 bits
        char c1;
        char c2;
        //char c3 = 'AA;                    // NOK
        //char c4 = -100;                   // NOK

        short s;                            // 16 bits
        short s1 = 32767;                   // MAX
        short s2 = -32768;                  // MIN

        int i1 = 2141483647;                //32 bits MAX
        int i2 = -2141483648;               //32 bits MIN
        //int i3 = -2141483648;             //to large

        long l = 9223372036854775807l;      // 64 bits MAX
        long l1 = -9223372036854775808l;    // 64 bits MIN
        //long l2 = 9223372036854775808l;   // to large

        float f = 65f;                      //32 bits 3.402,823,5 E+38
        float f1 = 65.0f;
        float f2 = -0.5f;                   // 1.4 E-45

        double d = 1024.99;                 // 64 bits
        double d1 = 10.2456;                 // 64 bits 4.9 E-324

        boolean bo1 = true;
        boolean bo2 = false;
        //boolean bo2 = "true";                // NOK
        //boolean bo3 = "false";                 // NOK

    }
}
