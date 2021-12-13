package controlador.usolista;

// @author "Santiago Tene"
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.usolista.ModeloTresRaya;
import vista.usolista.Frm_TresRaya;

public class ControladorTresRaya implements ActionListener {

    private Frm_TresRaya vista;
    private ModeloTresRaya juego;

    public ControladorTresRaya(Frm_TresRaya vista, ModeloTresRaya modelo) {
        this.vista = vista;
        this.juego = modelo;
    }

    public void iniciarJuego() {
        vista.setLocationRelativeTo(null);
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        this.vista.jButton3.addActionListener(this);
        this.vista.jButton4.addActionListener(this);
        this.vista.jButton5.addActionListener(this);
        this.vista.jButton6.addActionListener(this);
        this.vista.jButton7.addActionListener(this);
        this.vista.jButton8.addActionListener(this);
        this.vista.jButton9.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();

        if (this.juego.ganador() == 0) {
            if (boton == this.vista.jButton1) {
                this.vista.jButton1.setText(this.juego.setearMovimiento(1));
            } else if (boton == this.vista.jButton2) {
                this.vista.jButton2.setText(this.juego.setearMovimiento(2));
            } else if (boton == this.vista.jButton3) {
                this.vista.jButton3.setText(this.juego.setearMovimiento(3));
            } else if (boton == this.vista.jButton4) {
                this.vista.jButton4.setText(this.juego.setearMovimiento(4));
            } else if (boton == this.vista.jButton5) {
                this.vista.jButton5.setText(this.juego.setearMovimiento(5));
            } else if (boton == this.vista.jButton6) {
                this.vista.jButton6.setText(this.juego.setearMovimiento(6));
            } else if (boton == this.vista.jButton7) {
                this.vista.jButton7.setText(this.juego.setearMovimiento(7));
            } else if (boton == this.vista.jButton8) {
                this.vista.jButton8.setText(this.juego.setearMovimiento(8));
            } else if (boton == this.vista.jButton9) {
                this.vista.jButton9.setText(this.juego.setearMovimiento(9));
            }
            if (this.juego.get_error()) {
                JOptionPane.showMessageDialog(null, "Error: Esa Caja ya estaba marcada : Siguiente turno");
            }

            this.vista.setTitle(this.juego.get_turno());
        }

        if (this.juego.ganador() == 1) {
            mensajeFinal(" 'X'  ");
        } else if (this.juego.ganador() == 2) {
            mensajeFinal("'O'");
        } else if (this.juego.ganador() == 3) {
            mensajeFinal("'Empate'");
        }

    }

    private void mensajeFinal(String s) {
        int sel = JOptionPane.showOptionDialog(null, "El Ganador Es " + s + "\n ¿Que Vas A Hacer?", "Fin",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{" Jugar De nuevo ", " Salir Del Juego "}, "Jugar De Nuevo");
        if (sel != -1) {
            if ((sel + 1) == 1) {
                this.juego.JugarNuevamente();
                this.vista.jButton1.setText("");
                this.vista.jButton2.setText("");
                this.vista.jButton3.setText("");
                this.vista.jButton4.setText("");
                this.vista.jButton5.setText("");
                this.vista.jButton6.setText("");
                this.vista.jButton7.setText("");
                this.vista.jButton8.setText("");
                this.vista.jButton9.setText("");
            } else {
                System.exit(0);
            }
        }
    }
}
