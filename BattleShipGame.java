package com.example;
import java.util.*;
public class project1 {
public static void printMap(String[][] a)
{
    String[][] map = a;
    for(int i = 0; i < 10; i++)
    {
        System.out.print(i + " | ");
        for(int j = 0; j < 10; j++)
        {
            if(map[i][j]==null || map[i][j] == "2")
            {
                System.out.print(" ");
            }
            else
            {
                System.out.print(map[i][j]);
            }
        }
        System.out.println(" | " + i);
    }
}
public static void main(String[] args)
{
    String[][] coordinates = new String[10][10];
    System.out.println("** Welcome to Battle Ships game **\n");
    System.out.println("Right now, the sea is empty.\n");
    System.out.println("    0123456789    ");
    printMap(coordinates);
    System.out.println("    0123456789    ");

    Scanner input = new Scanner(System.in);
    int p = 1;
    for(int j = 1; j <= 5; j++) {
        int x = 11;
        int y = 11;
        while (x > 9) {
            System.out.println("Enter the X coordinate for ship " + p + ".");
            x = input.nextInt();
            if (x > 9 || x < 0) {
                System.out.println("Please enter a coordinate from 0-9.");
            }
        }
        while (y > 9) {
            System.out.println("Enter the Y coordinate for ship " + p + ".");
            y = input.nextInt();
            if (y > 9 || y < 0) {
                System.out.println("Please enter a coordinate from 0-9.");
            }
        }
        if (coordinates[x][y] == null) {
            coordinates[x][y] = "@";
            p++;
        } else {
            System.out.println("Coordinate (" + x + "," + " " + y + ") is occupied.");
            j--;
        }
    }
    System.out.println("Here is the map with your ships: \n");
    printMap(coordinates);

    System.out.println("Computer is deploying ships.");
    int w = 1;
    while(w <= 5)
    {

       int u = (int)(Math.random()*10);
       int o = (int)(Math.random()*10);
        if(coordinates[u][o] == null)
        {
            coordinates[u][o] = "2";
            System.out.println("Ship " + w + " has been deployed.");
            w++;
        }

    }
    int player = 5;
    int computer = 5;
    System.out.println("@ represents your ship; x represents your sunken ship; ! represents enemy sunken ship; \n - represents your misses; * represents computer misses");
    while(player > 0 && computer > 0)
    {
        int q = 0;
        System.out.println("YOUR TURN");
        while(q == 0) {
            int x = 10;
            int y = 10;
            while (x > 9) {
                System.out.print("Enter X coordinate for your attack: ");
                x = input.nextInt();
                System.out.println();
                if (x > 9 || x < 0) {
                    System.out.println("Please enter a coordinate from 0-9.");
                }
            }
            while (y > 9) {
                System.out.print("Enter Y coordinate for your attack: ");
                y = input.nextInt();
                System.out.println();
                if (y > 9 || y < 0) {
                    System.out.println("Please enter a coordinate from 0-9.");
                }
            }

            if (coordinates[x][y] == "2") {
                System.out.println("BOOM! You sunk a ship!");
                coordinates[x][y] = "!";
                computer--;
                printMap(coordinates);
                System.out.println("Your ships: " + player + " | Computer ships: " + computer + "\n");
                System.out.println("--------------------------------");
                q++;
            }
            else if (coordinates[x][y] == "@") {
                System.out.println("Aw shucks! You sunk your own ship!");
                coordinates[x][y] = "x";
                player--;
                printMap(coordinates);
                System.out.println("Your ships: " + player + " | Computer ships: " + computer + "\n");
                System.out.println("--------------------------------");
                q++;
            }
            else if(coordinates[x][y] == null) {
                System.out.println("Sorry, you missed.");
                coordinates[x][y] = "-";
                printMap(coordinates);
                System.out.println("Your ships: " + player + " | Computer ships: " + computer + "\n");
                System.out.println("--------------------------------");
                q++;
            }
            else {
                System.out.println("This spot has already been guessed, try again.");
            }

        }
        if(computer > 0 && player > 0)
        {
            System.out.println("Computer's turn.");
            int j = 0;
            while(j == 0) {
                int u = (int) (Math.random() * 10);
                int o = (int) (Math.random() * 10);
                    if (coordinates[u][o] == "@") {
                        System.out.println("Computer has sunk a player's ship.");
                        coordinates[u][o] = "x";
                        player--;
                        printMap(coordinates);
                        System.out.println("Your ships: " + player + " | Computer ships: " + computer + "\n");
                        System.out.println("--------------------------------");
                        j++;
                    } else if (coordinates[u][o] == "2") {
                        System.out.println("Wow! The computer sunk it's own ship!");
                        coordinates[u][o] = "!";
                        computer--;
                        printMap(coordinates);
                        System.out.println("Your ships: " + player + " | Computer ships: " + computer + "\n");
                        System.out.println("--------------------------------");
                        j++;
                    } else if(coordinates[u][o] == null) {
                        System.out.println("Computer missed.");
                        coordinates[u][o] = "*";
                        printMap(coordinates);
                        System.out.println("Your ships: " + player + " | Computer ships: " + computer + "\n");
                        System.out.println("--------------------------------");
                        j++;
                    }
            }
        }
    }

    System.out.println("GAME OVER!");
    if(player == 0)
    {
        System.out.println("You lost the game.");
    }
    else
    {
        System.out.println("Hooray! You won :)");
    }


}

}