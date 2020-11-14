package org.melchor.game.context;

import org.melchor.game.Application;
import org.melchor.game.dto.BaseBallNumbers;
import org.melchor.game.domain.Computer;
import org.melchor.game.domain.User;
import org.melchor.game.util.NumberUtil;

/**
 * 게임에 대한 로직이 수행되는 클래스입니다.
 * */
public class GameExecutor {

    private static final int NUMBER_SIZE = 3;
    private static Computer computer;

    public static void initComputer() {
        computer = new Computer(3);
    }

    public static void execute() {
        while (true) {
            User user = new User(NUMBER_SIZE);
            selectNumbers(user);
            boolean isEqual = compare(computer.getBaseBallNumbers(), user.getBaseBallNumbers());
            if (isEqual) {
                System.out.println("맞췄습니다!");
                return;
            }
        }
    }

    private static boolean compare(BaseBallNumbers computerNumbers, BaseBallNumbers gamerNumbers) {
        GameStage gameStage = new GameStage(computerNumbers, gamerNumbers);
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
