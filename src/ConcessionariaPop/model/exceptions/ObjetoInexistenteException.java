/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcessionariaPop.model.exceptions;

/**
 *
 * @author crist
 */
public class ObjetoInexistenteException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public ObjetoInexistenteException(String msg){
        super(msg);
    }
}
