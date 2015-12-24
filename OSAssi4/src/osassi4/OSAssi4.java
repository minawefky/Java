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
public class OSAssi4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("enter 1 for FIFO &2 for SJF &3 Round Robin ");
        int x;
        Scanner s = new Scanner(System.in);
        x = s.nextInt();
        if (x == 1) {
            FIFO f1 = new FIFO();
            f1.filling();
            f1.imp();
            f1.print();
        } else if (x == 2) {
            SJF s1 = new SJF();
            s1.filling();
            s1.sorted();
            s1.imp();
            s1.print();
        } else {
            RoundRobin r1 = new RoundRobin();
            r1.filling();
            r1.imp();
            r1.print();
        }
    }
}
