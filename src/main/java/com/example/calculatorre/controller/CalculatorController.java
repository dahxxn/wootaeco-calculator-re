package com.example.calculatorre.controller;

import com.example.calculatorre.service.CalculatorService;
import com.example.calculatorre.view.InputView;
import com.example.calculatorre.view.OutputView;
import java.util.List;

public class CalculatorController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    CalculatorService calculatorService = new CalculatorService();

    public CalculatorController() {

    }

    public List<String> setInputToken() {
        String rawInput = inputView.readInput("덧셈할 문자열을 입력해 주세요");
        return calculatorService.splitInputByDelimiter(rawInput);
    }

    public void run() {
        List<String> inputTokens = setInputToken();
        outputView.printMessage("결과 : " + calculatorService.checkAndCalculateInputToken(inputTokens));
    }
}
