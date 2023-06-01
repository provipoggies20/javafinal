import java.util.*;
import static java.lang.System.out;
public class GradesStatistics {
    private static Integer[] grades;
    private static Integer studentNum=0;
    private static double sum, ave;
    public static void main(String[] args)
    {
        GradesStatistics stat = new GradesStatistics();
        stat.readGrades();
        out.println("The Average Is : "+stat.average());
        out.println("The Minimum Is : "+stat.min());
        out.println("The Maximum Is : "+stat.max());
        out.println("The Standard Deviation : "+stat.stdDev());
    }
    private static void readGrades()
    {
        try{
            Scanner read=new Scanner(System.in);
            out.print("Enter the number of students: ");
            studentNum=read.nextInt();
            grades = new Integer[studentNum];       
            for(Integer x=0;x<studentNum;x++)
            {
                out.print("Enter the grade for student "+x+" : ");
                Integer grade = read.nextInt();
                if (0<= grade&&grade<=100)
                {
                    grades[x] = grade;
                }   
            }
        }
        catch(InputMismatchException str){
            out.println("Please Input Only Numbers From 0-100");
            readGrades();
        }
    }
    private static double average()
    {        
        for (int x=0;x<grades.length;x++) {
            sum+=grades[x];
        }
        ave=sum/grades.length;
        return ave;
    }
    private static Integer min()
    {
        Integer min = grades[0];
        for (Integer x=0;x<grades.length;x++) {
            if(grades[x]<min){
                min=grades[x];
            }
        }
        return min;
    }
    private static Integer max()
    {
        Integer max = grades[0];
        for (Integer x= 0;x<grades.length;x++) {
            if(grades[x]>max){
                max=grades[x];
            }
        }     
        return max;
    }
    private static double stdDev()
    {
        double all=0.0;
        double sdev=0.0;
        for(int x=0;x<grades.length;x++) {
            all+= grades[x]*grades[x]-ave*ave;
        }      
        sdev=Math.sqrt(all/grades.length);
        return sdev;
    }
}