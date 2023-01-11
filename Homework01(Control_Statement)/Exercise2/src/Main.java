import java.util.Scanner;

public class Main {
    //Write a Java program to calculate perimeter and area of Rectangle, Parallelogram and Ellipse (use switch case and if, else if)
    public static void main(String[] args) {
        System.out.println("Type R for Rectangle, P for Parallelogram and E for Ellipse: ");
        Scanner geo = new Scanner(System.in);
        char option = geo.next().charAt(0);

        switch(option){
            case'R':
                System.out.println("Enter 'p' to calculate perimeter and 'a' for area of the rectangle:");
                Scanner cal = new Scanner(System.in);
                char optR = cal.next().charAt(0);

                if (optR == 'p'){
                    System.out.print("Enter the length of rectangle: ");
                    double length = cal.nextDouble();
                    System.out.print("Enter the width of rectangle: ");
                    double width = cal.nextDouble();
                    double perimeter = 2 * (length + width);
                    System.out.println("Perimeter of rectangle:"+perimeter);
                } else if (optR == 'a'){
                    System.out.print("Enter the length of the rectangle: ");
                    double length = cal.nextDouble();
                    System.out.print("Enter the width of the rectangle: ");
                    double width = cal.nextDouble();
                    double area = (length * width);
                    System.out.println("Perimeter of the rectangle:"+area);
                }
                break;
            case'P':
                System.out.println("Enter 'p' to calculate perimeter and 'a' for area of the parallelogram:");
                Scanner calP = new Scanner(System.in);
                char optP = calP.next().charAt(0);

                if (optP == 'p'){
                    System.out.print("Enter base of the parallelogram: ");
                    double base = calP.nextDouble();
                    System.out.print("Enter the height of rectangle: ");
                    double height = calP.nextDouble();
                    double perimeter = 2 * (base + height);
                    System.out.println("Perimeter of the parallelogram:"+perimeter);
                } else if (optP == 'a'){
                    System.out.print("Enter the base of the parallelogram: ");
                    double base = calP.nextDouble();
                    System.out.print("Enter the height of the parallelogram: ");
                    double height = calP.nextDouble();
                    double area = (base * height);
                    System.out.println("Perimeter of the parallelogram:"+area);
                }
                break;
            case'E':
                System.out.println("Enter 'p' to calculate perimeter and 'a' for area of the ellipse:");
                Scanner calE = new Scanner(System.in);
                char optE = calE.next().charAt(0);

                if (optE == 'p'){
                    System.out.print("Enter the a-axis of the ellipse: ");
                    double a_axis = calE.nextDouble();
                    System.out.print("Enter the b-axis of ellipse: ");
                    double b_axis = calE.nextDouble();
                    double perimeter = Math.PI * a_axis * b_axis;
                    System.out.println("Perimeter of the ellipse:"+perimeter);
                } else if (optE == 'a'){
                    System.out.print("Enter the a-axis of the ellipse: ");
                    double a_axis = calE.nextDouble();
                    System.out.print("Enter the b-axis of the ellipse: ");
                    double b_axis = calE.nextDouble();
                    double area = Math.PI * (3 * (a_axis + b_axis)  - Math.sqrt((3 * a_axis + b_axis) * (a_axis + b_axis * 3)));
                    System.out.println("Perimeter of the ellipse:"+area);
                }
                break;

        }

    }
}