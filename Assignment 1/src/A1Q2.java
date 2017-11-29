/********************************************************************
 * Programmer:	C. Seeley
 * Class:  CS30S
 *
 * Assignment: Assignment 1 Question 2
 * Program Name:  A1Q2.java
 *
 * Description: Reads values from text file generated in question 1, 
 *              checks the frequency of each number, and
 *              allows you to check the frequency of each number
 *
 * Input:       text file generated in last question
 *
 * Output:      allows user to check the frequency of each number
 ***********************************************************************/
 
 // import java libraries here as needed
 
 import javax.swing.*;
 import java.text.DecimalFormat;
 import java.io.*; 					// import file io libraries
import java.util.Random;
 

public class A1Q2 {  // begin class
    
    public static void main(String[] args) throws IOException{  // begin main
    
    // ********* declaration of constants **********
        
        final int MAXLIST = 1000;           //max size of arrays
        final int MAX = 100;                //max size for generated values
        final int SenVal = -1;              //sentinel value integer form
        final String stringSenVal = "-1";   //sentinel value string form
        final int NumPerLine = 5;           //numbers per line for input
        final int offSet = 1;               //offset between array and numbers
        
    // ********** declaration of variables **********
        
        String delim = "[ ]+";          //delim for reading in values
        int array[] = new int[MAXLIST]; //array for input
        String strin = "";              //string for reading in line of values
        String input1[] = null;         //string for splitting input
        int count = 0;                  //int for loading input into array
        int num = 0;                    //int for checking frequency of values
        int freq[] = new int[MAX];      //array for storing frequency of values
        
        String delim2 = "[-]+";         //delim for checking frequency of values
        int inSingleNum = 0;            
            //int for checking frequency of single values
        String inMultNum = "";          
            //string for checking frequency of multiple values
        String tokens[] = null;     
            //string for splitting values to check frequency
        int n1 = 0; //first int for checking frequency of multiple numbers
        int n2 = 0; //second int for checking frequency of multiple numbers
        
        
    	
    // create instances of objects for i/o and formatting
    
    	BufferedReader fin = new BufferedReader(new FileReader("textOut.txt"));
    	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("Outa1.txt")));
        ProgramInfo programinfo = new ProgramInfo("A1 " + "Q2");
    	
    // ********** Print output Banner **********
    
    	System.out.println(programinfo.toString()); //output program info
        fout.println(programinfo.toString());       //output program info
 	    	
    // ************************ get input **********************
    
        strin = fin.readLine();     //read in first line
        count = 0;                  //set counter to 0
        
    	while (strin != null) {         //while loop for inputting data
            input1 = strin.split(delim);    //split input line
            //System.out.println(strin + "\n");
            
            for (int n = 0; n< NumPerLine; n++) {   //loop for parsing data
                array[count] = Integer.parseInt(input1[n]); //parse data
                
                count++;    //add one to counter for array
            }//end for loop
            
            strin = fin.readLine(); //read in next line
        }//end while loop
        
        
    // ************************ processing ***************************
    
    
        for (num = 0; num < MAX; num++) {   //loop for checking frequency of numbers
            //loop for checking frequency of numbers
        for (int n = 0; n < MAXLIST; n++) {             
            
            if (array[n] == (num + offSet)) { //if values are equal
                freq[num]++;    //adds one to frequency
            }//end if statement
        }//end for loop
        //System.out.println("Number " + num + " is generated " + freq[num] + " times\n");
        }//end for loop
        
        
        
        
        while (!(inSingleNum == SenVal || inMultNum.equals(stringSenVal))) {
                //while loop for checking frequency
            
            try {   
            inSingleNum = Integer.parseInt(JOptionPane.showInputDialog(
            "Enter the number that you would like to see the frequency of "
                    + " or -1 to end")); //input single number frequency
            
            if (inSingleNum != SenVal) {  //if not sentinel value
                System.out.println("The frequency of " + inSingleNum + " is "  
                    + freq[inSingleNum-offSet]); //output frequency
            }//end if
            }//end try
            catch (ArrayIndexOutOfBoundsException e) {  //catch value error
                System.out.println(
                        "Please enter a single number, between 1-100");
            }//end catch 1
            catch (NumberFormatException i) { //catch value type error
                System.out.println(
                        "Please enter a single number, between 1-100");
            }//end catch 2
            
            try {
            inMultNum = JOptionPane.showInputDialog(
            "Enter the numbers that you would like to see the frequency of "
                    + "(ex: 10-20), or -1 to end"); 
                //input for multiple number frequency
            
            if (!(inMultNum.equals(stringSenVal))) { //if not sentinel value
            tokens = inMultNum.split(delim2);   //split input
            n1 = Integer.parseInt(tokens[0]);   //parse first number
            n2 = Integer.parseInt(tokens[1]);   //parse second number
            
            for (int n = n1; n <= n2; n++) {  //loop for outputting frequency
                System.out.println("The frequency of " + n + " is "  
                   + freq[n-offSet]);  //output frequency of number
            }//end for loop
            }//end if
            }//end try
            catch (ArrayIndexOutOfBoundsException e) { //catch value error
                System.out.println(
                        "Enter two numbers between 1-100, seperated by '-'");
            }//end catch
            catch (NumberFormatException i) {   //catch value type error
                System.out.println(
                        "Enter two numbers between 1-100, seperated by '-'");
            }//end catch
            
            
        }//end while loop
        
        
    // ************************ print output ****************************

        //fileList(array, MAXLIST, fout);
        //printList(array, MAXLIST, fout);
    
    // ******** closing message *********
        
        System.out.println(programinfo.eoFile()); //output end of file message
        fout.println(programinfo.eoFile());       //output end of file message
        
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

