import java.util.Scanner;
import java.io.FileReader;
import java.io.File;

//Runs in ~40ms

public class Problem11 {
   int n = 20;
   int[][] grid = new int[n][n];
   
   public static void main(String[] args){
      Problem11 p = new Problem11();
      long time = System.currentTimeMillis();
      p.run(); 
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   public void run(){
      fillGrid();
      long maxProduct = 0;
      long temp = 0;
      
      for(int i=0; i<n; i++){
         for(int j=0; j<n; j++){
            if(j<17){ //Checks horizontal and vertical numbers
                temp = Math.max(grid[i][j]*grid[i][j+1]*grid[i][j+2]*grid[i][j+3], grid[j][i]*grid[j+1][i]*grid[j+2][i]*grid[j+3][i]);
                if(temp>maxProduct)
                  maxProduct = temp;
                
                if(i<17){ //Checks diagonal 
                  temp = grid[i][j]*grid[i+1][j+1]*grid[i+2][j+2]*grid[i+3][j+3];
                  if(temp>maxProduct)
                     maxProduct = temp;
                }
            }
            if(i<17 && j>2){
               temp = grid[i][j]*grid[i+1][j-1]*grid[i+2][j-2]*grid[i+3][j-3];
               if(temp>maxProduct)
                  maxProduct = temp;
            }
            
         }
      }
      System.out.println("Max product of 4 numbers: " + maxProduct);
   }  
 
   
   private void fillGrid(){
      try {
         Scanner fr = new Scanner(new FileReader(new File("p11data.txt")));
         String line;
         String[] nums;
         int i = 0;
         while(fr.hasNextLine()){
            line = fr.nextLine();
            nums = line.split(" ");
            for(int j=0; j<n; j++){
               grid[i][j] = Integer.parseInt(nums[j]);
            }   
            i++;    
         }          
      }catch(Exception e){}   
   }
}