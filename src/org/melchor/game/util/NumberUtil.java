package org.melchor.game.util;

/**
 * 숫자에 관련된 유틸 클래스입니다.
 */
public class NumberUtil {

    public static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static boolean isContain(int[] numbers, int newNumber) {
        for (int number : numbers) {
            if (number == newNumber) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(int number) {
        return number > 0 && number < 10;
    }

}
