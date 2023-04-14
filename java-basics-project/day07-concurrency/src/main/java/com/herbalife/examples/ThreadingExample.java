package com.herbalife.examples;

public class ThreadingExample {
    public static void main(String[] args) {
        //You create an instance of Thread
        //And supply the activity to it
        //start it
        Thread codingThread = new Thread(new CodingActivity());
        codingThread.start();

        Thread modernCodingThread = new Thread(() -> {
            while(true) {
                System.out.println("Search Stackoverflow; Use ChatGPT; type code");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        modernCodingThread.start();
    }
}
class CodingActivity implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.println("Writing code");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
