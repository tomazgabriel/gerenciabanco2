/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco2;

import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class GerenciaBanco2 {
    
    static String comando;
    static Scanner scanner = new Scanner(System.in);
    static double valor = 0;
    static int parcelas= 0;
    static boolean sair = false;
    
    public static void transacaoComum(ContaBanco usuario)
    {
        System.out.println("\nEscolha uma ação:\n1 - Depositar\n2 - Retirar\n3 - Verificar Saldo\n4 - Sair");
        comando = scanner.nextLine();
        switch (comando)
        {
            case "1":
                System.out.println("\nDigite o valor que deseja depositar: ");
                valor = 0;
                try
                {
                    valor = scanner.nextDouble();
                    usuario.deposito(valor);
                    System.out.println("O valor de R$" + valor + " foi depositado.");
                }catch(Exception e)
                {
                    System.out.println(e);
                    System.out.println("\n================================================\nERRO. Tente utilizar virgulas ao informar o valor\n======================================\n");
                }
                break;
            case "2":
                System.out.println("\nDigite o valor que deseja sacar: ");                   
                valor = 0;
                try
                {
                    valor = scanner.nextDouble();
                    if(valor > usuario.consultaSaldo())
                    {
                        System.out.println("Saldo insuficiente;");
                    }
                    else
                    {
                        usuario.retirada(valor);
                        System.out.println("O saque no valor de R$" + valor + " foi realizado");
                    }
                }catch(Exception e)
                {
                    System.out.println(e);
                    System.out.println("\n================================================\nERRO. Tente utilizar virgulas ao informar o valor\n======================================\n");
                }
                break;
            case "3":
                System.out.println("\nSeu saldo atual é de: R$" + usuario.consultaSaldo());
                break;
            case "4":
                sair = true;
                break;
            default:
                System.out.println("\nDigite um comando válido.");
                break;
        }      
    }
    
    public static void transacaoInvestimentos(ContaBanco usuario, AplicarBanco investimento)
    {
        double saldo = usuario.consultaSaldo();
        System.out.println("\nEscolha uma ação:\n1-Investir CDB\n2-Investir LCI\n3-Relatório");
        comando = scanner.nextLine();
        
        //CDB
        if(comando.equals("1"))
        {
            try
            {
                System.out.println("\nInforme o valor a ser investido: ");
                valor = 0;
                valor = scanner.nextDouble();
                if(usuario.consultaSaldo() >= valor)
                {
                    System.out.println("\nEm quantas parcelas será feito esse investimento: ");
                    parcelas = 0;
                    parcelas = scanner.nextInt();
                    investimento.CDB(valor, parcelas);
                }
                else
                {
                    System.out.println("\nSaldo insuficiente.");
                }      
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
        //LCI
        if(comando.equals("2"))
        {
            try
            {
                System.out.println("\nInforme o valor a ser investido: ");
                valor = 0;
                valor = scanner.nextDouble();
                if(usuario.consultaSaldo() >= valor)
                {
                    System.out.println("\nEm quantas parcelas será feito esse investimento: ");
                    parcelas = 0;
                    parcelas = scanner.nextInt();
                    investimento.LCI(valor, parcelas);
                }
                else
                {
                    System.out.println("\nSaldo insuficiente.");
                }      
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
        if(comando.equals("3"))
        {
            investimento.relatorio();
        }
            
    }
    
    public static void main(String[] args) {
        System.out.println("Por favor, identifique-se digitando o seu nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite seu sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        
        ContaBanco usuario = new ContaBanco(nome, sobrenome, cpf);
        AplicarBanco investimento = new AplicarBanco();
        
        do
        {   
            System.out.println("\nPressione ENTER para continuar.");
            scanner.nextLine();
            
            System.out.println("Escolha uma ação:\n1 - Transações Comuns\n2 - Investimentos\n4 - Sair");
            comando = scanner.nextLine();
            if(comando.equals("1"))
            {
                transacaoComum(usuario);
                comando = "";
            }
            if(comando.equals("2"))
            {
                transacaoInvestimentos(usuario, investimento);
                comando = "";
            }
            //sair
            if(comando.equals("4"))
            {
                sair = true;
            }
            
        } while (sair == false);
    }
}
