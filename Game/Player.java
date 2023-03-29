package Game;

import java.util.Scanner;

public abstract class Player {
    String name;
    abstract String play();
    String checkInput(String input)
    {
        String theInput = input.toLowerCase();
        if(theInput.equals("r"))
        {
            return "Rock";
        }
        else if(theInput.equals("p"))
        {
            return "Paper";
        }
        else if(theInput.equals("s"))
        {
            return "Scissors";
        }
        else
        {
            return "Wrong";
        }
    }

}
