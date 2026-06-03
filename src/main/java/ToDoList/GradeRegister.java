import java.util.ArrayList;

public class GradeRegister {

    private ArrayList<Integer> grades;

    public GradeRegister() {
        grades = new ArrayList<>();
    }

    public void addGradeBasedOnPoints(int points) {
        grades.add(pointsToGrades(points));
    }

    public int numberOfGrades(int grade) {
        int count = 0;

        for (int received : grades) {
            if (received == grade) {
                count++;
            }
        }

        return count;
    }

    public static int pointsToGrades(int points) {

        if (points < 50) {
            return 0;
        } else if (points < 60) {
            return 1;
        } else if (points < 70) {
            return 2;
        } else if (points < 80) {
            return 3;
        } else if (points < 90) {
            return 4;
        }

        return 5;
    }
}