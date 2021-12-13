package com.company;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {


    /*  Tenemos#un# taller#de#costura# (sitúenlo#en#Indonesia,#para#dar#ambiente),#dedicado#a#
hacer#jerséis.#En#su#interior#tenemos#a#tres#personas#trabajando#de#sol#a#sol#por#cuatro#
duros,# para# que# los# occidentales# podamos# comprarlos# baratitos# (la# globalización,# ya#
saben...)
Una#persona#está#continuamente#fabricando#mangas,#que#va#depositando#en#un#cesto.#
El#cesto#tiene#una#capacidad#limitada:#cuando#se#llena,#la#costurera#deja#de#coser#más#
mangas# hasta# que# hay# hueco# libre.#Otra# persona# está# continuamente# fabricando# los#
cuerpos#de#los#jerséis,#que#también#deposita#en#su#correspondiente#cesta#de#capacidad#
limitada.# Una# tercera# persona# se# encarga# continuamente# de# ensamblar# jerséis,#

cogiendo#en#cada#caso#dos#mangas#de#la#cesta#de#mangas#y#un#cuerpo#de#la#cesta#de#
cuerpos.
Se#trata#de#escribir#el#código#que#sincronice#a#estas#tres#personas,#de#forma#que#las#dos#
primeras# personas# no# avancen# si# su# cesta# está# llena,# y# que# la# tercera# persona# no#
avance#si#le#faltan#piezas#para#hacer#un#nuevo#jersey.
Se#supone#que#las#capacidades#de#las#dos#cestas#son#constantes#y#distintas#(supongan,#
p.ej.#que#son#dos#constantes#enteras#"NumMaxMangas"#y#"NumMaxCuerpos").  */


    public static Lock lockMangas = new ReentrantLock();



    public static void main(String[] args) {
	// write your code here


        Cesta cestaMangas=new Cesta(26, Cesta.tipusCesta.MANGAS);
        Cesta cestaCuerpo= new Cesta(14, Cesta.tipusCesta.CUERPOS);


        PersonA person1=new PersonA("A",cestaMangas);
        PersonB person2= new PersonB("B",cestaCuerpo);
        PersonC person3=new PersonC("C",cestaMangas,cestaCuerpo);

        person1.start();
        person2.start();
        person3.start();

        while(true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Porten "+person3.jerseis+" fets");
        }
    }
}
