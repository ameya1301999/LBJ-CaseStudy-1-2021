import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.util.List;

public class Delete {
    long rowid;

    public Delete(long rowid) {
        this.rowid = rowid;
    }

    public void delete() throws IOException, CsvException {
        CSVReader reader2 = new CSVReader(new 
            FileReader("colleges.csv"));
        List<String[]> allElements = reader2.readAll();
        allElements.remove(((int) rowid) - 1);

        FileWriter sw = new FileWriter("colleges.csv");
        CSVWriter writer = new CSVWriter(sw,
                CSVWriter.DEFAULT_SEPARATOR, 
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                CSVWriter.DEFAULT_LINE_END);
        writer.writeAll(allElements);
        writer.close();
        System.out.println("Row Deleted Successfully!👌");
    }
}
