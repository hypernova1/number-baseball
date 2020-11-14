package org.melchor.game.domain;

import org.melchor.game.dto.BaseBallNumbers;

/**
 * 사용자 클래스입니다. 선택된 숫자를 관리합니다.
 */
public class User implements Gamer {

    private final BaseBallNumbers baseBallNumbers;

    public User(int size) {
        this.baseBallNumbers = new BaseBallNumbers(size);
    }

    @Override
    public BaseBallNumbers getBaseBallNumbers() {
        return this.baseBallNumbers;
    }

    public void selectNumber(int number) {
        this.baseBallNumbers.push(number);
    }

    public boolean isAllSelected() {
        return baseBallNumbers.isFull();
    }

    public boolean isSelectedNumber(int number) {
        return this.baseBallNumbers.isExist(number);
    }

    public void clearNumber() {
        baseBallNumbers.removeAll();
    }
}
