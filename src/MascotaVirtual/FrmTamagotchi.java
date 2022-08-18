/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MascotaVirtual;

import RealizaMascota.Accion;
import Actividad.Mascota.Actividad;
import Actividad.Mascota.Correr;
import Actividad.Mascota.Escondite;
import Actividad.Mascota.Excavar;
import Actividad.Mascota.Futbol;
import Actividad.Mascota.Pasear;
import Alimento.Mascota.Alimento;
import Alimento.Mascota.Carne;
import Alimento.Mascota.Concentrado;
import Alimento.Mascota.Galletas;
import Alimento.Mascota.Hueso;
import Alimento.Mascota.Lechuga;
import Medicina.Mascota.Inyeccion;
import Medicina.Mascota.Medicina;
import Medicina.Mascota.Pastilla;
import Utilspet.Tiempo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
       private Actividad correr,escondite,excavar,futbol,pasear;
       private Alimento carne,concentrado,galletas,hueso,lechuga;
       private Medicina inyeccion,pastilla;
       
       int c1,c2,c3,c4,c5,cEdad,cEtapa;
       int contador1,contador2,contador3,contador4,contador5,contador6,contador7;
       
    public void InstanciarActividad(){
        //Actividad
        correr=new Correr();
        escondite=new Escondite();
        excavar=new Excavar();
        futbol=new Futbol();
        pasear=new Pasear();
        //Alimentos
        carne=new Carne();
        concentrado=new Concentrado();
        galletas=new Galletas();
        hueso=new Hueso();
        lechuga=new Lechuga();
        //Medicina
        inyeccion=new Inyeccion();
        pastilla=new Pastilla();
    }

    /**
     * Creates new form FrmTamagotchi
     */
    public FrmTamagotchi() {
        initComponents();
        this.setLocationRelativeTo(FrmTamagotchi.this);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/iconosbotones/tamago.png")));
        pet= new Mascota();
        time=new Tiempo();
        InstanciarActividad();
        inicializar();
        nombre();
        iniciar();
        
     
    }
    
    Timer timer = new Timer (1000, (ActionEvent e) -> {
        
        this.sumaAburrimiento();
        this.sumaBanio();
        this.restaEnergia();
        this.restaHambre();
        this.AumentaEdad();
        this.time.contar();
        this.etapa();
        nivelCritico();
        murio();
       
        
    });
    Timer time1 = new Timer (1000, (ActionEvent e) -> {
       desabilitarInyeccion();

    });
      Timer time2 = new Timer (1000, (ActionEvent e) -> {
       desabilitarPastillas();
    });
       Timer time3 = new Timer (1000, (ActionEvent e) -> {
       desabilitarCarne();
    });  
       Timer time4 = new Timer (1000, (ActionEvent e) -> {
      desabilitarConcentrado();
    });
         Timer time5 = new Timer (1000, (ActionEvent e) -> {
       desabilitarGalletas();
    });
         Timer time6 = new Timer (1000, (ActionEvent e) -> {
       desabilitarHueso();
    });
           Timer time7 = new Timer (1000, (ActionEvent e) -> {
       desabilitarLechuga();
    });
    
    public void desabilitarInyeccion(){//
         contador1++;
        System.out.println(contador1);
        if (contador1==inyeccion.getTiempo() ){
            this.miInyeccion.setEnabled(true);
            contador1=0;
            time1.stop();
        }
    }
    public void desabilitarPastillas(){//
         contador7++;
        System.out.println(contador7);
        if (contador7==pastilla.getTiempo() ){
            this.miPastilla.setEnabled(true);
            contador7=0;
            time2.stop();
        }
    }
    public void desabilitarCarne(){//
         contador2++;
        System.out.println(contador2);
        if (contador2==carne.getTiempo() ){
            this.miCarne.setEnabled(true);
            contador2=0;
            time3.stop();
        }
    }
    public void desabilitarConcentrado(){//
         contador3++;
        System.out.println(contador3);
        if (contador3==concentrado.getTiempo() ){
            this.miConsentrado.setEnabled(true);
            contador3=0;
            time4.stop();
        }
    }
    public void desabilitarGalletas(){//
         contador4++;
        System.out.println(contador4);
        if (contador4==galletas.getTiempo() ){
            this.btnBanio.setEnabled(true);
            contador4=0;
            time5.stop();
        }
    }
    public void desabilitarHueso(){//
         contador5++;
        System.out.println(contador5);
        if (contador5==hueso.getTiempo() ){
            this.btnBanio.setEnabled(true);
            contador5=0;
            time6.stop();
        }
    }
    public void desabilitarLechuga(){//
         contador6++;
        System.out.println(contador6);
        if (contador6==lechuga.getTiempo() ){
            this.btnBanio.setEnabled(true);
            contador6=0;
            time7.stop();
        }
    }
    
    
    /*
    Metodo que inicializa las barras de estado,Edad,Etapa.
    */
    public void  inicializar(){ //Inicializa las barras de estado
        this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perritoh.png")));
        this.barAburrimiento.setValue(pet.getAburrimiento());
        this.barBanio.setValue(pet.getNecesidades());
        this.barEnergia.setValue(pet.getEnergia());
        this.barHambre.setValue(pet.getHambre());
        
        this.lblEstado.setText(String.valueOf(pet.getEstado()));
        this.lblEdad.setText(String.valueOf(pet.getEdad()));
        this.lblEtapa.setText(String.valueOf(pet.getEtapa()));
        
    }
    public void nombre(){
        pet.nombrePet();
        lblNombre.setText(pet.getNombre());
    }
    /*
    Metodo que indica la etapa de la mascota.
    */
    public void etapa(){
         int ed=Integer.parseInt(this.lblEdad.getText());
        if(ed==10 ){
            pet.setEtapa(Etapa.Bebe);
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/BebeNormal.png")));
            this.lblEtapa.setText(String.valueOf(pet.getEtapa()));
        }if(ed==20){
            pet.setEtapa(Etapa.Joven);
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/JovenNormal.png")));
            this.lblEtapa.setText(String.valueOf(pet.getEtapa()));
        }if(ed==30){
            pet.setEtapa(Etapa.Adulto);
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Adulto Normal.png")));
            this.lblEtapa.setText(String.valueOf(pet.getEtapa()));
        }
    }
    
    public void iniciar(){
//         try {
//            TimeUnit.MILLISECONDS.sleep(1000);
           timer.start();
//        } catch (InterruptedException ex) {
           
//        }//
    }
    
    public void murio(){
         if (pet.getAburrimiento()==100 && pet.getNecesidades()==100 ||
             pet.getEnergia()==0 && pet.getHambre()==100 || pet.getAburrimiento()==100 && pet.getEnergia()==0 ||
             pet.getNecesidades()==100  && pet.getHambre()==100){
            pet.setEstado(Estado.Murio);
            this.lblEstado.setText(String.valueOf(pet.getEstado()));
            
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Murio.png")));
                timer.stop();
            }
         
    }
    public void nivelCritico(){
         if (pet.getAburrimiento()>=90 || pet.getNecesidades()>=90 || pet.getEnergia()<=10 || pet.getHambre()>=90 ){
            pet.setEstado(Estado.Enfermo);
            this.lblEstado.setText(String.valueOf(pet.getEstado()));
            if (pet.getEdad()<10){
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/HuevoEnfermo.png")));
            }else if(pet.getEdad()<20){
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BebeEnfermo.png")));
             } else if (pet.getEdad()<30){
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/JovenEnfermo.png")));
             }else{
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AdultoEnfermo.png")));
            }   
            //verificar cuando cambia    
        }else{
            if (pet.getEdad()<10){
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/perritoh.png")));
            }else if(pet.getEdad()<20){
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BebeNormal.png")));
            }else if(pet.getEdad()<30 ){
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/JovenNormal.png")));
            }else{
                this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Adulto Normal.png")));
                }               
            pet.setEstado(Estado.Saludable);
            this.lblEstado.setText(String.valueOf(pet.getEstado()));                
       }
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
            pet.setAburrimiento(pet.getAburrimiento()+10);//suma al aburrimiento
            this.barAburrimiento.setValue(pet.getAburrimiento()); 
            c1=0; 
        }
       
        
    }
    
    public void sumaBanio(){//METODO PARA RESTAR LAS BARRAS
        c2++;
        if (c2==7){
            pet.setNecesidades(pet.getNecesidades()+10);
           this.barBanio.setValue(pet.getNecesidades()); //obtiene el nuevo valor
           c2=0;
        }
//      
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
           pet.setHambre(pet.getHambre()+5);
            this.barHambre.setValue(pet.getHambre());
            c4=0;
        }
     }
      
     
     public void Modifica(){//METODO PARA RESTAR LAS BARRAS
       pet.setEnergia(pet.getEnergia()+15);
       this.barEnergia.setValue(pet.getEnergia());
       
//       pet.setAburrimiento(pet.getAburrimiento()-3);
//       this.barAburrimiento.setValue(pet.getAburrimiento());
       
        pet.setHambre(pet.getHambre()+3);
        this.barHambre.setValue(pet.getHambre());
        
        pet.setNecesidades(pet.getNecesidades()+3);
       this.barBanio.setValue(pet.getNecesidades());
        
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        barAburrimiento = new javax.swing.JProgressBar();
        barHambre = new javax.swing.JProgressBar();
        barBanio = new javax.swing.JProgressBar();
        lblEnergia = new javax.swing.JLabel();
        lblHambre = new javax.swing.JLabel();
        lblBanio = new javax.swing.JLabel();
        lblSalud = new javax.swing.JLabel();
        lblAburrimiento = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblEtapa = new javax.swing.JLabel();
        btnBanio = new javax.swing.JButton();
        btnDormir = new javax.swing.JButton();
        lblImagen = new javax.swing.JLabel();
        barEnergia = new javax.swing.JProgressBar();
        lblEstado = new javax.swing.JLabel();
        lblSalud1 = new javax.swing.JLabel();
        lblSalud2 = new javax.swing.JLabel();
        lblSalud3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mActividades = new javax.swing.JMenu();
        miExcavar = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        miCorrer = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        miEscondite = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        miPasear = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        miFutbol = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        miMedicina = new javax.swing.JMenu();
        miInyeccion = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        miPastilla = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mAlimentos = new javax.swing.JMenu();
        miConsentrado = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miHueso = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miLechuga = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        miCarne = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        miGalletas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TAMAGOTCHI");

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barAburrimiento.setBackground(new java.awt.Color(0, 153, 0));
        barAburrimiento.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        barAburrimiento.setOpaque(true);
        barAburrimiento.setStringPainted(true);
        jPanel1.add(barAburrimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 98, 16));

        barHambre.setBackground(new java.awt.Color(0, 153, 0));
        barHambre.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        barHambre.setBorder(null);
        barHambre.setOpaque(true);
        barHambre.setStringPainted(true);
        jPanel1.add(barHambre, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 98, 16));

        barBanio.setBackground(new java.awt.Color(0, 153, 0));
        barBanio.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        barBanio.setOpaque(true);
        barBanio.setStringPainted(true);
        jPanel1.add(barBanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 98, 16));

        lblEnergia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEnergia.setForeground(new java.awt.Color(0, 0, 204));
        lblEnergia.setText("Energia");
        jPanel1.add(lblEnergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 60, -1));

        lblHambre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHambre.setForeground(new java.awt.Color(0, 0, 204));
        lblHambre.setText("Hambre");
        jPanel1.add(lblHambre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 60, -1));

        lblBanio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBanio.setForeground(new java.awt.Color(0, 0, 204));
        lblBanio.setText("Baño");
        jPanel1.add(lblBanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 60, -1));

        lblSalud.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSalud.setForeground(new java.awt.Color(0, 0, 255));
        lblSalud.setText("Nombre");
        jPanel1.add(lblSalud, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 60, 30));

        lblAburrimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAburrimiento.setForeground(new java.awt.Color(0, 0, 204));
        lblAburrimiento.setText("Aburrimiento");
        jPanel1.add(lblAburrimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        lblNombre.setBackground(new java.awt.Color(145, 175, 63));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Nombre");
        lblNombre.setOpaque(true);
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 100, 30));

        lblEdad.setBackground(new java.awt.Color(145, 175, 63));
        lblEdad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEdad.setText("Edad");
        lblEdad.setOpaque(true);
        jPanel1.add(lblEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 100, 30));

        lblEtapa.setBackground(new java.awt.Color(145, 175, 63));
        lblEtapa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEtapa.setOpaque(true);
        jPanel1.add(lblEtapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 100, 30));

        btnBanio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/icons8-dog-pee-50.png"))); // NOI18N
        btnBanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBanioActionPerformed(evt);
            }
        });
        jPanel1.add(btnBanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 100, 80));

        btnDormir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/dormir.png"))); // NOI18N
        btnDormir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDormirMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDormirMouseReleased(evt);
            }
        });
        btnDormir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDormirActionPerformed(evt);
            }
        });
        jPanel1.add(btnDormir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, 100, 90));
        jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 310, 230));

        barEnergia.setBackground(new java.awt.Color(0, 153, 0));
        barEnergia.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        barEnergia.setOpaque(true);
        barEnergia.setStringPainted(true);
        jPanel1.add(barEnergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 98, 16));

        lblEstado.setBackground(new java.awt.Color(145, 175, 63));
        lblEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEstado.setOpaque(true);
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 100, 30));

        lblSalud1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSalud1.setForeground(new java.awt.Color(0, 0, 255));
        lblSalud1.setText("Salud");
        jPanel1.add(lblSalud1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 130, 48, -1));

        lblSalud2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSalud2.setForeground(new java.awt.Color(0, 0, 255));
        lblSalud2.setText("Etapa");
        jPanel1.add(lblSalud2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 48, -1));

        lblSalud3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSalud3.setForeground(new java.awt.Color(0, 0, 255));
        lblSalud3.setText("Edad");
        jPanel1.add(lblSalud3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 48, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/istockphoto-1309902693-170667a.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 10, 750, 420));

        jMenuBar1.setBackground(new java.awt.Color(196, 221, 217));
        jMenuBar1.setOpaque(true);

        mActividades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/fisico.png"))); // NOI18N
        mActividades.setText("Actividades");
        mActividades.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mActividades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        miExcavar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/cavar.png"))); // NOI18N
        miExcavar.setText("Excavar");
        miExcavar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExcavarActionPerformed(evt);
            }
        });
        mActividades.add(miExcavar);
        mActividades.add(jSeparator7);

        miCorrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/silueta-de-perro-corriendo.png"))); // NOI18N
        miCorrer.setText("Correr");
        miCorrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCorrerActionPerformed(evt);
            }
        });
        mActividades.add(miCorrer);
        mActividades.add(jSeparator9);

        miEscondite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/oculto.png"))); // NOI18N
        miEscondite.setText("Escondite");
        miEscondite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEsconditeActionPerformed(evt);
            }
        });
        mActividades.add(miEscondite);
        mActividades.add(jSeparator10);

        miPasear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/corriendo.png"))); // NOI18N
        miPasear.setText("Pasear");
        miPasear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPasearActionPerformed(evt);
            }
        });
        mActividades.add(miPasear);
        mActividades.add(jSeparator11);

        miFutbol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/futbol (1).png"))); // NOI18N
        miFutbol.setText("Futbol");
        miFutbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFutbolActionPerformed(evt);
            }
        });
        mActividades.add(miFutbol);
        mActividades.add(jSeparator6);

        jMenuBar1.add(mActividades);

        miMedicina.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/kit-de-primeros-auxilios.png"))); // NOI18N
        miMedicina.setText("Medicina");
        miMedicina.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        miInyeccion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/vacuna.png"))); // NOI18N
        miInyeccion.setText("Inyeccion");
        miInyeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miInyeccionActionPerformed(evt);
            }
        });
        miMedicina.add(miInyeccion);
        miMedicina.add(jSeparator8);

        miPastilla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/medicamento.png"))); // NOI18N
        miPastilla.setText("Pastilla");
        miPastilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPastillaActionPerformed(evt);
            }
        });
        miMedicina.add(miPastilla);
        miMedicina.add(jSeparator12);

        jMenuBar1.add(miMedicina);

        mAlimentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/healthy-food.png"))); // NOI18N
        mAlimentos.setText("Alimentos");
        mAlimentos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        miConsentrado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/dog-bowl.png"))); // NOI18N
        miConsentrado.setText("Concentrado");
        miConsentrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miConsentradoActionPerformed(evt);
            }
        });
        mAlimentos.add(miConsentrado);
        mAlimentos.add(jSeparator1);

        miHueso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/dog-treat.png"))); // NOI18N
        miHueso.setText("Hueso");
        miHueso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miHuesoActionPerformed(evt);
            }
        });
        mAlimentos.add(miHueso);
        mAlimentos.add(jSeparator3);

        miLechuga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/lettuce.png"))); // NOI18N
        miLechuga.setText("Lechuga");
        miLechuga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLechugaActionPerformed(evt);
            }
        });
        mAlimentos.add(miLechuga);
        mAlimentos.add(jSeparator4);

        miCarne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/meat.png"))); // NOI18N
        miCarne.setText("Carne");
        miCarne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCarneActionPerformed(evt);
            }
        });
        mAlimentos.add(miCarne);
        mAlimentos.add(jSeparator5);

        miGalletas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosBotones/pet-food.png"))); // NOI18N
        miGalletas.setText("Galletas");
        miGalletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGalletasActionPerformed(evt);
            }
        });
        mAlimentos.add(miGalletas);

        jMenuBar1.add(mAlimentos);

        setJMenuBar(jMenuBar1);

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

    private void btnBanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBanioActionPerformed
     
        pet.setNecesidades(pet.getNecesidades()-Mascota.BANIO);
        this.barBanio.setValue(pet.getNecesidades());
         this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconosBotones/toiletpaper.png")));
        
    }//GEN-LAST:event_btnBanioActionPerformed

    private void btnDormirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDormirActionPerformed
        Modifica();
        
     if(pet.getEdad()<10){
            
         this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/HuevoDormido.png")));
        }else if(pet.getEdad()<20){
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/BebeDurmiendo.png")));
        } else if(pet.getEdad()<30){
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/JovenDurmiendo.png")));
        }else{
            this.lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AdultoDurmiendo.png")));
        } 
       

    }//GEN-LAST:event_btnDormirActionPerformed

    private void miCarneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCarneActionPerformed
        this.miCarne.setEnabled(false);
        time3.start();
        pet.setEnergia(pet.getEnergia()+carne.getEnergia());//Para aumentar energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setHambre(pet.getHambre()-carne.getSatisfaccion());//para disminur Hambre
            this.barHambre.setValue(pet.getHambre());
    }//GEN-LAST:event_miCarneActionPerformed

    private void miConsentradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miConsentradoActionPerformed
        this.miConsentrado.setEnabled(false);
        time4.start();
        pet.setEnergia(pet.getEnergia()+concentrado.getEnergia());//Para aumentar energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setHambre(pet.getHambre()-concentrado.getSatisfaccion());//para disminur Hambre
            this.barHambre.setValue(pet.getHambre());
    }//GEN-LAST:event_miConsentradoActionPerformed

    private void miCorrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCorrerActionPerformed
        
        pet.setEnergia(pet.getEnergia()-correr.getEnergia());//Para disminuir energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setAburrimiento(pet.getAburrimiento()-correr.getEntretenimiento());//para disminur Aburrimiento.
            this.barAburrimiento.setValue(pet.getAburrimiento());
    }//GEN-LAST:event_miCorrerActionPerformed

    private void miHuesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miHuesoActionPerformed
        this.miHueso.setEnabled(false);
        time6.start();
        pet.setEnergia(pet.getEnergia()+hueso.getEnergia());//Para aumentar energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setHambre(pet.getHambre()-hueso.getSatisfaccion());//para disminur Hambre
            this.barHambre.setValue(pet.getHambre());
    }//GEN-LAST:event_miHuesoActionPerformed

    private void miExcavarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExcavarActionPerformed
       
        pet.setEnergia(pet.getEnergia()-excavar.getEnergia());//Para disminuir energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setAburrimiento(pet.getAburrimiento()-excavar.getEntretenimiento());//para disminur Aburrimiento.
            this.barAburrimiento.setValue(pet.getAburrimiento());
    }//GEN-LAST:event_miExcavarActionPerformed

    private void miEsconditeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEsconditeActionPerformed
        
        pet.setEnergia(pet.getEnergia()-escondite.getEnergia());//Para disminuir energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setAburrimiento(pet.getAburrimiento()-escondite.getEntretenimiento());//para disminur Aburrimiento.
            this.barAburrimiento.setValue(pet.getAburrimiento());
    }//GEN-LAST:event_miEsconditeActionPerformed

    private void miPasearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPasearActionPerformed
       
        pet.setEnergia(pet.getEnergia()-pasear.getEnergia());//Para disminuir energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setAburrimiento(pet.getAburrimiento()-pasear.getEntretenimiento());//para disminur Aburrimiento.
            this.barAburrimiento.setValue(pet.getAburrimiento());
    }//GEN-LAST:event_miPasearActionPerformed

    private void miFutbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFutbolActionPerformed
       time2.start();
        pet.setEnergia(pet.getEnergia()-futbol.getEnergia());//Para disminuir energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setAburrimiento(pet.getAburrimiento()-futbol.getEntretenimiento());//para disminur Aburrimiento.
            this.barAburrimiento.setValue(pet.getAburrimiento());
    }//GEN-LAST:event_miFutbolActionPerformed

    private void miLechugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLechugaActionPerformed
        this.miLechuga.setEnabled(false);
        time7.start();
        pet.setEnergia(pet.getEnergia()+lechuga.getEnergia());//Para aumentar energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setHambre(pet.getHambre()-lechuga.getSatisfaccion());//para disminur Hambre
            this.barHambre.setValue(pet.getHambre());
    }//GEN-LAST:event_miLechugaActionPerformed

    private void miGalletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGalletasActionPerformed
        this.miLechuga.setEnabled(false);
        time5.start();
        pet.setEnergia(pet.getEnergia()+galletas.getEnergia());//Para aumentar energia
          this.barEnergia.setValue(pet.getEnergia());
          
         pet.setHambre(pet.getHambre()-galletas.getSatisfaccion());//para disminur Hambre
            this.barHambre.setValue(pet.getHambre());
    }//GEN-LAST:event_miGalletasActionPerformed

    private void miInyeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miInyeccionActionPerformed
        this.miInyeccion.setEnabled(false);
        time1.start();
        pet.setEnergia(pet.getEnergia()+inyeccion.getCuracion());//Para aumentar energia
          this.barEnergia.setValue(pet.getEnergia());
          
        pet.setHambre(pet.getHambre()-inyeccion.getCuracion());//para disminur Hambre
           this.barHambre.setValue(pet.getHambre());
           
        pet.setNecesidades(pet.getNecesidades()-inyeccion.getCuracion());//Para aumentar energia
          this.barBanio.setValue(pet.getNecesidades());
          
        pet.setAburrimiento(pet.getAburrimiento()-inyeccion.getCuracion());//para disminur Hambre
            this.barHambre.setValue(pet.getHambre()); 
    }//GEN-LAST:event_miInyeccionActionPerformed

    private void miPastillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPastillaActionPerformed
        this.miPastilla.setEnabled(false);
        time2.start();
        
        pet.setEnergia(pet.getEnergia()+pastilla.getCuracion());//Para aumentar energia
          this.barEnergia.setValue(pet.getEnergia());
          
        pet.setHambre(pet.getHambre()-pastilla.getCuracion());//para disminur Hambre
           this.barHambre.setValue(pet.getHambre());
           
        pet.setNecesidades(pet.getNecesidades()-pastilla.getCuracion());//Para aumentar energia
          this.barBanio.setValue(pet.getNecesidades());
          
        pet.setAburrimiento(pet.getAburrimiento()-pastilla.getCuracion());//para disminur Hambre
            this.barHambre.setValue(pet.getHambre()); 
    }//GEN-LAST:event_miPastillaActionPerformed

    private void btnDormirMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDormirMouseReleased
           
    }//GEN-LAST:event_btnDormirMouseReleased

    private void btnDormirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDormirMousePressed
      
    }//GEN-LAST:event_btnDormirMousePressed

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
    private javax.swing.JButton btnBanio;
    private javax.swing.JButton btnDormir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel lblAburrimiento;
    private javax.swing.JLabel lblBanio;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblEnergia;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblEtapa;
    private javax.swing.JLabel lblHambre;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSalud;
    private javax.swing.JLabel lblSalud1;
    private javax.swing.JLabel lblSalud2;
    private javax.swing.JLabel lblSalud3;
    private javax.swing.JMenu mActividades;
    private javax.swing.JMenu mAlimentos;
    private javax.swing.JMenuItem miCarne;
    private javax.swing.JMenuItem miConsentrado;
    private javax.swing.JMenuItem miCorrer;
    private javax.swing.JMenuItem miEscondite;
    private javax.swing.JMenuItem miExcavar;
    private javax.swing.JMenuItem miFutbol;
    private javax.swing.JMenuItem miGalletas;
    private javax.swing.JMenuItem miHueso;
    private javax.swing.JMenuItem miInyeccion;
    private javax.swing.JMenuItem miLechuga;
    private javax.swing.JMenu miMedicina;
    private javax.swing.JMenuItem miPasear;
    private javax.swing.JMenuItem miPastilla;
    // End of variables declaration//GEN-END:variables
}
