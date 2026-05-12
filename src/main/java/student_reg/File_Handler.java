package student_reg;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class File_Handler {

    private static final String FILE_NAME = "src\\main\\java\\student_reg\\students.csv";

    public static void saveStudent(Student student) {

        try {

            FileWriter fw = new FileWriter(FILE_NAME, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(student.toCSV());
            bw.newLine();

            bw.close();

        } catch (IOException e) {
            System.out.println("Kļūda saglabājot failu!");
        }
    }

    public static List<Student> loadStudents() {

        List<Student> students = new ArrayList<>();

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {
                return students;
            }

            BufferedReader br =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 5) {

                    Student student = new Student(
                            data[0],
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    );

                    students.add(student);
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Kļūda nolasot failu!");
        }

        return students;
    }

    public static void rewriteFile(List<Student> students) {

        try {

            BufferedWriter bw =
                    new BufferedWriter(new FileWriter(FILE_NAME));

            for (Student s : students) {
                bw.write(s.toCSV());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            System.out.println("Kļūda pārrakstot failu!");
        }
    }
}