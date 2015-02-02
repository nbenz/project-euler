public class Problem17 {
    public static void main(String[] args) {
      Problem17 p = new Problem17();
      long time = System.currentTimeMillis();
      p.run();
      System.out.println("Time: " + (System.currentTimeMillis()-time));
    }
    public void run(){
      String[] letters = {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven",
                            "twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
        int temp;
        int numLetters=0;
                
        for(int i=1; i<=1000; i++){
            for(int j=2; j<=4; j++){
                if(j==2) {
                    temp = (i%100);       //Pulls the right two digits. These are handled uniquely.
                    if(temp < 20)
                        numLetters += letters[temp].length();
                    else {
                        numLetters += letters[temp%10].length();  //Pull out the ones digit
                        switch(temp/10) {    //Add the corresponding tens digit
                            case 2:
                                numLetters += "twenty".length();  
                                break;
                            case 3:
                                numLetters += "thirty".length();
                                break;
                            case 4:
                                numLetters += "forty".length();
                                break;
                            case 5:
                                numLetters += "fifty".length();
                                break;  
                            case 6: 
                                numLetters += "sixty".length();
                                break;
                            case 7:
                                numLetters += "seventy".length();
                                break;
                            case 8: 
                                numLetters += "eighty".length();
                                break;
                            case 9:
                                numLetters += "ninety".length();
                                break;                    
                        }
                    }
                }
                else {
                    temp = (i%(int)Math.pow(10,j)/(int)Math.pow(10,j-1)); 
                    numLetters += letters[temp].length();
                }
            }
            if(i>=100){
                if(i%100 != 0)
                  numLetters += "and".length();
                if(i%1000 != 0)
                  numLetters += "hundred".length();
            }      
            if(i>=1000)
                numLetters += "thousand".length();       
        }
        System.out.println(numLetters);
    }
}