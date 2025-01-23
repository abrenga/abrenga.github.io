package com.abrenga.experiments;

class Contatore {
    int contatore;

    public void incrementa() {
        contatore++;
    }
}

class MyThread extends Thread {
    private Contatore contatore;

    MyThread(Contatore contatore) {
        this.contatore = contatore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            contatore.incrementa();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Contatore contatore = new Contatore();

        MyThread myThread = new MyThread(contatore);
        myThread.start();

        MyThread myThread2 = new MyThread(contatore);
        myThread2.start();
    }
}
