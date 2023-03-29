package Game;

public class Game {
    Player human;

    Player computer;
    Player computer2;
    public Game()
    {
        System.out.print("Welcome to Rock-Paper-Scissors!\n");
        human = new HumanPlayer();
        computer = new ComputerPlayer();
    }
    void play(){
        result(human.play(),computer.play());
    }
    void result(String player,String computer)
    {
        if(player.equals(computer))
        {
            System.out.print("Tie\n");
        }
        else if(player.equals("Rock") && computer.equals("Scissors"))
        {
            System.out.print("Game.Player Win\n");
        }
        else if(player.equals("Paper") && computer.equals("Rock"))
        {
            System.out.print("Game.Player Win\n");
        }
        else if(player.equals("Scissors") && computer.equals("Paper"))
        {
            System.out.print("Game.Player Win\n");
        }
        else
        {
            System.out.print("Game.Player Lose\n");
        }
    }

}
