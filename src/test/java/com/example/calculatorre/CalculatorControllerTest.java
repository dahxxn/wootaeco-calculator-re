package com.example.calculatorre;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.calculatorre.controller.CalculatorController;
import com.example.calculatorre.error.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
@Test
public void 일반_확인_테스트() {
    int expected = 1000;
    int actual = 1000;
    assertEquals(expected, actual);

    //혹은 값 반환을 하지 않는 메서드를 테스트하는 경우
    assertDoesNotThrow(() -> {
    });
}

@Test
public void 예외발생_확인_테스트() {
    assertThatThrownBy(() -> {
    })
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("ExceptionMessage.ERROR_MESSAGE_INPUT_PURCHASE_INFO_NOT_EXIST_PRODUCT.toString()");
}

@Test
public void 참_반환_테스트() {
    assertTrue(true);
}

@Test
public void 거짓_반환_테스트() {
    assertFalse(false);
}

@ParameterizedTest
@ValueSource(strings = {"hello", "  hi  "})
public void 여러_값_테스트(String testInput) {

}
*/

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
        assertEquals(new ArrayList<>(List.of(new String[]{"1", "2", "3"})), controller.getInputToken(rawInput));
    }
}
