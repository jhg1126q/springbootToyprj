package org.springboottest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static final int TICKET_COUNT = 100;
    public static void main(String[] args) {
        // set ticket
        List<ArrayList<Integer>> tickets = new ArrayList<>();
        // set 45 Total Number
        ArrayList<Integer> total = generateTotalNumbers();
        // set winning result Number
        ArrayList<Integer> result = generateResultNumbers(total);
        // print result
        printResultNumbers(result);
        // ticket buy
        buyTicket(total, tickets);
        // result
        for(ArrayList<Integer> list: tickets) {
            matchNumbers(list, result);
        }
    }

    private static ArrayList<Integer> generateTotalNumbers() {
        ArrayList<Integer> total = new ArrayList<Integer>();
        for (int i = 0; i < 45; i++) {
            total.add(i + 1);
        }
        return total;
    }

    private static ArrayList<Integer> generateResultNumbers(ArrayList<Integer> total) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Collections.shuffle(total);
        result.addAll(total.subList(0,7));
        Collections.sort(result);
        return result;
    }

    private static void printResultNumbers(ArrayList<Integer> result) {
        System.out.println("result : ");
        result.forEach(number -> System.out.print("|" + number +  "|"));
        System.out.println("\n------");
    }

    private static ArrayList<Integer> generateTicketNumbers(ArrayList<Integer> total, ArrayList<Integer> ticket) {
        Collections.shuffle(total);
        ticket.addAll(total.subList(0,6));
        Collections.sort(ticket);
        return ticket;
    }

    private static List<ArrayList<Integer>> buyTicket(ArrayList<Integer> total, List<ArrayList<Integer>> ticket) {
        ArrayList<Integer> newTicket = new ArrayList<Integer>();
        for(int i =0; i < TICKET_COUNT; i++) {
            newTicket = generateTicketNumbers(total, newTicket);
            ticket.add(newTicket);
            newTicket = new ArrayList<Integer>();
            printTicketNumbers(ticket.get(i), i);
        }
        return ticket;
    }

    private static void printTicketNumbers(ArrayList<Integer> soloTicket, int num) {
        System.out.println("Ticket " + num + " : ");
        soloTicket.forEach(number -> System.out.print("|" + number +  "|"));
        System.out.println("\n------");
    }

    private static void matchNumbers(ArrayList<Integer> soloTicket, ArrayList<Integer> result) {
        int matchPoint = 0;
        for (int ticketNum : soloTicket) {
            for (int resultNum : result) {
                if(ticketNum == resultNum) {
                    matchPoint += 1;
                }
            }
        }
        printResultLotto(matchPoint);
    }

    private static void printResultLotto(int matchPoint) {
        switch (matchPoint) {
            case 3:
                System.out.println("Winning : 5 rank ");
                break;
            case 4:
                System.out.println("Winning : 4 rank ");
                break;
            case 5:
                System.out.println("Winning : 3 rank ");
                break;
            case 6:
                System.out.println("Winning : 2 rank ");
                break;
            default:
                System.out.println("Lose : Boom ");
                break;
        }
    }
}