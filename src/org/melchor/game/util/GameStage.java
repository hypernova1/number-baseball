package org.melchor.game.util;

/**
 * 컴퓨터와 사용자의 숫자를 비교하고 결과를 확인하는 클래스입니다.
 * */
public class GameStage {

    private final int[] computerNumbers;
    private final int[] gamerNumbers;

    private int strike;
    private int ball;
    private int out;

    public GameStage(int[] computerNumbers, int[] gamerNumbers) {
        this.computerNumbers = computerNumbers;
        this.gamerNumbers = gamerNumbers;
    }

    public void compareNumbers() {
        if (!isNumbersLengthEquals(computerNumbers, gamerNumbers)) {
            System.out.println("길이가 같지 않아 비교할 수 없습니다.");
        }
        for (int i = 0; i < gamerNumbers.length; i++) {
            compareNumber(gamerNumbers[i], i);
        }
    }

    public boolean isComplete() {
        return this.strike == this.gamerNumbers.length;
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        if (strike > 0) {
            sb.append(strike).append(" 스트라이크 ");
        }
        if (ball > 0) {
            sb.append(ball).append(" 볼 ");
        }
        if (gamerNumbers.length - strike - ball > 0) {
            sb.append(out).append(" 아웃");
        }
        System.out.println(sb.toString() + "입니다.");
    }

    private void compareNumber(int gamerNumber, int order) {
        for (int i = 0; i < computerNumbers.length; i++) {
            if (computerNumbers[i] == gamerNumber && i == order) {
                this.strike++;
                continue;
            }
            if (computerNumbers[i] == gamerNumber) {
                this.ball++;
            }
        }
        this.out = this.gamerNumbers.length - this.strike - this.ball;
    }

    private boolean isNumbersLengthEquals(int[] computerNumbers, int[] gamerNumbers) {
        return computerNumbers.length == gamerNumbers.length;
    }
}
