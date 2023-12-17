package Model;

public class MiExcepcion extends Exception {
    
    private int codigo;
    
    public MiExcepcion() {}
    
    public MiExcepcion(int codigo) {
        super();
        this.codigo=codigo;
    };    

    public int getCodigo() {
        return codigo;
    }
}
