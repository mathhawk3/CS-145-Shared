//Trevor Figgins, Brendan Leonard, Summer Chavez
//1/29/2024
//CS 145
//Lab 3 - Letter Inventory

package CS_145_Shared.lab_3_letter_inventory;
import java.util.Arrays;

public class LetterInventory{
    private int[] counts;
    private int size;

    public LetterInventory(String data){
        //TODO
    }

    public LetterInventory(int[] data){
        if(data.length!=26){
            throw new IllegalArgumentException("Data must have size 26");
        }
        this.counts = data.clone();
        this.size = 0;
        for(int count : data){
            size++;
        }
    }

    //should take in size as the limit for a for loop and then maybe an if statement to get a count on 
    //how many of each char their is in the array
    public int get(char letter){
        //TODO
        return(0);//PLACEHOLDER
    }

    //just setting the count of a letter in the list to the passed int value
    //pretty sure its way more complicated than this
    public void set(char letter, int value){
        //TODO
    }

    //counts the size of the inventory/keeps track
    public int size(){
    //since it's specified that this shouldn't calculate it everytime, should just be a return value
        return size;
    }


    //if size is 0, return true, otherwise return false
    public boolean isEmpty(){
        return(size==0);
    }

    public String toString(){
        String c = "";
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < this.counts[i]; j++){
                c += (char)('a'+ i);
            }
        }
        return(c);
    }

    //takes the counts for each letter from two inventory and adds them
    //returns a new inventory count w/o effecting the old lists
    public LetterInventory add(LetterInventory other){
        int[] result = new int[26];
        for(int i = 0; i < 26; i++) {
            result[i] = this.counts[i]+other.counts[i];
        }
        return(new LetterInventory(result));
    }

    //takes the counts for each letter from two inventory and subtracts leaving the difference
    //returns a new inventory count w/o effecting the old lists
    //If any of the counts would be negative, returns null instead.
    public LetterInventory subtract(LetterInventory other){
        int[] result = new int[26];
        for(int i = 0; i < 26; i++) {
            if(this.counts[i]<other.counts[i]){
                return(null);
            } else {
                result[i] = this.counts[i] - other.counts[i];
            }
        }
        return(new LetterInventory(result));
    }
}