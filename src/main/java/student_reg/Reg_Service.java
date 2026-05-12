package student_reg;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Reg_Service {

    Scanner sc = new Scanner(System.in);

    public void registerStudent() {

        try {

            System.out.print("Vārds: ");
            String name = sc.nextLine();

            if (!Validator.validateName(name)) {
                throw new Custom_except("Nepareizs vārds!");
            }

            System.out.print("Uzvārds: ");
            String surname = sc.nextLine();

            if (!Validator.validateSurname(surname)) {
                throw new Custom_except("Nepareizs uzvārds!");
            }

            System.out.print("E-pasts: ");
            String email = sc.nextLine();

            if (!Validator.validateEmail(email)) {
                throw new Custom_except("Nepareizs e-pasts!");
            }

            List<Student> students =
                    File_Handler.loadStudents();

            for (Student s : students) {

                if (s.getEmail().equals(email)) {
                    throw new Custom_except(
                            "E-pasts jau eksistē!"
                    );
                }

                if (s.getPersonalCode().equals(email)) {
                    throw new Custom_except(
                            "Personas kods jau eksistē!"
                    );
                }
            }

            System.out.print("Personas kods: ");
            String personalCode = sc.nextLine();

            if (!Validator.validatePersonalCode(personalCode)) {
                throw new Custom_except(
                        "Nepareizs personas kods!"
                );
            }

            String date =
                    LocalDateTime.now()
                            .format(
                                    DateTimeFormatter.ofPattern(
                                            "yyyy-MM-dd HH:mm:ss"
                                    )
                            );

            Student student = new Student(
                    name,
                    surname,
                    email,
                    personalCode,
                    date
            );

            File_Handler.saveStudent(student);

            System.out.println("Students reģistrēts!");

        } catch (Custom_except e) {
            System.out.println(e.getMessage());
        }
    }

    public void showStudents() {

        List<Student> students =
                File_Handler.loadStudents();

        if (students.isEmpty()) {
            System.out.println("Nav studentu!");
            return;
        }

        Table_print.printStudents(students);
    }

    public void removeStudent() {

        List<Student> students =
                File_Handler.loadStudents();

        System.out.print(
                "Ievadi personas kodu: "
        );

        String code = sc.nextLine();

        boolean removed =
                students.removeIf(
                        s -> s.getPersonalCode().equals(code)
                );

        if (removed) {

            File_Handler.rewriteFile(students);

            System.out.println("Students dzēsts!");

        } else {
            System.out.println("Students nav atrasts!");
        }
    }

    public void editStudent() {

        List<Student> students =
                File_Handler.loadStudents();

        System.out.print(
                "Ievadi personas kodu: "
        );

        String code = sc.nextLine();

        boolean found = false;

        for (Student s : students) {

            if (s.getPersonalCode().equals(code)) {

                found = true;

                System.out.print("Jauns vārds: ");
                String newName = sc.nextLine();

                if (Validator.validateName(newName)) {
                    s.setName(newName);
                }

                System.out.print("Jauns uzvārds: ");
                String newSurname = sc.nextLine();

                if (Validator.validateSurname(newSurname)) {
                    s.setSurname(newSurname);
                }

                System.out.print("Jauns e-pasts: ");
                String newEmail = sc.nextLine();

                if (Validator.validateEmail(newEmail)) {
                    s.setEmail(newEmail);
                }

                File_Handler.rewriteFile(students);

                System.out.println(
                        "Studenta dati atjaunoti!"
                );

                break;
            }
        }

        if (!found) {
            System.out.println(
                    "Students nav atrasts!"
            );
        }
    }
}