import java.util.Scanner;

public class Main {
    //Write a Java program to solve quadratic equations (use if, else if and else).
    public static void main(String[] args) {
        System.out.println("Enter a,b,c to solve a quadratic equation");
        Scanner a = new Scanner(System.in);
        System.out.println("Enter a: ");
        int a_a = a.nextInt();

        Scanner b = new Scanner(System.in);
        System.out.println("Enter b: ");
        int b_b = b.nextInt();

        Scanner c = new Scanner(System.in);
        System.out.println("Enter c: ");
        int c_c = c.nextInt();

        System.out.println("Find delta: ");
        double delta = (Math.pow(b_b, 2) - (4 * a_a * c_c));

        if (delta > 0.0) {
            double root = Math.sqrt(delta);
            System.out.println("Delta is positive, The equation has 2 real solutions:");
            System.out.println((-b_b + root) / (2 * a_a));
            System.out.println((-b_b - root) / (2 * a_a));;

        } else if (delta < 0.0) {
            double root = Math.sqrt(-delta);
            System.out.println("Delta is negative, The equation has 2 complex solutions:");
            System.out.println((-b_b / (2 * a_a)) + " + i" + root / (2 * a_a));
            System.out.println((-b_b / (2 * a_a)) + " - i" + root / (2 * a_a));

        } else {
            System.out.println("Delta is 0, The equation has only 1 real solution::");
            System.out.println(-b_b / (2 * a_a));
        }
    }
}