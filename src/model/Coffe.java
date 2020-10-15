package model;

public class Coffe {
	
	private String type = "Coffe";
    String id;
    String producto;
    String hora;

    public Coffe() {
    }

    public Coffe(String producto, String hora, String id) {
        this.producto = producto;
        this.id = id;
        this.hora = hora;

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
