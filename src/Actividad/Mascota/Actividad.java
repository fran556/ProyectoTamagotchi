/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad.Mascota;

/**
 *
 * @author Francisco
 */

public class Actividad {
    private int energia;
    private int entretenimiento;
/*
clase que obtiene la energia y entretenimiento de las actividades realizadas
*/
    public int getEnergia() {
        return energia;
    }

    public int getEntretenimiento() {
        return entretenimiento;
    }
    public Actividad(){
        
    }
    public Actividad(int energia, int entretenimiento) {//constructor
        this.energia = energia;
        this.entretenimiento = entretenimiento;
    }
}
