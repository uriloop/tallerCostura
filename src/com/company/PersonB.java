package com.company;

import static com.company.Main.lockMangas;

public class PersonB extends Person {


    public PersonB(String b, Cesta cestaCuerpo) {
        this.a = b;
        this.cestaCuerpo = cestaCuerpo;
    }

    @Override
    public void run() {

        while (true) {
            try {


                synchronized (lockMangas) {

                    if (cestaCuerpo.actual != cestaCuerpo.capacitat) {
                        cestaCuerpo.posa();
                        Thread.sleep((long) ((Math.random() * 150) + 50));
                        Thread.sleep(5000);
                    }
                }


            } catch (
                    InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
