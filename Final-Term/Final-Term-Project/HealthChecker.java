import java.util.*;
import static java.lang.System.out;
public class HealthChecker{
    private Integer choice, drink, bottles, intake;
    private String name;
    private Integer[] mg={300,288,160,144,100,95,83,83,74};
    private double[] size={8.4,8.4,16,16,12,10.5,8.3,8,8.4};
    private String[] drinkName={"Spike Shooter","Cocaine","Monster Energy","Full Throttle","Enviga","Tab Energy","Red Bull","SoBe No Fear","Amp"};
    public void mainMenu(){
        out.println("========= MAIN MENU =========");
        out.println("#                           #");
        out.println("#     [1] Enter Data        #");
        out.println("#     [2] Select Drink      #");
        out.println("#     [3] Compute Caffeine  #");
        out.println("#     [4] Print             #");
        out.println("#     [5] Exit              #");
        out.println("=============================");
        setChoice();
    }
    public void setChoice(){
        try{
            Scanner read=new Scanner(System.in);
            out.print("Enter Your Choice: ");
            choice=read.nextInt();
            directChoice();
        }   
        catch(InputMismatchException str){
            out.println("Please Choose From The Menu Above");
            out.println();
            setChoice();
        }
    }
    public void directChoice(){
        if(choice==1){
            setName();
        }
        else if(choice==2){
            setDrink();
        }
        else if(choice==3){
            setCaffeine();
        }
        else if(choice==4){
            setPrint();
        }
        else if(choice==5){
            out.println("Thank You For Using This Program...");
        }
        else{
            out.println("Invalid Number.....Please Select From Above");
            out.println();
            setChoice();
        }
    }
    public void setName(){
        Scanner read=new Scanner(System.in);
        out.print("Enter Your Name: ");
        name=read.nextLine();
        out.println();
        setChoice();
        }
    public void setDrink(){
        try{
            Scanner read=new Scanner(System.in);
            out.print("Enter Drink: ");
            drink=read.nextInt();
            out.println();
            setChoice();
        }
        catch(InputMismatchException str){
            out.println("Please Input Numbers Only");
            out.println();
        }
    }
    public void setCaffeine(){
        try{
            Scanner read=new Scanner(System.in);
            out.print("No. Of Bottles: ");
            bottles=read.nextInt();
            computeCaffeine();
            out.println("Caffeine Intake: "+intake);
            String remarks=intake>5000?"Check Your Health":"Live Health";
            out.println("Remarks: "+remarks);
            out.println();
            setChoice();
        }
        catch(InputMismatchException str){
            out.println("Enter Number Of Bottles");
            setCaffeine();
        }
    }
    public void computeCaffeine(){
        intake=bottles*mg[drink-1];
    }
    public void setPrint(){
        out.println(name+" Drink: "+size[drink-1]+" Ounces Of "+drinkName[drink-1]);
        out.println("Caffeine Intake: "+intake);
        out.println();
        setChoice();
    }      
    public static void main(String[] args){
        HealthChecker hc=new HealthChecker();
        hc.mainMenu();
    }
}