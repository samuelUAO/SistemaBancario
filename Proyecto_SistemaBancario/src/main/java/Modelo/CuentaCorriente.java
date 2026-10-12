/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SAMUEL
 */
public class CuentaCorriente extends Cuenta {
    private double cupoSobregiro;

    public CuentaCorriente(String numeroCuenta, String titular, Fecha fechaApertura, double saldoInicial, double cupoSobregiro) {
        super(numeroCuenta, titular, fechaApertura, saldoInicial);
        this.cupoSobregiro = cupoSobregiro;
    }

    public double getCupoSobregiro() { return cupoSobregiro; }

    @Override
    public boolean retirar(double valor) {
        if (valor <= (saldo + cupoSobregiro)) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() + " | Sobregiro: $" + cupoSobregiro;
    }
}