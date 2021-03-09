/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhaestatica;

import java.util.*;

/**
 *
 * @author upper
 */
public class PilhaEstatica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        Pilha minhaPilha = new Pilha(); // cria uma instância da classe pilha!
        Funcionario f;

        do
        {
            try
            {
                System.out.println("\n\n Escolha: 1-> empilha 2->desempilha " +
                " 3->topo 4-> tamanho 5->  Somar  6-> Listar " +
                "7 -> remover a base  9-> sair : ");
                opcao = Short.parseShort(scanner.next());
                if (opcao == 1)
                {
                    f = new Funcionario();

                    System.out.println(">>Digite o nome que deseja empilhar: ");
                    f.nome = scanner.next();

                    System.out.println(">>Digite o salário que deseja empilhar: ");
                    f.salario = Double.parseDouble(scanner.next());
                    minhaPilha.Empilha(f);
                }
                else if (opcao == 2)
                {
                    f = minhaPilha.Desempilha();
                    System.out.println(">>Desempilhado: " + f.nome + " - R$ " +  f.salario);
                }
                else if (opcao == 3)
                {
                    f = minhaPilha.RetornaTopo();
                    System.out.println(">>Topo: " + f.nome + " - R$ " +  f.salario);

                    System.out.println(">>Tipo: " + minhaPilha.RetornaTopo().nome +
                            "\n" + minhaPilha.RetornaTopo().salario);
                }
                else if (opcao == 4)
                {
                    System.out.println(">>Tamanho da pilha: " + minhaPilha.Tamanho());
                }
                else if (opcao== 5)
                {
                    double soma = 0;
                    Pilha pilhaAux = new Pilha();
                    while (minhaPilha.Tamanho() > 0)
                    {
                        soma += minhaPilha.RetornaTopo().salario;                            
                        pilhaAux.Empilha(minhaPilha.Desempilha());
                    }

                    while (pilhaAux.Tamanho() > 0)
                        minhaPilha.Empilha(pilhaAux.Desempilha());

                    System.out.println("Soma: " + soma);
                }
                else if (opcao == 6)
                {

                    Pilha pilhaAux = new Pilha();
                    while (minhaPilha.Tamanho() > 0)
                    {
                        System.out.println(minhaPilha.RetornaTopo().nome 
                                + "\n" + minhaPilha.RetornaTopo().salario);

                        pilhaAux.Empilha(minhaPilha.Desempilha());
                    }

                    while (pilhaAux.Tamanho() > 0)
                        minhaPilha.Empilha(pilhaAux.Desempilha());                     
                }
                else if (opcao == 7)
                {
                    Pilha pilhaAux = new Pilha();
                    while (minhaPilha.Tamanho() > 1)
                        pilhaAux.Empilha(minhaPilha.Desempilha());

                    System.out.println("Removendo a base: " + minhaPilha.RetornaTopo().nome +
                            "\n" + minhaPilha.RetornaTopo().salario);
                    minhaPilha.Desempilha(); // descarta a base

                    while (pilhaAux.Tamanho() > 0)
                        minhaPilha.Empilha(pilhaAux.Desempilha());
                }
                else if (opcao == 9)
                {
                    // sai do programa
                }
            }
            catch (NumberFormatException erro)
            {
                System.out.println("ERRO: " + erro);
            }
        }
        while (opcao != 9);
    }
    
}
