package org.melchor.game.context;

import org.melchor.game.dto.BaseBallNumbers;

/**
 * 컴퓨터와 사용자의 숫자를 비교하고 결과를 확인하는 클래스입니다.
 * */
public class GameStage {

    private final BaseBallNumbers computerNumbers;

    private final BaseBallNumbers gamerNumbers;

    private int strike;

    private int ball;

    private int out;

    public GameStage(BaseBallNumbers computerNumbers, BaseBallNumbers gamerNumbers) {
        this.computerNumbers = computerNumbers;
        this.gamerNumbers = gamerNumbers;
    }

    public void compareNumbers() {
        if (!isNumbersLengthEquals(computerNumbers, gamerNumbers)) {
            System.out.println("길이가 같지 않아 비교할 수 없습니다.");
        }
        for (int i = 0; i < gamerNumbers.size(); i++) {
            compareNumber(gamerNumbers.get(i), i);
        }
    }

    public boolean isComplete() {
        return this.strike == this.gamerNumbers.size();
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        if (strike > 0) {
            sb.append(strike).append(" 스트라이크 ");
        }
        if (ball > 0) {
            sb.append(ball).append(" 볼 ");
        }
        if (out > 0) {
            sb.append(out).append(" 아웃 ");
        }
        System.out.println(sb.toString() + "입니다.");
    }

    private void compareNumber(int gamerNumber, int order) {
        for (int i = 0; i < computerNumbers.size(); i++) {
            if (computerNumbers.get(i) == gamerNumber && i == order) {
                this.strike++;
                continue;
            }
            if (computerNumbers.get(i) == gamerNumber) {
                this.ball++;
            }
        }
        this.out = this.gamerNumbers.size() - this.strike - this.ball;
    }

    private boolean isNumbersLengthEquals(BaseBallNumbers computerNumbers, BaseBallNumbers gamerNumbers) {
        return computerNumbers.size() == gamerNumbers.size();
    }
}
