package universidadejemplo.Vistas;


import universidadejemplo.Vistas.ConsultasView_AlumnosPorMateria;

public class Vistas extends javax.swing.JFrame {

        
    public Vistas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmAlumno = new javax.swing.JMenu();
        jmFormAlum = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jmFormMat = new javax.swing.JMenuItem();
        jmAdmin = new javax.swing.JMenu();
        jmInscripciones = new javax.swing.JMenuItem();
        jmNotas = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jmConsultas_AlumPorMateria = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Base de Datos ULP");

        escritorio.setBackground(new java.awt.Color(204, 204, 204));
        escritorio.setPreferredSize(new java.awt.Dimension(700, 600));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jmAlumno.setText("Alumno");

        jmFormAlum.setText("Formulario de Alumno");
        jmFormAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFormAlumActionPerformed(evt);
            }
        });
        jmAlumno.add(jmFormAlum);

        jMenuBar2.add(jmAlumno);

        jmMateria.setText("Materia");

        jmFormMat.setText("Formulario de Materia");
        jmFormMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmFormMatActionPerformed(evt);
            }
        });
        jmMateria.add(jmFormMat);

        jMenuBar2.add(jmMateria);

        jmAdmin.setText("Administración");

        jmInscripciones.setText("Manejo de Inscripciones");
        jmInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInscripcionesActionPerformed(evt);
            }
        });
        jmAdmin.add(jmInscripciones);

        jmNotas.setText("Manipulación de Notas");
        jmNotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNotasActionPerformed(evt);
            }
        });
        jmAdmin.add(jmNotas);

        jMenuBar2.add(jmAdmin);

        jmConsultas.setText("Consultas");
        jmConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultasActionPerformed(evt);
            }
        });

        jmConsultas_AlumPorMateria.setText("Alumno por Materia");
        jmConsultas_AlumPorMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmConsultas_AlumPorMateriaActionPerformed(evt);
            }
        });
        jmConsultas.add(jmConsultas_AlumPorMateria);

        jMenuBar2.add(jmConsultas);

        jmSalir.setText("Salir");
        jmSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmSalirMouseClicked(evt);
            }
        });
        jMenuBar2.add(jmSalir);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmConsultas_AlumPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultas_AlumPorMateriaActionPerformed
        //CLICK EN "CONSULTAS - ALUMNOS POR MATERIA"
        
        // Limpio la ventana 
        escritorio.removeAll();
        escritorio.repaint();
        //instancio una variable de la ventana Consultas MateriaView por MateriaView
        ConsultasView_AlumnosPorMateria consulta = new ConsultasView_AlumnosPorMateria();
        //por defecto la ventana está invisible, la hago visible:
        consulta.setVisible(true);
        //agrego la ventana consulta al escritorio principal
        escritorio.add(consulta);
        //traigo al frente la ventana consulta
        escritorio.moveToFront(consulta);
    }//GEN-LAST:event_jmConsultas_AlumPorMateriaActionPerformed

    private void jmFormAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFormAlumActionPerformed
        //CLICK EN "ALUMNO - FORMULARIO DE ALUMNO"        
        
        // Limpio pantalla
        escritorio.removeAll();
        // Luego le indico que se redibuje
        escritorio.repaint();
        // Instancio un objeto de nuestra vista, en este caso sería la ventana "MateriaView", 
        // donde encuentro el formulario para completar los datos
        AlumnoView alum = new AlumnoView();
        // Cuando creo una instancia de una ventana, por defecto está invisible, así que debo
        // hacerlo visible
        alum.setVisible(true); //Me pide un booleano, así que le pongo "true" para que se vea
        // Luego agrego esta ventana al escritorio
        escritorio.add(alum);
        // Por último le digo al escritorio que traiga al frente esta ventana
        escritorio.moveToFront(alum);
    }//GEN-LAST:event_jmFormAlumActionPerformed

    private void jmFormMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmFormMatActionPerformed
        // CLICK EN "MATERIA - FORMULARIO DE MATERIA"
        
        // Limpio pantalla
        escritorio.removeAll();
        // Luego le indico que se redibuje
        escritorio.repaint();
        // Instancio un objeto de nuestra vista, en este caso sería la ventana "MateriaView", 
        // donde encuentro el formulario para completar los datos
        MateriaView mat = new MateriaView();
        // Cuando creo una instancia de una ventana, por defecto está invisible, así que debo
        // hacerlo visible
        mat.setVisible(true); //Me pide un booleano, así que le pongo "true" para que se vea
        // Luego agrego esta ventana al escritorio
        escritorio.add(mat);
        // Por último le digo al escritorio que traiga al frente esta ventana
        escritorio.moveToFront(mat);
    }//GEN-LAST:event_jmFormMatActionPerformed

    private void jmInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInscripcionesActionPerformed
        // CLICK EN "ADMINISTRACIÓN - MANEJO DE INSCRIPCIONES"
        //Repito lo mismo que en los otros clicks
        
        escritorio.removeAll();
        escritorio.repaint();
        AdministracionView_ManejoDeInscripciones inscripciones = new AdministracionView_ManejoDeInscripciones();
        inscripciones.setVisible(true);
        escritorio.add(inscripciones);
        escritorio.moveToBack(inscripciones);       
    }//GEN-LAST:event_jmInscripcionesActionPerformed

    private void jmNotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNotasActionPerformed
        // CLICK EN "ADMINISTRACIÓN - MANEJO DE NOTAS"
        
        escritorio.removeAll();
        escritorio.repaint();
        AdministracionView_ManipulacionDeNotas notas = new AdministracionView_ManipulacionDeNotas();
        notas.setVisible(true);
        escritorio.add(notas);
        escritorio.moveToBack(notas);
    }//GEN-LAST:event_jmNotasActionPerformed

    private void jmConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmConsultasActionPerformed
       //CLICK EN "CONSULTAS - ALUMNOS POR MATERIA"
        
        // Limpio la ventana 
        escritorio.removeAll();
        escritorio.repaint();
        //instancio una variable de la ventana Consultas MateriaView por MateriaView
        ConsultasView_AlumnosPorMateria consulta = new ConsultasView_AlumnosPorMateria();
        //por defecto la ventana está invisible, la hago visible:
        consulta.setVisible(true);
        //agrego la ventana consulta al escritorio principal
        escritorio.add(consulta);
        //traigo al frente la ventana consulta
        escritorio.moveToFront(consulta);   
    }//GEN-LAST:event_jmConsultasActionPerformed
      
    private void jmSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmSalirMouseClicked
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jmSalirMouseClicked

    
    
    
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
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vistas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vistas().setVisible(true);
            }
        });
             
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu jmAdmin;
    private javax.swing.JMenu jmAlumno;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenuItem jmConsultas_AlumPorMateria;
    private javax.swing.JMenuItem jmFormAlum;
    private javax.swing.JMenuItem jmFormMat;
    private javax.swing.JMenuItem jmInscripciones;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenuItem jmNotas;
    private javax.swing.JMenu jmSalir;
    // End of variables declaration//GEN-END:variables
}
