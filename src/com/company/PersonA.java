package com.company;


import static com.company.Main.lockMangas;

public class PersonA extends Person {
    public PersonA(String a, Cesta cestaMangas) {
        this.cestaMangas = cestaMangas;
        this.a = a;
    }

    @Override
    public void run() {


        try {

            while (true) {

                while (cestaMangas.actual == cestaMangas.capacitat ) wait();

                lockMangas.lock();


                cestaMangas.posa();


                lockMangas.unlock();
                Thread.sleep(3000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

