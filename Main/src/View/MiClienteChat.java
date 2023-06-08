/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Interfaces.MiInterfazRemota;
import Interfaces.MiInterfazRemotaPrivada;
import java.awt.Color;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.ClienteMS;
import main.MiClaseRemota;
import main.MiclassRemotaPunto;
/**
 *
 * @author Gerardo
 */
public class MiClienteChat extends javax.swing.JFrame {

    public  Registry registryG;
    public  Registry registryPrivate; 
    public  MiInterfazRemota remoteMi;
    public MiInterfazRemotaPrivada remoteMiPri;
    MiclassRemotaPunto remotePointPriv;
    
      
    public MiClienteChat() {
        initComponents();
        TextAreas();
        
        RegisterCliente();
        ChatPrivadoServer();
        
        this.lblErrorIP.setVisible(false);
       
    }

    public void ChatPrivadoServer() {
        try {

            remotePointPriv = new MiclassRemotaPunto();
            //se registara un puertto 
            Registry registry = LocateRegistry.createRegistry(1234);
            registry.rebind("MiInterfazRemotaPrivada", remotePointPriv);

            System.out.println("Servidor RMI Privado listo");
        } catch (Exception e) {
            System.err.println("Error  Registry in  servidor: " + e.toString());
            e.printStackTrace();
        }
        //RegisterClientePunto();
    }
    
    public void RegisterClientePunto() {
        try {
            
            // Registry registry = LocateRegistry.getRegistry("192.168.84.200", 1099);
            //remoteMiaux = (MiInterfazRemota) Naming.lookup("rmi://192.168.100.5:1099/MiInterfazRemota");

            registryPrivate = LocateRegistry.getRegistry(this.txtAreaIPAddress.getText(), 1234);
            remoteMiPri = (MiInterfazRemotaPrivada) registryPrivate.lookup("MiInterfazRemotaPrivada");
            
            ClienteMS cliente = new ClienteMS(ChatP1);
            remoteMiPri.registerClient(cliente);
            // System.out.println(remoteMiaux);
            System.out.println("Conexion exitosa");
            
        } catch (Exception e) {
            System.err.println("Error Registry in server: " + e.toString());
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        BtnGeneral = new javax.swing.JButton();
        ChatGeneral = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ChatGeneralArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChatP1 = new javax.swing.JTextArea();
        ChatP1Send = new javax.swing.JTextField();
        Registrarce = new javax.swing.JButton();
        BtnSP1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAreaIPAddress = new javax.swing.JTextField();
        lblErrorIP = new javax.swing.JLabel();
        btnDesconectar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BtnGeneral.setText("Enviar");
        BtnGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGeneralActionPerformed(evt);
            }
        });
        jPanel2.add(BtnGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 70, -1));
        jPanel2.add(ChatGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 310, -1));

        ChatGeneralArea.setColumns(20);
        ChatGeneralArea.setRows(5);
        ChatGeneralArea.setEnabled(false);
        jScrollPane1.setViewportView(ChatGeneralArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 310, 180));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/grupo.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, -1, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("Mensajes grupales");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 160, 30));

        ChatP1.setColumns(20);
        ChatP1.setRows(5);
        ChatP1.setEnabled(false);
        jScrollPane2.setViewportView(ChatP1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 310, 220));
        jPanel2.add(ChatP1Send, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 310, -1));

        Registrarce.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/individuo.jpg"))); // NOI18N
        Registrarce.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarceActionPerformed(evt);
            }
        });
        jPanel2.add(Registrarce, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 70, 60));

        BtnSP1.setText("Enviar");
        BtnSP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSP1ActionPerformed(evt);
            }
        });
        jPanel2.add(BtnSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 480, 70, -1));

        jLabel2.setBackground(new java.awt.Color(0, 255, 204));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("Mensajes privados");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 160, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("WhatSup");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 510, 120, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/whatsup.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 510, -1, -1));

        jLabel5.setText("Especifíca la IP a conectarse:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));
        jPanel2.add(txtAreaIPAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 150, -1));

        lblErrorIP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblErrorIP.setForeground(new java.awt.Color(204, 0, 51));
        lblErrorIP.setText("ERROR!");
        jPanel2.add(lblErrorIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 440, -1, -1));

        btnDesconectar.setText("Desconectar");
        btnDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesconectarActionPerformed(evt);
            }
        });
        jPanel2.add(btnDesconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/backgroundWhatsapp.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      public void RegisterCliente() {
        try {
            
            // Registry registry = LocateRegistry.getRegistry("192.168.84.200", 1099);
            //remoteMiaux = (MiInterfazRemota) Naming.lookup("rmi://192.168.100.5:1099/MiInterfazRemota");

            registryG = LocateRegistry.getRegistry("192.168.1.80", 1099);
            System.out.println("Antes: " + remoteMi);
            remoteMi = (MiInterfazRemota) registryG.lookup("MiInterfazRemota");
            System.out.println("Despues: " + remoteMi);

            ClienteMS cliente = new ClienteMS(ChatGeneralArea);
            remoteMi.registerClient(cliente);
            // System.out.println(remoteMiaux);
            System.out.println("Conexion exitosa");
            
        } catch (Exception e) {
            System.err.println("Error send the message: " + e.toString());
        }

    }
    
    private void BtnGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGeneralActionPerformed

        String MS = ChatGeneral.getText();

        try {
            // Registry registry = LocateRegistry.getRegistry("192.168.84.200", 1099);
            /* Registry registry = LocateRegistry.getRegistry("192.168.100.5", 1099);
            MiInterfazRemota remoteMi = (MiInterfazRemota) registry.lookup("MiInterfazRemota");*/

            //ClienteMS cliente = new ClienteMS(ChatGeneralArea);
            //remoteMi.registerClient(cliente);
            //System.out.println(cliente);
            // System.out.println(auxms + "main");
           // ChatGeneralArea.append(MS + "\n");

           // remoteMi.poolMS(MS);
            remoteMi.SendMS(MS);
        } catch (Exception e) {
            System.err.println("Error send the message: " + e.toString());
        }
        ChatGeneral.setText("");
    }//GEN-LAST:event_BtnGeneralActionPerformed

    private void BtnSP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSP1ActionPerformed
        // TODO add your handling code here:
        String MS = ChatP1Send.getText();
        try {
         
            
            remoteMiPri.SendMS(MS);
        } catch (Exception ex) {
            System.out.println("Error send the Messange Private");
        }

      
      ChatP1Send.setText("");
    }//GEN-LAST:event_BtnSP1ActionPerformed

    private void RegistrarceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarceActionPerformed
        if("".equals(this.txtAreaIPAddress.getText())) {
        
            this.lblErrorIP.setVisible(true);
            
        } else {
            
            this.lblErrorIP.setVisible(false);
            RegisterClientePunto();
            
        }
        
        
    }//GEN-LAST:event_RegistrarceActionPerformed

    private void btnDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesconectarActionPerformed
        
        remotePointPriv.closeConnection();
        
    }//GEN-LAST:event_btnDesconectarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void  TextAreas () {
        ChatGeneralArea.setEditable(false);
        ChatP1.setEditable(false);
    }
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
            java.util.logging.Logger.getLogger(MiClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiClienteChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiClienteChat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnGeneral;
    private javax.swing.JButton BtnSP1;
    private javax.swing.JTextField ChatGeneral;
    private javax.swing.JTextArea ChatGeneralArea;
    private javax.swing.JTextArea ChatP1;
    private javax.swing.JTextField ChatP1Send;
    private javax.swing.JButton Registrarce;
    private javax.swing.JButton btnDesconectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblErrorIP;
    private javax.swing.JTextField txtAreaIPAddress;
    // End of variables declaration//GEN-END:variables
}
