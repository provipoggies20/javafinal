import java.util.*;
import static java.lang.System.out;
import javax.swing.JOptionPane;
public class BinaryToDecimalConverter{
    private int bits;
    private char key;
    public BinaryToDecimalConverter(){
        bits=0; 
        key = ' ';
    }
    public void setBinary(){
            try{
                Scanner read=new Scanner(System.in);
                out.print("Enter Binary Digits (bits) : ");
                bits=read.nextInt();
                int rem = 0, decimal = 0, position = 0;
                while(bits!=0){   
                    rem = bits%10;
                    if(rem > 1){
                        out.println("Invalid binary digits!");
                        break;
                    }
                    decimal = decimal + (int) (rem*Math.pow (2, position));
                    position++;
                    bits /= 10;
                }
                out.print("The equivalent decimal value is: " + decimal);
                tryContinue();
            }   
            catch(InputMismatchException err){
                JOptionPane.showMessageDialog(null, "Please input numbers only!");
                tryContinue();
            }
    }
    public void tryContinue(){     
            Scanner read=new Scanner(System.in);
            out.println("\nTry Another Conversion? Press Y/y To Continue Or Any Key To Quit: ");
            key=read.next().charAt(0);
            switch(key){
                case 'Y': setBinary();
                case 'y': setBinary();
            }
    }
    public static void main(String[] args){
       BinaryToDecimalConverter bin=new BinaryToDecimalConverter();
       bin.setBinary();
    }
}