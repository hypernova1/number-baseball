package org.melchor.game.context;

import org.melchor.game.Application;
import org.melchor.game.domain.Gamer;
import org.melchor.game.domain.Computer;
import org.melchor.game.domain.User;
import org.melchor.game.util.NumberUtil;

/**
 * 게임에 대한 로직이 수행되는 클래스입니다.
 * */
public class GameExecutor {

    private static final int BASEBALL_NUMBER_SIZE = 3;

    public static void execute() {
        Computer computer = new Computer(BASEBALL_NUMBER_SIZE);
        User user = new User(BASEBALL_NUMBER_SIZE);
        while (true) {
            selectNumbers(user);
            boolean isAllStrike = compare(computer, user);
            if (isAllStrike) {
                System.out.println("맞췄습니다!");
                return;
            }
            user.clearNumber();
        }
    }

    private static boolean compare(Computer computer, Gamer gamer) {
        GameStage gameStage = new GameStage(computer, gamer);
        gameStage.compareNumbers();
        gameStage.printResult();
        return gameStage.isComplete();
    }

    private static void selectNumbers(User user) {
        int no = 1;
        while (!user.isAllSelected()) {
            System.out.println(no + " 번째 숫자를 입력해주세요.");
            String input = Application.scanner.nextLine();
            int number = NumberUtil.parseNumber(input);
            if (!NumberUtil.isValid(number)) {
                System.out.println("숫자는 1부터 9 사이의 값을 입력해주세요.");
                continue;
            }
            if (!user.isSelectedNumber(number)) {
                user.selectNumber(number);
                no++;
            }
        }
    }

}
