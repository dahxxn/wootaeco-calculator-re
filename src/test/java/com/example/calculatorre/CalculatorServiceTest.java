package com.example.calculatorre;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.calculatorre.error.ExceptionMessage;
import com.example.calculatorre.service.CalculatorService;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();

    @Test
    public void 모든_구분자_문자열_가져오기_테스트() {
        String expected = ",|:";
        assertEquals(expected, calculatorService.getAllDelimiters());
    }

    @Test
    public void 커스텀_구분자_추출_테스트() {
        String expected = "+";
        String actual = calculatorService.checkCustomDelimiters("//+\\n");
        assertEquals(expected, actual);
    }

    @Test
    public void 커스텀_구분자_추출불가_테스트() {
        assertThatThrownBy(() -> calculatorService.checkCustomDelimiters("/[][]]"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_INPUT.toString());
    }

    @Test
    public void 구분자로_문자열_조각_테스트() {
        String rawInput = "1,2:3";
        assertEquals(new ArrayList<>(List.of(new String[]{"1", "2", "3"})),
                calculatorService.splitInputByDelimiter(rawInput));
    }

}
