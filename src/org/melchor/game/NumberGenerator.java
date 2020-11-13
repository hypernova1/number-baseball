package org.melchor.game;

public class NumberGenerator {

    public static int[] generate(int size) {
        int[] numbers = new int[size];
        int pushedNumberCount = 0;
        while (pushedNumberCount < size) {
            int newNumber = creteRandomNumber();
            if (isContain(numbers, newNumber)) {
                continue;
            }
            numbers[pushedNumberCount] = newNumber;
            pushedNumberCount++;
        }
        return numbers;
    }

    private static int creteRandomNumber() {
        return (int) (Math.random() * 9) + 1;
    }

    private static boolean isContain(int[] numbers, int newNumber) {
        for (int number : numbers) {
            if (number == newNumber) {
                return true;
            }
        }
        return false;
    }

}
