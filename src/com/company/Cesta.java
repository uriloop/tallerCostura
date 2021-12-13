package com.company;

public class Cesta {

    int capacitat;
    int actual;
    boolean lliure;

    @Override
    public String toString() {
        return "Cesta{" +
                "capacitat=" + capacitat +
                ", actual=" + actual +
                ", tipus=" + tipus +
                '}';
    }

    enum tipusCesta {
        MANGAS, CUERPOS
    }

    Enum<tipusCesta> tipus;


    public Cesta(int max, tipusCesta tipus) {
        this.capacitat = max;
        actual = 0;
        lliure = true;
        this.tipus = tipus;
    }


    public synchronized void posa() {
        try {
            while (!lliure) wait();
            lliure = false;
            notifyAll();
            actual ++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cesta" + this.tipus + "  +1  Total= "+actual);
        lliure=true;
        notifyAll();

    }

    public synchronized void agafa(int i) {

        try {
            while (!lliure) wait();
            lliure = false;
            notifyAll();
            actual -= i;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        System.out.println("Cesta" + this.tipus + "  -" + i+"Total= "+actual);
        lliure=true;
        notifyAll();


    }
}
