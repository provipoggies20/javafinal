import java.util.*;
import static java.lang.System.out;
public class ExtractingDigits{
    private Integer digits, rev;
    public void inputDigits(){
        try{
            Scanner read=new Scanner(System.in);
            out.print("Enter Any Digits: ");
            digits=read.nextInt();
            revOrder();
        }
        catch(InputMismatchException str){
            out.println("Please Input Numbers Only");
            inputDigits();
        }
    }
    public Integer getDigits(){
        return digits;
    }
    public void revOrder(){
        while(digits>0){
            rev=digits%10;
            out.print(rev+", ");
            digits=digits/10;
        }
    }
    public static void main(String[] args){
        ExtractingDigits ext=new ExtractingDigits();
        ext.inputDigits();

    }
}