/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MascotaVirtual;

/**
 *
 * @author Francisco
 */
public enum Estado {
    Normal(1),Enfermo(2);
    
    private int valor;

    private Estado(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    } 
}
