package org.melchor.game.context;

import org.melchor.game.Application;
import org.melchor.game.domain.Gamer;
import org.melchor.game.util.NumberGenerator;
import org.melchor.game.util.NumberUtil;

/**
 * 게임에 대한 로직이 수행되는 클래스입니다.
 * */
public class GameExecutor {

    private static int[] computerNumbers;

    public static void initComputerNumbers() {
        computerNumbers = NumberGenerator.generate(3);
    }

    public static void execute() {
        while (true) {
            Gamer gamer = new Gamer(3);
            selectNumbers(gamer);
            boolean isEqual = compare(computerNumbers, gamer.getNumbers());
            if (isEqual) {
                System.out.println("맞췄습니다!");
                return;
            }
        }
    }

    private static boolean compare(int[] computerNumbers, int[] gamerNumbers) {
        GameStage gameStage = new GameStage(computerNumbers, gamerNumbers);
        gameStage.compareNumbers();
        gameStage.printResult();
        return gameStage.isComplete();
    }

    private static void selectNumbers(Gamer gamer) {
        int no = 1;
        while (!gamer.isAllSelected()) {
            System.out.println(no + " 번째 숫자를 입력해주세요.");
            String input = Application.scanner.nextLine();
            int number = NumberUtil.parseNumber(input);
            if (!NumberUtil.isValid(number)) {
                System.out.println("숫자는 1부터 9 사이의 값을 입력해주세요.");
                continue;
            }
            boolean result = gamer.selectNumber(number);
            if (result) {
                no++;
            }
        }
    }

}
