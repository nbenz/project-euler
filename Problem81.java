import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem81{
   int[][] matrix;
   int[][] cache;
   
   public static void main(String[] args){
      Problem81 p = new Problem81();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
   }
   
   public void run(){
      int size = 80;
      matrix = new int[size][size];
      cache = new int[size][size];
      String line;
      String[] lineArray;
      
      try{ 
         Scanner fr = new Scanner(new FileReader(new File("p81data.txt")));
         for(int y=0; y<size; y++){
            line = fr.nextLine();
            lineArray = line.split(",");
            for(int x=0; x<size; x++){
               matrix[y][x] = Integer.parseInt(lineArray[x]);
            }
         }
      }catch(Exception e){}
      
      
      
      cache[0][0] = matrix[0][0];
      
      for(int i=1; i<size; i++)
         cache[0][i] = matrix[0][i] + cache[0][i-1];
      for(int j=1; j<size; j++)
         cache[j][0] = matrix[j][0] + cache[j-1][0];
         
      for(int a=1; a<size; a++){
         for(int b=1; b<size; b++){
            if(cache[a-1][b] < cache[a][b-1])
               cache[a][b] = cache[a-1][b]+matrix[a][b];
            else
               cache[a][b] = cache[a][b-1]+matrix[a][b];
         }
      } 
      System.out.println("Min path: " + cache[size-1][size-1]);  
   }
   
   
}