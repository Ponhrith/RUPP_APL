package Game;

import java.util.Random;

public class ComputerPlayer extends Player{
    String choice;
    @Override
    String play() {

        Random rand = new Random();
        int x = rand.nextInt(3);

        if(x == 0)
        {
            choice ="Rock";
        }
        else if(x == 1)
        {
            choice ="Paper";
        }
        else
        {
            choice ="Scissors";
        }
        System.out.print("Computer choose "+choice+"\n");
        return choice;
    }
}
