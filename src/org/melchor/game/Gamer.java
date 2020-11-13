package org.melchor.game;

/**
 * Created by melchor
 * Date: 2020/11/13
 * Time: 10:29 AM
 */
public class Gamer {

    private final int[] numbers;

    public Gamer(int size) {
        this.numbers = new int[size];
    }

    public boolean selectNumbers(int newNumber) {
        for (int i = 0; i < numbers.length; i++) {

            if (numbers[i] == newNumber) {
                return false;
            }
            if (numbers[i] == 0) {
                numbers[i] = newNumber;
                return true;
            }
        }
        System.out.println("더 이상 숫자를 선택 할 수 없습니다.");
        return false;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

}
