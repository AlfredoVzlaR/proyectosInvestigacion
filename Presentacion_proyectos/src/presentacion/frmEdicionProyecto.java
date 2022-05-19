/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Doctor;
import dominio.NoDoctor;
import dominio.Profesor;
import dominio.Proyectos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.FabricaLogica;

/**
 *
 * @author Alfredo Valenzuela
 */
public class frmEdicionProyecto extends javax.swing.JFrame {

    
    DefaultTableModel modeloTabla;
    /**
     * Creates new form frmEdicionProyecto
     */
    public frmEdicionProyecto() {
        initComponents();
        this.modeloTabla = (DefaultTableModel) tbIntegrantes.getModel();
    }

    protected void abrirBuscarProyecto(Proyectos proyecto) {
        mostrarDetallesProyecto(proyecto);
        llenarTablaDisponibles(proyecto);
    }

    public void mostrarDetallesProyecto(Proyectos proyecto) {
        txtLinea.setText(proyecto.getCodigo());
        txtNombre.setText(proyecto.getNombre());
        txtAcronimo.setText(proyecto.getAcronimo());
        txtPrograma.setText(proyecto.getProgramaInvestigacion());
        txtDesarrollo.setText(proyecto.getDesarrolloFinancia());
        txtDescripcion.setText(proyecto.getDescripcionObjetivos());
        fechaInicio.setDate(proyecto.getFechaInicio());
        fechaFin.setDate(proyecto.getFechaFinalizacion());
        cbInvestigador.addItem(proyecto.getInvestigadorPrincipal());
        txtCodigo.setText(proyecto.getLineaInvestigacion());
        txtPresupuesto.setText(String.valueOf(proyecto.getPresupuesto()));
        
        if(proyecto.getProfesores().isEmpty()){
            return;
        }
        List<Profesor> integrantes = proyecto.getProfesores();
        DefaultTableModel modeloTabla = (DefaultTableModel) tbIntegrantes.getModel();
        Object[] fila = new Object[4];
        
        for(int i=0;i<integrantes.size();i++){
            fila[0]=integrantes.get(i).getNombre();
            fila[1]=integrantes.get(i).getApellido();
            fila[2]=integrantes.get(i).getDespacho();
            fila[3]=integrantes.get(i).getTelefono();
            modeloTabla.addRow(fila);
        }
    }
    private void llenarTablaDisponibles(Proyectos proyecto){
        List<Doctor> doctores = FabricaLogica.getInstancia().consultarDoctores();
        List<NoDoctor> noDoctores = FabricaLogica.getInstancia().consultarNoDoctores();

        List<Profesor> profesores = new ArrayList();

        profesores.addAll(doctores);
        profesores.addAll(noDoctores);

        DefaultTableModel modeloTablaDisponibles = (DefaultTableModel) tbDisponibles.getModel();

        Object fila[] = new Object[4];
        try{
        for (int i = 0; i < profesores.size(); i++) {
            if(proyecto.getProfesores().get(i).equals(profesores.get(i))){
                return;
            }
            else{
                fila[0] = profesores.get(i).getNombre();
                fila[1] = profesores.get(i).getApellido();
                fila[2] = profesores.get(i).getDespacho();
                fila[3] = profesores.get(i).getTelefono();
                modeloTablaDisponibles.addRow(fila);
            }
            return;
        }}catch(Exception e){}
    }

    private boolean actualizar() {
        if (FabricaLogica.getInstancia().verificaElementosSeleccionados(tbIntegrantes)) {
            Proyectos proyecto = new Proyectos();
            proyecto.setCodigo(txtLinea.getText());
            proyecto.setNombre(txtNombre.getText());
            proyecto.setAcronimo(txtAcronimo.getText());
            proyecto.setProgramaInvestigacion(txtPrograma.getText());
            proyecto.setInvestigadorPrincipal(cbInvestigador.getItemAt(0));
            proyecto.setLineaInvestigacion(txtCodigo.getText());
            proyecto.setDesarrolloFinancia(txtDesarrollo.getText());
            proyecto.setFechaInicio(fechaInicio.getDate());
            proyecto.setFechaFinalizacion(fechaFin.getDate());
            proyecto.setDescripcionObjetivos(txtDescripcion.getText());
            proyecto.setPresupuesto(Double.parseDouble(txtPresupuesto.getText()));
            
            if(fechaInicio.getDate().after(fechaFin.getDate())){
                JOptionPane.showMessageDialog(this, "La fecha inicial no puede ser mayor a la fecha de fin.", "Error!", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            List<Profesor> listaIntegrantes = new ArrayList<>();
            for(int i=0;i<modeloTabla.getColumnCount();i++){
                Profesor profesor=null;
                profesor.setNombre((String) modeloTabla.getValueAt(0,i));
                profesor.setApellido((String) modeloTabla.getValueAt(1,i));
                profesor.setDespacho((String) modeloTabla.getValueAt(2, i));
                profesor.setTelefono((String) modeloTabla.getValueAt(3,i));
                listaIntegrantes.add(profesor);
            }
            proyecto.setProfesores(listaIntegrantes);
            if (FabricaLogica.getInstancia().verificarActualizar(proyecto)==true){
                JOptionPane.showMessageDialog(this, "Se actualizó correctamente el proyecto.", "Éxito.", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtAcronimo = new javax.swing.JTextField();
        txtPrograma = new javax.swing.JTextField();
        txtDesarrollo = new javax.swing.JTextField();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaFin = new com.toedter.calendar.JDateChooser();
        cbInvestigador = new javax.swing.JComboBox<>();
        txtCodigo = new javax.swing.JTextField();
        txtPresupuesto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbIntegrantes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDisponibles = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("Edición proyecto");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel4.setText("Acrónimo:");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel5.setText("Programa investigación:");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel6.setText("Desarrollo financia:");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel7.setText("Fecha inicio:");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel8.setText("Fecha fin:");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel9.setText("Investigador principal");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane4.setViewportView(txtDescripcion);

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel12.setText("Descripción:");

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel13.setText("Linea investigación:");

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel14.setText("Presupuesto:");

        txtLinea.setEditable(false);
        txtLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLineaActionPerformed(evt);
            }
        });

        txtPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProgramaActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);

        tbIntegrantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Despacho", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbIntegrantes);

        tbDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Despacho", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbDisponibles);

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel10.setText("Profesores disponibles");

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel11.setText("Integrantes");

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre)
                                .addComponent(txtAcronimo)
                                .addComponent(txtPrograma)
                                .addComponent(txtDesarrollo)
                                .addComponent(fechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbInvestigador, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCodigo)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addComponent(jLabel1))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(botonActualizar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(txtAcronimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtPrograma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(txtDesarrollo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel7))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cbInvestigador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(botonActualizar)
                        .addContainerGap(161, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProgramaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProgramaActionPerformed

    private void txtLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLineaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLineaActionPerformed

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        actualizar();        // TODO add your handling code here:
    }//GEN-LAST:event_botonActualizarActionPerformed

//    private boolean agregarProfesorLista(Profesor profesor) {
//        try {
//            if (modeloIntegrantes.contains(profesor)) {
//                JOptionPane.showMessageDialog(this, "El profesor seleccionado ya se encuentra dentro de la lista");
//                return false;
//            }
//
//            modeloIntegrantes.addElement(profesor);
//            profesoresParticipantes.add(profesor);
//
//            return true;
//        } catch (Exception e) {
//
//        }
//        return true;
//    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(frmEdicionProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(frmEdicionProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(frmEdicionProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(frmEdicionProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new frmEdicionProyecto().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private static javax.swing.JComboBox<Doctor> cbInvestigador;
    private static com.toedter.calendar.JDateChooser fechaFin;
    private static com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private static javax.swing.JTable tbDisponibles;
    private static javax.swing.JTable tbIntegrantes;
    private static javax.swing.JTextField txtAcronimo;
    private static javax.swing.JTextField txtCodigo;
    private static javax.swing.JTextField txtDesarrollo;
    private javax.swing.JTextArea txtDescripcion;
    private static javax.swing.JTextField txtLinea;
    private static javax.swing.JTextField txtNombre;
    private static javax.swing.JTextField txtPresupuesto;
    private static javax.swing.JTextField txtPrograma;
    // End of variables declaration//GEN-END:variables
}
