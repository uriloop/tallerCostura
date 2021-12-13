package com.company;

import static com.company.Main.lockMangas;

public class PersonC extends Person {

    int jerseis = 0;

    public PersonC(String c, Cesta cestaMangas, Cesta cestaCuerpo) {
        this.a = c;
        this.cestaCuerpo = cestaCuerpo;
        this.cestaMangas = cestaMangas;
    }

    @Override
    public void run() {


        try {
            while (true) {
                while (cestaMangas.actual < 2 || cestaCuerpo.actual < 1) wait();

                lockMangas.lock();


                cestaCuerpo.agafa(1);
                cestaMangas.agafa(2);
                jerseis++;


                lockMangas.unlock();
                Thread.sleep(2000);
                System.out.println("  +1 jersey");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
