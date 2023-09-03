import java.util.*;
import java.io.*;
/**
 * The description of this class is that this class is used to count the number 
 * of times fractions and unique fractions appear. 
 * 
 * @author Iakjot Kaur 
 * @version April 6th, 2020
 */
public class FractionsV1
{   
    // 1. Yes you can complete this without arrays, you will just need to use
    //    more variables. You will need a counter to keep track and another counter 
    //    the fractions
    // 2. Yes you can use just one array to solve this if you use string arrays and 
    //    then use a loop to go through 
    // 3. It means making an instance (object) of a class. Compostion in this case means
    //    making an object and using it in the class. 
    // 4. Use an array and use every element and maybe turn them into decimals 

    /**
     * The fractions file is opened, read, and stored. 
     * In the main method, the file is opened and read. Each line from the 
     * file is read and stored into an array,by using while loops.
     * Used a counter to keep track of the fractions.
     * The main method also prints out the count of the fractions, I used a for
     * loop to go through the array and printed out the count if doesn't equal zero
     * PRE: need a text file
     * POST: will read and store the fractions
     * 
     * @params: String[]
     * @return: none
     */
    public static void main(String[] args){
        Scanner c = null; 
        Scanner s = null;

        try{
            c = new Scanner(new FileInputStream("fractions.txt"));
            int count = 0; 

            while(c.hasNextLine()){
                count++; 
                c.nextLine();
            }
            String[] fractions = new String[count];
            s = new Scanner(new FileInputStream("fractions.txt"));
            count = 0;
            while(s.hasNextLine()){
                fractions[count] = s.nextLine();
                count++;
            }
            int[] countArray = numOfTimes(fractions);
            for(int i = 0; i < fractions.length; i++){
                if( countArray[i] != 0){
                    System.out.println(fractions[i] + " has a count of " + countArray[i]);
                }
            }

        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
            System.exit(0); 

        }

    }

    /**
     * Simplifiyng the fractions and splitting them.
     * Made an array to split the fractions, and used the .split for the "/".
     * This made the numbers split from the "/"
     * Stored the numerators and denomators as intergers. Then printed them out.
     * Used if statements to simplify the fractions.
     * PRE: have to have a fraction
     * POST: stored the numerators and denomators as intergers
     * 
     * @params: String
     * @return: String
     */

    public static String simplify(String fraction){
        String[] apart = fraction.split("/");
        int num = Integer.parseInt(apart[0]);
        int denom = Integer.parseInt(apart[1]);
        System.out.println(num);
        System.out.println(denom);

        if(denom%num == 0){
            denom = denom/num;
            num = 1;
            return num + "/" + denom;
        }

        else if(num%denom == 0){
            num = num/denom;
            denom = 1;
            return denom + "/" + num;
        }

        else if(num/denom == 1){
            return "1/1";
        }
        else{
            String value = "";
            if(num == 1 || denom == 0){
                value = num + "/" + denom;
                return value; 
            }
        }
        return"";

    }

    /**
     * Method for number of times the fraction appears.
     * Made an array just for counting and made the length as long as the fraction array
     * Used a nested for loop, started from the top and went through the elements
     * and if they matched, added the count and if its the same, it breaks and goes
     * to the top and starts again. 
     * PRE: need to have fractions
     * POST: counts the number of times each fraction appears
     * 
     * @params: String[]
     * @return: int[]
     */
    public static int[] numOfTimes(String[] fractions){
        int[] count = new int[fractions.length];

        for(int i=0; i<fractions.length; i++){
            for( int j=0; j <= i; j++){
                if(fractions[i].equals(fractions[j])){
                    count[j]++;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 
     * 
     * @params: String[]
     * @return: boolean
     */

}
