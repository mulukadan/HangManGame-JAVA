import java.io.Console;
 public class HangMan {
     private String word;
     private String WrongAns="";
     private String CorrectAns= "";
     int wrongCount = 0;
     boolean GameDone = false;
     String Message = "";

    public String CheckifMatchFound(String TheWord, String UserInput){
      word = TheWord;
        CheckIfBlankCorrectAnsIsSet();
    int UserInputlength = UserInput.length();
    if(UserInputlength>1){
      //meaning the user has typed a WHOLE WORD
      if(TheWord == UserInput){
        GameDone = true;
        Message = "Won";
      }else{
        GameDone = true;
        Message = "Lost";
      }
    }else{
      //meaning the user has typed a single Character
      char c = UserInput.charAt(0);
      CheckifCHarFound(c);
      while(GameDone==false){
        Console myConsole = System.console();
        System.out.println("Whats Correct So far:" + CorrectAns);
        System.out.println("Wrong Answers:" + WrongAns);
        System.out.println("Enter Another Character:");
        String input = myConsole.readLine();
        CheckifMatchFound(word, input);
      }
    }

    return Message;
   }

   public void CheckifCHarFound(char guess){
     int index = word.indexOf(guess);
     if(index > -1){
       while (index >= 0) {
           System.out.println(index);
           StringBuilder UpdateCorrectChars = new StringBuilder(CorrectAns);
           UpdateCorrectChars.setCharAt(index, guess);
           index = word.indexOf(guess, index + 1);
           CorrectAns = UpdateCorrectChars.toString();
            if(word == CorrectAns){
               GameDone = true;
               Message = "Won";
             }
       }
     }else{
        StringBuilder UpdateWrongAns = new StringBuilder();
        UpdateWrongAns.append(guess);
        WrongAns = UpdateWrongAns.toString();
        wrongCount++;
        if(wrongCount > 5){
          GameDone = true;
          Message = "Lost";
        }
     }
   }

   public void CheckIfBlankCorrectAnsIsSet(){
     if(CorrectAns.length()<1){
       int Wordlength = word.length();
       for(int i = 0; i<Wordlength; i++){
         CorrectAns = CorrectAns+"_";
       }
     }
   }

}
