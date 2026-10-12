/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.util.ArrayList;
import java.util.List;
import Modelo.Cuenta;
/**
 *
 * @author SAMUEL
 */
public class ControladorBanco {
    private List<Cuenta> cuentas;

    public ControladorBanco() {
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(String numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta().equals(numero)) {
                return c;
            }
        }
        return null;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
}