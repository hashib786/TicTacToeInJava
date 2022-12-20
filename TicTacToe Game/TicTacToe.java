package OOPS_4;

import java.util.Scanner;

public class TicTacToe {
    private Player hashib, sonu;
    private Board board;
    private int count;
    Scanner sc = new Scanner(System.in);

    public void startGame(){
        // take Input
        this.hashib = takeInput(1);
        this.sonu = takeInput(2);
        this.board = new Board();

        playGame();

    }

    private void playGame() {
        int flag = 1;
        while (count != 9){
            if(flag == 1){
                System.out.format("%s Where You Want To Put %s [X]:- ", hashib.getName(), hashib.getSymbol());
                int first = sc.nextInt();
                System.out.format("%s Where You Want To Put %s [Y]:- ", hashib.getName(), hashib.getSymbol());
                int second = sc.nextInt();
                if(this.board.board[first][second] == ' '){
                    this.board.board[first][second] = hashib.getSymbol();
                    count++;
                    flag = 0;
                }

                printSituation();

                boolean isTrue = checkWin(hashib.getSymbol());
                if(isTrue) {
                    System.out.format("Congratulation ****** %s ****** You Win!!!", hashib.getName());
                    break;
                }
            }else{
                System.out.format("%s Where You Want To Put %s [X]:- ", sonu.getName(), sonu.getSymbol());
                int first = sc.nextInt();
                System.out.format("%s Where You Want To Put %s [Y]:- ", sonu.getName(), sonu.getSymbol());
                int second = sc.nextInt();
                if(this.board.board[first][second] == ' '){
                    this.board.board[first][second] = sonu.getSymbol();
                    count++;
                    flag = 1;
                }

                printSituation();

                boolean isTrue = checkWin(sonu.getSymbol());
                if(isTrue) {
                    System.out.format("Congratulation ****** %s ****** You Win!!!", sonu.getName());
                    break;
                }
            }
        }
    }

    private void printSituation() {
        for (int i = 0; i < this.board.board.length; i++) {
            for (int j = 0; j < this.board.board[i].length; j++) {
                System.out.print("|");
                System.out.print(this.board.board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    private boolean checkWin(char symbol) {
        boolean isTrue = true;

        for (int i = 0; i < 3; i++)
            if (this.board.board[0][i] != symbol) {
                isTrue = false;
                break;
            }
        if(isTrue) return true;
        isTrue = true;

        for (int i = 0; i < 3; i++)
            if (this.board.board[i][2] != symbol) {
                isTrue = false;
                break;
            }
        if(isTrue) return true;
        isTrue = true;

        for (int i = 0; i < 3; i++)
            if (this.board.board[2][2] != symbol) {
                isTrue = false;
                break;
            }
        if(isTrue) return true;
        isTrue = true;

        for (int i = 2; i >= 0; i--)
            if (this.board.board[i][0] != symbol) {
                isTrue = false;
                break;
            }
        if(isTrue) return true;
        isTrue = true;

        for (int i = 0, j = 0; i < 3; i++, j++)
            if (this.board.board[i][j] != symbol) {
                isTrue = false;
                break;
            }
        if(isTrue) return true;
        isTrue = true;

        for (int i = 0, j = 2; i < 3; i++, j--)
            if (this.board.board[i][j] != symbol) {
                isTrue = false;
                break;
            }
        return isTrue;
    }

    private Player takeInput(int position){
        System.out.format("%s Player Name :- ", position == 1 ? "First" : "Second");
        String player = sc.next();
        System.out.format("%s Symbol :- ", player);
        char symbol = sc.next().charAt(0);
        return new Player(player, symbol);
    }

}

class Board{
    char[][] board;

    public Board(){
        int size = 3;
        board = new char[size][size];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < size; j++) board[i][j] = ' ';
        }
    }
}

class Player{
    private String name;
    private char symbol;

    public Player(String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
