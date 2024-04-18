package com.go.it;

public class BreakContinueReturn {
    public static void main(String[] args) {
        double[][] numArray = new double[][]{
                {1.0, 5.0, 3.0, 9.0, 7.0},
                {8.0, 8.9, 4.5, 6.7, 8.6}
        };

        for (int i = 0; i < numArray.length; i++) {
            for (int j = 0; j < numArray[i].length; j++) { // порція коду одної ітерації
                double currentValue = numArray[i][j];

                if (currentValue == 4.5) {
                    System.out.println("Знайдено 4.5");
                    continue; // завершить поточну ітерацію і цикл запустить наступну(при цьому робота поточного циклу
                    //загалом не зупиняється )
                }
                if (currentValue > 8.9) {
                    System.out.printf("Знайдено число більше ніж 8.0: %.2f\n", currentValue);
                    break;// зупинить виконання поточного циклу, але зовнішній продовжить працювати
                }

            } // порція коду одної ітерації
        }

        Double number = findNumber(6.7, numArray);
        System.out.println("FOUND: " + number);

        findNumberWithBreak();
        findNumberWithContinue();
    }

    public static Double findNumber(double numberToFound, double[][] numArray) {
        for (int i = 0; i < numArray.length; i++) {
            for (int j = 0; j < numArray[i].length; j++) { // порція коду одної ітерації
                double currentValue = numArray[i][j];
                if (numberToFound == currentValue) {
                    return numberToFound;
                }
            } // порція коду одної ітерації
        }
        return null;
    }

    public static void findNumberWithBreak() {

        for (int l = 0; l < 100; l++) {
            happyStudent:
            for (int i = 0; i < 100; i++) {
                goIt:
                for (int j = 0; j < 100; j++) {
                    for (int k = 0; k < 100; k++) {
                        if (k == 50) {
                            System.out.println("number: " + k);
                            break goIt;// зупинить виконання поточного циклу і перемістить виконання коду
                            // на місце де ця мітка буда створена(goIt)
                        }

//                        if (k == 40) {
//                            System.out.println("number: " + k);
//                            break happyStudent; // зупинить виконання поточного циклу і перемістить виконання коду
//                            // на місце де ця мітка буда створена(happyStudent)
//                        }
                    }
                }
            }
        }
    }

    public static void findNumberWithContinue() {

        for (int l = 0; l < 100; l++) {
            happyStudent:
            for (int i = 0; i < 100; i++) {
                goIt:
                for (int j = 0; j < 100; j++) {
                    for (int k = 0; k < 100; k++) {
                        if (k == 50) {
                            System.out.println("number: " + k);
                            continue happyStudent;// зупинить виконання поточного циклу і перемістить виконання коду
                            // на місце де ця мітка буда створена(goIt)
                        }
                        if (k == 50) {
                            System.out.println("continue works here");
                        }

//                        if (k == 40) {
//                            System.out.println("number: " + k);
//                            break happyStudent; // зупинить виконання поточного циклу і перемістить виконання коду
//                            // на місце де ця мітка буда створена(happyStudent)
//                        }
                    }
                    System.out.println("1 цей код коли спрацює continue буде пропущений");
                }
                System.out.println("2 цей код коли спрацює continue буде пропущений");
            }
        }
    }
}