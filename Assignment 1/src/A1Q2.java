/********************************************************************
 * Programmer:	C. Seeley
 * Class:  CS30S
 *
 * Assignment: Assignment 1 Question 2
 * Program Name:  A1Q2.java
 *
 * Description: 
 *
 * Input: 
 *
 * Output: 
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
import java.util.Random;
 

public class A1Q2 {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
        
        final int MAXLIST = 1000;
        final int MAX = 101;
        final int SenVal = -1;
        final String stringSenVal = "-1";
        
    // ********** declaration of variables **********
        
        String delim = "[ ]+";
        int array[] = new int[MAXLIST];
        String strin = "";
        String input1[] = null;
        int count = 0;
        int num = 0;
        int freq[] = new int[MAX];
        
        String delim2 = "[-]+";
        int inLeng = 0;
        int inSingleNum = 0;
        String inMultNum = "";
        String tokens[] = null;
        int n1 = 0;
        int n2 = 0;
        
        
    	
    // create instances of objects for i/o and formatting
    
    	BufferedReader fin = new BufferedReader(new FileReader("textOut.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("Outa1.txt")));
        ProgramInfo programinfo = new ProgramInfo("A1 " + "Q2");
    	
    // ********** Print output Banner **********
    
    	System.out.println(programinfo.toString());
        fout.println(programinfo.toString());
 	    	
    // ************************ get input **********************
    
        strin = fin.readLine();
        count = 0;
        
    	while (strin != null) {
            input1 = strin.split(delim);
            System.out.println(strin + "\n");
            
            for (int n = 0; n< 5; n++) {
                array[count] = Integer.parseInt(input1[n]);
                //System.out.println("Number " + count + " is generated " + array[count] + " times\n");
                
                count++;
            }//end for loop
            
            strin = fin.readLine();
        }//end while loop
        
        
    // ************************ processing ***************************
    
        
    
        for (num = 1; num < MAX ; num++) {
        for (int n = 0; n < MAXLIST; n++) {
            
            
            if (array[n] == num) {
                freq[num]++;
                
                //System.out.println(freq[num]);
            }//end if statement
            //System.out.println(freq[num]);
            
            
        }//end for loop
        //System.out.println(freq[num]);
        System.out.println("Number " + num + " is generated " + freq[num] + " times\n");
        }//end for loop
        
        
        
        
        while (!(inSingleNum == SenVal || inMultNum.equals(stringSenVal))) {
            
            try {
            inSingleNum = Integer.parseInt(JOptionPane.showInputDialog(
            "Enter the number that you would like to see the frequency of "
                    + " or -1 to end"));
            
            if (inSingleNum != SenVal) {
                System.out.println("The frequency of " + inSingleNum + " is "  
                    + freq[inSingleNum]);
            }
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(
                        "Please enter a single number, between 1-100");
            }
            catch (NumberFormatException i) {
                System.out.println(
                        "Please enter a single number, between 1-100");
            }
            
            try {
            inMultNum = JOptionPane.showInputDialog(
            "Enter the numbers that you would like to see the frequency of "
                    + "(ex: 10-20), or -1 to end");
            
            if (!(inMultNum.equals(stringSenVal))) {
            tokens = inMultNum.split(delim2);
            n1 = Integer.parseInt(tokens[0]);
            n2 = Integer.parseInt(tokens[1]);
            
            for (int n = n1; n <= n2; n++) {
                System.out.println("The frequency of " + n + " is "  
                   + freq[n]);
            }
            }
            }//end try
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(
                        "Enter two numbers between 1-100, seperated by '-'");
            }
            catch (NumberFormatException i) {
                System.out.println(
                        "Enter two numbers between 1-100, seperated by '-'");
            }
            
            
        }//end while loop
        
        
    // ************************ print output ****************************

        //fileList(array, MAXLIST, fout);
        //printList(array, MAXLIST, fout);
    
    // ******** closing message *********
        
        //System.out.println(programinfo.eoFile);
        //fout.println(programinfo.eoFile);
        
    // ***** close streams *****
        
        fin.close();			// close input buffer
        fout.close();			// close output buffer
    }  // end main
    
    
    //************************************************
    // Purpose: print the array to file
    // Interface: IN: base address of list,
    //                actual size of list
    // Returns: 
    // *****************************************************
    public static void fileList(int[] a, int b, PrintWriter fout){
        fout.println("\nThere are " + b + " numbers in the array\n");
        for (int i = 0; i < b; i++) {
            //fout.println(a[i]);
            fout.println(a[i]);
           
        }//end for
    }  // end file list
    
    //************************************************
    // Purpose: print the array to console
    // Interface: IN: base address of list,
    //                actual size of list
    // Returns: 
    // *****************************************************
    public static void printList(int[] a, int b, PrintWriter fout){
        System.out.println("\nThere are " + b + " numbers in the array\n");
        for (int i = 0; i < b; i++) {
            System.out.println(a[i]);
        }//end for
    }  // end print list
    
    
}  // end class

