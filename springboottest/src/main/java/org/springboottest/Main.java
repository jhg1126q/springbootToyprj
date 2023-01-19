package org.springboottest;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int RESULT_LENGTH = 7;
    private static final int TICKET_LENGTH = 6;
    private static final int TICKET_COUNT = 5;
    public static void main(String[] args) {
        int[] result = new int[RESULT_LENGTH];
        int[][] printNum = new int[TICKET_LENGTH][TICKET_COUNT];
        result = setResultNumbers();
        printResultNumbers(result);
        printNum = setTicketing();
        printTicketing(printNum);
    }

    private static int[] setResultNumbers() {
        int[] result = new int[RESULT_LENGTH];
        Random r = new Random();
        for (int i = 0; i < RESULT_LENGTH; i++) {
            result[i] = r.nextInt(45)+1;
        }
        return result;
    }

    private static void printArrayNumbers(int[] result) {
        System.out.println(Arrays.toString(result));
    }

    private static void printResultNumbers(int[] result) {
        System.out.println("result print!");
        printArrayNumbers(result);
    }

    private static int[] setTicketNumbers() {
        int[] result = new int[TICKET_LENGTH];
        Random r = new Random();
        for (int i = 0; i < TICKET_LENGTH; i++) {
            result[i] = r.nextInt(45)+1;
        }
        return result;
    }

    private static int[][] setTicketing() {
        int[][] result = new int[TICKET_LENGTH][TICKET_COUNT];
        for (int i = 0; i < TICKET_COUNT; i++) {
            result[i] = setTicketNumbers();
        }
        return result;
    }

    private static void printTicketing(int[][] result) {
        System.out.println("Ticketing print! : ");
        for (int[] ticket: result) {
            printArrayNumbers(ticket);
        }
    }
}