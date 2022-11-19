package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upResult, List<String> downResult) {
        System.out.print("[");
        for (int i = 0; i < upResult.size() - 1; i++) {
            System.out.print(upResult.get(i));
        }
        System.out.println("]");
        System.out.print("[");
        for (int i = 0; i < downResult.size() - 1; i++) {
            System.out.print(downResult.get(i));
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printGameStart() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }
}
