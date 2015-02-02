public class Problem19 {
   int day = 1;
   int month = 1;
   int year = 1900;
   
   int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
   
   public static void main(String[] args) {
      Problem19 p = new Problem19();
      System.out.println(p.countDays());
   }
   
   
   public int countDays() {
      int count = 0;
      addDays(6); //Gets it on a Sunday
      while(day != 31 || month != 12 || year <= 2000) {
         addDays(7);
         if(day == 1)
            count++;
      }    
      return count;
   }
   
   public void addDays(int n) {
      while(n > 0){
         if(isLeapYear() && month == 2 && (day+n)>29) {
            n -= (29 - day + 1);
            day = 1;
            month++;
         }
         
         else if((day+n)>days[month-1]){
            n -= (days[month-1]-day+1);
            day = 1;
            
            if(month == 12) {
               year++;
               month = 1;
            }
            else
               month++;   
         }
         else {
            day += n;
            n = 0;
         }
      } 
   }
   
   public boolean isLeapYear() {
      if(year%4 != 0)
         return false;
      else if (year%100 != 0)
         return true;
      else if (year%400 != 0)
         return false;
      else
         return true;         
   }
}