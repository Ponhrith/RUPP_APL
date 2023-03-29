package Game;

import java.util.Scanner;

public class HumanPlayer extends Player{
    Scanner scanner;
    public HumanPlayer()
    {
         scanner = new Scanner(System.in);
        System.out.print("Enter your name:");
        name = scanner.nextLine();
    }
    String choice;
    public String promptInput()
    {
        System.out.print("\nRock, paper, or scissors? (r/p/s):");
        return scanner.nextLine();
    }
    @Override
    String play() {
        choice = checkInput(promptInput());
        System.out.print(this.name+" choose "+choice+"\n");
        return choice;
    }
}
