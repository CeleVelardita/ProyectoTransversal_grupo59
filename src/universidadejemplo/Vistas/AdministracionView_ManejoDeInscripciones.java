
package universidadejemplo.Vistas;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.AccesoADatos.InscripcionData;
import universidadejemplo.AccesoADatos.MateriaData;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Materia;


public class AdministracionView_ManejoDeInscripciones extends javax.swing.JInternalFrame {
    
    private ArrayList<Materia> listaMatInsc;
    private ArrayList<Materia> listaMatNOInsc;
    private ArrayList<Alumno> listaA; // Lista de Alumnos
    
    private InscripcionData inscData;
    private MateriaData mData;
    private AlumnoData aData;
    
    //modelo de la tabla 
    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        // Con esto hago que las celdas no sean editables
        public boolean isCellEditable(int row, int colum) {
            return false;
        }
    };

    public AdministracionView_ManejoDeInscripciones() {
        initComponents();
        
        //Le cambio el colorcito al JInternalFrame sin necesidad de usar un JPanel 
        JInternalFrame frame = new JInternalFrame();
        getContentPane().setBackground(new Color(0, 128, 128));
        
        //Deshabilito la reordenación de las columnas
        jTable_ListaMaterias.getTableHeader().setReorderingAllowed(false);
        
        aData = new AlumnoData();        
        listaA = (ArrayList<Alumno>)aData.listarAlumnos(); // Se recuperan de AlumnoData todos los alumnos activos
        // como devuelve una lista se caste a un arrayList (ArrayList<Alumno>)
              
                
        inscData = new InscripcionData();
        mData = new MateriaData();
        
        cargarComboBoxAlumnos();
        armarCabeceraTabla();
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo_Formulario = new javax.swing.JLabel();
        jlSelecAlum = new javax.swing.JLabel();
        jr_MateriasInscriptas = new javax.swing.JRadioButton();
        jr_MateriasNOInscriptas = new javax.swing.JRadioButton();
        jbotonInscribir = new javax.swing.JButton();
        jbotonAnularInscripcion = new javax.swing.JButton();
        jbotonSalir = new javax.swing.JButton();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_ListaMaterias = new javax.swing.JTable();
        jlTitulo_Listado = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(606, 600));

        jlTitulo_Formulario.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jlTitulo_Formulario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo_Formulario.setText("Formulario de Inscripcion");

        jlSelecAlum.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        jlSelecAlum.setText("Seleccione un alumno:");

        jr_MateriasInscriptas.setText("Materias Inscriptas");
        jr_MateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_MateriasInscriptasActionPerformed(evt);
            }
        });

        jr_MateriasNOInscriptas.setText("Materias No Inscriptas");
        jr_MateriasNOInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jr_MateriasNOInscriptasActionPerformed(evt);
            }
        });

        jbotonInscribir.setText("Inscribir");
        jbotonInscribir.setEnabled(false);
        jbotonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotonInscribirActionPerformed(evt);
            }
        });

        jbotonAnularInscripcion.setText("Anular Inscripcion");
        jbotonAnularInscripcion.setEnabled(false);
        jbotonAnularInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotonAnularInscripcionActionPerformed(evt);
            }
        });

        jbotonSalir.setText("Salir");
        jbotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbotonSalirActionPerformed(evt);
            }
        });

        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jTable_ListaMaterias.setAutoCreateRowSorter(true);
        jTable_ListaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_ListaMaterias.setAutoscrolls(false);
        jTable_ListaMaterias.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_ListaMaterias);

        jlTitulo_Listado.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jlTitulo_Listado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo_Listado.setText("Listado de Materias");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jlSelecAlum))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jbotonInscribir)
                        .addGap(152, 152, 152)
                        .addComponent(jbotonAnularInscripcion)
                        .addGap(156, 156, 156)
                        .addComponent(jbotonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jlTitulo_Formulario, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jlTitulo_Listado, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jr_MateriasInscriptas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jr_MateriasNOInscriptas)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo_Formulario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlSelecAlum)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jlTitulo_Listado)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jr_MateriasInscriptas)
                    .addComponent(jr_MateriasNOInscriptas))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbotonInscribir)
                    .addComponent(jbotonAnularInscripcion)
                    .addComponent(jbotonSalir))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jr_MateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_MateriasInscriptasActionPerformed
    // Evento del boton de Materias Inscriptas
    
        //borramos filas para "limpiar"
        borrarFilaDeTabla();
        //Al seleccionar éste botón hacemos que el otro se deseleccione
        jr_MateriasNOInscriptas.setSelected(false);
        //cargamos la lista de materias inscriptas
        cargarMateriasInscriptas();
        //habilitamos el boton que anula la inscripción
        jbotonAnularInscripcion.setEnabled(true);
        //Anulamos el botón que inscribe
        jbotonInscribir.setEnabled(false);                
    }//GEN-LAST:event_jr_MateriasInscriptasActionPerformed

    private void jr_MateriasNOInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jr_MateriasNOInscriptasActionPerformed
    // Evento del boton de Materias NO Inscriptas
        //borramos filas para "limpiar"
        borrarFilaDeTabla();
        //Al seleccionar éste botón hacemos que el otro se deseleccione
        jr_MateriasInscriptas.setSelected(false);
        //cargamos la lista de materias NO inscriptas
        cargarMateriasNoInscriptas();
        //habilitamos el boton inscripción
        jbotonInscribir.setEnabled(true);         
        //Anulamos el botón que Anula inscripción
        jbotonAnularInscripcion.setEnabled(false);    
    }//GEN-LAST:event_jr_MateriasNOInscriptasActionPerformed

    private void jbotonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotonInscribirActionPerformed
    // Evento botón Inscribir
    
        //tomamos la fila de la tabla seleccionada por el usuario
        int filaSeleccionada = jTable_ListaMaterias.getSelectedRow();
        //verificamos que se haya seleccionado una fila, sino el if devuelve un -1
        if(filaSeleccionada!=-1){
            //tomamos el alumno seleccionado en el combobox para inscribirlo
            Alumno alu = (Alumno)jcbAlumno.getSelectedItem();
            
            //recuperamos la materia seleccionada, su id, nombre y año
            int idMateria = (Integer)modeloTabla.getValueAt(filaSeleccionada, 0);//casteamos porque devuelve un object
            String nombreMateria = (String)modeloTabla.getValueAt(filaSeleccionada, 1);//casteamos porque devuelve un object
            int anio = (Integer)modeloTabla.getValueAt(filaSeleccionada, 2);//casteamos porque devuelve un object
            
            Materia m = new Materia(idMateria, nombreMateria, anio, true);//creamos la materia con los datos obtenidos
            //creamos la inscripción y le pasamos alu, m y 0 por parámetro
            Inscripcion i = new Inscripcion(alu, m , 0); // Va 0 porque en principio no hay nota registrada
            //mandamos la inscripcion al método guardarInscripcion de InscripcionData
            inscData.guardarInscripcion(i);
            //limpiamos la tabla
            borrarFilaDeTabla();                
        }        
    }//GEN-LAST:event_jbotonInscribirActionPerformed

    private void jbotonAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotonAnularInscripcionActionPerformed
    // Evento botón de Anular Inscripción
    
        //tomamos la fila de la tabla seleccionada por el usuario
        int filaSeleccionada = jTable_ListaMaterias.getSelectedRow();
        //verificamos que se haya seleccionado una fila, sino el if devuelve un -1
        if(filaSeleccionada!=-1){
            //tomamos el alumno seleccionado en el jcombobox en el combobox para inscribirlo
            Alumno alu = (Alumno)jcbAlumno.getSelectedItem();
            //recupero el id del alumno seleccionado desde alu
            int idAlumno=alu.getIdAlumno();
            //recuperamos el id de la materia seleccionada en la tabla
            int idMateria = (Integer)modeloTabla.getValueAt(filaSeleccionada, 0);//casteamos porque devuelve un object            
            //mandamos la inscripcion al método borrarInscripcionMateriaAlumno(int idAlumno, int idMAteria) de InscripcionData
            inscData.borrarInscripcionMateriaAlumno(idAlumno, idMateria);
            //limpiamos la tabla
            borrarFilaDeTabla(); 
        }        
    }//GEN-LAST:event_jbotonAnularInscripcionActionPerformed

    private void jbotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbotonSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbotonSalirActionPerformed

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        // Borrar la tabla
        borrarFilaDeTabla();
    }//GEN-LAST:event_jcbAlumnoActionPerformed


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_ListaMaterias;
    private javax.swing.JButton jbotonAnularInscripcion;
    private javax.swing.JButton jbotonInscribir;
    private javax.swing.JButton jbotonSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JLabel jlSelecAlum;
    private javax.swing.JLabel jlTitulo_Formulario;
    private javax.swing.JLabel jlTitulo_Listado;
    private javax.swing.JRadioButton jr_MateriasInscriptas;
    private javax.swing.JRadioButton jr_MateriasNOInscriptas;
    // End of variables declaration//GEN-END:variables

    private void cargarComboBoxAlumnos(){
            // Limpia el JComboBox
        jcbAlumno.removeAllItems();

        for(Alumno item: listaA){
            jcbAlumno.addItem(item);
        }
    }
   
    private void armarCabeceraTabla(){
         ArrayList<Object> filaCabecera = new  ArrayList<>();
         filaCabecera.add("ID");
         filaCabecera.add("Materia");
         filaCabecera.add("Año");
         
         for(Object it: filaCabecera){
             modeloTabla.addColumn(it);
         }
         jTable_ListaMaterias.setModel(modeloTabla);
    }
    
    private void borrarFilaDeTabla(){
        int indice = modeloTabla.getRowCount() -1;
        //NOTA: Recordar que el rowCount me devuelve una cantidad de columnas 
        for(int i = indice ; i >= 0 ; i--){
            modeloTabla.removeRow(i);           
        }
    }
    
    private void cargarMateriasInscriptas(){
        borrarFilaDeTabla();
        Alumno alu = (Alumno)jcbAlumno.getSelectedItem();
        listaMatInsc = (ArrayList)inscData.obtenerMateriasCursadas(alu.getIdAlumno());
        for(Materia m: listaMatInsc){
            modeloTabla.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnioMateria()});
        }        
    }
    
    private void cargarMateriasNoInscriptas(){
        borrarFilaDeTabla();
        
        /* 
        Este método primero selecciona del comboBox al alumno seleccionado, luego llama al método obtenerMateriasNoCursadas
        de InscripciónData y se le pasa del alumno seleccionado anteriormente, el id
        Finalmente se obtiene una lista con todas las materias en las que no está inscripto dicho alumno
        */
        
        Alumno alu = (Alumno)jcbAlumno.getSelectedItem();
        listaMatNOInsc = (ArrayList)inscData.obtenerMateriasNOCursadas(alu.getIdAlumno());
        for(Materia m: listaMatNOInsc){
            modeloTabla.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnioMateria()});
        }
    }
    

}
