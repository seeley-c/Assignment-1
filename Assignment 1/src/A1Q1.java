/********************************************************************
 * Programmer:	C. Seeley
 * Class:  CS30S
 *
 * Assignment: Assignment 1 Question 1
 * Program Name:  A1Q1.java
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
 

public class A1Q1 {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
        
        final int MAXLIST = 1000;
        final int MAX = 100;
        final int MIN = 0;
        
    // ********** declaration of variables **********
        
        String delim = "";
        int ranNum = 0;
        int array[] = new int[MAXLIST];
    	
    // create instances of objects for i/o and formatting
    
    	
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("testOut.txt")));
        ProgramInfo programinfo = new ProgramInfo("A1 " + "Q1");
        Random rand = new Random();
    	
    // ********** Print output Banner **********
    
    	System.out.println(programinfo.toString());
        fout.println(programinfo.toString());
 	    	
    // ************************ get input **********************

    	

    // ************************ processing ***************************
    
        for (int n = 0; n < MAXLIST; n++) {
             ranNum = rand.nextInt(MAX - MIN) + MIN; //generate random ints
             array[n] = ranNum;
        } //end for loop for generating numbers
    
    // ************************ print output ****************************

        fileList(array, MAXLIST, fout);
        printList(array, MAXLIST, fout);
    
    // ******** closing message *********
        
        //System.out.println(programinfo.eoFile);
        //fout.println(programinfo.eoFile);
        
    // ***** close streams *****
        
        //fin.close();			// close input buffer
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