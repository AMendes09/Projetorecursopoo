package poorecurso;

public class DetetorPosicao extends Sensor {
    private PosicaoEstores posicao;

    public DetetorPosicao(String nome) {
        super(nome);
        this.posicao = PosicaoEstores.ABERTO; // Inicialmente aberto
    }

    @Override
    public PosicaoEstores medir() {
        return posicao;
    }

    public void setPosicao(PosicaoEstores posicao) {
        this.posicao = posicao;
    }
}
