package poorecurso;

import java.io.Serializable;

public class TrincoEletrico extends Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;

    public TrincoEletrico(String nome) {
        super(nome);
    }

    @Override
    public void ligar() {
        super.ligar();
        System.out.println("Trinco Elétrico " + getNome() + " ligado.");

        // Lógica adicional quando o trinco elétrico é ligado
        ajustarTrincoCompartimento();
    }

    @Override
    public void desligar() {
        super.desligar();
        System.out.println("Trinco Elétrico " + getNome() + " desligado.");

        // Lógica adicional quando o trinco elétrico é desligado
        ajustarTrincoCompartimento();
    }

    private void ajustarTrincoCompartimento() {
        Compartimento compartimento = getCompartimento();
        if (compartimento != null) {
            for (Equipamento equipamento : compartimento.getEquipamentos()) {
                if (equipamento instanceof DetetorFecho) {
                    DetetorFecho sensorFecho = (DetetorFecho) equipamento;
                    // Atualizar ou ajustar o estado do trinco com base na lógica específica
                    System.out.println("Sensor de Fecho " + sensorFecho.getNome() + " ajustado.");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "TrincoEletrico{" +
                "nome='" + getNome() + '\'' +
                ", ligado=" + isLigado() +
                '}';
    }
}
