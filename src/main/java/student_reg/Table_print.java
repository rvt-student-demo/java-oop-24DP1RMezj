package student_reg;

import java.util.List;

public class Table_print {

    public static void printStudents(List<Student> students) {

        System.out.println(
                "+--------------+--------------+----------------------+---------------+---------------------+");

        System.out.printf(
                "| %-12s | %-12s | %-20s | %-13s | %-19s |\n",
                "Vards",
                "Uzvards",
                "E-pasts",
                "Personas kods",
                "Datums"
        );

        System.out.println(
                "+--------------+--------------+----------------------+---------------+---------------------+");

        for (Student s : students) {

            System.out.printf(
                    "| %-12s | %-12s | %-20s | %-13s | %-19s |\n",
                    s.getName(),
                    s.getSurname(),
                    s.getEmail(),
                    s.getPersonalCode(),
                    s.getRegistrationDate()
            );
        }

        System.out.println(
                "+--------------+--------------+----------------------+---------------+---------------------+");
    }
}