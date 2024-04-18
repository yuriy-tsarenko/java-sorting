package com.go.it;

import java.util.Arrays;

/**
 * Клас BubbleSorting демонструє реалізацію алгоритму сортування бульбашкою.
 * Алгоритм бульбашкового сортування полягає в порівнянні пари сусідніх елементів
 * і перестановці їх у відповідності до порядку сортування, що продовжується до тих пір,
 * поки масив не буде повністю відсортований.
 */
public class BubbleSorting {
    public static void main(String[] args) {
        // Ініціалізація масиву з невпорядкованими значеннями
        int[] shuffledArray = {5, 7, 7, 2, 6, 8, 1, 1, 9};
        // Виклик методу bubbleSort для сортування масиву
        bubbleSort(shuffledArray, false);
        // Вивід відсортованого масиву
        System.out.println(Arrays.toString(shuffledArray));
    }

    /**
     * Метод для сортування масиву методом бульбашки.
     *
     * @param shuffledArray масив, який потрібно відсортувати
     * @param reverseOrder якщо true, сортування буде здійснено у зворотному порядку
     */
    public static void bubbleSort(int[] shuffledArray, boolean reverseOrder) {
        int length = shuffledArray.length; // Зберігаємо довжину масиву

        // Зовнішній цикл, кожен прохід якого зменшує ефективну довжину масиву
        for (int i = 0; i < length; i++) {
            // Внутрішній цикл, порівняння сусідніх елементів масиву
            for (int j = 0; j < length - i - 1; j++) {
                int first = shuffledArray[j]; // Перший елемент пари
                int second = shuffledArray[j + 1]; // Другий елемент пари
                // Визначення порядку сортування
                boolean sortingOrder = reverseOrder
                        ? first < second
                        : first > second;
                // Якщо умова виконана, відбувається заміна елементів
                if (sortingOrder) {
                    int temporaryValue = first; // Тимчасова змінна для заміни
                    first = second;
                    second = temporaryValue;
                    shuffledArray[j] = first; // Оновлення першого елемента
                    shuffledArray[j + 1] = second; // Оновлення другого елемента
                }
            }
        }
    }
}
