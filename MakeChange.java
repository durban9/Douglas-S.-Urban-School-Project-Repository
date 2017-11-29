
package makechange;

import java.util.Scanner;


 
 // @author DUrban
 
public class MakeChange {

    static Scanner sc = new Scanner(System.in);
    
    static int qoh, doh, noh, poh;
    
    public static void main(String[] args) {
        int cents; 
        boolean usingset;
        
        System.out.println("Welcome to the Make Change Calculator:");
       
        
        usingset = getCoinSet();  
        
                
        cents = getCents();
        while (cents != 0) {
            if (cents==101) {
                sc.nextLine();
                usingset = getCoinSet();
            } else if (cents==102) {
                allChange(usingset);
            } else {
                if (usingset == false) {
                    makeChange(cents);
            } else {
                perfectChange(cents);
            } 
            }
           
            cents = getCents();
      
    }    
        System.out.println("Thanks for using the Make Change Program!");
     
}// end of main
    
    public static int getCents() {
        int c=0; 
        do{
            try {
                System.out.println("For what value would you like change?  "
                                    + "(Enter 1-100, 101 for"
                               + " new coin set, 102 for all, or 0 to quit):");
                c =  sc.nextInt();
                
                if (c<0|| c>102) { System.out.println("Sorry, but "
                        + "the value given" + 
                        " must be greater than zero or less than 102. ");
                } 
                
                } catch (Exception e) {
                        System.out.println("Sorry, but the value given " +
                                "must be a positive integer between " +
                                "zero and 102.");
                        sc.nextLine();
                        c = -1;
                                
            }  
            
        } while (c<0 || c>102);
        
        return c;
        
    }
    
    
    public static void makeChange(int cents) {
        int q, d, n, p; 
        int r; 
        
        r = cents;
        q = r/25;
        r = r-(q*25);
        d = r/10;
        r = r-(d*10);
        n = r/5;
        r = r-(n*5);
        p = r;
        
        
        
        
        
        System.out.println("For " + cents + " cent(s), I give: " + 
                 q + " quarter(s), " + d + " dime(s), " + n + " nickel(s), and "
                            + p + " penn(y/ies).");
    }// end of method
    
      public static boolean getCoinSet() {
            boolean usingset = false;
            String coinname;
            
            System.out.println("Do you have a coinset? (Y/N): ");
            coinname = sc.nextLine();
            
            if (!coinname.isEmpty() &&
                 coinname.substring(0,1).equalsIgnoreCase("Y")) {
                 usingset = true;
                 qoh = getCoin("Quarters");
                 doh = getCoin("Dimes");
                 noh = getCoin("Nickels");
                 poh = getCoin("Penny/Pennies");
                 
        } else  {
                usingset = false;
                qoh = 0;
                doh = 0;
                noh = 0;
                poh = 0;
            }
            return usingset;
                
        }// end of method
      
      
      public static void perfectChange(int cents) {
        int q, d, n, p; 
        int r; 
        
        r = cents;
        q = r/25;
        if (q>qoh) {
            q=qoh;
        }
        r = r-(q*25);
        d = r/10;
        if (d>doh) {
            d=doh;
        }
        r = r-(d*10);
        n = r/5;
        if (n>noh) {
            n=noh;
        }
        r = r-(n*5);
        p = r/1;
        if (p>poh) {
            p=poh;
        }
        r = r-p;
        
        if (r>0) {
            System.out.println("For " + cents + 
                    " cents, I am unable to make perfect change because I am"
                    + " short by " + r + " cents.");
        } else {
            System.out.println("For " + cents + " cent(s), I give "
                                + q + " quarter(s), " + d + " dime(s), " 
                                + n + " nickel(s), and " + p + " penn(y/ies)."
                                + " This leaves " + (qoh-q) + " quarter(s), "
                                + (doh-d) + " dime(s), "
                                + (noh-n) + " nickel(s), "
                                + (poh-p) + " pennie(s).");
        }
      
    }//end of method
      
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
                            System.out.println("Illegal input: " +
                                                e.getMessage());
                            sc.nextLine();
                            c=-1;
                        }
                } while (c<0);
                return c;
                
            
            
        }// end of method
        
        public static void allChange(boolean usingset) {
            for (int i=1; i<=100; i++) {
              if (usingset==true) {
                  perfectChange(i);
              }  else {
                  makeChange(i);
              }
            }
        }   //end of method

}// end of MakeChange class
