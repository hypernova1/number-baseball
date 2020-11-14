package org.melchor.game.domain;

import org.melchor.game.dto.BaseBallNumbers;
import org.melchor.game.util.NumberGenerator;

/**
 * 컴퓨터 클래스입니다.
 */
public class Computer implements Gamer {

    private final BaseBallNumbers baseBallNumbers;

    public Computer(int size) {
        int[] generatedNumbers = NumberGenerator.generate(size);
        this.baseBallNumbers = new BaseBallNumbers(generatedNumbers);
    }

    @Override
    public BaseBallNumbers getBaseBallNumbers() {
        return this.baseBallNumbers;
    }

}
