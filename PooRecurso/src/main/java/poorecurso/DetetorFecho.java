package poorecurso;

public class DetetorFecho extends Sensor {
    private boolean fechado;

    public DetetorFecho(String nome) {
        super(nome);
        this.fechado = false; // Inicialmente aberto
    }

    @Override
    public Boolean medir() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }
}
 