/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lzw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author mina
 */
public class LZW {

    public static void main(String[] args) {
        Scanner s;
        s = new Scanner(System.in);
        String input;
        input = s.next();
        char[] in;
        in = input.toCharArray();
        int DicSize = 128, OutputSize = 0;
        int[] out = new int[128];
//        char[] ch = new char[256];
        Map dic = new HashMap();
        for (int i = 0; i < DicSize; i++) {
            char ch = (char) i;
            dic.put(ch, i);
        }
        String search = "";
        for(int i=0;i<input.length();i++) {
            char cha = in[i];
            search += cha;
            if (dic.containsKey(search)) {
                search += cha;
            } else {
                int x=dic.;
                dic.put(search, DicSize++);
                search= ""+cha;
                OutputSize++;
            }
        }
        if(!search.equals("")){
            out[OutputSize] = (int) dic.get(search);
        }
        System.out.println(out);
    }
}
        