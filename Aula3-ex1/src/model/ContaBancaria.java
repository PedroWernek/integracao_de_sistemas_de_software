package model;

import exceptions.ContaException;

public class ContaBancaria {

    private final String id;
    private Usuario usuario;
    private double saldo;

    public ContaBancaria(String id, Usuario usuario, double saldo) {
        this.id = id;
        this.usuario = usuario;
        this.saldo = saldo;
    }

    public String getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) throws ContaException {
        if (valor > this.saldo) {
            throw new ContaException("Saldo Insuficiente");
        }
        this.saldo -= valor;
    }
}
