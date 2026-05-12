package student_reg;

public class Validator {

    public static boolean validateName(String name) {
        return name.matches("^[A-Za-zĀ-ž]{3,}$");
    }

    public static boolean validateSurname(String surname) {
        return surname.matches("^[A-Za-zĀ-ž]{3,}$");
    }

    public static boolean validateEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean validatePersonalCode(String code) {
        return code.matches("^\\d{6}-\\d{5}$");
    }
}