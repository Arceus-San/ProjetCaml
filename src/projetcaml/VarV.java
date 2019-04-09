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
public class VarV extends Value{
    /* Fields */
    String iv;

    /* Constructors */
    public VarV (String i) {
	iv = i;
    }

    String get_VarV () {
        return iv;
    }
    void set_VarV (String i) {
        iv = i;
    }

    void print_value() {
        System.out.print(iv);
    }
}
