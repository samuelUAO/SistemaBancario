/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SAMUEL
 */
public abstract class Cuenta {
    protected String numeroCuenta;
    protected String titular;
    protected Fecha fechaApertura;
    protected double saldo;

    public Cuenta(String numeroCuenta, String titular, Fecha fechaApertura, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.fechaApertura = fechaApertura;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    public void consignar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
        }
    }

    public abstract boolean retirar(double valor);

    public String obtenerInformacion() {
        return "Cuenta: " + numeroCuenta + " | Titular: " + titular + " | Fecha: " + fechaApertura + " | Saldo: $" + saldo;
    }

    public String obtenerInformacion(boolean soloSaldo) {
        if (soloSaldo) {
            return "Saldo actual: $" + saldo;
        }
        return obtenerInformacion();
    }
}