package cafeteriaa;

public class Cafe {
    private String gramos;
    private String agua;
    private String tamano;

    private int precio;

    public Cafe(String gramos, String agua, String tamano) {
        this.gramos = gramos;
        this.agua = agua;
        this.tamano = tamano;
        this.precio = 2000;
    }

    public String registroCSV(){
        return "CAFE, "+this.gramos+","+this.agua+","+this.tamano+","+String.valueOf(this.precio)+"\n";
    }
    public int getPrecio() {
        return precio;
    }

    public String getGramos() {
        return gramos + "gm";
    }
    public String getAgua() {
        return agua + "ml";
    }
    public String getTamano() {
        return tamano;
    }
    public void setGramos(String gramos) {
        this.gramos = gramos;
    }
    public void setAgua(String agua) {
        this.agua = agua;
    }
    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "cafeteriaa.Cafe{" +
                "gramos=" + gramos + " gm" +
                ", agua=" + agua + " ml" +
                ", tamano='" + tamano + '\'' +
                '}';
    }

}