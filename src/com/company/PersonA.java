package com.company;


import static com.company.Main.lockMangas;

public class PersonA extends Person {
    public PersonA(String a, Cesta cestaMangas) {
        this.cestaMangas = cestaMangas;
        this.a = a;
    }

    @Override
    public void run() {

        while (true) {
            try {
                boolean creat=false;
                synchronized (lockMangas) {
                    if (cestaMangas.actual != cestaMangas.capacitat) {
                        cestaMangas.posa();
                        Thread.sleep((long) ((Math.random() * 150) + 50));

                    }

                }
                if(creat){
                    Thread.sleep(1000);

                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

