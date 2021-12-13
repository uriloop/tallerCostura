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

boolean creat=false;
                synchronized (lockMangas) {

                    if (cestaCuerpo.actual != cestaCuerpo.capacitat) {
                        cestaCuerpo.posa();
                        creat=true;
                    }
                }

                if(creat){
                    System.out.println(cestaCuerpo.toString());
                    Thread.sleep(3000);
                }
            } catch (
                    InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
