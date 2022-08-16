/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilspet;

/**
 *
 * @author Francisco
 */
public class Tiempo {
    private int segundos;
    private int minutos;
    private int horas;

    public int getHoras() {
        return horas;
    }

    public int getSegundos() {
        return segundos;
    }

    public int getMinutos() {
        return minutos;
    }

    public Tiempo() {
        this.segundos=0;
        this.minutos=0;
        this.horas=0;
    }
    
    public  void contar(){
        this.segundos++;
        if(this.segundos==60){
            this.minutos++;
            this.segundos=0;
            if(minutos==60){
                this.horas++;
                this.minutos=0;
            }
            
        }
    }
    public void reiniciar(){
        this.segundos=0;
        this.minutos=0;
        this.horas=0;
    }

    @Override
    public String toString() {
        
        return horas + ":" + minutos + ":" +segundos;
    }
    
}
