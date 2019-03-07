package co.edu.uptc.sw2.proyectofinalfotos.entities;

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
