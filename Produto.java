package Model;

public class Produto {
    private String nome;
    private int codigo;
    private int quantidade;
    private int quantidadeMinima;
    
    public Produto(String nome, int codigo, int quantidade, int quantidadeMinima){
        setNome(nome);
        setCodigo(codigo);
        setQuantidade(quantidade);
        setQuantidadeMinima(quantidadeMinima);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidadeMinima(int quantidadeMinima){
        this.quantidadeMinima = quantidadeMinima;
    }
    public int getQuantidadeMinima(){
        return quantidadeMinima;
    }
}
