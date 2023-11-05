package lotto;

import lotto.config.GameConfig;
import lotto.controller.GameController;

public class Application {
    public static void main(String[] args) {

        GameConfig gameConfig = new GameConfig();
        GameController gameController = gameConfig.getGameController();

        gameController.start();
    }
}
