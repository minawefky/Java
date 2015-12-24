/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package osassi4;

import java.util.AbstractQueue;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author mina
 */
public class RoundRobin {

    HashMap<String, Integer> nameA = new HashMap<>();
    HashMap<String, Integer> nameB = new HashMap<>();
    HashMap<String, Integer> result = new HashMap<>();
    int atime, btime, arival, timer = 0, TimeQuantum;
    String name, time;
    Queue<String> ready = new PriorityQueue<>();

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
        System.out.println("enter Time Quantum");
        TimeQuantum = s.nextInt();
        for (String x : nameB.keySet()) {
            ready.add(x);
        }
    }

    public void imp() {
//        HashMap<String, Integer> temp = new HashMap<>();
        while (!ready.isEmpty()) {
            String x = ready.poll();
//            String x = (String) nameA.keySet().toArray()[0];
////            temp.put(x, nameA.get(x));
////            arival = nameA.get(x);
            int c = nameB.get(x);
            if (TimeQuantum >= c) {
                timer += nameB.get(x);
                result.put(x, timer);
            } else {
                c = c - TimeQuantum;
                nameB.replace(x, c);
                timer += TimeQuantum;
                ready.add(x);
            }
        }
    }

    public void print() {
        int i = 0;
        float f;
        for (String x : result.keySet()) {
            i += result.get(x);
            System.out.println(x + "     " + result.get(x));
        }
        f = i / result.size();
        System.out.println(i);
    }
}
