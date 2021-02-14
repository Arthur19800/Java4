package homework.lesson_4.task1;

import java.util.Random;
import java.util.Scanner;

public class Main {
//
    public static void main(String[] args) {
       int x = 0;
       int y = 0;
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String [][]field = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};


        PrintInitialArray(field);

       do
         {

            doPlayerMove(field, scanner);
            doCompMove(field, rand);

        }
        while (!StopGame(field,x,y));
        PrintWinner(field,x,y);
    }

    static void PrintInitialArray(String[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(" " + field[i][j]);
            }
            System.out.print("\n");
        }
    }

    static void doPlayerMove(String[][] field, Scanner scanner) {

        int x = 0;
        int y = 0;

        do {
            System.out.print("Input  coordinate of X in range 1..3:");
            x = scanner.nextInt()-1;
            if (x < 0 || x > 2) {
                System.out.print("Input  coordinate of X in range 1..3:");
            }
            System.out.print("Input  coordinate of Y in range 1..3:");
            y = scanner.nextInt() - 1;
            if (y < 0 || y > 2) {
                System.out.print("Input  coordinate of X in range 1..3:");
            }
            }
            while (!CheckCell(field,x,y)) ;
            field[x][y] = "x";

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    System.out.print(" " + field[i][j]);
                }
                System.out.print("\n");
            }
        }

        static void doCompMove (String[][]field, Random rand){

            int x;
            int y;
            do {
                x = rand.nextInt(field.length);
                y = rand.nextInt(field.length);
            }
            while (!CheckCell(field, x, y));
            field[x][y] = "O";

            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {

                        System.out.print(" " + field[i][j]);
                     }
                System.out.print("\n");
            }
        }

        static boolean CheckCell (String[][]field,int x, int y){
            for (int i = 0; i < field.length; i++) {
                for (int j = 0; j < field[i].length; j++) {
                    if (field[i][j] == "-") {
                        return true;
                    } else if (field[i][j] == "O" || field[i][j] == "X") {
                        return false;
                    }

                }
            }
            return true;
        }
        static boolean StopGame(String[][]field,int x, int y) {
            if (field [0][0] == "x"&& field [0][1] == "x" && field [0][2] == "x") {
                return true;
            }
            if (field [1][0] == "x"&& field [1][1] == "x" && field [1][2] == "x") {
                return true;
            }
            if (field [2][0] == "x"&& field [2][1] == "x" && field [2][2] == "x") {
                return true;
            }
            if (field [0][0] == "x"&& field [1][1] == "x" && field [2][2] == "x") {
                return true;
            }
            if (field [0][2] == "x"&& field [1][1] == "x" && field [2][0] == "x") {
                return true;
            }

            if (field [0][0] == "x"&& field [1][0] == "x" && field [2][0] == "x") {
                return true;
            }
            if (field [0][1] == "x"&& field [1][1] == "x" && field [2][1] == "x") {
                return true;
            }
            if (field [0][2] == "x"&& field [1][2] == "x" && field [2][2] == "x") {
                return true;
            }

            if (field [0][0] == "O"&& field [0][1] == "O" && field [0][1] == "O") {
                return true;
            }
            if (field [1][0] == "O"&& field [1][1] == "O" && field [1][2] == "O") {
                return true;
            }
            if (field [2][0] == "O"&& field [2][1] == "O" && field [2][2] == "O") {
                return true;
            }
            if (field [0][0] == "O"&& field [1][1] == "O" && field [2][2] == "O") {
                return true;
            }
            if (field [0][2] == "O"&& field [1][1] == "O" && field [2][0] == "O") {
                return true;
            }

            if (field [0][0] == "O"&& field [1][0] == "O" && field [2][0] == "O") {
                return true;
            }
            if (field [0][1] == "O"&& field [1][1] == "O" && field [2][1] == "O") {
                return true;
            }
            if (field [0][2] == "O"&& field [1][2] == "O" && field [2][2] == "O") {
                return true;
            }

            return false;

        }
      static void PrintWinner(String[][]field,int x, int y) {
          System.out.print("The winner is "+field[x][y]);
      }
    }
