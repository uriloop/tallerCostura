package com.company;

import static com.company.Main.lockMangas;

public class PersonB extends Person {


    public PersonB(String b, Cesta cestaCuerpo) {
        this.a = b;
        this.cestaCuerpo = cestaCuerpo;
    }

    @Override
    public void run() {


        try {
            while (true) {
                while (cestaCuerpo.actual == cestaCuerpo.capacitat ) wait();

                lockMangas.lock();

                cestaCuerpo.posa();


                lockMangas.unlock();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
