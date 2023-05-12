/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gerenciabanco2;

/**
 *
 * @author gabriel
 */
public class AplicarBanco
{

    private double valorInvestido;

    private final double taxaCDB = 10;
    private double valorCDB;
    private final double taxaLCI = 8;
    private double valorLCI;
    private int parcelasCDB;
    private int parcelasLCI;
    
    public AplicarBanco()
    {
        this.valorInvestido = 0;
    }
    
    
    public void CDB(double investimento, int parcelas)
    {
        this.valorInvestido += investimento;
        this.valorCDB = investimento;
        for(int p = 0; p < parcelas; p++)
        {
            this.valorCDB = ((this.valorCDB * taxaCDB)/100) + this.valorCDB;
        }
        this.parcelasCDB = parcelas;
        System.out.println("\nRendimento do ano: R$" + String.format("%.2f", this.valorCDB));
        System.out.println("\nParcelas: " + parcelas);
    }
    
    public void LCI(double investimento, int parcelas)
    {
        this.valorInvestido += investimento;
        this.valorLCI = investimento;
        for(int p = 0; p < parcelas; p++)
        {
            this.valorLCI = ((this.valorLCI * taxaLCI)/100) + this.valorLCI;
        }
        this.parcelasLCI = parcelas;
        System.out.println("\nRendimento do ano: R$" + String.format("%.2f", this.valorLCI));
        System.out.println("\nParcelas: " + parcelas);
    }
    
    public void relatorio()
    {
        double total = this.valorInvestido + this.valorCDB + this.valorLCI;
        System.out.println("\n=====RELATÓRIO DE INVESTIMENTOS=====");
        System.out.println("\nVALOR TOTAL INVESTIDO: R%" + String.format("%.2f", this.valorInvestido));
        System.out.println("\nVALOR TOTAL INVESTIDO COM RENDIMENTO: R$" + String.format("%.2f", total));
    }
}
