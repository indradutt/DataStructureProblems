package com.indra.problems.ds.strings;

/**
 * Indra Dutt
 */
public class ConvertNumber {

    private String[] singleDigit = {"", " one", " two", " three", " four", " five", " six", " seven", " eight", " nine" };

    private String[] tens = {" ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen", " seventeen", " eighteen", " nineteen"};
    private String[] twoDigit = {"", " twenty", " thirty", " forty", " fifty", " sixty", " seventy", " eighty", " ninety"};

    public String convertTo(String input) {

        int size = input.length();

        if (size == 0) {
            throw new NumberFormatException("");
        }

        if (size <= 3) {
            return handleUpToThreeDigits(input.toCharArray());
        } else if (size > 3 && size <= 6) {
            char[] in1 = new char[3];
            char[] in2 = new char[size - 3];

            for (int i = 0 ; i < 3; i++) {
                in1[i] = input.charAt(i);
            }
            for (int i = 0 ; i < size -3; i++) {
                in2[i] = input.charAt(3 + i);
            }
            String firstSet = handleUpToThreeDigits(in2);
            String secondSet = handleUpToThreeDigits(in1);
            return (!firstSet.isEmpty() ? firstSet + " million": "") + secondSet;
        } else if (size >= 6 && size <= 9) {
            char[] in1 = new char[3];
            char[] in2 = new char[3];
            char[] in3 = new char[size - 3];

            for (int i = 0 ; i < 3; i++) {
                in1[i] = input.charAt(i);
            }
            for (int i = 3 ; i < 6; i++) {
                in2[i] = input.charAt(i);
            }
            for (int i = 6 ; i < size; i++) {
                in3[i] = input.charAt(i);
            }

            String firstSet = handleUpToThreeDigits(in1);
            String secondSet = handleUpToThreeDigits(in2);
            String thirdSet = handleUpToThreeDigits(in3);

            return  (!firstSet.isEmpty() ? firstSet + " billion": "") + (!secondSet.isEmpty()? secondSet + " million": "") +  thirdSet;
        }

        return "Not Supported Yet";
    }

    private String handleUpToThreeDigits(char[] input) {
        String word = "";
        if (input.length == 3) {
            String out = input[0] - '0' > 0 ? singleDigit[input[0] - '0'] + " hundred" : "";
            word = word + out;
            if (input[1] - '0' == 1 ) {
                return word + tens[input[1] - '0'];
            }
            out= input[1] - '0' > 1 ? twoDigit[input[1] - '0'] : input[1] - '0' == 1 ? tens[input[1] - '0']: "";
            word = word + out;

            out= input[2] - '0' > 0 ? singleDigit[input[2] - '0'] : "";
            word = word + out;
        }
        if (input.length == 2) {
            if (input[0] - '0' == 1 ) {
                return word + tens[input[0] - '0'];
            }
            String out= input[0] - '0' > 1 ? twoDigit[input[1] - '0'] : input[0] - '0' == 1 ? tens[input[0] - '0']: "";
            word = word + out;

            out= input[1] - '0' > 0 ? singleDigit[input[1] - '0'] : "";
            word = word + out;
        }
        if (input.length == 1){
            String out= input[0] - '0' > 0 ? singleDigit[input[0] - '0'] : "";
            word = word + out;
        }
        return word;
    }
}
