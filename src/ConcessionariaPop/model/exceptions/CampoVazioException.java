package ConcessionariaPop.model.exceptions;

import com.jfoenix.controls.JFXTextField;

public class CampoVazioException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public CampoVazioException(String mensagem, JFXTextField campo){
        super(mensagem);
//        campo.setText("");
        campo.clear();
    }
}
