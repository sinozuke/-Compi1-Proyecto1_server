/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import BackEnd.Analizador.Consola.Lexico_Request_consola;
import BackEnd.Analizador.Consola.AnalizadorSintactico_compilador_consola;
import static compi1.proyecto1_server.pkg201403775.Compi1Proyecto1_Server201403775.SG;
import static compi1.proyecto1_server.pkg201403775.Compi1Proyecto1_Server201403775.errores;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import BackEnd.DAO.Objetos.Error;
import java.io.ByteArrayInputStream;

/**
 *
 * @author sinozuke
 */
public class Interfaz_Server extends javax.swing.JFrame {

    
    private final JFileChooser fc = new JFileChooser();
    private File entrada;
    private BufferedReader br;
    private Document lex;
    private Document sin;
    private Document sem;
    private PdfPTable tabla;
    private final Font fuente = new Font();
    private Paragraph fin;
    private Paragraph ini;
    private PdfPCell cabeza;
    private PdfPCell Pie;
    private PdfWriter instance;
    /**
     * Creates new form Interfaz_Server
     */
    public Interfaz_Server() {
        initComponents();
        fuente.setSize(18);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void ejecutar() throws Exception{
        errores.clear();
        Lexico_Request_consola ANAL_LEX = new Lexico_Request_consola(new ByteArrayInputStream(this.txtconsola.getText().getBytes()));
        AnalizadorSintactico_compilador_consola ANAL_SIN = new AnalizadorSintactico_compilador_consola(ANAL_LEX);
        ANAL_SIN.parse();
    }
    
    public void generar_pdf_lex(){
        try {
            instance = PdfWriter.getInstance(lex, new FileOutputStream("~/errlex.pdf"));
            
            lex.open();
            
            tabla = new PdfPTable(3);
            
            ini = new Paragraph("Errores Lexicos",fuente);
            ini.setLeading(0,1);
            
            fin = new Paragraph("-- Fin Errores Lexicos --",fuente);
            fin.setLeading(0,1);
            
            cabeza = new PdfPCell(ini);
            cabeza.setColspan(3);
                       
            Pie = new PdfPCell(fin);
            Pie.setColspan(3);
            
            tabla.setWidthPercentage(100);
            
            tabla.addCell(cabeza);
            
            errores.stream().forEach((Error err)->{
                if(err.getTipo().equals("lexico")){
                    tabla.addCell(String.valueOf(err.getFila()));
                    tabla.addCell(String.valueOf(err.getColumna()));
                    tabla.addCell(err.getDescripccion());
                }
            });
            
            tabla.addCell(Pie);
            
            lex.add(tabla);
            lex.close();
            this.mostrar_documento_lex();
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(Interfaz_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrar_documento_lex(){
        try {
            Runtime.getRuntime().exec("evince ./errlex.pdf");
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "linux No  pude abrir evince");
                System.out.println("err al ejecutar evince (pdfs()): " + ex.getCause());
        }
    }
    
    public void generar_pdf_sin(){
        try {
            instance = PdfWriter.getInstance(sin, new FileOutputStream("~/errsin.pdf"));
            
            sin.open();
            
            tabla = new PdfPTable(3);
            
            ini = new Paragraph("Errores Sintacticos",fuente);
            ini.setLeading(0,1);
            
            fin = new Paragraph("-- Fin Errores Sintacticos --",fuente);
            fin.setLeading(0,1);
            
            cabeza = new PdfPCell(ini);
            cabeza.setColspan(3);
                       
            Pie = new PdfPCell(fin);
            Pie.setColspan(3);
            
            tabla.setWidthPercentage(100);
            
            tabla.addCell(cabeza);
            
            errores.stream().forEach((Error err)->{
                if(err.getTipo().equals("sintactico")){
                    tabla.addCell(String.valueOf(err.getFila()));
                    tabla.addCell(String.valueOf(err.getColumna()));
                    tabla.addCell(err.getDescripccion());
                }
            });
            
            tabla.addCell(Pie);
            
            sin.add(tabla);
            sin.close();
            this.mostrar_documento_sin();
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(Interfaz_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrar_documento_sin(){
        try {
            Runtime.getRuntime().exec("evince ./errsin.pdf");
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "linux No  pude abrir evince");
                System.out.println("err al ejecutar evince (pdfs()): " + ex.getCause());
        }
    
    }
    
    public void generar_pdf_sem(){
        try {
            instance = PdfWriter.getInstance(sem, new FileOutputStream("~/errsem.pdf"));
            
            sem.open();
            
            tabla = new PdfPTable(3);
            
            ini = new Paragraph("Errores Semanticos",fuente);
            ini.setLeading(0,1);
            
            fin = new Paragraph("-- Fin Errores Semanticos --",fuente);
            fin.setLeading(0,1);
            
            cabeza = new PdfPCell(ini);
            cabeza.setColspan(3);
                       
            Pie = new PdfPCell(fin);
            Pie.setColspan(3);
            
            tabla.setWidthPercentage(100);
            
            tabla.addCell(cabeza);
            
            errores.stream().forEach((Error err)->{
                if(err.getTipo().equals("semantico")){
                    tabla.addCell(String.valueOf(err.getFila()));
                    tabla.addCell(String.valueOf(err.getColumna()));
                    tabla.addCell(err.getDescripccion());
                }
            });
            
            tabla.addCell(Pie);
            
            sem.add(tabla);
            sem.close();
            this.mostrar_documento_sem();
        } catch (DocumentException | FileNotFoundException ex) {
            Logger.getLogger(Interfaz_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void mostrar_documento_sem(){
        try {
            Runtime.getRuntime().exec("evince ~./errsem.pdf");
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "linux No  pude abrir evince");
                System.out.println("err al ejecutar evince (pdfs()): " + ex.getCause());
        }
    }
    
    private void cargar(){
        fc.showOpenDialog(this);
        entrada = new File(fc.getSelectedFile().getAbsolutePath());
        if(entrada.canRead()){
            try {
                br = new BufferedReader(new FileReader(entrada));
                while(br.readLine()!=null){
                    txtconsola.append(br.readLine()+"\n");
                }
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Interfaz_Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "El Archivo no Tiene Permisos para ser leido");
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtconsola = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtsalida = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Consola");

        txtconsola.setColumns(20);
        txtconsola.setRows(5);
        jScrollPane1.setViewportView(txtconsola);

        jButton1.setText("Limpiar Consola");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Ejecutar Acciones");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cargar Archivo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Mostrar Errores Lexicos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Mostrar Errores Sintacticos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Mostrar Errores Semanticos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setText("consola de Salida");

        txtsalida.setColumns(20);
        txtsalida.setRows(5);
        txtsalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtsalidaKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtsalida);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        SG.Realizar_Backup();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void txtsalidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsalidaKeyTyped
        evt.consume();
    }//GEN-LAST:event_txtsalidaKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.mostrar_documento_lex();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.mostrar_documento_sin();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.mostrar_documento_sem();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.cargar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            this.ejecutar();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getCause());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtconsola.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtconsola;
    public javax.swing.JTextArea txtsalida;
    // End of variables declaration//GEN-END:variables
}