package DepthFirstSearch;
import java.util.*;
import java.math.BigInteger;

public class AdditiveNumber {
    public boolean AdditiveNumber(String num){

        public boolean isAdditiveNumber(String num) {
        int length = num.length();
        for (int i = 1; i < length / 2 + 1; i++) {
            for (int j = 1; j < length / 2 + 1; j++) {
                String first = num.substring(0, i);
                String second = num.substring(i, i + j);
                String others = num.substring(i + j, length);

                if (isValid(first, second, others))
                    return true;
            }
        }

        return false;
    }

    public boolean isValid(String first, String second, String others) {

        if ((first.length() > 1 && first.charAt(0) == '0') || (second.length() > 1 && second.charAt(0) == '0'))
            return false;

        BigInteger x1 = new BigInteger(first);
        BigInteger x2 = new BigInteger(second);
        x2 = x2.add(x1);
        String sumStr = x2.toString();

        if (others.equals(sumStr)) {
            return true;
        } else if (others.startsWith(sumStr)) {
            return isValid(second, sumStr, others.substring(sumStr.length()));
        } else {
            return false;
        }
    }
}