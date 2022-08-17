/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MascotaVirtual;

import RealizaMascota.Accion;
import Actividad.Mascota.Actividad;
import Actividad.Mascota.Correr;
import Utilspet.Tiempo;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
//import java.util.concurrent.TimeUnit;
import javax.swing.Timer;

/**
 *
 * @author Francisco
 */
public final class FrmTamagotchi extends javax.swing.JFrame {
       private Tiempo time;
       private Mascota pet;
       private Accion realiza;
       int c1;
       int c2;
       int c3;
       int c4;
       int c5;
       int cEdad;
       int cEtapa=0;
    /**
     * Creates new form FrmTamagotchi
     */
    public FrmTamagotchi() {
        initComponents();
        this.setLocationRelativeTo(FrmTamagotchi.this);
        realiza=new Accion();
        pet= new Mascota();
        time=new Tiempo();
        inicializar();
        nombre();
        iniciar();
        c1=0;
        c2=0;
        c3=0;
        c4=0;
        c5=0;
        cEdad=0;
    }
    
    Timer timer = new Timer (1000, (ActionEvent e) -> {
        this.lblTime.setText(time.toString());
        this.sumaAburrimiento();
        this.restaBanio();
        this.restaEnergia();
        this.restaHambre();
        this.restaSalud();
        this.AumentaEdad();
        this.time.contar();
        this.etapa();
    });
    
    public void nombre(){
        pet.nombrePet();
        lblNombre.setText(pet.getNombre());
    }
    /*
    Metodo que indica la etapa de la mascota.
    */
    public void etapa(){
         int ed=Integer.parseInt(this.lblEdad.getText());
        if(ed==30 ){
            pet.setEtapa(Etapa.Bebe);
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BebeNormal.png")));
            this.lblEtapa.setText(String.valueOf(pet.getEtapa()));
        }if(ed==60){
            pet.setEtapa(Etapa.Joven);
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JovenNormal.png")));
            this.lblEtapa.setText(String.valueOf(pet.getEtapa()));
        }if(ed==90){
            pet.setEtapa(Etapa.Adulto);
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Adulto Normal.png")));
            this.lblEtapa.setText(String.valueOf(pet.getEtapa()));
        }
    }
    /*
    Metodo que inicializa las barras de estado,Edad,Etapa.
    */
    public void  inicializar(){ //Inicializa las barras de estado
        this.barAburrimiento.setValue(pet.getAburrimiento());
        this.barBanio.setValue(pet.getNecesidades());
        this.barEnergia.setValue(pet.getEnergia());
        this.barHambre.setValue(pet.getHambre());
        this.barSalud.setValue(pet.getSalud());
        this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perritoh.png")));
        this.lblEdad.setText(String.valueOf(pet.getEdad()));
        this.lblEtapa.setText(String.valueOf(pet.getEtapa()));
       
    }
    
    public void iniciar(){
//         try {
//            TimeUnit.MILLISECONDS.sleep(1000);
           timer.start();
//        } catch (InterruptedException ex) {
           
//        }//
        
    }
    /*
    Metodo que aumenta la edad.
    */
    public void AumentaEdad(){//Aumentamos la edad conforme pasa el tiempo
        cEdad++;
        if (cEdad==5){
            int edad=Integer.parseInt(this.lblEdad.getText());
            pet.setEdad(edad+1);
            this.lblEdad.setText(String.valueOf(pet.getEdad()));
            cEdad=0;
        }else if(pet.getEdad()==100){
            timer.stop();
            JOptionPane.showMessageDialog(null, "Fallecio por motivos de edad");
        }
    }
    /*
    Metodo para restar el aburrimiento
    */
    public void sumaAburrimiento(){//METODO PARA sumar LAS BARRA
        c1++;
        if (c1==5){
            pet.setAburrimiento(pet.getAburrimiento()+10);
//            int get=this.barAburrimiento.getValue()+10;//le suma a la barra
            this.barAburrimiento.setValue(pet.getAburrimiento()); 
           c1=0; 
        }
    }
    
    public void restaBanio(){//METODO PARA RESTAR LAS BARRAS
        c2++;
        if (c2==5){
            pet.setNecesidades(pet.getNecesidades()-5);
           this.barBanio.setValue(pet.getNecesidades()); //obtiene el nuevo valor
           c2=0;
        }
    }
    
    public void restaEnergia(){//METODO PARA RESTAR LAS BARRAS
        c3++;
        if (c3==5){
           pet.setEnergia(pet.getEnergia()-5);
            this.barEnergia.setValue(pet.getEnergia());
            c3=0;
        }
    }
     public void restaHambre(){//METODO PARA RESTAR LAS BARRAS
         c4++;
         if (c4==5){
           pet.setHambre(pet.getHambre()-5);
            this.barHambre.setValue(pet.getHambre());
            c4=0;
        }
     }
     
     public void restaSalud(){//METODO PARA RESTAR LAS BARRAS
         c5++;
         if (c5==5 ){
             pet.setSalud(pet.getSalud()-5);
            this.barSalud.setValue(pet.getSalud());
            
            c5=0;
        }
     }
     
     public void sumaEnergia(){//METODO PARA RESTAR LAS BARRAS
         if (pet.getEnergia()<100){
             pet.setEnergia(pet.getEnergia()+10);
           this.barEnergia.setValue(pet.getEnergia()); 
        }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barAburrimiento = new javax.swing.JProgressBar();
        barHambre = new javax.swing.JProgressBar();
        barBanio = new javax.swing.JProgressBar();
        barSalud = new javax.swing.JProgressBar();
        lblEnergia = new javax.swing.JLabel();
        lblHambre = new javax.swing.JLabel();
        lblBanio = new javax.swing.JLabel();
        lblSalud = new javax.swing.JLabel();
        lblAburrimiento = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblEtapa = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblTime = new javax.swing.JLabel();
        btnEnergia = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        barEnergia = new javax.swing.JProgressBar();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barAburrimiento.setBackground(new java.awt.Color(0, 153, 0));
        barAburrimiento.setStringPainted(true);
        jPanel1.add(barAburrimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 98, 16));

        barHambre.setBackground(new java.awt.Color(0, 153, 0));
        barHambre.setStringPainted(true);
        jPanel1.add(barHambre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 98, 16));

        barBanio.setBackground(new java.awt.Color(0, 153, 0));
        barBanio.setStringPainted(true);
        jPanel1.add(barBanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 98, 16));

        barSalud.setBackground(new java.awt.Color(0, 153, 0));
        barSalud.setStringPainted(true);
        jPanel1.add(barSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 98, 16));

        lblEnergia.setText("Energia");
        jPanel1.add(lblEnergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 48, -1));

        lblHambre.setText("Hambre");
        jPanel1.add(lblHambre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 48, -1));

        lblBanio.setText("Baño");
        jPanel1.add(lblBanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 30, 48, -1));

        lblSalud.setText("Salud");
        jPanel1.add(lblSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 48, -1));

        lblAburrimiento.setText("Aburrimiento");
        jPanel1.add(lblAburrimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 72, -1));

        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        lblEdad.setText("Edad");
        jPanel1.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 50, -1));

        lblEtapa.setText("Etapa");
        jPanel1.add(lblEtapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, -1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        lblTime.setText("Time");
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, 97, -1));

        btnEnergia.setText("jButton2");
        btnEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnergiaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, -1, -1));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 270, 230));

        barEnergia.setBackground(new java.awt.Color(0, 153, 0));
        barEnergia.setStringPainted(true);
        jPanel1.add(barEnergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 98, 16));

        jMenu1.setText("Opciones");

        jMenuItem1.setText("jMenuItem1");
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("jMenuItem2");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//         realiza.CorrerAct();
//        this.barEnergia.setValue(pet.getEnergia());
        Actividad n=new Correr();
         pet.setEnergia(pet.getEnergia()-n.getEnergia());
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setAburrimiento(pet.getAburrimiento()-n.getEntretenimiento());
            this.barAburrimiento.setValue(pet.getAburrimiento());
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEnergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnergiaActionPerformed
        sumaEnergia();
        int valor=this.barAburrimiento.getValue();
        this.lblTime.setText(String.valueOf(valor));
       
    }//GEN-LAST:event_btnEnergiaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrmTamagotchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTamagotchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTamagotchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTamagotchi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTamagotchi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barAburrimiento;
    private javax.swing.JProgressBar barBanio;
    private javax.swing.JProgressBar barEnergia;
    private javax.swing.JProgressBar barHambre;
    private javax.swing.JProgressBar barSalud;
    private javax.swing.JButton btnEnergia;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblAburrimiento;
    private javax.swing.JLabel lblBanio;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEnergia;
    private javax.swing.JLabel lblEtapa;
    private javax.swing.JLabel lblHambre;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalud;
    private javax.swing.JLabel lblTime;
    // End of variables declaration//GEN-END:variables
}
