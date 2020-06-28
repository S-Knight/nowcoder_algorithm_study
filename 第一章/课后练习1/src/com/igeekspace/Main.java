package com.igeekspace;

import java.util.Scanner;

class User {
    private String name;
    private int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int userCount = scanner.nextInt();
            byte sortType = scanner.nextByte();

            User[] users = new User[userCount];
            for (int i = 0; i < userCount; i++) {
                User user = new User(scanner.next(), scanner.nextInt());
                users[i] = user;
            }

            bubbleSort(users, sortType);

            printUsers(users);
        }
    }

    /**
     * 冒泡排序
     *
     * @param users 要排序的用户数组
     */
    private static void bubbleSort(User[] users, int sortType) {
        if (sortType == 0) {//降序
            for (int i = 0; i < users.length - 1; i++) {
                for (int j = users.length - 1; j > i; j--) {
                    if (users[j].getScore() > users[j - 1].getScore()) {
                        User tempUser = users[j - 1];
                        users[j - 1] = users[j];
                        users[j] = tempUser;
                    }
                }
            }
        } else {
            for (int i = 0; i < users.length - 1; i++) {
                for (int j = 1; j < users.length - i; j++) {
                    if (users[j - 1].getScore() > users[j].getScore()) {
                        User tempUser = users[j - 1];
                        users[j - 1] = users[j];
                        users[j] = tempUser;
                    }
                }
            }
        }
    }


    private static void printUsers(User[] users) {
        for (User user : users) {
            System.out.println(user.getName() + " " + user.getScore());
        }
    }
}
