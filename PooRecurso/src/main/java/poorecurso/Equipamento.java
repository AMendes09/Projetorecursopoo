package poorecurso;

import java.io.Serializable;

public abstract class Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private boolean ligado;
    private Compartimento compartimento; // Referência ao compartimento

    public Equipamento(String nome) {
        this.nome = nome;
        this.ligado = false;
    }

    public String getNome() {
        return nome;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void ligar() {
        this.ligado = true;
    }

    public void desligar() {
        this.ligado = false;
    }

    public Compartimento getCompartimento() {
        return compartimento;
    }

    public void setCompartimento(Compartimento compartimento) {
        this.compartimento = compartimento;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "nome='" + nome + '\'' +
                ", ligado=" + ligado +
                '}';
    }
}
