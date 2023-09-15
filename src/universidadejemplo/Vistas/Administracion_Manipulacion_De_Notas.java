
package universidadejemplo.Vistas;

import java.awt.Color;

public class Administracion_Manipulacion_De_Notas extends javax.swing.JInternalFrame {

    public Administracion_Manipulacion_De_Notas() {
        initComponents();
        getContentPane().setBackground(new Color(0, 128, 128));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo_CargarNotas = new javax.swing.JLabel();
        jlSeleccioneAlumno = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtNotas = new javax.swing.JTable();
        jbCargar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setClosable(true);
        setTitle("Carga de Notas");

        jlTitulo_CargarNotas.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jlTitulo_CargarNotas.setText("Carga de Notas");

        jlSeleccioneAlumno.setText("Seleccione un Alumno: ");

        jtNotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código", "Nombre", "Nota"
            }
        ));
        jScrollPane1.setViewportView(jtNotas);

        jbCargar.setText("Guardar");

        jbSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbCargar)
                        .addGap(146, 146, 146)
                        .addComponent(jbSalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jlSeleccioneAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jlTitulo_CargarNotas)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jlTitulo_CargarNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSeleccioneAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCargar)
                    .addComponent(jbSalir))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbAlumno;
    private javax.swing.JLabel jlSeleccioneAlumno;
    private javax.swing.JLabel jlTitulo_CargarNotas;
    private javax.swing.JTable jtNotas;
    // End of variables declaration//GEN-END:variables
}
