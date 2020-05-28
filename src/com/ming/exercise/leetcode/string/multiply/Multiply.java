package com.ming.exercise.leetcode.string.multiply;

/**
 * @Description Multiply
 * @Author Administrator
 * @Date 2020/5/28 23:42 2020
 *
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 *  示例 1:
 *
 *  输入: num1 = "2", num2 = "3"
 * 输出: "6"
 *
 *  示例 2:
 *
 *  输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 *
 *  说明：
 *
 *
 *  num1 和 num2 的长度小于110。
 *  num1 和 num2 只包含数字 0-9。
 *  num1 和 num2 均不以零开头，除非是数字 0 本身。
 *  不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 */
public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() < 1 || num2 == null || num2.length() < 1) {
            return null;
        }
        // 判断 num1 或者num2 是否为0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 返回字符串
        String result = null;

        // 拼接字符串buff
        StringBuffer stringBuffer = new StringBuffer();

//        if ()



        return result;
    }
}
