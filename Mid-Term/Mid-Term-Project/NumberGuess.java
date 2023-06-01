import java.util.*;
import static java.lang.System.out;
public class NumberGuess{
    private Integer trials, num, in;
    public NumberGuess(){
        trials=0;
        num=0;
        in=0;
    }
    public void randomNum(){
        num=(int)(Math.random()*98+1);
    }
    public void trialsNum(){
        try{
        Scanner read=new Scanner(System.in);
        out.println("Key In Your Guess: ");
        while(in!=num){
            in=read.nextInt();
            if(in>num){
                out.println("Try Lower");
                trials+=1;
            }
            else{
                out.println("Try Higher");
                trials+=1;
            }   
        }
        out.println("You Got It In "+trials+" !");
        }
        catch(InputMismatchException str){
            out.println("Please Input Numbers Only From 0-99");
            trialsNum();
        }
    }
    public static void main(String[] args){
        NumberGuess gs= new NumberGuess();
        gs.randomNum();
        gs.trialsNum();
    }
}