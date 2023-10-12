/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

/**
 *
 * @author Administrador
 */
public class Divisas {
    private String nombre;
    private double tasaConversión;

    public Divisas(String nombre, double tasaConversión) {
        this.nombre = nombre;
        this.tasaConversión = tasaConversión;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTasaConversión() {
        return tasaConversión;
    }

    public void setTasaConversión(double tasaConversión) {
        this.tasaConversión = tasaConversión;
    }
    
}
