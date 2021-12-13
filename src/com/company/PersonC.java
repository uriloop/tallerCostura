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

        while(true){
        try {


            synchronized (lockMangas) {
                if (cestaMangas.actual > 1 && cestaCuerpo.actual > 0) {
                    cestaCuerpo.agafa(1);
                    Thread.sleep((long) ((Math.random() * 150) + 50));

                    cestaMangas.agafa(2);
                    Thread.sleep((long) ((Math.random() * 150) + 50));
                    jerseis++;
                    System.out.println("  +1 jersey");
                    Thread.sleep(2000);
                }

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        }


    }
}
