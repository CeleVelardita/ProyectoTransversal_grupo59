
package universidadejemplo.Vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.AccesoADatos.InscripcionData;
import universidadejemplo.AccesoADatos.MateriaData;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Materia;

public class ConsultasView_AlumnosPorMateria extends javax.swing.JInternalFrame {

    //modelo de la tabla 
    private DefaultTableModel modeloTabla;
    
    
    
    
    
    public ConsultasView_AlumnosPorMateria() {
        initComponents();        
        //Le cambio el colorcito al JInternalFrame sin necesidad de usar un JPanel (LO LOGRÉ!!!)
        JInternalFrame frame = new JInternalFrame();
        getContentPane().setBackground(new Color(0, 128, 128));
        
        
        modeloTabla = new DefaultTableModel();
        cargarComboBoxMaterias();
        armarCabeceraTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo_listado = new javax.swing.JLabel();
        jlSeleccioneMateria = new javax.swing.JLabel();
        jcbMateria = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaDeAlumnos = new javax.swing.JTable();
        jbSalirConsulta = new javax.swing.JButton();

        setForeground(new java.awt.Color(53, 167, 112));

        jlTitulo_listado.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jlTitulo_listado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo_listado.setText("Listado de Alumnos por Materia");

        jlSeleccioneMateria.setText("Seleccione una materia: ");

        jcbMateria.setToolTipText("");
        jcbMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMateriaActionPerformed(evt);
            }
        });

        jtListaDeAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Apellido", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtListaDeAlumnos);
        if (jtListaDeAlumnos.getColumnModel().getColumnCount() > 0) {
            jtListaDeAlumnos.getColumnModel().getColumn(0).setResizable(false);
            jtListaDeAlumnos.getColumnModel().getColumn(1).setResizable(false);
            jtListaDeAlumnos.getColumnModel().getColumn(2).setResizable(false);
        }

        jbSalirConsulta.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jlTitulo_listado, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbSalirConsulta)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jlSeleccioneMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo_listado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSeleccioneMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jbSalirConsulta)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMateriaActionPerformed
        // éste evento se ejecuta al hacer click en el jcombobox 
        cargarAlumnosxMateria();
    }//GEN-LAST:event_jcbMateriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbSalirConsulta;
    private javax.swing.JComboBox<Materia> jcbMateria;
    private javax.swing.JLabel jlSeleccioneMateria;
    private javax.swing.JLabel jlTitulo_listado;
    private javax.swing.JTable jtListaDeAlumnos;
    // End of variables declaration//GEN-END:variables

    private void cargarComboBoxMaterias(){
        // Limpia el JComboBox
            jcbMateria.removeAllItems();

        //para el jcombobox necesito los métodos de este objeto para recuperar de la BD 
        MateriaData materiaData = new MateriaData(); //declaro e inicializo

        // Obtener la lista de materias
        List<Materia> listaMaterias = materiaData.listarMateria();

        //Creamos un Modelo que almacenará los nombres de la materia 
         DefaultComboBoxModel<Materia> comboBoxModel = new DefaultComboBoxModel<>();

        for (Materia materia : listaMaterias) {
            comboBoxModel.addElement(materia); // Agregamos el objeto Materia directamente
        }

       // Establecer el modelo en el JComboBox
       jcbMateria.setModel(comboBoxModel);
    }
    
    private void armarCabeceraTabla(){
         ArrayList<Object> filaCabecera = new  ArrayList<>();
         filaCabecera.add("ID");
         filaCabecera.add("DNI");
         filaCabecera.add("Apellido");
         filaCabecera.add("Nombre");
         
         for(Object it: filaCabecera){
             modeloTabla.addColumn(it);
         }
         jtListaDeAlumnos.setModel(modeloTabla);
    }

    private void borrarFilaDeTabla(){
        int indice = modeloTabla.getRowCount() -1;
        for(int i = indice ; i >= 0 ; i--){
            modeloTabla.removeRow(i);           
        }
    }

    private void cargarAlumnosxMateria(){
        //limpiamos tabla
        borrarFilaDeTabla();
        //recuperamos la materia desde el combobox
        Materia materia= (Materia)jcbMateria.getSelectedItem();
        //obtenemos el id de esa materia    
        int idMateria=materia.getIdMateria();
        //mandamos ese idMateria al método obtenerAlumnoxMateria que lo espera como parametro y almacenamos el ArrayList que nos devolverá
        InscripcionData insc= new InscripcionData();//para usar el método de InscripcionData
        ArrayList<Alumno> listaAlumnos=(ArrayList<Alumno>)insc.obtenerAlumnosXMateria(idMateria);
        //mostramos en tabla la lista fila por fila (alumno por alumno)
        for(Alumno a: listaAlumnos){
            modeloTabla.addRow(new Object[]{a.getIdAlumno(),a.getDni(), a.getApellido() , a.getNombre()});
        }
    }
}
