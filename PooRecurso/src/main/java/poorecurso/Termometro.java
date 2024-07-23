package poorecurso;

public class Termometro extends Sensor {
    private double temperatura;
    public static final double TEMPERATURA_INICIAL = 25.0;
    public static final double TEMPERATURA_MINIMA = -50.0;
    public static final double TEMPERATURA_MAXIMA = 50.0;

    public Termometro(String nome) {
        super(nome);
        this.temperatura = TEMPERATURA_INICIAL;
    }

    @Override
    public Double medir() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        if (temperatura < TEMPERATURA_MINIMA || temperatura > TEMPERATURA_MAXIMA) {
            throw new IllegalArgumentException("Temperatura fora dos limites permitidos.");
        }
        this.temperatura = temperatura;
    }
}
