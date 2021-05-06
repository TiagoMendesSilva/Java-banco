package model;

import helper.Utils;

public class Conta {

    private static int codigo = 10001;

    private int numero;
    private Cliente cliente;
    private Double saldo = 0.0;
    private Double limite = 0.0;
    private Double saldoTotal;

    public Conta(Cliente cliente) {
        this.numero = Conta.codigo;
        this.cliente = cliente;
        Conta.codigo += 1;
        this.atualizaSaldoTotal();
    }

    public static int getCodigo() {
        return codigo;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public Double getSaldoTotal() {
        return saldoTotal;
    }

    private void atualizaSaldoTotal(){
        this.saldoTotal = this.getSaldo() + getLimite();
    }

    public String toString(){
        return "Número da Conta: " + this.getNumero() +
                "\nCliente: " + this.cliente.getNome() +
                "\nSaldo Total: " + Utils.doubleParaString(this.getSaldoTotal());
    }


}
