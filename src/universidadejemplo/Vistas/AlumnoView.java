
package universidadejemplo.Vistas;

import java.awt.Color;
import java.sql.Date;
import java.time.ZoneId;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.Entidades.Alumno;

public class AlumnoView extends javax.swing.JInternalFrame {

    public AlumnoView() {
        initComponents();
        
        //Le cambio el colorcito al JInternalFrame sin necesidad de usar un JPanel (LO LOGRÉ!!!)
        getContentPane().setBackground(new Color(0, 128, 128));
         
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
        jLabel2 = new javax.swing.JLabel();
        jtDni = new javax.swing.JTextField();
        jbBuscarAlum = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdFechaNac = new com.toedter.calendar.JDateChooser();
        jbNuevoAlum = new javax.swing.JButton();
        jbEliminarAlum = new javax.swing.JButton();
        jbGuardarAlum = new javax.swing.JButton();
        jbSalirAlum = new javax.swing.JButton();
        jcbEstado = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alumno");
        setPreferredSize(new java.awt.Dimension(500, 400));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel1.setText("Alumno");

        jLabel2.setText("Documento:");

        jbBuscarAlum.setText("Buscar");
        jbBuscarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarAlumActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Fecha de Nacimiento:");

        jbNuevoAlum.setText("Nuevo");
        jbNuevoAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoAlumActionPerformed(evt);
            }
        });

        jbEliminarAlum.setText("Eliminar");

        jbGuardarAlum.setText("Guardar");
        jbGuardarAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarAlumActionPerformed(evt);
            }
        });

        jbSalirAlum.setText("Salir");

        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbNuevoAlum)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(102, 102, 102)
                                .addComponent(jbBuscarAlum))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jbGuardarAlum)
                                .addGap(30, 30, 30)
                                .addComponent(jbEliminarAlum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSalirAlum))
                            .addComponent(jtApellido, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbEstado)
                            .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscarAlum)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jcbEstado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevoAlum)
                    .addComponent(jbGuardarAlum)
                    .addComponent(jbEliminarAlum)
                    .addComponent(jbSalirAlum))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarAlumActionPerformed
        // CLICK EN "BUSCAR" - SE VINCULA CON "BUSCAR ALUMNO POR DNI"
        AlumnoData alumnoData = new AlumnoData();
        
        // Debo parsear/convertir a un int el número que se ingresa en el JTextField
        int dni = Integer.parseInt(jtDni.getText());
        Alumno dato = alumnoData.buscarAlumnoPorDni(dni); // Me pide un int dni
        // Ahora se debería mostrar en los otros campos los datos correspondientes al alumno seleccionado
        jtApellido.setText(dato.getApellido());
        jtNombre.setText(dato.getNombre());        
        jdFechaNac.setDate(Date.valueOf(dato.getFechaNac())); // Parsear/convertir de LocalDate a Date
        jcbEstado.setSelected(dato.isActivo()); // RECORDAR!!!! si es un booleano va "IS" con un setSELECTED
        
    }//GEN-LAST:event_jbBuscarAlumActionPerformed

    private void jbNuevoAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoAlumActionPerformed
        // CLICK EN "NUEVO" - SE VINCULA CON "GUARDAR ALUMNO"
        AlumnoData alumnoData = new AlumnoData();
        Alumno alumno = new Alumno();
        
        //Alumno guardar = alumnoData.guardarAlumno(alumno);
        
        // De igual manera que el método anterior, debo parsear los JTextField
        int dni = Integer.parseInt(jtDni.getText());
        alumno.setApeliido(jtApellido.getText());
        alumno.setNombre(jtNombre.getText());
        alumno.setDni(dni);
        alumno.setFechaNac(jdFechaNac.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        //alumno.setActivo(jcbEstado.);
        
    }//GEN-LAST:event_jbNuevoAlumActionPerformed

    private void jbGuardarAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarAlumActionPerformed
        // CLICK EN "GUARDAR" - SE VINCULA CON "
    }//GEN-LAST:event_jbGuardarAlumActionPerformed

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        
    }//GEN-LAST:event_jcbEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbBuscarAlum;
    private javax.swing.JButton jbEliminarAlum;
    private javax.swing.JButton jbGuardarAlum;
    private javax.swing.JButton jbNuevoAlum;
    private javax.swing.JButton jbSalirAlum;
    private javax.swing.JCheckBox jcbEstado;
    private com.toedter.calendar.JDateChooser jdFechaNac;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDni;
    private javax.swing.JTextField jtNombre;
    // End of variables declaration//GEN-END:variables
}
