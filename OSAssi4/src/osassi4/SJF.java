/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osassi4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author mina
 */
public class SJF {

    HashMap<String, Integer> nameA = new HashMap<>();
    HashMap<String, Integer> nameB = new HashMap<>();
    int atime, btime, arival, timer = 0;
    String name, time;

    public void filling() {
         Scanner s = new Scanner(System.in);
        System.out.println("enter page name arrival time the brust time -1 to exit");
        while (true) {
            name = s.nextLine();
            if (name.equals("-1")) {
                break;
            } else {
                atime = Integer.valueOf(s.nextLine());
                btime = Integer.valueOf(s.nextLine());
                nameA.put(name, atime);
                nameB.put(name, btime);
            }
        }
    }

    public void sorted() {
       Object[] a = nameA.entrySet().toArray();
    Arrays.sort(a, new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return ((Map.Entry<String, Integer>) o2).getValue().compareTo(
                    ((Map.Entry<String, Integer>) o1).getValue());
        }
    });
    }

    public void imp() {
            for (String x : nameA.keySet()) {
            arival = nameA.get(x);
            if (arival > timer) {
                timer = arival;
//                arival = nameA.get(x)-timer;
                timer += nameB.get(x);
                nameA.replace(x, timer);
                arival = 0;
            } else if (arival == timer) {
                timer += nameB.get(x);
                nameA.replace(x, timer);
            } else {
//                arival = timer - nameA.get(x);
                timer += nameB.get(x);
                nameA.replace(x, timer);
                arival = 0;
            }
        }
    }
      public void print() {
        int i = 0;
        float z;
        for (String x : nameA.keySet()) {
            System.out.println(x + "     " + nameA.get(x));
            i += nameA.get(x);
        }
        z = i / nameA.size();
        System.out.println(i);
    }
    }

  