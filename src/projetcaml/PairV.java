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
public class PairV extends Value{
    /* Fields */
    Value x;
    Value y;

    /* Constructors */
    public PairV (Value a,Value b) {
	x=a;
        y=b;
    }

    Value get_first () {
        return x;
    }
    
    Value get_second () {
        return y;
    }
    
    void set_PairV (Value a,Value b) {
        x=a;
        y=b;
    }

    void print_value() {
        System.out.print(x+" "+y);
    }
}
