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
public class Val extends StackElem{
    
    /* Fields */
    Value v;

    /* Constructors */
    public Val (Value i) {
	v = i;
    }

    Value get_val () {
        return v;
    }
    void set_val (Value i) {
        v = i;
    }
    
    void exec_instr(Config cf) {
        cf.set_value(v);
        cf.get_code().pop();
    }
    
    
}
