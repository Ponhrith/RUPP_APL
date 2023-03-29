package Game;

import java.util.Scanner;

public class GameController {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Game gameObject = new Game();
        do {

            gameObject.play();

            System.out.print("Play Again? ( Y/N )");
        }while(input.nextLine().equals("y"));


    }
}
