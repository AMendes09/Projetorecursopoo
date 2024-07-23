package poorecurso;

import java.io.Serializable;

public class InterruptorLuz extends Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;

    public InterruptorLuz(String nome) {
        super(nome);
    }

    @Override
    public void ligar() {
        super.ligar();
        System.out.println("Interruptor de Luz " + getNome() + " ligado.");

        // Lógica adicional quando o interruptor de luz é ligado
        ajustarLuzCompartimento();
    }

    @Override
    public void desligar() {
        super.desligar();
        System.out.println("Interruptor de Luz " + getNome() + " desligado.");

        // Lógica adicional quando o interruptor de luz é desligado
        ajustarLuzCompartimento();
    }

    private void ajustarLuzCompartimento() {
        Compartimento compartimento = getCompartimento();
        if (compartimento != null) {
            for (Equipamento equipamento : compartimento.getEquipamentos()) {
                if (equipamento instanceof DetetorDeLuz) {
                    DetetorDeLuz detetorLuz = (DetetorDeLuz) equipamento;
                    // Atualizar o estado do detetor de luz
                    if (isLigado()) {
                        detetorLuz.setEstado(true); // Luz está acesa
                        System.out.println("Detetor de Luz " + detetorLuz.getNome() + " atualizado para estado aceso.");
                    } else {
                        detetorLuz.setEstado(false); // Luz está apagada
                        System.out.println("Detetor de Luz " + detetorLuz.getNome() + " atualizado para estado apagado.");
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "InterruptorLuz{" +
                "nome='" + getNome() + '\'' +
                ", ligado=" + isLigado() +
                '}';
    }
}
