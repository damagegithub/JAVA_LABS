import java.math.BigDecimal;

public class JavaClass {
    public static void main(String[] args) {
        //Урок 1
        Object i = 1;
        Object s = "";
        if (i instanceof String) {
            System.out.println("Integer instanceof String");
        } else if (s instanceof Integer) {
            System.out.println("String instanceof Integer");
        }
        //Урок 2
        BigDecimal bigDecimal1 = new BigDecimal(3);
        BigDecimal bigDecimal2 = new BigDecimal(3);
        System.out.printf("bigDecimal1.equals(bigDecimal2) = %s\n", bigDecimal1.equals(bigDecimal2));
        System.out.printf("bigDecimal1 == bigDecimal2 = %s\n", bigDecimal1 == bigDecimal2);
        System.out.printf("bigDecimal1.compareTo(bigDecimal2) = %d\n", bigDecimal1.compareTo(bigDecimal2));
        System.out.printf("bigDecimal1.add(bigDecimal2) = %d\n", bigDecimal1.add(bigDecimal2).toBigInteger());
        System.out.printf("bigDecimal1.multiply(bigDecimal2) = %d\n", bigDecimal1.multiply(bigDecimal2).toBigInteger());
        System.out.printf("bigDecimal1.divide(bigDecimal2) = %d\n", bigDecimal1.divide(bigDecimal2).toBigInteger());
        System.out.println("Operators +, /, * is undefined for BigDecimal");

    }
}
