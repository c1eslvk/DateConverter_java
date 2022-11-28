import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


class FileHandler {
    private List<String> dates = new ArrayList<>();

    public void readFile() {
        try {
            File inputFile = new File("InputData.txt");
            Scanner readFile = new Scanner(inputFile);
            while (readFile.hasNextLine()) {
                String date = readFile.nextLine();
                dates.add(date);
            } 
            readFile.close();
        }  
        catch (FileNotFoundException e) {
            System.out.println("File error");
            e.printStackTrace();
        }
    }

    public void writeToFile(Set<MyDate> convertedDates) throws IOException { 
        FileWriter fileWriter = new FileWriter("OutputFile.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (MyDate date : convertedDates) {
            printWriter.printf("day = %d, month = %d, year = %d, weekday = %s\n", date.getDay(), date.getMonth(), date.getYear(), date.getWeekday());
        }
        printWriter.close();
    }

    public List<String> getDates() {
        return dates;
    }
}
