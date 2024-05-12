package net.zliss.tool.mybatis.generator.zgenerator.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ZGStringUtil {

    public static String underscoreToUpperCamel(String input) {
        if (input == null) {
            return null;
        }
        String[] words = input.split("_");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(StringUtils.capitalize(word.toLowerCase()));
        }
        return result.toString();
    }

    public static String firstLetterUpper(String param) {
        if (null == param || "".equals(param)) {
            return "";
        }
        String firstLetter = String.valueOf(param.charAt(0));
        if (firstLetter.matches("[a-zA-Z]")) {
            firstLetter = firstLetter.toUpperCase();
        }
        return firstLetter + param.substring(1);
    }

    public static String firstLetterLower(String param) {
        if (null == param || "".equals(param)) {
            return "";
        }
        String firstLetter = String.valueOf(param.charAt(0));
        if (firstLetter.matches("[a-zA-Z]")) {
            firstLetter = firstLetter.toLowerCase();
        }
        return firstLetter + param.substring(1);
    }

    public static String toString(Object obj) {
        return Objects.toString(obj, "");
    }
}
