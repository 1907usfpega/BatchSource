package com.package1;

import java.lang.StringBuilder;

public class MyChild extends MySuper {
        public boolean checkForUpper(String s) {
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }

        public String makeUpper(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(Character.toUpperCase(c));
            }
            return sb.toString();
        }

        public int addTen(String s) {
            return 10 + Integer.valueOf(s);
        }
    }