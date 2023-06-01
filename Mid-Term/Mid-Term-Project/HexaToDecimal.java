import java.util.*;
import static java.lang.System.out;
import javax.swing.JOptionPane;
import java.lang.String;
public class HexaToDecimal{
    private String hexStr;
    private char hexChar;
    public HexaToDecimal(){
        hexStr = " ";
        hexChar = ' ';
    }   
    public void setHex(){
            Scanner read=new Scanner(System.in);
            out.print("Enter a Hexadecimal string: ");
            hexStr=read.nextLine();
            int base = 1, decimal = 0;
            for (int i = 0; i < hexStr.length(); i++){                  
                hexChar = hexStr.charAt(i);
                try{
                if(hexChar >= '0'  && hexChar <= '9'){
                    decimal = Integer.parseInt(hexStr, 16);
                    base *= 16;
                }       
                else if (hexChar >= 'a' && hexChar <= 'f'){
                    decimal = Integer.parseInt(hexStr, 16);
                    base *=16;
                }   
                else if (hexChar >= 'A' && hexChar <= 'F'){
                    decimal = Integer.parseInt(hexStr, 16);
                    base *= 16;
                } 
                }     
                catch(NumberFormatException str){
                    out.println("Error: Invalid Hexadecimal String");
                    System.exit(1); 
                }
            }
            out.println("The equivalent decimal number for hexadecimal " + hexStr + " is: " + decimal + "\n");
            out.println("");
        }
    public static void main(String[] args){
        HexaToDecimal hex = new HexaToDecimal();
        hex.setHex();
    }  
}