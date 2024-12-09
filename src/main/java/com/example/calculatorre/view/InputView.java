package com.example.calculatorre.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    OutputView outputView = new OutputView();

    public String readInput(String message) {
        outputView.printMessage(message);
        return Console.readLine();
    }
}