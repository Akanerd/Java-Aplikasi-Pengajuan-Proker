/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inti;

import java.util.Iterator;

/**
 *
 * @author Lenovo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jabatan p = new Jabatan();
        p.getproker();
        Proker pp = new Proker();
        Iterator it = p.getIteratorProker();
        while(it.hasNext()){
            pp=(Proker) it.next();
            System.out.println(pp.getPeriodeProker());
        }
    }
    
}
