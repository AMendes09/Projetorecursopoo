package poorecurso;

public abstract class Atuador extends Equipamento {
    public Atuador(String nome) {
        super(nome);
    }

    public abstract void atuar(Compartimento compartimento);
}
