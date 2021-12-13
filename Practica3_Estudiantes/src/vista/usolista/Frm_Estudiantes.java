/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.usolista;

import controlador.usolista.EstudianteController;
import javax.swing.JOptionPane;
import modelo.usolista.DatosEstudiante;
import vista.modeloTablas.ModeloTablaDatosEstudiante;

/**
 *
 * @author Santiago Tene
 */
public class Frm_Estudiantes extends javax.swing.JDialog {

    private Frm_Materias frmCiudad;
    public EstudianteController cc = new EstudianteController();
    private ModeloTablaDatosEstudiante modelo = new ModeloTablaDatosEstudiante();

    /**
     * Creates new form FrmSitio
     */
    public Frm_Estudiantes(java.awt.Frame parent, boolean modal, Frm_Materias frm) {
        super(parent, modal);
        initComponents();
        this.frmCiudad = frm;
        limpiar();
    }

    public Frm_Estudiantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        limpiar();
    }

    private void cargarTabla() {
        modelo.setLista(cc.listar());
        tblTablaSitio.setModel(modelo);
        tblTablaSitio.updateUI();
    }

    private void limpiar() {
        txtCedula.setText("");
        txtApellido.setText("");
        txtNombre.setText("");
        txtMateria.setText("");
        txtCorreo.setText("");
        txtCiclo.setText("");
        txtNota.setText("");
        txtObservaciones.setText("");
        cc.setEstudiante(null);
        cc.setDatosEstudiante(null);
        cargarTabla();
    }

    private void guardar() {
        if (txtCedula.getText().isEmpty() || txtApellido.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Llene todos los campos", "ERORR", JOptionPane.ERROR_MESSAGE);
        } else {
            cc.getDatosEstudiante().setNombre(txtNombre.getText());
            cc.getDatosEstudiante().setApellido(txtApellido.getText());
            cc.getDatosEstudiante().setCedula(txtCedula.getText());
            cc.getDatosEstudiante().setCorreo(txtCorreo.getText());
            cc.getDatosEstudiante().setCiclo(txtCiclo.getText());
            cc.getDatosEstudiante().setNota(txtNota.getText());
            cc.getDatosEstudiante().setObservaciones(txtObservaciones.getText());
            if (cc.guardarSitio()) {
                JOptionPane.showMessageDialog(null, "Se ha registrado la Materia", "OK", JOptionPane.INFORMATION_MESSAGE);
                limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "No se puede guardar Materia", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void llamarMateria() {
        Frm_Materias vista_Materias = new Frm_Materias(null, true, this);
        vista_Materias.setVisible(true);
        if (cc.getEstudiante().getId() != null) {
            txtMateria.setText(cc.getEstudiante().getNombre());
        } else {
            cc.setEstudiante(null);
            txtMateria.setText("");
        }
    }
    
    private void AgregarMaterias() {
        Frm_Materias vista_Materias = new Frm_Materias(null, true, this);
        vista_Materias.setVisible(true);
        if (cc.getEstudiante().getId() != null) {
            txtMateria.setText(cc.getEstudiante().getNombre());
        } else {
            cc.setEstudiante(null);
            txtMateria.setText("");
        }
    }

    private void seleccionar() {
        int fila = tblTablaSitio.getSelectedRow();
        if (fila >= 0) {
            if (this.frmCiudad != null) {
                cc.setDatosEstudiante(modelo.getListado().consultarDatoPosicion(fila));
                this.dispose();
            } else {
                cc.setDatosEstudiante(modelo.getListado().consultarDatoPosicion(fila));
                txtNombre.setText(cc.getDatosEstudiante().getNombre());
                txtApellido.setText(cc.getDatosEstudiante().getApellido());
                txtCedula.setText(cc.getDatosEstudiante().getCedula());
                txtCiclo.setText(cc.getDatosEstudiante().getCiclo());
                txtCorreo.setText(cc.getDatosEstudiante().getCorreo());
                txtNota.setText(cc.getDatosEstudiante().getNota());
                txtObservaciones.setText(cc.getDatosEstudiante().getObservaciones());
//                System.out.println("Direccion" + cc.getSitioTuristico().getDireccion());
//                System.out.println("Nombre" + cc.getCiudad().getNombre());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccionar un dato de la tabla", "EROOR", JOptionPane.ERROR_MESSAGE);
        }
         if (tblTablaSitio.getSelectedRow() == fila) {
            cc.setEstudiante(modelo.getLista().consultarDatoPosicion(tblTablaSitio.getSelectedRow()));
//            cc.setSitioTuristico(modelo.getListado().consultarDatoPosicion(fila));
            txtMateria.setText(modelo.getLista().consultarDatoPosicion(cc.getDatosEstudiante().getId().intValue()-1).getNombre());
            System.out.println(tblTablaSitio.getSelectedRow());
            System.out.println(fila);
        } else {
            cc.setEstudiante(null);
            txtMateria.setText("");
        }
    }

    private void actualizarDatosEst() {
        if (!txtNombre.getText().trim().isEmpty() || !txtApellido.getText().trim().isEmpty() || txtCedula.getText().trim().isEmpty() ) {
            System.out.println("aqui no es el problema");
            cc.getDatosEstudiante().setNombre(txtNombre.getText());
            cc.getDatosEstudiante().setApellido(txtApellido.getText());
            cc.getDatosEstudiante().setCedula(txtCedula.getText());
            cc.getDatosEstudiante().setCiclo(txtCiclo.getText());
            cc.getDatosEstudiante().setCorreo(txtCorreo.getText());
            cc.getDatosEstudiante().setNota(txtNota.getText());
            cc.getDatosEstudiante().setObservaciones(txtObservaciones.getText());
            //modificar
            if (cc.modificar()) {
                System.out.println("si llega");
                JOptionPane.showMessageDialog(null, "Se ha registrado correctamente", "Ok", JOptionPane.WARNING_MESSAGE);
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMateria = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTablaSitio = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtCiclo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Materia");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 330, 70, 20);
        getContentPane().add(txtCedula);
        txtCedula.setBounds(100, 120, 150, 30);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(100, 30, 150, 30);
        getContentPane().add(txtApellido);
        txtApellido.setBounds(100, 70, 150, 30);

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 30, 70, 15);

        jLabel3.setText("Apellido");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 80, 70, 15);

        jLabel4.setText("Nota");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 280, 70, 15);

        txtMateria.setColumns(20);
        txtMateria.setRows(5);
        txtMateria.setEnabled(false);
        jScrollPane1.setViewportView(txtMateria);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(90, 310, 200, 50);

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(120, 370, 120, 25);

        tblTablaSitio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblTablaSitio);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(290, 30, 910, 180);

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(10, 370, 100, 25);

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(250, 370, 120, 25);
        getContentPane().add(txtCiclo);
        txtCiclo.setBounds(100, 170, 150, 30);

        jLabel5.setText("Cedula");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 120, 70, 15);
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(100, 220, 150, 30);

        jLabel6.setText("Ciclo");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 180, 70, 15);
        getContentPane().add(txtNota);
        txtNota.setBounds(100, 270, 150, 30);

        jLabel7.setText("Correo");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 230, 70, 15);

        jButton5.setText("Agregar Materia");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(540, 0, 200, 25);

        jLabel8.setText("Observaciones Cambio Nota");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(320, 250, 220, 15);
        getContentPane().add(txtObservaciones);
        txtObservaciones.setBounds(540, 240, 670, 30);

        setBounds(0, 0, 1238, 431);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        seleccionar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        actualizarDatosEst();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        AgregarMaterias();
        
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Estudiantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frm_Estudiantes dialog = new Frm_Estudiantes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblTablaSitio;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCiclo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtMateria;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
}
