/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author SAMUEL
 */
public class CuentaAhorros extends Cuenta {

    public CuentaAhorros(String numeroCuenta, String titular, Fecha fechaApertura, double saldoInicial) {
        super(numeroCuenta, titular, fechaApertura, saldoInicial);
    }

    @Override
    public boolean retirar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}