/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhaestatica;

/**
 *
 * @author upper
 */
public class Pilha {
    static int CAPACIDADE = 5; //define o tamanho maximo desta uma pilha.
    private final Funcionario[] dados = new Funcionario[CAPACIDADE]; // vetor para guardar os dados da pilha.
    private int topo = -1; // variável que irá indicar a posição no vetor do topo da pilha.
                           // este método informa o tamanho da pilha
    public int Tamanho()
    {
        return topo + 1; // lembre-se que o vetor inicia da posição zero...
    }

    // este método empilha um valor string na pilha
    public void Empilha(Funcionario f_valor)
    {
        if (Tamanho() != CAPACIDADE)
        {
            topo++;
            dados[topo] = f_valor;
        }
        else
        {
            System.out.println("A pilha está cheia!!!");
        }
    }
    // este método desempilha um valor da pilha
    public Funcionario Desempilha()
    {
        if (Tamanho() == 0){
            System.out.println("A pilha está vazia!!!");
            return null;
        }               
        else
        {
            Funcionario retorno = dados[topo];
            dados[topo] = null;
            topo--;
            return retorno;
        }

    }
    // este método devolve o valor que está no topo
    public Funcionario RetornaTopo()
    {
        if (Tamanho() == 0){
            System.out.println("A pilha está vazia!!!");
            return null;
        }
        else
            return dados[topo];
    }
}
