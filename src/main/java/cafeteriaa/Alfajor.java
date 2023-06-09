package cafeteriaa;

public class Alfajor {
    private String sabor;
    private String tamano;

    private int precio;

    public Alfajor(String sabor, String tamano) {
        this.sabor = sabor;
        this.tamano = tamano;
        this.precio = 1000;
    }
    public String registroCSV(){
        return "Alfajor, "+this.sabor+","+this.tamano+","+String.valueOf(this.precio)+"\n";
    }
    public String getSabor() {
        return sabor;
    }
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public String getTamano() {
        return tamano;
    }
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "cafeteriaa.Alfajor{" +
                "sabor='" + sabor + '\'' +
                ", tamano='" + tamano + '\'' +
                '}';
    }
}
