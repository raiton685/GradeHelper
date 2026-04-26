package program;

import java.util.Scanner;

public class GradeHelper {
    Scanner in = new Scanner(System.in);
    int grade;
    int[] gradesArray;
    double average;
    int number;
    int one = 0, two = 0, three = 0, four = 0, five = 0;


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

        System.out.print("Введите название предмета: ");
        String subject = in.next();
        System.out.println("Предмет: " + subject + ".");
        System.out.println();
    }

    public int quantityGrades() {
        while (true) {
            System.out.print("Введите количество оценок от 5 до 15: ");
            number = in.nextInt();
            if (number >= 5 && number <= 15) {
                break;
            } else {
                System.out.println("Введено неверное значение!");
            }
        }
        return number;
    }

    public void getGrades() {
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
        in.close();
    }


    public void showGrades() {
        System.out.print("Оценки по предмету: ");
        for (int j : gradesArray) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public double averageGrade() {
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
        return average = (double) (one + 2 * two + 3 * three + 4 * four + 5 * five) /
                (one + two + three + four + five);
    }

    public void showAverage() {
        System.out.printf("\n" + "Средняя оценка по предмету: %.1f", average);
        System.out.println("\n" + "Количество пятерок: " + five + "\n" +
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

    public int finalGrade() {
        if (average < 2.54) {
            return grade = 2;
        } else if (average >= 2.55 && average <= 3.54) {
            return grade = 3;
        } else if (average >= 3.55 && average <= 4.54) {
            return grade = 4;
        } else {
            return grade = 5;
        }
    }

    public void showResult() {
        if (grade == 2) {
            System.out.println("Итоговая оценка: " + grade + "\n" + "Необходимо улучшить результат.");
        } else if (grade == 3) {
            System.out.println("Итоговая оценка: " + grade + "\n" + "Необходимо улучшить результат.");
        } else if (grade == 4) {
            System.out.println("Итоговая оценка: " + grade + "\n" + "Хороший результат.");
        } else {
            System.out.println("Итоговая оценка: " + grade + "\n" + "Отличный результат.");
        }

    }


    public static void main(String[] args) {
        GradeHelper program = new GradeHelper();
        program.inputInfo();
        program.gradesArray = new int[program.quantityGrades()];
        program.getGrades();
        program.showGrades();
        program.average = program.averageGrade();
        program.minMaxGrade();
        program.showAverage();
        program.grade = program.finalGrade();
        program.showResult();
    }
}