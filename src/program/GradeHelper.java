package program;

import java.util.Scanner;

public class GradeHelper {
    Scanner in = new Scanner(System.in);
    int[] gradesArray;
    int number;
    int one, two, three, four, five;


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
        String subject = in.nextLine();
        System.out.println("Предмет: " + subject + ".");
        System.out.println();
    }

    public int quantityGrades() {
        while (true) {
            System.out.print("Введите количество оценок от 5 до 15: ");
            if (in.hasNextInt()) {
                number = in.nextInt();
                if (number >= 5 && number <= 15) {
                    break;
                } else {
                    System.out.println("Введено неверное значение!");
                }
            } else {
                System.out.println("Введено неверное значение!");
                in.next();
            }
        }
        return number;
    }

    public void getGrades() {
        System.out.println("Введите оценки от 1 до 5: ");
        for (int i = 0; i < gradesArray.length; i++) {
            while (true) {
                if (in.hasNextInt()) {
                    gradesArray[i] = in.nextInt();
                    if (gradesArray[i] >= 1 && gradesArray[i] <= 5) {
                        break;
                    } else {
                        System.out.println("Введите 1, 2, 3, 4 или 5!");
                    }
                } else {
                    System.out.println("Введите 1, 2, 3, 4 или 5!");
                    in.next();
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
        double sum = 0;
        for (int i = 0; i <= gradesArray.length - 1; i++) {
            sum += gradesArray[i];
        }
        return sum / number;
    }

    public void howMuchGrade() {
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
    }

    public void showAverage() {
        double average = averageGrade();
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
        double average = averageGrade();
        if (average < 2.55) {
            return 2;
        } else if (average < 3.55) {
            return 3;
        } else if (average < 4.55) {
            return 4;
        } else {
            return 5;
        }
    }

    public void showResult() {
        int grade = finalGrade();
        if (grade == 2 || grade == 3) {
            System.out.println("Итоговая оценка: " + grade + "\n" + "Необходимо улучшить результат.");
        } else if (grade == 4) {
            System.out.println("Итоговая оценка: " + grade + "\n" + "Хороший результат.");
        } else {
            System.out.println("Итоговая оценка: " + grade + "\n" + "Отличный результат.");
        }

    }


    public static void main(String[] args) {
        GradeHelper program = new GradeHelper();
        //program.inputInfo();
        program.gradesArray = new int[program.quantityGrades()];
        program.getGrades();
        program.showGrades();
        program.howMuchGrade();
        program.minMaxGrade();
        program.showAverage();
        program.showResult();
    }
}