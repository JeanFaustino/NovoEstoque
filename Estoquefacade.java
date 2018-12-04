package Controller;

import  Exceptions.ProdutoInvalidoException;
import Model.Controle;

public class Estoquefacade {
    private static Estoquefacade singleton = new Estoquefacade();
    private Controle controle;
    
    public static Estoquefacade getInstance(){
        return singleton;
    }
    
    public void novoControle(int numeroProdutos) throws ProdutoInvalidoException{
        controle = new Controle(numeroProdutos);
    }
    
    public void novoProdutoNoEstoque
        (String nome, int codigo, int quantidade, int quantidadeMinima) throws ProdutoInvalidoException{
       if(controle == null)
           throw new ProdutoInvalidoException("Abra primeiro o controle de estoque para adicionar produtos");
        controle.novoProduto(nome, codigo, quantidade, quantidadeMinima);
    }
    
    public Controle getControle() throws ProdutoInvalidoException {
        if(controle == null)
            throw new ProdutoInvalidoException("Estoque nao criado. Nao existem produtos para serem listados");
        return controle;
    }
    
    public void removerProdutoDoEstoque(String remover) throws ProdutoInvalidoException{
        if(controle == null)
            throw new ProdutoInvalidoException("Estoque não foi criado.");
        controle.remover(remover);
    }
    
    public void removerQuantidadeDeProdutos(int codigo, int quantidade) throws ProdutoInvalidoException{
        if(controle == null)
            throw new ProdutoInvalidoException("Estoque nao foi criado.");
        controle.removerQuantidade(codigo, quantidade);
    }
    
    public void adicionarQuantidadeDeProdutos(int codigo, int quantidade) throws ProdutoInvalidoException{
        if(controle == null)
            throw new ProdutoInvalidoException("Estoque nao foi criado.");
        controle.adicionarQuantidade(codigo, quantidade);
    }
}
