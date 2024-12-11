package com.example.calculatorre.service;

import com.example.calculatorre.constant.DefaultDelimiter;
import com.example.calculatorre.constant.Regex;
import com.example.calculatorre.error.CustomException;
import com.example.calculatorre.error.ExceptionMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private final List<String> customDelimiters = new ArrayList<>();

    public StringBuilder getDefaultDelimiters(StringBuilder totalDelimiters) {
        for (DefaultDelimiter delimiter : DefaultDelimiter.values()) {
            totalDelimiters.append(delimiter.getDelimiter());
            totalDelimiters.append("|");
        }
        return totalDelimiters;
    }

    public StringBuilder getCustomDelimiters(StringBuilder totalDelimiters) {
        for (String customDelimiter : customDelimiters) {
            totalDelimiters.append(customDelimiter);
            totalDelimiters.append("|");
        }
        return totalDelimiters;
    }

    public String getAllDelimiters() {
        StringBuilder totalDelimiters = new StringBuilder();
        totalDelimiters = getDefaultDelimiters(totalDelimiters);
        totalDelimiters = getCustomDelimiters(totalDelimiters);

        if (totalDelimiters.charAt(totalDelimiters.length() - 1) == '|') {
            totalDelimiters.deleteCharAt(totalDelimiters.length() - 1);
        }
        return totalDelimiters.toString();
    }

    public Boolean isNumber(String inputToken) {
        Matcher matcher = Pattern.compile(Regex.NUMBER_REGEX.getRegex()).matcher(inputToken);
        return matcher.matches();
    }

    public List<String> splitInputByDelimiter(String rawInput) {
        String[] rawInputToken = rawInput.split(getAllDelimiters());
        return new ArrayList<>(List.of(rawInputToken));
    }

    public String checkCustomDelimiters(String inputToken) {
        Matcher matcher = Pattern.compile(Regex.NORMAL_STRING_REGEX.getRegex() + Regex.CUSTOM_FORMAT_REGEX.getRegex()
                + Regex.NORMAL_STRING_REGEX.getRegex()).matcher(inputToken);
        if (!matcher.matches()) {
            throw new CustomException(ExceptionMessage.WRONG_INPUT);
        }
        return matcher.group(3);
    }

    public List<String> checkMoreSplitInputByDelimiter(String inputToken, List<String> inputTokens) {
        List<String> cutInputToken = splitInputByDelimiter(inputToken);
        if (cutInputToken.size() > 1) {
            inputTokens.addAll(cutInputToken);
            return inputTokens;
        }
        return null;
    }

    public List<String> checkDelimiterAndSetInputTokens(String inputToken, List<String> inputTokens) {
        String newCustomDelimiter = checkCustomDelimiters(inputToken);
        customDelimiters.add(newCustomDelimiter);
        String[] nonCustomRange = inputToken.split(Regex.CUSTOM_FORMAT_REGEX.getRegex());
        inputTokens.addAll(Arrays.asList(nonCustomRange));
        return inputTokens;
    }

    public List<String> validateInputToken(String inputToken, List<String> inputTokens) {
        List<String> newInputTokens = checkMoreSplitInputByDelimiter(inputToken, inputTokens);
        if (newInputTokens != null) {
            return newInputTokens;
        }
        if (!isNumber(inputToken)) {
            return checkDelimiterAndSetInputTokens(inputToken, inputTokens);
        }
        return null;
    }

    public String checkInputTokenEmpty(String inputToken) {
        if (inputToken.isEmpty()) {
            return "0";
        }
        return inputToken;
    }

    public int checkAndCalculateInputToken(List<String> inputTokens) {
        int sum = 0;
        for (int i = 0; i < inputTokens.size(); i++) {
            String inputToken = inputTokens.get(i).trim();
            inputToken = checkInputTokenEmpty(inputToken);
            if (validateInputToken(inputToken, inputTokens) == null) {
                sum += Integer.parseInt(inputToken);
            }
        }
        return sum;
    }

}
