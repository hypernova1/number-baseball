package org.melchor.game.util;

/**
 * 랜덤 숫자 배열을 생성하는 클래스입니다.
 * */
public class NumberGenerator {

    public static int[] generate(int size) {
        int[] numbers = new int[size];
        int pushedNumberCount = 0;
        while (pushedNumberCount < size) {
            int newNumber = creteRandomNumber();
            if (NumberUtil.isContain(numbers, newNumber)) {
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

}
