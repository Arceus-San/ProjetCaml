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
public class Fst extends Instr{
	
	void exec_instr(Config cf) {
		cf.set_value(((PairV)(cf.get_value())).get_first());
		cf.get_code().pop();
	}
}
