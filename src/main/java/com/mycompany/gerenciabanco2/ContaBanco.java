/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciabanco2;

/**
 *
 * @author gabri
 */
public class ContaBanco
{
    private String nome;
    private String sobrenome;
    private String cpf;
    
    private double saldo;
    
    public ContaBanco(String nome, String sobrenome, String cpf)
    {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = 0;
    }
    
    public String getNome(){return nome;}
    public String getSobrenome(){return sobrenome;}
    public String getCPF(){return cpf;}
    
    public double consultaSaldo(){return saldo;}  
    public void deposito(double valor)
    {
        this.saldo += valor;
    }
    public void retirada(double valor)
    {
        this.saldo -= valor;
    }
}
