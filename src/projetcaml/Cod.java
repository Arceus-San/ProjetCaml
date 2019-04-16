/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcaml;

import java.util.LinkedList;

/**
 *
 * @author mgresse
 */
public class Cod extends StackElem{
 
    /* Fields */
    LinkedList<Instr> c;

    /* Constructors */
    public Cod (LinkedList<Instr> i) {
	i = c;
    }

    LinkedList<Instr> get_code () {
        return c;
    }
    void set_code (LinkedList<Instr> i) {
        c = i;
    }
    
    void exec_instr(Config cf) {
        cf.set_code(c);
        cf.get_code().pop();
    }
}
