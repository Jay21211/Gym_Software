import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Schedule {
    private FitnessClass [] classes;
    private int numClasses;

    public Schedule(FitnessClass[] classes, int numClasses){
        this.classes = classes;
        this.numClasses = numClasses;
    }

    public FitnessClass[] getClasses(){

        return classes;
    }

    public int getNumClasses(){

        return  numClasses;
    }
    public void load(File file) throws IOException {
        if (file == null || !file.exists()) {
            throw new IOException("File not found");
        }
        boolean fileName = file.getName().equals("classSchedule.txt");
        if (fileName) {
            try (Scanner scanner = new Scanner(file)) {
                // Assuming each line in the file represents a fitness class
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    // Use StringTokenizer to parse the line
                    StringTokenizer tokenizer = new StringTokenizer(line);

                    // Assuming the order is ClassType InstructorName Time Location
                    String classType = tokenizer.nextToken();
                    String instructorName = tokenizer.nextToken();
                    String time = tokenizer.nextToken();
                    String location = tokenizer.nextToken();

                    Offer offer = Offer.valueOf(classType);
                    Instructor instructor = Instructor.valueOf(instructorName);
                    Location studio = Location.valueOf(location);
                    Time classTime = Time.valueOf(time);

                    // Assuming MemberList and guests are initialized as needed
                    MemberList members = new MemberList();
                    MemberList guests = new MemberList();

                    // Assuming FitnessClass has a constructor that takes Offer, Instructor, Location, Time, MemberList, MemberList
                    FitnessClass fitnessClass = new FitnessClass(offer, instructor, studio, classTime, members, guests);

                    // Add the fitness class to your classes array or list
                    // Increment the number of classes
                }
            }
        }
    }

    // You can add more methods and constructors as needed
}