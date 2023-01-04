import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the mark: ");
        int mark = input.nextInt();

        if (mark >= 50){
            System.out.print("PASS\n");
        }else{
            System.out.print("FAIL\n");
        }
        System.out.print("DONE");
        System.exit(0);
    }
}