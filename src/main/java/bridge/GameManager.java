package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 게임을 관리해주는 역할을 한다.
 */
public class GameManager {
    InputView inputView;
    OutputView ouputView;
    BridgeMaker bridgeMaker;
    List<String> bridge;
    List<String> upResult = new ArrayList<>();
    List<String> downResult = new ArrayList<>();

    public GameManager(InputView input, OutputView output, BridgeRandomNumberGenerator generator) {
        this.inputView = input;
        this.ouputView = output;
        this.bridgeMaker = new BridgeMaker(generator);
    }

    public void start() {
        ouputView.printGameStart();
        boolean activation = true;
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int round = 0;

        while (activation) {
            String moving = inputView.readMoving();
            String[] result = bridgeGame.move(round, moving);
            addGameResult(result);
            ouputView.printMap(upResult, downResult);
            round++;

            if (Arrays.asList(result).contains(" X ")) {
                activation = retry();
                round = 0;
            }
        }

    }

    public void addGameResult(String[] result) {
        upResult.add(result[1]);
        upResult.add("|");
        downResult.add(result[0]);
        downResult.add("|");
    }

    public boolean retry() {
        String command = inputView.readGameCommand();
        return Objects.equals(command, "R");
    }
}
