
package calcchange;

 // @author DUrban
 
import java.util.Scanner;

public class CalcChange {

    static Scanner sc = new Scanner (System.in);
   
    public static void main(String[] args) {
        int h, q, d, n, p;
        String choice; 
        
        System.out.println("Welcome to the Change Calculator!");
        System.out.println("Do you have any change? (Y/N): ");
        choice = sc.nextLine();
        
        System.out.println ("Your choice was: " + choice);
        choice = sc.nextLine();
        
        while (!choice.isEmpty() &&
                choice.substring(0,1).equalsIgnoreCase("Y")) {
            
            h = getCoin("Half Dollars");
            q = getCoin("Quarters");
            d = getCoin("Dimes");
            n = getCoin("Nickels");
            p = getCoin("Pennies");
            
            coinTotal(h, q, d, n, p);
            
            
        
        } //end of while
        
       System.out.println("Thank you for using the Change Calculator!");
    }// end of main
    
    
        public static int getCoin(String Coinname) {
            int c=0;
            
            do {
                
                try {
                 System.out.println("How many " + Coinname + " do you have?");
                    c = sc.nextInt();  
                
                if (c<0) {
                    System.out.println("Input must be a positive integer.");
                } 
                        
                        }catch (Exception e) {
                            System.out.println("Illegal input" +
                                                e.getMessage());
                            sc.nextLine();
                            c=-1;
                        }
                } while (c<0);
                return c;
                
            
            
        }
        
        public static void coinTotal (int h, int q, int d, int n, int p) {
            int dollars, cents, totalcents;
            
            totalcents= (h*50)+(q*25)+(d*10)+(n*5)+p;
            dollars = totalcents/100;
            cents = totalcents%100;
            
            System.out.println("You have " + totalcents + " which equates to " 
                                    + dollars + " dollars and " + cents
                                            + "cents.");
                    
        }
        
    }
    

