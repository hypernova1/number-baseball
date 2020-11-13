package org.melchor.game.util;

/**
 * Created by melchor
 * Date: 2020/11/13
 * Time: 4:39 PM
 */
public class NumberUtil {

    public static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static boolean isValidNumber(int number) {
        return number > 0 && number < 10;
    }

}
