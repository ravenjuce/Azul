package comp1110.ass2.gittest;


import comp1110.ass2.Azul;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        C c = new C();
        String[] a = {"AFCB0703080106D0411011105", "A7Md00a02b03e04d11e13a20c24c30e40S1c12b2FaaaaB11Ma00c01b02d03e04c12a13b14d20b21c23a32S1e13c34e4Fccddddf"};
        String[] b = Azul.nextRound(a);
        System.out.println(Azul.getBonusPoints(a, 'B'));
        System.out.println(b[0]);


    }
}
