package poorecurso;

import java.io.Serializable;

public class AtuadorEstores extends Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;

    public AtuadorEstores(String nome) {
        super(nome);
    }

    @Override
    public void ligar() {
        super.ligar();
        System.out.println("Atuador de Estores " + getNome() + " ligado.");

        ajustarEstoresCompartimento();
    }

    @Override
    public void desligar() {
        super.desligar();
        System.out.println("Atuador de Estores " + getNome() + " desligado.");
        
        ajustarEstoresCompartimento();
    }

    private void ajustarEstoresCompartimento() {
        Compartimento compartimento = getCompartimento();
        if (compartimento != null) {
            for (Equipamento equipamento : compartimento.getEquipamentos()) {
                if (equipamento instanceof DetetorPosicao) {
                    DetetorPosicao sensorPosicao = (DetetorPosicao) equipamento;
                    
                    System.out.println("Sensor de Posição " + sensorPosicao.getNome() + " ajustado.");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AtuadorEstores{" +
                "nome='" + getNome() + '\'' +
                ", ligado=" + isLigado() +
                '}';
    }
}
