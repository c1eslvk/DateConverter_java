import java.io.IOException;

public class DateConverterProgram {

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        DateConverter dateConverter = new DateConverter();

        fileHandler.readFile();

        dateConverter.initDateSet(fileHandler.getDates());

        dateConverter.printDates();

        try {
            fileHandler.writeToFile(dateConverter.getConvertedDates());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

