package com.example.calculatorre;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.calculatorre.controller.CalculatorController;
import com.example.calculatorre.error.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CalculatorControllerTest {
    CalculatorController controller = new CalculatorController();

    @BeforeEach
    void setUp() {
        //각 테스트 실행 전 실행해야할 로직
    }

    @Test
    public void 모든_구분자_문자열_가져오기_테스트() {
        String expected = ",|:";
        assertEquals(expected, controller.getAllDelimiters());
    }

    @Test
    public void 커스텀_구분자_추출_테스트() {
        String expected = "+";
        String actual = controller.checkCustomDelimiters("//+\\n");
        assertEquals(expected, actual);
    }

    @Test
    public void 커스텀_구분자_추출불가_테스트() {
        assertThatThrownBy(() -> controller.checkCustomDelimiters("/[][]]"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.WRONG_INPUT.toString());
    }

    @Test
    public void 구분자로_문자열_조각_테스트() {
        String rawInput = "1,2:3";
        assertEquals(new ArrayList<>(List.of(new String[]{"1", "2", "3"})), controller.splitInputByDelimiter(rawInput));
    }
}
