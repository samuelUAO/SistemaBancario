/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import java.awt.*;
import Controlador.ControladorBanco;
import Modelo.*;
/**
 *
 * @author SAMUEL
 */
public class VistaBanco extends JFrame {
    private ControladorBanco controlador;
    private JTextArea txtLog;
    private JTextField txtNum, txtTitular, txtMonto, txtSobregiro;
    private JComboBox<String> cbTipo;

    public VistaBanco(ControladorBanco controlador) {
        this.controlador = controlador;
        setTitle("Sistema Bancario MVC");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelForm = new JPanel(new GridLayout(6, 2, 5, 5));
        panelForm.add(new JLabel("Número Cuenta:"));
        txtNum = new JTextField(); panelForm.add(txtNum);

        panelForm.add(new JLabel("Titular:"));
        txtTitular = new JTextField(); panelForm.add(txtTitular);

        panelForm.add(new JLabel("Tipo Cuenta:"));
        cbTipo = new JComboBox<>(new String[]{"Ahorros", "Corriente"});
        panelForm.add(cbTipo);

        panelForm.add(new JLabel("Cupo Sobregiro (Si es Corriente):"));
        txtSobregiro = new JTextField("200000"); panelForm.add(txtSobregiro);

        panelForm.add(new JLabel("Monto (Depósito/Retiro/Inicial):"));
        txtMonto = new JTextField("100000"); panelForm.add(txtMonto);

        JButton btnCrear = new JButton("Crear Cuenta");
        JButton btnConsignar = new JButton("Consignar");
        panelForm.add(btnCrear);
        panelForm.add(btnConsignar);

        add(panelForm, BorderLayout.NORTH);

        txtLog = new JTextArea();
        txtLog.setEditable(false);
        add(new JScrollPane(txtLog), BorderLayout.CENTER);

        JPanel panelAcciones = new JPanel();
        JButton btnRetirar = new JButton("Retirar");
        JButton btnConsultar = new JButton("Consultar Todo");
        panelAcciones.add(btnRetirar);
        panelAcciones.add(btnConsultar);
        add(panelAcciones, BorderLayout.SOUTH);

        btnCrear.addActionListener(e -> crearCuenta());
        btnConsignar.addActionListener(e -> consignar());
        btnRetirar.addActionListener(e -> retirar());
        btnConsultar.addActionListener(e -> consultar());
    }

    private void crearCuenta() {
        String num = txtNum.getText();
        String titular = txtTitular.getText();
        double monto = Double.parseDouble(txtMonto.getText());
        Fecha hoy = new Fecha(12, 10, 2026);

        if (cbTipo.getSelectedItem().equals("Ahorros")) {
            Cuenta c = new CuentaAhorros(num, titular, hoy, monto);
            controlador.agregarCuenta(c);
            txtLog.append("Cuenta de Ahorros creada.\n");
        } else {
            double sg = Double.parseDouble(txtSobregiro.getText());
            Cuenta c = new CuentaCorriente(num, titular, hoy, monto, sg);
            controlador.agregarCuenta(c);
            txtLog.append("Cuenta Corriente creada con sobregiro de $" + sg + ".\n");
        }
    }

    private void consignar() {
        Cuenta c = controlador.buscarCuenta(txtNum.getText());
        if (c != null) {
            double m = Double.parseDouble(txtMonto.getText());
            c.consignar(m);
            txtLog.append("Consignación exitosa. " + c.obtenerInformacion(true) + "\n");
        } else {
            txtLog.append("Cuenta no encontrada.\n");
        }
    }

    private void retirar() {
        Cuenta c = controlador.buscarCuenta(txtNum.getText());
        if (c != null) {
            double m = Double.parseDouble(txtMonto.getText());
            boolean exito = c.retirar(m);
            if (exito) {
                txtLog.append("Retiro exitoso. " + c.obtenerInformacion(true) + "\n");
            } else {
                txtLog.append("ERROR: Retiro rechazado. Excede cupo o saldo.\n");
            }
        } else {
            txtLog.append("Cuenta no encontrada.\n");
        }
    }

    private void consultar() {
        txtLog.append("\n--- ESTADO DE CUENTAS ---\n");
        for (Cuenta c : controlador.getCuentas()) {
            txtLog.append(c.obtenerInformacion() + "\n");
        }
    }
}