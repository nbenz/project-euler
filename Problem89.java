import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Problem89{
   
   public static void main(String[] args){
      Problem89 p = new Problem89();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));         
   }
   
   public void run(){
      Scanner fr;
      String line;
      int charsSaved = 0;
      try{
         fr = new Scanner(new FileReader(new File("p89data.txt")));
         int n;
         String temp;
         
         while(fr.hasNextLine()){
         line = fr.nextLine();
         n = parseNumerals(line);
         temp = getNumerals(n);
         
         charsSaved += (line.length()-temp.length());
      }
      }catch(Exception e){
         System.out.println("File not found.");
         System.exit(0);
      }
      System.out.println("Saved: " + charsSaved + " characters.");   
   }
   
   public String getNumerals(int n) {
      String numerals = "";
      int[] keys = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
      String[] values = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
      for(int i=0; i<keys.length; i++){
         while(n >= keys[i]){
            numerals += values[i];
            n -= keys[i];
         }
      }
      return numerals;
   }
   
   public int parseNumerals(String nums){
      int length = nums.length();
      int sum = 0; //Sum of the numerals. Bad variable name?
      char currentNum;
      char nextNum;
      
      for(int i=0; i<nums.length(); i++){
         if(i == nums.length()-1){ //End of the string
            sum += numeralToInt(nums.charAt(i));   
         }
         else{
            currentNum = nums.charAt(i);
            nextNum = nums.charAt(i+1);
            
            if(numeralToInt(currentNum)<numeralToInt(nextNum)){  //Cases like XL - Need to subtract
               sum += (numeralToInt(nextNum)-numeralToInt(currentNum));
               i++;   //Accounted for two letters in this block
            }
            else{
               sum += numeralToInt(currentNum);  //If subtraction isn't need, add the next number
            }
         }
      }
      return sum;
   }
   
   public int numeralToInt(char num){
      switch(num){
         case 'I': return 1;
         case 'V': return 5;
         case 'X': return 10;
         case 'L': return 50;
         case 'C': return 100;
         case 'D': return 500;
         case 'M': return 1000;
         default: return 0;
      }
   }
}