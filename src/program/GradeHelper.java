package program;

import java.util.Scanner;

public class GradeHelper {
    Scanner in = new Scanner(System.in);
    int[] gradesArray;
    int average;
    int numberOfGrades;


    public void inputInfo() {
        while (true) {
            System.out.print("Введите Ф.И.О: ");
            String name = in.nextLine();
            String[] words = name.split(" ");
            if (words.length >= 3) {
                System.out.println("Ученик: " + words[0] + " " +
                        words[1].charAt(0) + "." +
                        words[2].charAt(0) + ".");
                break;
            } else {
                System.out.println("Введено неверное значение!");
            }
        }
        System.out.println();
        while (true) {
            System.out.print("Выберите предмет: информатика, история, математика: ");
            String subject = in.next();
            if (subject.equalsIgnoreCase("Информатика") ||
                    subject.equalsIgnoreCase("История") ||
                    subject.equalsIgnoreCase("Математика")) {
                System.out.println("Предмет: " + subject + ".");
                break;
            } else {
                System.out.println("Введено неверное значение!");
            }
        }
        System.out.println();
    }

    public int quantityGrades() {
        while (true) {
            System.out.print("Введите количество оценок от 5 до 15: ");
            numberOfGrades = in.nextInt();
            if (numberOfGrades >= 5 && numberOfGrades <= 15) {
                break;
            } else {
                System.out.println("Введено неверное значение!");
            }
        }
        return numberOfGrades;
    }

    public void getGrades() {
        gradesArray = new int[numberOfGrades];
        System.out.println("Введите оценки от 1 до 5: ");
        for (int i = 0; i < gradesArray.length; i++) {
            while (true) {
                gradesArray[i] = in.nextInt();
                if (gradesArray[i] >= 1 && gradesArray[i] <= 5) {
                    break;
                } else {
                    System.out.println("Введите 1, 2, 3, 4 или 5!");
                }
            }
        }
        System.out.print("Оценки по предмету: ");
        for (int j : gradesArray) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public void averageGrade() {
        int one = 0, two = 0, three = 0, four = 0, five = 0;
        for (int j : gradesArray) {
            if (j == 1) {
                one++;
            } else if (j == 2) {
                two++;
            } else if (j == 3) {
                three++;
            } else if (j == 4) {
                four++;
            } else {
                five++;
            }
        }
        int result = (one + 2 * two + 3 * three + 4 * four + 5 * five) / (one + two + three + four + five);
        average = result;
        System.out.println("\n" + "Средняя оценка по предмету: " + result + "\n" +
                "Количество пятерок: " + five + "\n" +
                "Количество оценок ниже тройки: " + (one + two));

        System.out.println();
    }

    public void minMaxGrade() {
        int min = gradesArray[0];
        int max = gradesArray[0];
        for (int j : gradesArray) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
        }
        System.out.println("Минимальная оценка: " + min);
        System.out.println("Максимальная оценка: " + max);
        System.out.println();
    }

    public void gradeResult() {
        if (average <= 3) {
            System.out.println("Итоговоя оценка: " + average + "\n" + "Необходимо улучшить результат.");
        } else if (average == 4) {
            System.out.println("Итоговоя оценка: " + average + "\n" + "Хороший результат.");
        } else {
            System.out.println("Итоговоя оценка: " + average + "\n" + "Отличный результат.");
        }

    }

    public static void main(String[] args) {
        GradeHelper program = new GradeHelper();
        program.inputInfo();
        program.quantityGrades();
        program.getGrades();
        program.averageGrade();
        program.minMaxGrade();
        program.gradeResult();

    }
}