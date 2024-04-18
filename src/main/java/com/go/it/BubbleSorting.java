package com.go.it;

import java.util.Arrays;

public class BubbleSorting {
    public static void main(String[] args) {
        int[] shuffledArray = {5, 7, 7, 2, 6, 8, 1, 1, 9};
        bubbleSort(shuffledArray, false);
        System.out.println(Arrays.toString(shuffledArray));
    }

    public static void bubbleSort(int[] shuffledArray, boolean reverseOrder) {
        int length = shuffledArray.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                int first = shuffledArray[j];
                int second = shuffledArray[j + 1];
                boolean sortingOrder = reverseOrder
                        ? first < second
                        : first > second;
                if (sortingOrder) {
                    int temporaryValue = first;
                    first = second;
                    second = temporaryValue;
                    shuffledArray[j] = first;
                    shuffledArray[j + 1] = second;
                }
            }
        }

    }
}
