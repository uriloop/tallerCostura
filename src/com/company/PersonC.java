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

            boolean creat=false;
            synchronized (lockMangas) {
                if (cestaMangas.actual > 1 && cestaCuerpo.actual > 0) {
                    cestaCuerpo.agafa(1);
                    cestaMangas.agafa(2);
                    jerseis++;
                    System.out.println("  +1 jersey  Total= "+jerseis);
                    creat=true;
                }

            }
            if(creat){

                System.out.println(cestaMangas.toString());
                System.out.println(cestaCuerpo.toString());
                System.out.println("Total jerseys "+jerseis);

                Thread.sleep(2000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        }


    }
}
