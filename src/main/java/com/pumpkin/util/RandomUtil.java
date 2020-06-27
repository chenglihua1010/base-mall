package com.pumpkin.util;

import java.util.Random;

public class RandomUtil {
        /**
         * java生成随机数字10位数
         *
         * @param length(随机生成的长度)
         * @return
         */
        public static String getRandomNickname(int length) {
                String val = "";
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                        val += String.valueOf(random.nextInt(30));
                }
                return val;
        }

        public static void main(String[] args) {
                System.out.println("java生成随机数字10位数：" + getRandomNickname(30));
        }
}