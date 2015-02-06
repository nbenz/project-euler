public class Problem10{
   String num = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
   String nums = "12345678912340";
   int numLength = num.length();
   int n = 13; //How many adjacent digits you want in your product
   
   public static void main(String[] args){
      Problem10 p = new Problem10();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){   
      long[] result = resetProduct(0);;       //This will store the results when resetProduct is called.
      long maxProd = result[0];
      long currProd = result[0];      
      int i = (int)result[1];
      
      while(i<numLength){
         if(num.charAt(i)=='0'){
            result = resetProduct(i+1);
            currProd = result[0];
            i = (int)result[1];
         }
         else {   //Take the previous product, divide by the number at position i-n, multiply by the current number. If this is confusing, see *** at the end.
            currProd = (currProd/Character.getNumericValue(num.charAt(i-n)))*Character.getNumericValue(num.charAt(i));
            i++; 
         }
         if(currProd > maxProd)
            maxProd = currProd;
      }
      System.out.println("Maximum product of "+n+" adjacent numbers: " + maxProd);
   }
   
   
   /*
      This is called when you encounter a 0. Obviously any consecutive digit string containing 0
      will not be the highest product (unless that describes all consecutive strings, in which case
      0 is already the max product). Returns a long[] containing the new current product at 0 and the
      next index in the string at 1.
   */
   private long[] resetProduct(int index){ 
      long prod = 1;
      int count = 0;
      while(count<n && index<numLength){
         if(num.charAt(index)== '0') //Encountered a 0 while resetting product
            return resetProduct(index+1);
         else {
            prod *= Character.getNumericValue(num.charAt(index));
            index++;
            count++;
         }   
      } 
      if(count < n) //If there was not an n-length string of non-zero digits before reaching the end, the last product = 0.
         prod = 0;
      return new long[]{prod,index};
   }
}

/* 
   ***
   Suppose we want the product of 3 adjacent numbers:
   123456789
   
   1*2*3
   2*3*4
   3*4*5
    ...
   
   We are repeating the calculations 2*3, 3*4, ... , 8*9 twice.
   
   Recognize:
   
   2*3*4 = ((1*2*3)/1)*4
   3*4*5 = ((2*3*4)/2)*5
   ...
   
   Thus, we can take our previous product, divide by the leftmost digit,
   and multiply by the next digit in the list to get the next product.
   This ensures we only multiply each number once, making the algorithm O(n)
   
*/