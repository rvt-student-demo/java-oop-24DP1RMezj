package student_reg;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Reg_Service service =
                new Reg_Service();

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("register");
            System.out.println("show");
            System.out.println("remove");
            System.out.println("edit");
            System.out.println("exit");

            System.out.print("Izvēle: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "register":
                    service.registerStudent();
                    break;

                case "show":
                    service.showStudents();
                    break;

                case "remove":
                    service.removeStudent();
                    break;

                case "edit":
                    service.editStudent();
                    break;

                case "exit":
                    System.out.println(
                            "Programma apturēta."
                    );
                    return;

                default:
                    System.out.println(
                            "Nepareiza izvēle!"
                    );
            }
        }
    }
}