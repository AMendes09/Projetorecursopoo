package poorecurso;

import java.io.Serializable;

public class ArCondicionado extends Equipamento implements Serializable {
    private static final long serialVersionUID = 1L;
    private double temperaturaAjustada;
    private static final double TEMPERATURA_DEFAULT = 22.0; // Temperatura padrão ao ligar
    private static final double TEMPERATURA_MINIMA = 0.0; // Temperatura mínima quando desligado

    public ArCondicionado(String nome) {
        super(nome);
        this.temperaturaAjustada = TEMPERATURA_DEFAULT; // Inicializa com a temperatura padrão
    }

    public double getTemperaturaAjustada() {
        return temperaturaAjustada;
    }

    public void setTemperaturaAjustada(double temperaturaAjustada) {
        this.temperaturaAjustada = temperaturaAjustada;
    }

    @Override
    public void ligar() {
        super.ligar();
        System.out.println("Ar Condicionado " + getNome() + " ligado.");

        // Lógica adicional para quando o ar condicionado é ligado
        ajustarTemperatura(TEMPERATURA_DEFAULT);
        ajustarTemperaturaCompartimento();
    }

    @Override
    public void desligar() {
        super.desligar();
        System.out.println("Ar Condicionado " + getNome() + " desligado.");

        // Lógica adicional para quando o ar condicionado é desligado
        ajustarTemperatura(TEMPERATURA_MINIMA);
        ajustarTemperaturaCompartimento();
    }

    private void ajustarTemperatura(double novaTemperatura) {
        this.temperaturaAjustada = novaTemperatura;
        System.out.println("Temperatura ajustada para " + novaTemperatura + " graus.");
    }

    private void ajustarTemperaturaCompartimento() {
        if (getCompartimento() != null) {
            // Ajusta a temperatura dos sensores de temperatura no compartimento
            for (Equipamento equipamento : getCompartimento().getEquipamentos()) {
                if (equipamento instanceof Termometro) {
                    Termometro termometro = (Termometro) equipamento;
                    termometro.setTemperatura(this.temperaturaAjustada);
                    System.out.println("Temperatura do termômetro " + termometro.getNome() + " ajustada para " + this.temperaturaAjustada + " graus.");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ArCondicionado{" +
                "nome='" + getNome() + '\'' +
                ", temperaturaAjustada=" + temperaturaAjustada +
                ", ligado=" + isLigado() +
                '}';
    }
}
