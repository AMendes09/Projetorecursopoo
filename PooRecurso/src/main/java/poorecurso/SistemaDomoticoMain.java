package poorecurso;

public class SistemaDomoticoMain {
    public static void main(String[] args) {
        Compartimento sala = new Compartimento("Sala");
        Termometro termometro = new Termometro("Termômetro 1");
        ArCondicionado arCondicionado = new ArCondicionado("Ar Condicionado 1");
        InterruptorLuz interruptorLuz = new InterruptorLuz("Interruptor de Luz 1");
        DetetorDeLuz detetorDeLuz = new DetetorDeLuz("Detetor de Luz 1");

        sala.adicionarEquipamento(termometro);
        sala.adicionarEquipamento(arCondicionado);
        sala.adicionarEquipamento(interruptorLuz);
        sala.adicionarEquipamento(detetorDeLuz);

       

        System.out.println(sala);
    }
}
