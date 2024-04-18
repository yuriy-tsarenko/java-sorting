package com.go.it;

public class QuickSortExample {

    public static void main(String[] args) {
        int[] unsortedNumbers = {34, 7, 23, 32, 5, 62, 78, 99, 1};
        quickSort(unsortedNumbers, 0, unsortedNumbers.length - 1);
        for (int number : unsortedNumbers) {
            System.out.print(number + " ");
        }
    }

    /**
     * Виконує сортування масиву методом швидкого сортування. Рекурсивно сортує частини масиву,
     * що розташовані до і після індексу опорного елемента.
     *
     * @param array      масив для сортування
     * @param startIndex початковий індекс
     * @param endIndex   кінцевий індекс
     */
    public static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int pivotIndex = partition(array, startIndex, endIndex);
            // Сортування лівої частини масиву від startIndex до pivotIndex - 1
            quickSort(array, startIndex, pivotIndex - 1);
            // Сортування правої частини масиву від pivotIndex + 1 до endIndex
            quickSort(array, pivotIndex + 1, endIndex);
        }
    }

    /**
     * Розділяє масив використовуючи останній елемент як опорний і визначає індекс для цього опорного елемента.
     *
     * @param array      масив для розділення
     * @param startIndex початковий індекс
     * @param endIndex   кінцевий індекс
     * @return індекс опорного елемента після визначення його позиції
     */
    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivotValue = array[endIndex]; // Опорний елемент
        int smallerElementIndex = startIndex - 1; // Індекс меншого елемента

        for (int currentIndex = startIndex; currentIndex < endIndex; currentIndex++) {
            // Якщо поточний елемент менший або рівний опорному
            if (array[currentIndex] <= pivotValue) {
                smallerElementIndex++;
                swap(array, smallerElementIndex, currentIndex); // Виконуємо обмін елементів
            }
        }
        int pivotPositionAfterReplacement = smallerElementIndex + 1;
        swap(array, pivotPositionAfterReplacement, endIndex); // Обмін опорного елемента з елементом на позиції pivotPositionAfterReplacement
        return pivotPositionAfterReplacement;
    }

    /**
     * Обмінює два елементи в масиві.
     *
     * @param array       масив, в якому відбувається обмін
     * @param firstIndex  індекс першого елемента для обміну
     * @param secondIndex індекс другого елемента для обміну
     */
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
