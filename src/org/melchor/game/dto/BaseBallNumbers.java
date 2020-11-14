package org.melchor.game.dto;

import java.util.Arrays;

/**
 * 야구 게임의 숫자를 관리하는 클래스입니다.
 */
public class BaseBallNumbers {

    private final int[] numbers;

    public BaseBallNumbers(int size) {
        this.numbers = new int[size];
    }

    public BaseBallNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int get(int index) {
        if (this.numbers[index] == 0) {
            return -1;
        }
        return numbers[index];
    }

    public void push(int newNumber) {
        if (isFull()) {
            System.out.println("더 이상 삽입할 수 없습니다.");
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = newNumber;
                return;
            }
        }
    }

    public boolean isExist(int number) {
        if (number == 0) {
            return false;
        }

        for (int n : this.numbers) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        int result = 0;
        for (int number : numbers) {
            if (number == 0) break;
            result++;
        }
        return result;
    }

    public void removeAll() {
        Arrays.fill(numbers, 0);
    }

    public boolean isFull() {
        return this.numbers.length == size();
    }
}
