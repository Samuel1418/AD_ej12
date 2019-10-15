/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Exercicio12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Mclase obj = new Mclase("ola", -7, 2.7E10);
        try {
            FileOutputStream leer = new FileOutputStream("/home/oracle/Desktop/ProbaExer4/serial.txt");
            ObjectOutputStream escribir = new ObjectOutputStream(leer);
            
            FileInputStream fis = new FileInputStream("/home/oracle/Desktop/ProbaExer4/serial.txt");
            ObjectInputStream escribirr = new ObjectInputStream(fis);
            
            //se escribe el objeto en el fichero y se cierran los objetos llamados
            escribir.writeObject(obj);
            escribir.close();
            leer.close();
            
            //Se crea un nuevo constructor y se le asigna la lectura de esta forma
            Mclase objj = new Mclase();
            objj=(Mclase) escribirr.readObject();
            escribirr.close();
            fis.close();
            System.out.println(objj); //Necesario el ToString para que devuelva los datos
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Exercicio12.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
