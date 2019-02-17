/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uptc.sw2.proyectofinalfotos.entities;

/**
 *
 * @author Karol Alfonso
 */
public enum EnumStatus {
    IN_PROCESS("En Proceso"), AVAILABLE("Disponible");

    private String status;

    private EnumStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
