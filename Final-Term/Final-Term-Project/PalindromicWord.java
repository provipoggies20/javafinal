import java.util.*;
import static java.lang.System.out;
public class PalindromicWord {
    String word;
    public static void main(String[] args) {
        PalindromicWord pw=new PalindromicWord();      
        pw.setPal();
    }   
    public void setPal(){
        Scanner read=new Scanner(System.in);
        out.print("Please enter a word to test it for palindromic: ");
        word=read.nextLine().replaceAll("[^a-zA-Z]", "");
        TestPalindromicWord();
    }
    private void TestPalindromicWord()
    {
        String backwardIndex = "";
        for(int i = word.length() - 1; i >= 0 ; i--) {
            backwardIndex += word.toLowerCase().charAt(i);
        }       
        if (word.toLowerCase().equals(backwardIndex.toLowerCase())){
            out.println(word+" Is A Palindrome");
        }
        else {
            out.println(word+" Is Not A Palindrome");
        }
    }
}  

