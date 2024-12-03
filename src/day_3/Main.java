package day_3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static int multiplyResult(String str) {
        String pattern = "mul\\((\\d+),(\\d+)\\)";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(str);

        int result = 0;

        while (matcher.find()) {
            int num1 = Integer.parseInt(matcher.group(1));
            int num2 = Integer.parseInt(matcher.group(2));

            result += num1 * num2;
        }

        if (result == 0) throw new IllegalArgumentException("No valid multiplications found in the input string!");

        return result;
    }

    public static void main(String[] args) {
        int exampleResult = multiplyResult("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
        System.out.println(exampleResult);
    }
}
