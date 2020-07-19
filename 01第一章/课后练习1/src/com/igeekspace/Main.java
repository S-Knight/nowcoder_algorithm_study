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
            boolean isSorted = true;
            if (sortType == 0) {//降序
                for (int j = users.length - 1; j > i; j--) {
                    if (users[j].getScore() > users[j - 1].getScore()) {
                        swapUser(users, j, j - 1);
                        isSorted = false;//如果没有任何数发生过swap，则说明该段数组已经有序
                    }
                }
            } else {
                for (int j = 1; j < users.length - i; j++) {
                    if (users[j - 1].getScore() > users[j].getScore()) {
                        swapUser(users, j, j - 1);
                        isSorted = false;
                    }
                }
            }

            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param users    要排序的用户数组
     * @param sortType 0:降序 1升序
     */
    private static void insertSort(User[] users, int sortType) {
        for (int i = 0; i < users.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (sortType == 0) {
                    if (users[j].getScore() > users[j - 1].getScore()) {
                        swapUser(users, j, j - 1);
                    } else {
                        break;
                    }
                } else {
                    if (users[j].getScore() < users[j - 1].getScore()) {
                        swapUser(users, j, j - 1);
                    } else {
                        break;
                    }
                }
            }
        }

    }

    private static void mergeSort(User[] users, int sortType, int left, int right) {
        if (left == right) {
            return;
        }

        int middle = (left + right) / 2;

        mergeSort(users, sortType, left, middle);
        mergeSort(users, sortType, middle + 1, right);

        User[] tempUsers = new User[right - left + 1];

        for (int i = left, j = middle + 1, k = 0; i <= middle || j <= right; ) {
            if (i > middle) {
                tempUsers[k++] = users[j];
                j++;
                continue;
            }

            if (j > right) {
                tempUsers[k++] = users[i];
                i++;
                continue;
            }

            if (sortType == 0) {
                if (users[i].getScore() >= users[j].getScore()) {
                    tempUsers[k++] = users[i];
                    i++;
                } else {
                    tempUsers[k++] = users[j];
                    j++;
                }
            } else {
                if (users[i].getScore() <= users[j].getScore()) {
                    tempUsers[k++] = users[i];
                    i++;
                } else {
                    tempUsers[k++] = users[j];
                    j++;
                }
            }
        }

        for (int i = 0; i < tempUsers.length; i++) {
            users[i + left] = tempUsers[i];
        }
    }

    private static void printUsers(User[] users) {
        for (User user : users) {
            System.out.println(user.getName() + " " + user.getScore());
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

            //插入排序
            //insertSort(users, sortType);

            //归并排序
            //mergeSort(users, sortType, 0, users.length - 1);
            printUsers(users);
        }
    }
}
