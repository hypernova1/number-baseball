package org.melchor.game.context;

import org.melchor.game.Application;
import org.melchor.game.util.GameStage;
import org.melchor.game.domain.Gamer;
import org.melchor.game.util.NumberUtil;

import java.util.Scanner;

/**
 * 게임에 대한 로직이 수행되는 클래스입니다.
 * */
public class GameExecutor {

    private static final Scanner scanner = new Scanner(System.in);

    public static void start(int[] computerNumbers) {
        Gamer gamer = new Gamer(3);
        selectNumbers(gamer);
        boolean result = play(computerNumbers, gamer);
        if (result) {
            System.out.println("맞췄습니다!");
            Application.exit();
        }
    }

    private static boolean play(int[] computerNumbers, Gamer gamer) {
        int[] gamerNumbers = gamer.getNumbers();
        GameStage gameStage = new GameStage(computerNumbers, gamerNumbers);
        gameStage.compareNumbers();
        gameStage.printResult();
        return gameStage.isComplete();
    }

    private static void selectNumbers(Gamer gamer) {
        int no = 1;
        while (!gamer.isAllSelected()) {
            System.out.println(no + " 번 째 숫자를 입력해주세요.");
            String input = scanner.nextLine();
            int number = NumberUtil.parseNumber(input);
            if (!NumberUtil.isValidNumber(number)) {
                System.out.println("숫자는 0부터 9 사이의 값을 입력해주세요.");
                continue;
            }
            boolean result = gamer.selectNumber(number);
            if (result) {
                no++;
            }
        }
    }





}
