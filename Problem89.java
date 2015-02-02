import java.util.Scanner;
import java.io.File;
import java.io.FileReader;

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
   
   //Hoping there is a much better way to do this... 
   public String getNumerals(int n) {
      String numerals = "";
      while(n>=1000){
         numerals += "M";
         n -= 1000;
      }
      if(n/100 == 9){
         numerals += "CM";
         n -= 900;
      }
      else {
         if(n>=500){
            numerals += "D";
            n -= 500;
         }
         if(n/100 == 4){
            numerals += "CD";
            n -= 400;
         }
         else{
            while(n >= 100){
               numerals += "C";
               n -= 100;
            }
         }
      }
      if(n/10 == 9){
         numerals += "XC";
         n -= 90;
      }
      else {      
         if(n>=50){
            numerals += "L";
            n -= 50;
         }
         if(n/10 == 4){
            numerals += "XL";
            n -= 40;
         }
         else{
            while(n>=10){
               numerals += "X";
               n -= 10;
            }
         }
      }
      switch(n){
         case 9:
            numerals += "IX";
            break;
         case 8:
            numerals += "VIII";
            break;
         case 7:
            numerals += "VII";
            break;
         case 6:
            numerals += "VI";
            break;
         case 5:
            numerals += "V";
            break;
         case 4:
            numerals += "IV";
            break;
         case 3:
            numerals += "III";
            break;
         case 2:
            numerals += "II";
            break;
         case 1:
            numerals += "I";
            break;                  
      }
      
      return numerals;
   }
   
   public int parseNumerals(String nums){
      int length = nums.length();
      int sum = 0; //Sum of the numerals. Bad variable name.
      char currentNum;
      char nextNum;
      
      for(int i=0; i<nums.length(); i++){
         if(i == nums.length()-1){
            sum += numToInt(nums.charAt(i));   
         }
         else{
            currentNum = nums.charAt(i);
            nextNum = nums.charAt(i+1);
            
            if(numToInt(currentNum)<numToInt(nextNum)){
               sum += (numToInt(nextNum)-numToInt(currentNum));
               i++;
            }
            else{
               sum += numToInt(currentNum);
            }
         }
      }
      return sum;
   }
   
   public int numToInt(char num){
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