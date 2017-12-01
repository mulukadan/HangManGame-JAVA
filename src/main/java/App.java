import java.io.Console;

public class App{

  public static void main (String [] Args){
    String Words[]= new String[]{"SCHOOL", "COMPUTER", "SHOPPING"};
    String ThePickedWord =Words[0];

    HangMan hangMan = new HangMan();
    Console myConsole = System.console();
    System.out.println(ThePickedWord.length()+" Letter Word");
    System.out.println("_ _ _ _");
    System.out.println("Enter a Character:");
    String input = myConsole.readLine().toUpperCase();

    hangMan.CheckifMatchFound(ThePickedWord, input);

  }

}
