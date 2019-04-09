/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetcaml;

/**
 *
 * @author mgresse
 */
public class BoolV extends Value{
    /* Fields */
    Boolean iv;

    /* Constructors */
    public BoolV (Boolean i) {
	iv = i;
    }

    Boolean get_bool () {
        return iv;
    }
    void set_bool (Boolean i) {
        iv = i;
    }

    void print_value() {
        System.out.print(iv);
    }
}

