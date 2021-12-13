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

                    }

                }
                if(creat){
                    System.out.println(cestaMangas.toString());
                    Thread.sleep(1000);

                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

