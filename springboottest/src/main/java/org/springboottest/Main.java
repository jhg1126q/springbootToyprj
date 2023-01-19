package org.springboottest;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static final int TICKET_COUNT = 5;
    public static void main(String[] args) {
        ArrayList<Integer> total = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer>[] ticket = new ArrayList[TICKET_COUNT];
        total = generateTotalNumbers(total);
        result = generateResultNumbers(total, result);
        printResultNumbers(result);
        ticket = buyTicket(total, ticket);
    }

    private static ArrayList<Integer> generateTotalNumbers(ArrayList<Integer> total) {
        for (int i = 0; i < 45; i++) {
            total.add(i + 1);
        }
        return total;
    }

    private static ArrayList<Integer> generateResultNumbers(ArrayList<Integer> total, ArrayList<Integer> result) {
        Collections.shuffle(total);
        result.addAll(total.subList(0,7));
        Collections.sort(result);
        return result;
    }

    private static void printResultNumbers(ArrayList<Integer> result) {
        System.out.println("result : ");
        result.forEach(number -> System.out.print("|" + number +  "|"));
    }

    private static ArrayList<Integer> generateTicketNumbers(ArrayList<Integer> total, ArrayList<Integer> ticket) {
        Collections.shuffle(total);
        ticket.addAll(total.subList(0,6));
        Collections.sort(ticket);
        return ticket;
    }

    private static ArrayList<Integer>[] buyTicket(ArrayList<Integer> total, ArrayList<Integer>[] ticket) {
        for(int i =0; i < TICKET_COUNT; i++) {
            ticket[i] = generateTicketNumbers(total, ticket[i]);
            printTicketNumbers(ticket[i], i);
        }
        return ticket;
    }

    private static void printTicketNumbers(ArrayList<Integer> ticket, int num) {
        System.out.println("Ticket " + num + " : ");
        ticket.forEach(number -> System.out.print("|" + number +  "|"));
    }

}