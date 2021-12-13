package com.company;

public class Cesta {

    int capacitat;
    int actual;
    boolean lliure;

    enum tipusCesta{
        MANGAS,CUERPOS
    }

    Enum<tipusCesta> tipus;








    public Cesta(int max,tipusCesta tipus) {
        this.capacitat = max;
        actual = 0;
        lliure=true;
        this.tipus=tipus;
    }




    public synchronized void posa() {
        actual+=1;
        System.out.println("Cesta"+this.tipus+"  +1");
        notifyAll();

    }

    public synchronized void agafa(int i) {
        actual-=i;
        notifyAll();
        System.out.println("Cesta"+this.tipus+"  -"+i);

    }
}
