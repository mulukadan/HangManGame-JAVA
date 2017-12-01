import java.io.Console;
 public  class HangMan {
     private static String word;
     private static String WrongAns="";
     private static String CorrectAns= "";
     static int  wrongCount = 0;
     static boolean  GameOn = true;
     static String  Message = "";

    public static String CheckifMatchFound(String TheWord, String UserInput){
      // System.out.print("UserInput22:" + UserInput);
       word = TheWord.toUpperCase();
        CheckIfBlankCorrectAnsIsSet();
    int UserInputlength = UserInput.length();
    if(UserInputlength>1){
      //meaning the user has typed a WHOLE WORD
      if(TheWord.equals(UserInput.toUpperCase())){
        GameOn = false;
        Message = "Won";
        System.out.println("You " + Message);
      }else{
        GameOn = false;
        Message = "Lost";
        System.out.println("You " + Message);
      }
    }else{
      //meaning the user has typed a single Character
      UserInput = UserInput.toUpperCase();
      char c = UserInput.charAt(0);
      CheckifCHarFound(c);

      while(GameOn){
        if(word.equals(CorrectAns) ){
           GameOn = false;
           Message = "Won";
         }else{
           Console myConsole = System.console();
           System.out.println("Whats Correct So far:" + CorrectAns);
           System.out.println("Wrong Answers:" + WrongAns);
           System.out.println("Enter Another Character:");
           String input = myConsole.readLine();
           CheckifMatchFound(word, input);
         }

      }
      System.out.println("You " + Message);
    }
    return Message;
   }

   public static void CheckifCHarFound(char guess){
     int index = word.indexOf(guess);
     if(index > -1){
       while (index >= 0) {
           StringBuilder UpdateCorrectChars = new StringBuilder(CorrectAns);
           UpdateCorrectChars.setCharAt(index, guess);
           index = word.indexOf(guess, index + 1);
           CorrectAns = UpdateCorrectChars.toString();
       }
     }else{
        StringBuilder UpdateWrongAns = new StringBuilder();
        UpdateWrongAns.append(guess);
        WrongAns = UpdateWrongAns.toString();
        wrongCount++;
        if(wrongCount > 4){
          GameOn = false;
          Message = "Lost";
        }
     }
   }

   public static void CheckIfBlankCorrectAnsIsSet(){
     if(CorrectAns.length()<1){
       int Wordlength = word.length();
       for(int i = 0; i<Wordlength; i++){
         CorrectAns = CorrectAns+"_";
       }
     }
   }

}
