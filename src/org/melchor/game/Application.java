package org.melchor.game;

import org.melchor.game.constant.GameStatus;
import org.melchor.game.context.GameExecutor;

import java.util.Scanner;

/**
 * 게임을 시작하는 클래스입니다.
 */
public class Application {

    private static GameStatus status = GameStatus.CONTINUE;

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (status == GameStatus.CONTINUE) {
            GameExecutor.initComputer();
            GameExecutor.execute();

            System.out.println("계임이 종료되었습니다. 다시 하시려면 Y를 입력하세요.");
            String result = scanner.nextLine().toUpperCase();
            if (!"Y".equals(result)) {
                status = GameStatus.EXIT;
            }
        }
    }
}
