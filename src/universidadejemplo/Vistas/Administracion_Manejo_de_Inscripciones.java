
package universidadejemplo.Vistas;

import java.awt.Color;

public class Administracion_Manejo_de_Inscripciones extends javax.swing.JInternalFrame {

    public Administracion_Manejo_de_Inscripciones() {
        initComponents();
        //Cambio el color de fondo :)
        getContentPane().setBackground(new Color(0, 128, 128));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jlTitulo_Formulario = new javax.swing.JLabel();
        jlSeleccioneAlumno = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jlTitulo_Materia = new javax.swing.JLabel();
        jrMateriaInscripta = new javax.swing.JRadioButton();
        jrMateria_NO_Inscripta = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListadoMaterias = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbAnularInscripcion = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setTitle("Formulario de Inscripción");

        jlTitulo_Formulario.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jlTitulo_Formulario.setText("Formulario de Inscripción");

        jlSeleccioneAlumno.setText("Seleccione unl Alumno: ");

        jlTitulo_Materia.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jlTitulo_Materia.setText("Listado de Materias");

        jrMateriaInscripta.setText("Materias Inscriptas");

        jrMateria_NO_Inscripta.setText("Materias No Inscriptas");

        jtListadoMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ));
        jScrollPane2.setViewportView(jtListadoMaterias);
        if (jtListadoMaterias.getColumnModel().getColumnCount() > 0) {
            jtListadoMaterias.getColumnModel().getColumn(2).setResizable(false);
        }

        jbInscribir.setText("Inscribir");

        jbAnularInscripcion.setText("Anular Inscripción");

        jbSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jlTitulo_Formulario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jlTitulo_Materia))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlSeleccioneAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jrMateriaInscripta)
                                    .addGap(191, 191, 191)
                                    .addComponent(jrMateria_NO_Inscripta))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbInscribir)
                                        .addGap(108, 108, 108)
                                        .addComponent(jbAnularInscripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jbSalir))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlTitulo_Formulario)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSeleccioneAlumno)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jlTitulo_Materia)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrMateriaInscripta)
                    .addComponent(jrMateria_NO_Inscripta))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbAnularInscripcion)
                    .addComponent(jbSalir))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbAnularInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbAlumno;
    private javax.swing.JLabel jlSeleccioneAlumno;
    private javax.swing.JLabel jlTitulo_Formulario;
    private javax.swing.JLabel jlTitulo_Materia;
    private javax.swing.JRadioButton jrMateriaInscripta;
    private javax.swing.JRadioButton jrMateria_NO_Inscripta;
    private javax.swing.JTable jtListadoMaterias;
    // End of variables declaration//GEN-END:variables
}
