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
public class ClosureV {
    
    /* Fields */
    Value x;
    LinkedList<Instr>  y;

    /* Constructors */
    public ClosureV (Value a,LinkedList<Instr>  b) {
	x=a;
        y=b;
    }

    Value get_first () {
        return x;
    }
    
    LinkedList<Instr> get_second () {
        return y;
    }
    
    void set_ClosureV (Value a,LinkedList<Instr>  b) {
        x=a;
        y=b;
    }

    void print_value() {
        System.out.print(x+" "+y);
    }
    
}
