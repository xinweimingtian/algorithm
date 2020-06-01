package com.ming.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Description CodeCounter
 * @Author weihuiming
 * @Date
 *
 * 代码行数统计
 *
 */
public class CodeCounter {

    /**
     * 代码行数统计
     */
    public static void main(String[] args) {
        // 获取class文件路径
        String file = CodeCounter.class.getResource("/").getFile();
        // 改变路径获取java文件
        String path = file.replace("out/production/algorithm", "src");

        // 获取主文件下所有的文件
        ArrayList<File> al = getFile(new File(path));
        for (File f : al) {
            // 匹配java格式文件
            if (f.getName().matches(".*\\.java$")) {
                count(f);
                System.out.println(f);
            }
        }
        System.out.println("统计文件：" + files);
        System.out.println("代码行数：" + codeLines);
        System.out.println("注释行数：" + commentLines);
        System.out.println("空白行数：" + blankLines);
    }

    /**
     * 文件个数统计
     */
    static long files = 0;

    /**
     * 代码行数统计
     */
    static long codeLines = 0;

    /**
     * 注解行数统计
     */
    static long commentLines = 0;

    /**
     * 空白行数统计
     */
    static long blankLines = 0;

    /**
     * 目录下的所有文件
     */
    static ArrayList<File> fileArray = new ArrayList<>();

    /**
     * @Description 获取目录下的文件和子目录下的文件
     * @Author 		weihuiming
     * @Date		2017年2月14日下午2:57:08
     * @param file 	获取的文件目录
     * @return		返回此文件夹下所有文件
     */
    private static ArrayList<File> getFile(File file) {
        // 返回抽象路径名数组
        File[] ff = file.listFiles();
        for (File child : ff) {
            if (child.isDirectory()) {
                // 进行迭代
                getFile(child);
            } else {
                // 文件添加到集合
                fileArray.add(child);
            }
        }
        return fileArray;
    }

    /**
     * @Description 统计行数方法
     * @Author 		weihuiming
     * @Date		2017年2月14日下午3:09:25
     * @param f		需要统计的文件
     */
    private static void count(File f) {
        // 获取输入流缓冲
        BufferedReader br = null;
        // 多行注释判断验证判断
        boolean flag = false;

        try {
            // 获取缓冲
            br = new BufferedReader(new FileReader(f));
            // 每行读取内容
            String line = "";
            while ((line = br.readLine()) != null) {
                // 去除前后空格
                line = line.trim();
                // 匹配空行
                if (line.matches("^[ ]*$")) {
                    blankLines++;
                } else if (line.startsWith("//")) { // 匹配单行注解
                    commentLines++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")) { // 匹配多行注释开始
                    commentLines++;
                    flag = true;
                } else if (line.startsWith("/*") && line.endsWith("*/")) { // 匹配一行写的多行注释
                    commentLines++;
                } else if (flag == true) { // 匹配多行注释结束
                    commentLines++;
                    if (line.endsWith("*/")){
                        flag = false; // 重置验证
                    }
                } else { // 代码行数增加
                    codeLines++;
                }
            }
            files++;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
