import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

class DateConverter {
    private List<String> formats = new ArrayList<String>();
    private Set<MyDate> convertedDates = new HashSet<MyDate>();
    private static String format1 = "dd/MM/yyyy EEEE";
    private static String format2 = "dd/M/yyyy EEEE";
    private static String format3 = "yyyy-MM-dd EEEE";
    private static String format4 = "EEEE dd.MM.yyyy";

    private LocalDate convertDate(String dateString) {
        setFormats();
        for (int i = 0; i < 4; i++) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formats.get(i));
                LocalDate date = LocalDate.parse(dateString, formatter);
                return date;
            } catch (DateTimeException e) {}
        }
        return null;
    }

    public void initDateSet(List<String> dates) {
        for (String d: dates) 
        {
            LocalDate date = convertDate(d);

            try {
                MyDate myDate = new MyDate(date.getDayOfMonth(), date.getMonthValue(), date.getYear(), date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US));
                convertedDates.add(myDate);
            } catch (Exception e) {
                System.out.print("Date: ");
                System.out.print(d);
                System.out.println(" doesnt exist.");
            }
        }
    }

    public void printDates() {
        int counter = 0;
    
        for (MyDate date : convertedDates) {
            System.out.print("day = ");
            System.out.print(date.getDay());
            System.out.print(" month = ");
            System.out.print(date.getMonth());
            System.out.print(" year = ");
            System.out.print(date.getYear());
            System.out.print(" weekday = ");
            System.out.println(date.getWeekday());
            counter++;
        }

        System.out.print("Number of converted dates: ");
        System.out.println(counter);
    }

    private void setFormats() {
        formats.add(format1);
        formats.add(format2);
        formats.add(format3);
        formats.add(format4);
    }

    public Set<MyDate> getConvertedDates() {
        return convertedDates;
    }
}