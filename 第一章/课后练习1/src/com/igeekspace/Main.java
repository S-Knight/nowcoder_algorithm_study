package com.igeekspace;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    static class User {
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

    static class ScoreAscendingComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o1.score - o2.score;
        }
    }

    static class ScoreDescendingComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return o2.score - o1.score;
        }
    }

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

            //比较器排序
            //comparatorSort(users, sortType);

            //冒泡排序
            bubbleSort(users, sortType);

            printUsers(users);
        }
    }

    /**
     * 使用比较器排序
     *
     * @param users    要排序的用户数组
     * @param sortType 0:降序 1升序
     */
    private static void comparatorSort(User[] users, int sortType) {
        if (sortType == 0) {//降序
            Arrays.sort(users, new ScoreDescendingComparator());
        } else {
            Arrays.sort(users, new ScoreAscendingComparator());
        }
    }

    private static void swapUser(User[] users, int i, int j) {
        User tempUser = users[j];
        users[j] = users[i];
        users[i] = tempUser;
    }

    /**
     * 冒泡排序
     *
     * @param users    要排序的用户数组
     * @param sortType 0:降序 1升序
     */
    private static void bubbleSort(User[] users, int sortType) {
        for (int i = 0; i < users.length - 1; i++) {
            if (sortType == 0) {//降序
                for (int j = users.length - 1; j > i; j--) {
                    if (users[j].getScore() > users[j - 1].getScore()) {
                        swapUser(users, j, j - 1);
                    }
                }
            } else {
                for (int j = 1; j < users.length - i; j++) {
                    if (users[j - 1].getScore() > users[j].getScore()) {
                        swapUser(users, j, j - 1);
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
