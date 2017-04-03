package com.hejinyo.common.utils;

import java.util.Collection;

public final class StringUtil {
    private StringUtil() {
        throw new Error("工具类不能实例化！");
    }

    public static String capitalize(String str) {
        return jodd.util.StringUtil.capitalize(str);
    }

    public static String compressChars(String str, char c) {
        return jodd.util.StringUtil.compressChars(str, c);
    }

    public static String convertCharset(String str, String srcCharsetName, String newCharsetName) {
        return jodd.util.StringUtil.convertCharset(str, srcCharsetName, newCharsetName);
    }

    public static int count(String str, String sub, int startIndex, boolean ignoreCase) {
        return ignoreCase?jodd.util.StringUtil.countIgnoreCase(str.substring(startIndex), sub):jodd.util.StringUtil.count(str, sub, startIndex);
    }

    public static String cut(String str, String prefix, String suffix) {
        String source = str;
        if(jodd.util.StringUtil.isNotEmpty(prefix)) {
            source = jodd.util.StringUtil.cutPrefix(str, prefix);
        }

        if(jodd.util.StringUtil.isNotEmpty(suffix)) {
            source = jodd.util.StringUtil.cutSuffix(source, suffix);
        }

        return source;
    }

    public static String cutFrom(String str, String substring) {
        return jodd.util.StringUtil.cutFromIndexOf(str, substring);
    }

    public static String cutTo(String str, String substring) {
        return jodd.util.StringUtil.cutToIndexOf(str, substring);
    }

    public static String join(Collection<?> collction, String separator) {
        return jodd.util.StringUtil.join(collction, separator);
    }

    public static boolean isNullOrEmpty(String str) {
        return jodd.util.StringUtil.isEmpty(str);
    }

    public static boolean isNullOrBlank(String str) {
        return jodd.util.StringUtil.isBlank(str);
    }

    public static String maxCommonPrefix(String str1, String str2) {
        return jodd.util.StringUtil.maxCommonPrefix(str1, str2);
    }

    public static String prefix(String str, String prefix) {
        return jodd.util.StringUtil.prefix(str, prefix);
    }

    public static String reverse(String str) {
        return jodd.util.StringUtil.reverse(str);
    }

    public static String suffix(String str, String suffix) {
        return jodd.util.StringUtil.suffix(str, suffix);
    }

    public static String surround(String str, String prefix, String suffix) {
        return jodd.util.StringUtil.surround(str, prefix, suffix);
    }

    public static String trimLeft(String str) {
        return jodd.util.StringUtil.trimLeft(str);
    }

    public static String trimRight(String str) {
        return jodd.util.StringUtil.trimRight(str);
    }

    public static String uncapitalize(String str) {
        return jodd.util.StringUtil.uncapitalize(str);
    }
}
