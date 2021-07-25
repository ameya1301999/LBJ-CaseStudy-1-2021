/**
 * In addition, this class contains the main function 
 * which takes the user input and call functions of
 * other classes.  
 *
 * @author  Rahul Ghosh
 * Date : 24/07/2021
 */

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import com.opencsv.exceptions.CsvException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.csv.*;

public class App {
    public static void main(String[] args) throws IOException, CsvException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nWelcome to 🎓  College Management Console. How can I help you!");
            System.out.println("1️⃣   Register new College");
            System.out.println("2️⃣   Display Colleges in Mumbai who teach Engineering");
            System.out.println("3️⃣   Remove College based on collegeId");
            System.out.println("4️⃣   Exit\n");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter the college details in the below format ==>");
                    System.out.println("===========================================");
                    System.out.println("collegeId,collegeName,courseType,city,fees,pinCode");
                    System.out.println("============================================");

                    String input = sc.nextLine();

                    String[] split = input.split(",");
                    int collegeId = Integer.valueOf(split[0]);
                    String collegeName = split[1];
                    String courseType = split[2];
                    String city = split[3];
                    int fees = Integer.valueOf(split[4]);
                    int pinCode = Integer.valueOf(split[5]);

                    Register reg = new Register("colleges.csv");

                    College clg = new College();
                    clg.setCollegeId(collegeId);
                    clg.setCollegeName(collegeName);
                    clg.setCourseType(courseType);
                    clg.setCity(city);
                    clg.setFees(fees);
                    clg.setPinCode(pinCode);

                    reg.setCLG(clg);
                    reg.registration();
                    System.out.println("Registration Successfull!");
                    break;

                case 2:
                    try (Reader reader = Files.newBufferedReader(Paths.get("colleges.csv"))) {

                        // read csv file
                        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
                        for (CSVRecord record : records) {
                            if ((record.get(2)).equals("Engineering") && (record.get(3)).equals("Mumbai")) {
                                System.out.println("College ID: " + record.get(0));
                                System.out.println("College Name: " + record.get(1));
                                System.out.println("College Type: " + record.get(2));
                                System.out.println("City: " + record.get(3));
                                System.out.println("Fees: " + record.get(4));
                                System.out.println("Pin Code: " + record.get(5));
                                System.out.println("\n");
                            }
                        }

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Enter the college ID which you want to delete:\n");
                    int colld = sc.nextInt();
                    long rowid = 0;
                    try (Reader reader = Files.newBufferedReader(Paths.get("colleges.csv"))) {

                        // read csv file
                        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);
                        for (CSVRecord record : records) {
                            if ((record.get(0)).equals(String.valueOf(colld))) {

                                rowid = record.getRecordNumber();
                                break;
                            }
                        }
                        if (rowid == 0)
                            System.out.println("Entered college Id not found!😔");
                        else {
                            Delete del = new Delete(rowid);
                            del.delete();
                        }

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    break;
                
                case 4:
                    System.out.println("Thank you for using the console🙏");
                    break;

                default:
                    System.out.println("Please enter a valid input!🥺");
                    break;

            }
        } while (choice != 4);

        sc.close();

    }
}
