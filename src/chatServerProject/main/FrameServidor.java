package chatServerProject.main;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrameServidor extends javax.swing.JFrame {
    private ChatServidor servidor; 
    public FrameServidor() {
        initComponents();
        actualizarMiIP();
    }
    public void setIPCliente(String texto){
        clienteIP.setText(clienteIP.getText()+texto);
    }
    public void setTextoBoton(String texto) {
        botonConectarDesconectar.setText(texto);
    }
    public void setTextoChat (String texto) {
        textoChat.setText(texto);
    }
    private void actualizarMiIP(){
        InetAddress mihost;
        try {
            mihost = InetAddress.getLocalHost();
            String direccion=mihost.getHostAddress();
            String texto=ServidorIP.getText();
            texto=texto+direccion;
            ServidorIP.setText(texto); 
        } catch (UnknownHostException ex) {
            System.exit(0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ServidorIP = new javax.swing.JLabel();
        textoPuerto = new javax.swing.JTextField();
        Puerto = new javax.swing.JLabel();
        clienteIP = new javax.swing.JLabel();
        botonConectarDesconectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoChat = new javax.swing.JTextArea();
        tituloTexto = new javax.swing.JLabel();
        botonLimpiar = new javax.swing.JButton();
        botonEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Servidor");

        ServidorIP.setText("Dirección IP: ");

        textoPuerto.setColumns(10);

        Puerto.setText("Puerto:");

        clienteIP.setText("IP Cliente: ");

        botonConectarDesconectar.setText("Conectar");
        botonConectarDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConectarDesconectarActionPerformed(evt);
            }
        });

        textoChat.setColumns(20);
        textoChat.setLineWrap(true);
        textoChat.setRows(5);
        jScrollPane1.setViewportView(textoChat);

        tituloTexto.setText("Texto");

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonEnviar.setText("Enviar");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tituloTexto)
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonConectarDesconectar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonEnviar)
                                .addGap(19, 19, 19)
                                .addComponent(botonLimpiar))
                            .addComponent(ServidorIP)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Puerto)
                                .addGap(18, 18, 18)
                                .addComponent(textoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(clienteIP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloTexto)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ServidorIP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Puerto)
                            .addComponent(textoPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(clienteIP)
                        .addGap(60, 60, 60)
                        .addComponent(botonConectarDesconectar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonLimpiar)
                            .addComponent(botonEnviar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonConectarDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConectarDesconectarActionPerformed
        if (botonConectarDesconectar.getText().compareTo("Conectar")==0){
        //cogemos el puerto y lo convertimos a entero
            String puertoS=textoPuerto.getText();
            if (puertoS.length()!=0){
                try {
                    int puertoI=Integer.parseInt(puertoS);
                    //creamos el objeto servidor
                    servidor=new ChatServidor(puertoI, this);
                    servidor.start(); //se llama así porque es un thread
                    setTextoBoton("Conectando..");
                    
                }catch(NumberFormatException nfe){
                    textoPuerto.setText("");
                }
            }
        }else {
            if (botonConectarDesconectar.getText().compareTo("Desconectar")==0){
                servidor.cerrar();
                //servidor.enviar("#CERRAR_CONEXION#");
            }              
        }
    }//GEN-LAST:event_botonConectarDesconectarActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        textoChat.setText("");
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        servidor.enviar(textoChat.getText());
    }//GEN-LAST:event_botonEnviarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameServidor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Puerto;
    private javax.swing.JLabel ServidorIP;
    private javax.swing.JButton botonConectarDesconectar;
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JLabel clienteIP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textoChat;
    private javax.swing.JTextField textoPuerto;
    private javax.swing.JLabel tituloTexto;
    // End of variables declaration//GEN-END:variables
}
