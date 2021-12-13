package Main;

import controlador.usolista.ControladorTresRaya;
import modelo.usolista.ModeloTresRaya;
import vista.usolista.Frm_TresRaya;

/**
 *
 * @author santy
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ModeloTresRaya modelo = new ModeloTresRaya();
        Frm_TresRaya vista = new Frm_TresRaya();
        ControladorTresRaya controlador = new ControladorTresRaya(vista, modelo);
        controlador.iniciarJuego();
        vista.setVisible(true);
    }
    }
    
