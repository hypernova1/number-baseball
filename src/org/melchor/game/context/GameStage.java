package org.melchor.game.context;

import org.melchor.game.domain.Computer;
import org.melchor.game.domain.Gamer;

/**
 * 컴퓨터와 사용자의 숫자를 비교하고 결과를 확인하는 클래스입니다.
 * */
public class GameStage {

    private static final int BASEBALL_NUMBER_SIZE = 3;

    private final Computer computer;

    private final Gamer gamer;

    private int strike;

    private int ball;

    private int out;

    public GameStage(Computer computer, Gamer gamer) {
        this.computer = computer;
        this.gamer = gamer;
    }

    public void compareNumbers() {
        if (!isNumbersLengthEquals()) {
            System.out.println("길이가 같지 않아 비교할 수 없습니다.");
        }
        for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
            compareNumber(gamer.getBaseBallNumbers().get(i), i);
        }
    }

    private void compareNumber(int gamerNumber, int order) {
        for (int i = 0; i < BASEBALL_NUMBER_SIZE; i++) {
            int computerNumber = computer.getBaseBallNumbers().get(i);

            if (computerNumber == gamerNumber && i == order) {
                this.strike++;
                continue;
            }
            if (computerNumber == gamerNumber) {
                this.ball++;
            }
        }
        this.out = BASEBALL_NUMBER_SIZE - this.strike - this.ball;
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();
        if (this.strike > 0) {
            sb.append(this.strike).append("스트라이크 ");
        }
        if (ball > 0) {
            sb.append(this.ball).append("볼 ");
        }
        if (out > 0) {
            sb.append(this.out).append("아웃 ");
        }
        System.out.println(sb.toString() + "입니다.");
    }

    public boolean isComplete() {
        return this.strike == BASEBALL_NUMBER_SIZE;
    }

    private boolean isNumbersLengthEquals() {
        return this.computer.getBaseBallNumbers().size() == this.computer.getBaseBallNumbers().size();
    }
}
