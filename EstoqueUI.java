package view;


import java.util.Scanner;

import Controller.Estoquefacade;
import Exceptions.ProdutoInvalidoException;
import Model.Produto;
import java.util.ArrayList;

public class EstoqueUI {
    private Scanner ler;
    private Estoquefacade estoquefacade;
    public EstoqueUI(){
        estoquefacade = Estoquefacade.getInstance();
    }
    
    public void menu() {
        do{
            mostraOpcoesMenu();
        }while(verificaOpcoes() != 0);
    }
    
    private void mostraOpcoesMenu(){
        imprimeLinha("\n\n");
        imprimeLinha("\n---MENU DE OPCOES---\n");
        imprimeLinha("[1] Novo estoque");
        imprimeLinha("[2] Novo produto do estoque");
        imprimeLinha("[3] Mostrar produtos do estoque");
        imprimeLinha("[4] Excluir um produto");
        imprimeLinha("[5] Remover quantidade de um produto");
        imprimeLinha("[6] Adicionar quantidade em um produto");
        imprimeLinha("[7] Mostrar produtos abaixo do estoque");
        imprimeLinha("[0] Sair");
        imprimeLinha("\nDigite uma opcao: ");
    }
    
    private byte verificaOpcoes(){
        byte opcao = recebeOpcao();
        
        try{
            switch(opcao){                   
                case 1:
                    novoControle();
                    break;
                    
                case 2:
                    adicionaProdutoNoEstoque();
                    break;
                    
                case 3:
                    mostrarProdutosEstoque();
                    break;
                
                case 4:
                    excluirProdutoNoEstoque();
                    break;
                    
                case 5:
                    removerQuantidadeProdutoDoEstoque();
                    break;
                    
                case 6:
                    adicionarQuantidadeProdutoNoEstoque();
                    break;
                    
                case 7:
                    mostrarProdutosAbaixoDoEstoque();
                    break;
                    
                case 0:
                    sair();
                    break;
            }
        }catch (ProdutoInvalidoException e){
            imprimeLinha(e.getMessage());
        }
        
        return opcao;
    }
    
    private byte recebeOpcao(){
        ler = new Scanner(System.in);
        return ler.nextByte();
    }
    
    private void novoControle() throws ProdutoInvalidoException {
	int numProdutos = recebeValorInteiro("Digite a quantidade de produtos do estoque: ");
	estoquefacade.novoControle(numProdutos);
    }
    
    private void adicionaProdutoNoEstoque() throws ProdutoInvalidoException{
        String nome = recebeValorString("Digite o nome do produto: ");
        int codigo = recebeValorInteiro("Digite o codigo do produto: ");
        int quantidade = 0;
        int quantidadeMinima = 0;
        do{
            quantidade = recebeValorInteiro("Digite a quantidade do produto: ");
            if(quantidade < 0){
                throw new ProdutoInvalidoException("Nao e aceitavel numeros negativos");
            }
        }while(quantidade < 0);
        
        do{
            quantidadeMinima = recebeValorInteiro("Digite a quantidade minima do produto: ");
            if(quantidade < 0){
                throw new ProdutoInvalidoException("Não e aceitavel numeros negativos!!!");
            }
        }while(quantidadeMinima < 0);
        estoquefacade.novoProdutoNoEstoque(nome, codigo, quantidade, quantidadeMinima);
    }
    
    private void mostrarProdutosEstoque() throws ProdutoInvalidoException{
        ArrayList<Produto> produtos;
        
        produtos = estoquefacade.getControle().getLista();
        imprimeLinha("\nNome \tCodigo \tQuantidade \tQuantidadeMinima");
        for(int i = 0; i < produtos.size(); i++)
            imprimeLinha("\n" + produtos.get(i).getNome() + "\t" + produtos.get(i).getCodigo() + "\t" + produtos.get(i).getQuantidade() + "\t" + produtos.get(i).getQuantidadeMinima() );
    }
    
    private void mostrarProdutosAbaixoDoEstoque() throws ProdutoInvalidoException{
        ArrayList<Produto> produtos;
        
        produtos = estoquefacade.getControle().getLista();
        imprimeLinha("\nNome \tCodigo \tQuantidade \tQuantidadeMinima");
        for(int i = 0; i < produtos.size(); i++)
            if(produtos.get(i).getQuantidade() < produtos.get(i).getQuantidadeMinima())
                imprimeLinha("\n" + produtos.get(i).getNome() + "\t" + produtos.get(i).getCodigo() + "\t" + produtos.get(i).getQuantidade() + "\t" + produtos.get(i).getQuantidadeMinima() );
    }
    
    private void excluirProdutoNoEstoque() throws ProdutoInvalidoException{      
        String nome = recebeValorString("Digite o nome do produto que deseja excluir: ");
        estoquefacade.removerProdutoDoEstoque(nome);
    }
    
    private void removerQuantidadeProdutoDoEstoque() throws ProdutoInvalidoException{
        int codigo = recebeValorInteiro("Digite o codigo do produto que deseja remover a quantidade: ");
        int quantidade = recebeValorInteiro("Digite a quantidade que deseja remover: ");
        estoquefacade.removerQuantidadeDeProdutos(codigo, quantidade);
    }
    
    private void adicionarQuantidadeProdutoNoEstoque() throws ProdutoInvalidoException{
        int codigo = recebeValorInteiro("Digite o codigo do produto que deseja adicionar quantidade: ");
        int quantidade = recebeValorInteiro("Digite a quantidade que deseja adicionar: ");
        estoquefacade.adicionarQuantidadeDeProdutos(codigo, quantidade);
    }
    
    private void sair(){
        imprimeLinha("\n\nPrograma finalizado!!!!");
    }
    
    private int recebeValorInteiro(String mensagem){
        imprimeLinha(mensagem);
        return ler.nextInt();
    }
    
    private String recebeValorString(String mensagem){
        imprimeLinha(mensagem);
        return ler.next();
    }
    
    private void imprimeLinha(String mensagem){
        System.out.println(mensagem);
    }
    
}
