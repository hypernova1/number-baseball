package org.melchor.game.domain;

import java.util.Arrays;

/**
 * 사용자에 대한 클래스입니다. 선택된 숫자를 관리합니다.
 */
public class Gamer {

    private final int[] numbers;
    private int selectedNumberCount = 0;

    public Gamer(int size) {
        this.numbers = new int[size];
    }

    public boolean selectNumber(int newNumber) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == newNumber) {
                System.out.println("이미 선택한 숫자입니다.");
                return false;
            }
            if (numbers[i] == 0) {
                numbers[i] = newNumber;
                selectedNumberCount++;
                return true;
            }
        }
        return false;
    }

    public int[] getNumbers() {
        return this.numbers;
    }

    public boolean isAllSelected() {
        return numbers.length == selectedNumberCount;
    }

}
