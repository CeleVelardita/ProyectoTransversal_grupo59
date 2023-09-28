
package universidadejemplo.Vistas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.AccesoADatos.AlumnoData;
import universidadejemplo.AccesoADatos.InscripcionData;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;


public class AdministracionView_ManipulacionDeNotas extends javax.swing.JInternalFrame {
    
    private DefaultTableModel modeloTabla;//modelo para la tabla
    private ArrayList<Inscripcion> ListaInscripto;
    private InscripcionData inscData;
    
    public AdministracionView_ManipulacionDeNotas() {
        initComponents();
        getContentPane().setBackground(new Color(0, 128, 128));//color ventana
        
        modeloTabla = new DefaultTableModel();//inicializamos modelo de la tabla
        
        ListaInscripto=new ArrayList<>();
        inscData=new InscripcionData();
        
        cargarComboBoxMaterias();
        armarCabeceraTabla();
        
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

        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

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
        jbCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCargarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

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

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        
        cargarMateriasConNotas();
    }//GEN-LAST:event_jcbAlumnoActionPerformed

    private void jbCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCargarActionPerformed
        // Evento botón Guardar
    
        //tomamos la fila de la tabla seleccionada por el usuario
        int filaSeleccionada = jtNotas.getSelectedRow();
        //verificamos que se haya seleccionado una fila, sino el if devuelve un -1
        if(filaSeleccionada!=-1){
            //tomamos el alumno seleccionado en el combobox para inscribirlo
            Alumno alu = (Alumno)jcbAlumno.getSelectedItem();
            //obtenemos el idAlumno desde alu
            int idAlumno=alu.getIdAlumno();
            //recuperamos el id  de la materia y la nota
            int idMateria = (Integer)modeloTabla.getValueAt(filaSeleccionada, 0);//casteamos porque devuelve un object
            Double nota = (Double)modeloTabla.getValueAt(filaSeleccionada, 2);//casteamos porque devuelve un object
            
            //mandamos los datos al método encargado de guardar la nota
            inscData.actualizarNota(idAlumno, idMateria, nota);
            //limpiamos la tabla
            borrarFilaDeTabla();                
        }  
    }//GEN-LAST:event_jbCargarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed


    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCargar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JLabel jlSeleccioneAlumno;
    private javax.swing.JLabel jlTitulo_CargarNotas;
    private javax.swing.JTable jtNotas;
    // End of variables declaration//GEN-END:variables

    private void cargarComboBoxMaterias(){
        // Limpia el JComboBox
            jcbAlumno.removeAllItems();

        //para el jcombobox necesito los métodos de este objeto para recuperar de la BD 
        AlumnoData aData = new AlumnoData(); //declaro e inicializo

        // Obtener la lista de materias
        List<Alumno> listaA = aData.listarAlumnos();

        //Creamos un Modelo que almacenará los nombres de la materia 
         DefaultComboBoxModel<Alumno> comboBoxModel = new DefaultComboBoxModel<>();

        for (Alumno alu : listaA) {
            comboBoxModel.addElement(alu); // Agregamos el objeto Materia directamente
        }

       // Establecer el modelo en el JComboBox
       jcbAlumno.setModel(comboBoxModel);
    }

    private void armarCabeceraTabla(){
        ArrayList<Object> filaCabecera = new  ArrayList<>();
             filaCabecera.add("Código");
             filaCabecera.add("Nombre de Materia");
             filaCabecera.add("Nota");

             for(Object it: filaCabecera){
                 modeloTabla.addColumn(it);
             }
             jtNotas.setModel(modeloTabla);
    }    
    
    private void borrarFilaDeTabla(){
        int indice = modeloTabla.getRowCount() -1;
        for(int i = indice ; i >= 0 ; i--){
            modeloTabla.removeRow(i);           
        }
    }

    private void cargarMateriasConNotas(){
        borrarFilaDeTabla();//limpiamos tabla
        Alumno alu = (Alumno)jcbAlumno.getSelectedItem();//recuperamos al alumno seleccionado en el combobox   
        int idAlumno=alu.getIdAlumno();//obtenemos el id del alumno  
        ListaInscripto= (ArrayList)inscData.obtenerNotasDeMaterias(idAlumno);
        //mostramos en tabla la lista fila por fila (materias con sus notas)
        for(Inscripcion i: ListaInscripto){
            modeloTabla.addRow(new Object[]{i.getId_Materia(),i.getNombreMateria() , i.getNota()});
        }
    }

}
