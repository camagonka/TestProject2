package my_package;

public class MyFirstProgram {

    public static void main(String[] args) {

        hello("world");
        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + area(s));
    }

    public static void hello(String somebody) {

        System.out.println("Hello " + somebody);
    }

    private static double area(Square s){

        return s.l+s.l;
    }
}
