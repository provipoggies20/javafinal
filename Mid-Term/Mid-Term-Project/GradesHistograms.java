import java.util.*;
import java.io.*;
public class GradesHistograms { 
    private int[] grades;    
    private int[] bins = new int[10];
    public static void main(String[] args) {
        GradesHistograms gh = new GradesHistograms();        
        gh.readGrades("grades.in");
        gh.computeHistogram();       
        gh.printHistogramHorizontal();
        gh.printHistogramVertical();
    }
    private boolean checkGrade(int grade) {
        return (0 <= grade && grade <= 100);
    }
    private void readGrades(String filename)
    {        
        try {
            String filepath = getClass().getResource(filename).getPath();
            Scanner file = new Scanner(new File(filepath));
            if ( ! file.hasNextInt()) {
                System.out.println("Error! Not found students number.");
                return;
            }
            int n = file.nextInt();
            grades = new int[n];
            for(int i = 0; i < n; i++) {
                if ( ! file.hasNextInt()) {
                    continue;
                }
                grades[i] = file.nextInt();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error! File \"grades.in\" not found.");
        }
    }
    private void computeHistogram()
    {
        for(int i = 0; i < grades.length; i++) {
            int j = (grades[i] == 100) ? 9 : grades[i] / 10;
            bins[j] += 1;
        }
    }
    private void printHistogramHorizontal()
    {
        System.out.println();
        for(int i = 0; i < bins.length; i++)
        {
            int delta = (i == bins.length - 1) ? 10 : 9;
            System.out.printf("%2d -%3d:", (i*10), (i*10+delta));
            for(int j = 0; j < bins[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    private void printHistogramVertical()
    {
        int maxBin = bins[0];
        for(int i = 0; i < bins.length; i++) {
            maxBin = (bins[i] > maxBin) ? bins[i] : maxBin;
        }
        System.out.println();
        for(int i = maxBin; i >= 0; i--)
        {
            if (i == 0)
            {
                for(int j = 0; j < bins.length; j++)
                {
                    int delta = (j == bins.length - 1) ? 10 : 9;
                    System.out.printf("%2d-%-2d ", (j*10), (j*10+delta));
                }
            }
            else {
                for(int j = 0; j < bins.length; j++)
                {
                    String str = (bins[j] < i ) ? " " : "*";
                    System.out.printf("%3s%-2s ", str, " ");
                }
            }
            System.out.println();
        }
    }
    private void printGrades()
    {
        for(int i = 0; i < grades.length; i++) {
            System.out.print(grades[i]+" ");
        }
        System.out.println();
    }
    private void printBins()
    {
        for(int i = 0; i < bins.length; i++) {
            System.out.print(bins[i]+" ");
        }
        System.out.println();
    }
}