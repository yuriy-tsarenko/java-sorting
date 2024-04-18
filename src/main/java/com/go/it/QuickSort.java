package com.go.it;

import java.util.Stack;

/**
 * Швидке сортування (Quick Sort) — це алгоритм сортування, який використовує стратегію "розділяй та володарюй".
 * Цей метод є одним з найшвидших способів сортування масивів на практиці, особливо для великих наборів даних.
 * <p>
 * Основні кроки алгоритму:
 * 1. Вибір опорного елемента: Вибрати елемент з масиву, який слугуватиме як опорний пункт для подальшого розділення.
 * 2. Розділення: Переставити інші елементи масиву так, щоб ліворуч від опорного знаходилися елементи, менші за нього,
 *    а праворуч — більші або рівні.
 * 3. Рекурсивне сортування: Застосувати ті ж кроки рекурсивно до лівої та правої частин масиву.
 * 4. Завершення: Рекурсія завершується, коли сегменти масиву, що сортуються, досягають розміру одного або нульового елемента,
 *    що означає їх повне впорядкування.
 * <p>
 * Час виконання:
 * - В середньому: O(n log n), де n — кількість елементів у масиві.
 * - У гіршому випадку: O(n^2), якщо опорний елемент завжди є найменшим або найбільшим елементом сегмента.
 * <p>
 * Примітка: Швидке сортування може бути особливо неефективним без вдалого вибору опорного елемента, тому рекомендується
 * використовувати методи, що забезпечують вибір опорного елемента, який максимально приближений до медіани.
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] unsortedNumbers = {34, 7, 23, 32, 5, 62, 78, 99, 1};
        iterativeQuickSort(unsortedNumbers, 0, unsortedNumbers.length - 1);
        for (int number : unsortedNumbers) {
            System.out.print(number + " ");
        }
    }

    /**
     * Виконує ітеративне швидке сортування вказаного масиву.
     * @param array масив, який потрібно відсортувати
     * @param startIndex початковий індекс сегменту масиву для сортування
     * @param endIndex кінцевий індекс сегменту масиву для сортування
     */
    public static void iterativeQuickSort(int[] array, int startIndex, int endIndex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startIndex);
        stack.push(endIndex);

        while (!stack.isEmpty()) {
            endIndex = stack.pop();
            startIndex = stack.pop();

            int pivotIndex = partition(array, startIndex, endIndex);

            if (pivotIndex - 1 > startIndex) {
                stack.push(startIndex);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < endIndex) {
                stack.push(pivotIndex + 1);
                stack.push(endIndex);
            }
        }
    }

    /**
     * Розділяє масив, використовуючи останній елемент як опорний, і повертає індекс опорного елемента після розміщення.
     * @param array масив для розділення
     * @param startIndex початковий індекс
     * @param endIndex кінцевий індекс
     * @return індекс опорного елемента
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivotValue = array[endIndex];  // Опорний елемент
        int smallerElementIndex = startIndex - 1;  // Індекс для менших елементів

        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            if (array[currentIndex] <= pivotValue) {
                smallerElementIndex++;
                swap(array, smallerElementIndex, currentIndex);  // Міняємо місцями елементи
            }
        }
        int pivotPositionAfterReplacement = smallerElementIndex + 1;
        swap(array, pivotPositionAfterReplacement, endIndex);  // Міняємо місцями опорний елемент
        return pivotPositionAfterReplacement;
    }

    /**
     * Міняє місцями два елементи в масиві.
     * @param array масив, в якому відбувається обмін
     * @param firstIndex індекс першого елемента для обміну
     * @param secondIndex індекс другого елемента для обміну
     */
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
