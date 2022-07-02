
import java.util.Random;
import java.util.*;
import java.util.Scanner;

public class wordleGame {

     public static void main(String[] args) {
     
          Wordlewords words = new Wordlewords();
          Scanner sc = new Scanner (System.in);
          Random rand = new Random();
          ArrayList<String> list = new ArrayList<String>();  // for helper
          
          String word = words.getWord(rand.nextInt(words.getSize()));
          String result = "";
          String resultMin = "";
          String guess = "";
          String guessUpper = "";
          int flag = 0;
          int counter = 0;
          
          for (int pos1 = 0; pos1 < words.getSize(); pos1++)  // fill a list with initial wordle list
          {
              list.add(words.getWord(pos1));
          }
          
          System.out.println("---------------[G][A][M][E] [R][U][L][E][S]----------------------");
          System.out.println(" ");
          System.out.println("The game will chose a word randomly.");
          System.out.println("You have to guess the word in 6 attempts.");
          System.out.println("Each attempt, the game will give you hints.");
          System.out.println("The hints are in the following form: [0][0][1][2][0].");
          System.out.println("Each digit between square brackets represents character index.");
          System.out.println("'0' Means the character does not exist in the word you're guessing.");
          System.out.println("'1' Means the character exists, but is in a different index.");
          System.out.println("'2' Means the character exists, and is in the correct index.");
          System.out.println(" ");
          System.out.println("---------------[G][A][M][E] [R][U][L][E][S]----------------------");
          System.out.println("\n");
          
          while (counter < 6)
          {
              do
              {
                   System.out.println("Please enter your word:");
                   guess = sc.nextLine();
                   
                   if (isAllowable(guess) == false)
                   {
                        System.out.println("The word you typed is not valid.");
                        System.out.println("Please make sure you type a 5 character word or check the list with allowable words.");
                   }
              }while(isAllowable(guess) == false);
              
              guessUpper = guess.toUpperCase();     // for printing indexes in upper letters (looks nicer)
              
              //System.out.println(guess); // This is to show the word I have typed
              //System.out.println(word + " <--- The word you're guessing (CHEATER!)");      // This is to show the word I have to guess (CHEATING!!!!)
              
              if (guess.equalsIgnoreCase(word))     // if you guessed the word, you won and program finishes
              {
                   System.out.println("!!!~Congratulations~!!! You have guessed the word '" + guess + "' in " + ++counter + " tries!");
                   break;
              }
              
              for (int pos1 = 0; pos1 < 5; pos1++)
              {
                   if (guess.charAt(pos1) == word.charAt(pos1))   // if two letters match in the same position
                   {
                        result = result + "[2]";
                        resultMin = resultMin + "2";
                        flag++;
                   }
                   else if (guess.charAt(pos1) != word.charAt(pos1))     // if there is a matching letter but in different position
                   {
                        for (int pos2 = 0; pos2 < 5; pos2++)
                        {
                             if ((guess.charAt(pos1) == word.charAt(pos2)) && (flag == 0))
                             {
                                  result = result + "[1]";
                                  resultMin = resultMin + "1";
                                  flag++;
                             }
                        }
                   }
                   
                   if (flag == 0) // if there were no matching letters
                   {
                        result = result + "[0]";
                        resultMin = resultMin + "0";
                   }
                   flag = 0;
              }
              System.out.println(result + " <--- " + "[" + guessUpper.charAt(0) + "]" + "[" + guessUpper.charAt(1) + "]" + "[" + guessUpper.charAt(2) + "]" + "[" + guessUpper.charAt(3) + "]" + "[" + guessUpper.charAt(4) + "]");    // Just to add <--- [A][P][P][L][E] to show word in indexes
              result = result + " <--- " + "[" + guessUpper.charAt(0) + "]" + "[" + guessUpper.charAt(1) + "]" + "[" + guessUpper.charAt(2) + "]" + "[" + guessUpper.charAt(3) + "]" + "[" + guessUpper.charAt(4) + "]" + "\n";  // Just to add <--- [A][P][P][L][E] to show word in indexes
              counter++;
              
              if (counter == 6)
              {
                   System.out.println("You have failed to guess the word! The word was '" + word + "'. Better luck next time.");
                   break;
              }
              
              
              
              
              // A pack of loops that use Helper method pack and makes a list of possible words
              if (resultMin.contains("2")) // helper loop for green letter
              {
                   for (int pos1 = 0; pos1 < 5; pos1++)
                   {
                        if (resultMin.charAt(pos1) == ('2'))
                        {
                             list = helperGreen(list, pos1, guess.charAt(pos1));
                        }
                   }
              }
              if (resultMin.contains("1"))	// helper loop for yellow letter
              {
                 for (int pos1 = 0; pos1 < 5; pos1++)
                  {
                       if (resultMin.charAt(pos1) == ('1'))
                       {
                            list = helperYellow(list, guess.charAt(pos1));
                       }
                  }
              }
              if (resultMin.contains("0"))	// helper loop for gray letter
              {
                 for (int pos1 = 0; pos1 < 5; pos1++)
                  {
                       if (resultMin.charAt(pos1) == ('0'))
                       {
                            list = helperGray(list, guess.charAt(pos1));
                       }
                  }
              }
              resultMin = "";    // reset resultMin
              System.out.println("\nNumber of words in new list after Helper did magic: " + list.size());             //helper message
              System.out.println("This is the list of possible words from the Helper:");             //helper message
              System.out.println(list);
          }
          sc.close();
     }
     
     public static boolean isAllowable(String a)
     {
          Allowable allowable = new Allowable();
          
          for (int pos1 = 0; pos1 < allowable.getSize(); pos1++)
          {
              if (a.equalsIgnoreCase(allowable.getWord(pos1)))
              {
                   return true;
              }
          }
          return false;
     }
     
     
     
     // Worldle Helper Method Pack below
     public static ArrayList<String> helperGreen(ArrayList<String> a, int index, char c) // new helper method for green letter
     {
          ArrayList<String> list = new ArrayList<String>();
          
          for (int pos1 = 0; pos1 < a.size(); pos1++)
          {
              if (a.get(pos1).charAt(index) == c)	// if a word from the list has the correct character in correct index
              {
                   list.add(a.get(pos1));
              }
          }
          return list;
     }
     public static ArrayList<String> helperYellow(ArrayList<String> a, char c) // new helper method for yellow letter
     {
    	 ArrayList<String> list = new ArrayList<String>();
         String charCheck = c + "";
                 
         for (int pos1 = 0; pos1 < a.size(); pos1++)
         {
             if (a.get(pos1).contains(charCheck))	// if a word contains a character somewhere but no in correct index
             {
                  list.add(a.get(pos1));
             }
         }
         return list;
     }
     public static ArrayList<String> helperGray(ArrayList<String> a, char c) // new helper method for yellow letter
     {
    	 ArrayList<String> list = new ArrayList<String>();
         String charCheck = c + "";
                 
         for (int pos1 = 0; pos1 < a.size(); pos1++)
         {
             if (!a.get(pos1).contains(charCheck))	// do not add a word to the list if it has this character
             {
                  list.add(a.get(pos1));
             }
         }
         return list;
     }
}

