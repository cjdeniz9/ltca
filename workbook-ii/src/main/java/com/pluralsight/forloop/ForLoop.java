package com.pluralsight.workbook.ii.asychronous;

public class ForLoop {
    public static void main(String[] args) throws InterruptedException {
        int countdown = 10;

        for (int i = 1; i <= 10; i++) {
            System.out.println(countdown);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            countdown -= 1;
        }
    }
}
