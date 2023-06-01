import static java.lang.System.out;
public class CozaLozaWoza {
    public void loopIf(){
        for(Integer number=1;number<=110;number++){
            if(number%3==0){
                out.print("Coza");
                if(number%5==0){
                    if(number%7==0){
                        out.print("LozaWoza");
                    }
                    else{
                        out.print("Loza");
                    }
                }
                 if(number%7==0){
                    out.print("Woza");
                }
            }
            else if(number%5==0){
                out.print("Loza");
                if(number%7==0){
                    out.print("LozaWoza");
                }
            }
            else if(number%7 == 0){
                out.print("Woza");
            }           
            else if(number%3!=0){
                if(number%5!=0){
                    if(number%7!=0){             
                        out.print(number);
                    }
                }
            }  
            out.print(" ");
            if(number%11==0){
                out.print("\n");
            }
        }
    }
    public static void main(String args[]) {
        CozaLozaWoza ss=new CozaLozaWoza();
        ss.loopIf();
    }
}