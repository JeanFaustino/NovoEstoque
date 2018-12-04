package Exceptions;

public class ProdutoInvalidoException extends Exception{
    private static final long serialVersionUID = 1L;
    
    public ProdutoInvalidoException(String mensagem){
        super(mensagem);
    }
}
