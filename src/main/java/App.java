import java.io.Console;

public class App{

  public static void main (String [] Args){
    HangMan hangMan = new HangMan();
    Console myConsole = System.console();
    System.out.println("4 Letter Word");
    System.out.println("_ _ _ _");
    System.out.println("Enter a Character:");
    String input = myConsole.readLine();
    hangMan.CheckifMatchFound("Mulu", input);

  }

}
