public class conversion
 {
    public static void main(String[] args) 
    {
        byte b;
        int i = 257;
        double d = 323.142;
        System.out.println("\nConversion of int into byte");
         b = (byte) i;
        System.out.println("i and b " + i + " " +b);


        System.out.println("\nConversion of double into int");
        i = (int) d;
        System.out.println("d and i " + d + " " + i);

        System.out.println("\nConversion of double into byte");
        b = (byte) d;
        System.out.println("d and b " + d + " " + b);
    }
}
//6th program