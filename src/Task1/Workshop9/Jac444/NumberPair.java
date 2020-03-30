package Task1.Workshop9.Jac444;
/*
Student: Mitchell Culligan
id: 161293170
email: mculligan@myseneca.ca
Professor: Mahboob Ali
 */
import java.util.HashSet;
import java.util.HashMap;

public class NumberPair {
    public static final int MAX_RANGE =1000;
    public static final int MIN_RANGE =0;
    public static final int MAX_SIZE = MAX_RANGE-MIN_RANGE+1;
    private int first;
    private int second;


    public NumberPair(int first, int second){
        this.first = first;
        this.second = second;
    }


    public int add(){
        return this.first+this.second;
    }

    public int sub(){
        return this.first-this.second;
    }

    public int multiply(){
        return this.first*this.second;
    }

    public double divide(){
        return (double)this.first/this.second;
    }

    public int getFirst(){
        return this.first;
    }

    public int getSecond(){
       return this.second;
    }
    public static NumberPair generatePair(){
            return new NumberPair(randomNum(MIN_RANGE,MAX_RANGE),randomNum(MIN_RANGE+1,MAX_RANGE));
    }


    public static int randomNum(int min, int max){
        return (int)(Math.random()*(max-min))+min;
    }

}
