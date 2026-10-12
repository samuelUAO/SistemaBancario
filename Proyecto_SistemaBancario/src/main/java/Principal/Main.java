/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Principal;
import Controlador.ControladorBanco;
import Vista.VistaBanco;
/**
 *
 * @author SAMUEL
 */
public class Main {
    public static void main(String[] args) {
        ControladorBanco controlador = new ControladorBanco();
        VistaBanco vista = new VistaBanco(controlador);
        vista.setVisible(true);
    }
}