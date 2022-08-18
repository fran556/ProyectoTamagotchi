/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MascotaVirtual;

/**
 *
 * @author Francisco
 */
public enum Etapa {
    
    Huevo(1),Bebe(2),Joven(3),Adulto(4);
    
    private int valor;

    private Etapa(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }  
}
