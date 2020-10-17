package model;

public class Smoothie {

    private String type = "Smoothie";
    String id;
    String producto;
    String hora;
    String ip;

    public Smoothie() {
    }

    public Smoothie(String producto, String hora, String id, String ip) {
        this.producto = producto;
        this.id = id;
        this.hora = hora;
        this.ip = ip;

    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}

