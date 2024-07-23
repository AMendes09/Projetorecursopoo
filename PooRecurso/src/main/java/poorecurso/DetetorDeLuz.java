package poorecurso;

import java.io.Serializable;

public class DetetorDeLuz extends Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean estado; // True se a luz está acesa, false caso contrário

    public DetetorDeLuz(String nome) {
        super(nome);
        this.estado = false; // Inicialmente a luz está apagada
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetectorLuz{" +
                "nome='" + getNome() + '\'' +
                ", estado=" + estado +
                '}';
    }
}
