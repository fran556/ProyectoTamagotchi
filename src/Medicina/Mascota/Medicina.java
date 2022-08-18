/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Medicina.Mascota;

/**
 *
 * @author Francisco
 */
public class Medicina {
    private int curacion;
    private double tiempo;

    public int getCuracion() {
        return curacion;
    }

    public double getTiempo() {
        return tiempo;
    }

    public Medicina(int curacion) {
        this.curacion = curacion;
        this.tiempo = 10;
    }
}
