/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RealizaMascota;

import Actividad.Mascota.Actividad;
import Actividad.Mascota.Correr;

import MascotaVirtual.Mascota;

/**
 *
 * @author Francisco
 */
public class Accion {
    Mascota pet=new Mascota();
     Actividad co=new Correr();
   
    
     public void CorrerAct(){
     
        pet.setEnergia(pet.getEnergia()-co.getEnergia());
        pet.setAburrimiento(pet.getAburrimiento()-co.getEntretenimiento());

         
       
     
     
    }
    
//    public static void main (String[] args){
//        Accion mascot=new Accion();
//        Correr co=new Correr();
//        mascot.CorrerAct();
//    }
    
}
