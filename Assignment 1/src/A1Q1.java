/********************************************************************
 * Programmer:	C. Seeley
 * Class:  CS30S
 *
 * Assignment: Assignment 1 Question 1
 * Program Name:  A1Q1.java
 *
 * Description: Generates numbers between 1-100 for an array that is
 *              1000 numbers long, and outputs the array to a text file
 *              five numbers per line
 *
 * Input:       none
 *
 * Output:      1000 numbers between 1-100 to a text file, 5 per line
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
import java.util.Random;
 

public class A1Q1 {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
        
        final int MAXLIST = 1000;       //max length of array
        final int MAX = 100;            //max value for generated number
        
    // ********** declaration of variables **********
        
        int array[] = new int[MAXLIST]; 
        //array that will hold the generated values
        int counter = 0; //counter for outputting 5 numbers per line
    	
    // create instances of objects for i/o and formatting
    
    	
    	PrintWriter fout = new PrintWriter(new BufferedWriter
            (new FileWriter("textOut.txt")));
        ProgramInfo programinfo = new ProgramInfo("A1 " + "Q1");
        Random rand = new Random(); //random value generator
    	
    // ********** Print output Banner **********
    
    	System.out.println(programinfo.toString()); //output program info
        //fout.println(programinfo.toString());
 	    	
    // ************************ get input **********************

    	

    // ************************ processing ***************************
    
        for (int n = 0; n < MAXLIST; n++) { //loop for generating values
             array[n] = rand.nextInt (MAX)+ 1; //generate random ints
             
        } //end for loop for generating numbers
    
    // ************************ print output ****************************

        //fileList(array, MAXLIST, fout);
        //printList(array, MAXLIST, fout);
        
        for (int n = 0; n <MAXLIST; n++) {  //output for loop
            fout.print(array[n] + " "); //output number to line
            counter++;  //add one to counter, for outputting 5 per line
            
            if (counter == 5) { //if statement for outputting 5 per line
                fout.println("");   //create new line
                counter = 0; //reset counter
            }//end if statement
        }//end output for loop
        
    
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
