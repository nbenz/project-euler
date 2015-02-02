//Doesn't work yet

import java.util.Scanner;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;

public class Problem82{
   int[][] matrix;
   int[][] cache;
   
   public static void main(String[] args){
      Problem82 p = new Problem82();
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
         Scanner fr = new Scanner(new FileReader(new File("matrix.txt")));
         for(int y=0; y<size; y++){
            line = fr.nextLine();
            lineArray = line.split(",");
            for(int x=0; x<size; x++){
               matrix[y][x] = Integer.parseInt(lineArray[x]);
            }
         }
      }catch(Exception e){}
     
      for(int i=1; i<size; i++)
         cache[i][0] = matrix[j][0];
         
      for(int a=1; a<size; a++){
         for(b=0; b<size; b++){
            
         }
      } 
      System.out.println("Min path: " + cache[size-1][size-1]);  
   }
   
   
}