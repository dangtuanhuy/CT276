/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvclass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author minhtuyet
 */
public class check {

    public check() {
    }

    public static boolean checkName(String n) {

        if (n == null || n.length() == 0) {
            return false;
        } else {
            String strPattern = "[^a-z ]";

            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    public static boolean checkPhone(String n) {
        if (n == null || n.length() > 13 || n.length() < 7) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    public static boolean checkSpace(String n) {
        String strPattern = "[^ ]";
        Pattern p;
        Matcher m;
        int flag = Pattern.CASE_INSENSITIVE;
        p = Pattern.compile(strPattern, flag);
        m = p.matcher(n);
        return m.find();

    }

    public static boolean checkEmail(String n) {
        if (n == null) {
            return false;
        } else {
            String strPattern = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return m.find();
        }
    }

    public static boolean checkNumber(String n) {
        if (n == null || n.length() > 10 || n.length() < 1) {
            return false;
        } else {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    public static boolean check(String n) {
        if (n == null || n.length() == 0) {
            return false;
        }
        return true;
    }

    public static boolean checkID(String n) {
        if (n == null || n.length() > 10 || n.length() < 2) {
            return false;
        } else {
            String strPattern = "[^a-z0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();

        }
    }

    public static boolean checkDate(String n) {
        if (n == null || n.length() > 10 || n.length() < 2) {
            return false;
        } else {
            //String strPattern = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
              String strPattern = "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }
}
