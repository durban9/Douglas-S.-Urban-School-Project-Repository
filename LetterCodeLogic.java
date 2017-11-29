/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Stuff
 */
public class LetterCodeLogic 
{   
   public static String Encode(String msg)
   {
       String m = msg.toUpperCase();
       String result="";
       char c;
       int x;
       for (int i=0; i<m.length(); i++)
       {
            c=m.charAt(i);
            x=c;
            if (x==32)
            {
                x=0;
            } 
            else 
            {
             x=x-64;   
             if (x<0||x>26)
             {
               x=99;  
             }    
            }
            result=result+String.valueOf(x)+ " ";
       }    //end of for loop
   
       return result;
   } 
   public static String Decode(String msg)
   {
       String result = "";
       int x=0;
       char c;
       String nums[];
       nums = msg.split("\\s*,\\s*");
       for (int i=0; i < nums.length; i++)
       {
           try
           {
               x=Integer.parseInt(nums[i]);
           } catch (NumberFormatException e) {
               x = 99; 
           }
           if (x==0)
           {
               c=' ';
           } 
           else if (x<1 || x>26)
           {
               c='?';
           }
           else 
           {
              x+=64;
              c=(char) x;
           }
           result += c;
       }//end of for 
       return result;
   } 
    
}
