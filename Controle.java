package Model;

import Exceptions.ProdutoInvalidoException;
import java.util.ArrayList;

public class Controle {
    private ArrayList<Produto> lista;
    private int numeroProdutos;
    
    public Controle(int totalItens) throws ProdutoInvalidoException{
        if (totalItens <= 0)
            throw new ProdutoInvalidoException("Nao e possivel criar um estoque com numeros negativos"); 
        lista = new ArrayList<Produto>(totalItens);
        numeroProdutos = 0;
        inicializaProdutos();
    }
    
    public ArrayList<Produto> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Produto> lista) {
        this.lista = lista;
    }
        
       private void inicializaProdutos() {
            for (int i = 0; i < lista.size(); i++)
                lista.add(i, new Produto("", 0, 0, 0));
	}
        
        public void novoProduto(String nome, int codigo, int quantidade, int quantidadeMinima){
            
            lista.add(new Produto(nome, codigo, quantidade, quantidadeMinima));
        }
        
        public void remover(String remover) throws ProdutoInvalidoException{
            for(int i = 0; i < this.lista.size(); i++)
                if(this.lista.get(i).getNome().equals(remover))
                    remover += this.lista.remove(i);
                else
                    throw new ProdutoInvalidoException("Nao e possivel encontrar o produto"); 
        }
        
        public void removerQuantidade(int codigo, int quantidade) throws ProdutoInvalidoException{
            for(int i = 0; i < this.lista.size(); i++){
                if(this.lista.get(i).getCodigo() == codigo){
                    if(quantidade > 0){
                        quantidade = this.lista.get(i).getQuantidade() - quantidade;
                        this.lista.get(i).setQuantidade(quantidade);
                    }else{
                        throw new ProdutoInvalidoException("Valor fornecido e invalido");
                    }
                }
            }
        }
        
        public void adicionarQuantidade(int codigo, int quantidade) throws ProdutoInvalidoException{
            for(int i = 0; i < this.lista.size(); i++){
                if(this.lista.get(i).getCodigo() == codigo){
                    if(quantidade > 0){
                        quantidade = this.lista.get(i).getQuantidade() + quantidade;
                        this.lista.get(i).setQuantidade(quantidade);
                    }
                }
            }
        }
}