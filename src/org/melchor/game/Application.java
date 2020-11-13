package org.melchor.game;

import org.melchor.game.constant.GameStatus;
import org.melchor.game.context.GameExecutor;
import org.melchor.game.util.NumberGenerator;

/**
 * 게임을 시작하는 클래스입니다.
 */
public class Application {

    private static GameStatus status = GameStatus.CONTINUE;

    public static void main(String[] args) {
        int[] computerNumbers = NumberGenerator.generate(3);
        while (status == GameStatus.CONTINUE) {
            GameExecutor.start(computerNumbers);
        }
    }

    public static void exit() {
        status = GameStatus.EXIT;
    }

}
