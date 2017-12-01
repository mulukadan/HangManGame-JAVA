
 public class HangMan {
 private String word;
 private String WrongAns="";
 private String CorrectAns= "";
 int wrongCount = 0;


public boolean CheckifMatchFound(String TheWord, String UserInput){
  word = TheWord;
    boolean found = false;
    CheckIfBlankCorrectAnsIsSet();
    int UserInputlength = UserInput.length();
    if(UserInputlength>1){
      //meaning the user has typed a WHOLE WORD
      if(TheWord == UserInput){
        found = true;
      }
    }else{
      //meaning the user has typed a single Character
      char c = UserInput.charAt(0);
      CheckifCHarFound(c);
    }
    System.out.println("word:" + word);
    System.out.println("WrongAns:" + WrongAns);
    System.out.println("CorrectAns:" + CorrectAns);
    return found;
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
       }
     }else{
        StringBuilder UpdateWrongAns = new StringBuilder();
        UpdateWrongAns.append(guess);
        WrongAns = UpdateWrongAns.toString();
        wrongCount++;
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
