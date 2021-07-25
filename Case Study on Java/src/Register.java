import java.io.*;

public class Register {
    String filename = "";

    College data;

    public Register(String filename) {
        this.filename = filename;
    }

    void setCLG(College clg) {
        this.data = clg;
    }

    public void registration() throws IOException {

        FileWriter csvwriter = new FileWriter(filename, true);

        csvwriter.append(String.valueOf(
            data.getCollegeId()));
        csvwriter.append(",");
        csvwriter.append(data.getCollegeName());
        csvwriter.append(",");
        csvwriter.append(data.getCourseType());
        csvwriter.append(",");
        csvwriter.append(data.getCity());
        csvwriter.append(",");
        csvwriter.append(String.valueOf(data.getFees()));
        csvwriter.append(",");
        csvwriter.append(String.valueOf(data.getPinCode()));
        csvwriter.append("\n");

        csvwriter.close();
    }

}
