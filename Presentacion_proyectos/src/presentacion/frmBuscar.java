/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package presentacion;

import dominio.Proyectos;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.FabricaLogica;

/**
 *
 * @author Alfredo Valenzuela
 */
public class frmBuscar extends javax.swing.JFrame {
    /**
     * Creates new form PantallaBuscar
     */
    public frmBuscar() {
        initComponents();
        fechaInicio.setDate(new Date());
        fechaFin.setDate(new Date());
        fechaFin.setEnabled(false);
        fechaInicio.setEnabled(false);
    }
    private void buscar()
    {
        limpiarTablaProyectos();
        limpiarTablaProfesores();
        if(mostrarError()){
                mostrarProyecto();
        }
    }
    private void mostrarProyecto() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tbProyectos.getModel();
        Proyectos proyecto = FabricaLogica.getInstancia().consultarProyectos(txtBusqueda.getText(),comboBoxBusqueda.getSelectedIndex());
        
        if(comboBoxBusqueda.getSelectedIndex()==5){
            List<Proyectos> proyectosPeriodo = FabricaLogica.getInstancia().consultarProyectosPeriodo(fechaInicio.getDate(),fechaFin.getDate());
            if(proyectosPeriodo==null){
                mostrarMsjNoProyecto();
                return;
            }
            for(Proyectos proyecto1:proyectosPeriodo){
            Object[] fila2 = new Object[7];
            fila2[0] = proyecto1.getCodigo();
            fila2[1] = proyecto1.getNombre();
            fila2[2] = proyecto1.getAcronimo();
            fila2[3] = proyecto1.getProgramaInvestigacion();
            fila2[4] = proyecto1.getDesarrolloFinancia();
            fila2[5] = proyecto1.getFechaInicio();
            fila2[6] = proyecto1.getFechaFinalizacion();
            modeloTabla.addRow(fila2);
            }
            return;
        }
        
        if(proyecto==null)
        {
            mostrarMsjNoProyecto();
            return;
        }

        else{
            modeloTabla.setRowCount(0);
        
            Object[] fila = new Object[7];
            fila[0] = proyecto.getCodigo();
            fila[1] = proyecto.getNombre();
            fila[2] = proyecto.getAcronimo();
            fila[3] = proyecto.getProgramaInvestigacion();
            fila[4] = proyecto.getDesarrolloFinancia();
            fila[5] = proyecto.getFechaInicio();
            fila[6] = proyecto.getFechaFinalizacion();
            modeloTabla.addRow(fila);
            
            llenarTablaProfesores(proyecto);
        }
        
        
    }
    private boolean mostrarError()
    {
        if(comboBoxBusqueda.getSelectedIndex()==5){return true;}
        if(FabricaLogica.getInstancia().verificarInformacionBuscar(txtBusqueda.getText())){
            return true;
        }
        return false;
    }
    private boolean mostrarMsjNoProyecto()
    {
        if(FabricaLogica.getInstancia().consultarProyectosPeriodo(fechaInicio.getDate(), fechaFin.getDate())==null){
            JOptionPane.showMessageDialog(this,"No se encontró proyecto","No proyecto", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(FabricaLogica.getInstancia().consultarProyectos(txtBusqueda.getText(),comboBoxBusqueda.getSelectedIndex())==null)
        {
            JOptionPane.showMessageDialog(this,"No se encontró proyecto","No proyecto", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    protected static void abrirBuscarProyecto()
    {
        frmBuscar abrir = new frmBuscar();
        abrir.setVisible(true);
    }
    public String proyectoSeleccionado() {
        int indice = this.tbProyectos.getSelectedRow();
        if (indice != -1) {
            DefaultTableModel modeloTabla = (DefaultTableModel) this.tbProyectos.getModel();
            int indiceColumnaCodigo = 0;
            String codigo = (String) modeloTabla.getValueAt(indice,indiceColumnaCodigo);
            return codigo ;
        } else {
            return null;
        }
    }
    private void limpiarTablaProyectos(){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tbProyectos.getModel();
        modeloTabla.setRowCount(0);
    }
    private void limpiarTablaProfesores(){
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tbProfesores.getModel();
        modeloTabla.setRowCount(0);
    }
    private void llenarTablaProfesores(Proyectos proyecto){
        DefaultTableModel modeloTablaProfesores = (DefaultTableModel) tbProfesores.getModel();
        try{
        proyecto.getProfesores().forEach(profesor
                -> {
            Object[] filaProfesor = new Object[4];
            filaProfesor[0] = profesor.getNombre();
            filaProfesor[1] = profesor.getApellido();
            filaProfesor[2] = profesor.getDespacho();
            filaProfesor[3] = profesor.getTelefono() ;
            modeloTablaProfesores.addRow(filaProfesor);
        });}catch(Exception e){}
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
        comboBoxBusqueda = new javax.swing.JComboBox<>();
        txtBusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        fechaFin = new com.toedter.calendar.JDateChooser();
        scroll = new javax.swing.JScrollPane();
        tbProyectos = new javax.swing.JTable();
        botonBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProfesores = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        botonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar proyecto");

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("Buscador de proyectos");

        comboBoxBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Nombre", "Acronimo", "Programa de Investigacion", "Desarrollo Financiero", "Periodo" }));
        comboBoxBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxBusquedaActionPerformed(evt);
            }
        });

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });

        jLabel2.setText("Fecha inicio:");

        jLabel3.setText("Fecha de finalización:");

        tbProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Acrónimo", "Programa", "Desarrollo", "Fecha inicio", "Fecha fin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProyectosMouseClicked(evt);
            }
        });
        scroll.setViewportView(tbProyectos);
        if (tbProyectos.getColumnModel().getColumnCount() > 0) {
            tbProyectos.getColumnModel().getColumn(0).setResizable(false);
            tbProyectos.getColumnModel().getColumn(1).setResizable(false);
            tbProyectos.getColumnModel().getColumn(2).setResizable(false);
            tbProyectos.getColumnModel().getColumn(3).setResizable(false);
            tbProyectos.getColumnModel().getColumn(4).setResizable(false);
            tbProyectos.getColumnModel().getColumn(5).setResizable(false);
            tbProyectos.getColumnModel().getColumn(6).setResizable(false);
        }

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel4.setText("Proyecto.");

        tbProfesores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbProfesores);
        if (tbProfesores.getColumnModel().getColumnCount() > 0) {
            tbProfesores.getColumnModel().getColumn(0).setResizable(false);
            tbProfesores.getColumnModel().getColumn(1).setResizable(false);
            tbProfesores.getColumnModel().getColumn(2).setResizable(false);
            tbProfesores.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel5.setText("Profesores.");

        botonEditar.setText("Editar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxBusqueda, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBusqueda)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(fechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addComponent(botonBuscar))
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(botonEditar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEditar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void tbProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProyectosMouseClicked
        if(comboBoxBusqueda.getSelectedItem() == "Periodo"){
            limpiarTablaProfesores();
            Proyectos proyecto = FabricaLogica.getInstancia().consultarProyectos(proyectoSeleccionado(),0);
            if(proyecto==null){
                mostrarMsjNoProyecto();
            }
            else{
                llenarTablaProfesores(proyecto);
            }
        }
    }//GEN-LAST:event_tbProyectosMouseClicked

    private void comboBoxBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxBusquedaActionPerformed
        if(comboBoxBusqueda.getSelectedItem() == "Periodo"){
            fechaFin.setEnabled(true);
            fechaInicio.setEnabled(true);
        } else {
            fechaFin.setEnabled(false);
            fechaInicio.setEnabled(false);
        }
    }//GEN-LAST:event_comboBoxBusquedaActionPerformed

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        if(txtBusqueda.getText().length() >= 60){
            evt.consume();
        }
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
       if(proyectoSeleccionado()==null){return;}
       Proyectos proyecto = FabricaLogica.getInstancia().consultarProyectos(proyectoSeleccionado(),0);
       frmEdicionProyecto frmEdicion = new frmEdicionProyecto();
       frmEdicion.setVisible(true);
       frmEdicion.abrirBuscarProyecto(proyecto);
    }//GEN-LAST:event_botonEditarActionPerformed

//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(PantallaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PantallaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PantallaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PantallaBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PantallaBuscar().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JComboBox<String> comboBoxBusqueda;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbProfesores;
    private javax.swing.JTable tbProyectos;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
