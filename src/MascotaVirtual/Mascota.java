/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MascotaVirtual;

import Actividad.Mascota.Actividad;
import Actividad.Mascota.Correr;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class Mascota {
    private String nombre;
    private int edad;
    private Etapa etapa;
    private int energia;
    private int hambre;
    private int aburrimiento;
    private int necesidades;
    private int salud;
    private Estado estado;
    public static final int BANIO=100;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
         if (edad >= 0 && edad <= 100) {
            this.edad = edad;
        }
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia >= 0 && energia < 100) {
            this.energia = energia;
        } else if (energia >= 100) {
            this.energia = 100;
        } else if (energia < 0) {
            this.energia = 0;
        }
        
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        if (hambre >= 0 && hambre < 100) {
            this.hambre = hambre;
        } else if (hambre >= 100) {
            this.hambre = 100;
        } else if (hambre < 0) {
            this.hambre = 0;
        }
    }

    public int getAburrimiento() {
        return aburrimiento;
    }

    public void setAburrimiento(int aburrimiento) {
        if (aburrimiento >= 0 && aburrimiento < 100) {
            this.aburrimiento = aburrimiento;
        } else if (aburrimiento >= 100) {
            this.aburrimiento = 100;
        } else if (aburrimiento < 0) {
            this.aburrimiento = 0;
        }
    }

    public int getNecesidades() {
        return necesidades;
    }

    public void setNecesidades(int necesidades) {
        if (necesidades >= 0 && necesidades < 100) {
            this.necesidades = necesidades;
        } else if (necesidades >= 100) {
            this.necesidades = 100;
        } else if (necesidades < 0) {
            this.necesidades = 0;
        }
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        if (salud >= 0 && salud <= 100) {
            this.salud = salud;
        } else if (salud > 100) {
            this.salud = 100;
        } else if (salud < 0) {
            this.salud = 0;
        }
    }
    
    
    public Mascota() {
        edad = 0;
        etapa = Etapa.Huevo;
        estado=Estado.Saludable;
        energia = 50;
        hambre = 50;
        aburrimiento = 50;
        necesidades = 50;
        salud = 50;
        nombre="Tamagotchi";
    }
    public void nombrePet(){
        this.nombre=JOptionPane.showInputDialog(null, " INGRESE EL NOMBRE DE LA MASCOTA","NOMBRE MASCOTA", JOptionPane.QUESTION_MESSAGE);
    }
   
//    public void jugar() {
//         Correr co=new Correr();
//        setEnergia(co.getEnergia());
//        setAburrimiento(getAburrimiento() - co.getEntretenimiento());
//    }
    
    
    
//    public static void main (String[] args){
//        Mascota n=new Mascota();
////       n.setEstado(Estado.Enfermo);
////        n.jugar();
////        n.setEtapa(Etapa.Bebe);
////        n.setNombre("Juan");
////        n.setEtapa(Etapa.Adulto);
//        if (n.getAburrimiento()<90){
//            n.setEstado(Estado.Enfermo);
//            n.getEstado();
//
//        }
//            
//        System.out.println(n.getEstado()+" = "+n.getAburrimiento());
//    }
}
