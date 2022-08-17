/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alimento.Mascota;

/**
 *
 * @author Francisco
 */
public class Alimento {
    private int energia;
    private double tiempo;
    private int satisfaccion;

    public int getEnergia() {
        return energia;
    }

    public double getTiempo() {
        return tiempo;
    }

    public int getSatisfaccion() {
        return satisfaccion;
    }

    public Alimento(int energia, double tiempo, int satisfaccion) {
        this.energia = energia;
        this.tiempo = tiempo;
        this.satisfaccion = satisfaccion;
    }
    
}
