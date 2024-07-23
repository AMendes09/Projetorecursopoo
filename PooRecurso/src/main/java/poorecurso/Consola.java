package poorecurso;

import java.io.*;
import java.util.*;

public class Consola implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<String, Compartimento> compartimentos;

    public Consola() {
        this.compartimentos = new HashMap<>();
    }

    public void adicionarCompartimento(Compartimento compartimento) {
        if (compartimentos.containsKey(compartimento.getNome())) {
            throw new IllegalArgumentException("Compartimento já existente.");
        }
        compartimentos.put(compartimento.getNome(), compartimento);
    }

    public void removerCompartimento(String nome) {
        compartimentos.remove(nome);
    }

    public Compartimento getCompartimento(String nome) {
        return compartimentos.get(nome);
    }

    public void reset() {
        for (Compartimento compartimento : compartimentos.values()) {
            compartimento.resetEquipamentos();
        }
    }

    public void listarEquipamentos() {
        for (Compartimento compartimento : compartimentos.values()) {
            System.out.println("Compartimento: " + compartimento.getNome());
            for (Equipamento equipamento : compartimento.getEquipamentos()) {
                System.out.println("  Equipamento: " + equipamento.getNome() + " (Ligado: " + equipamento.isLigado() + ")");
            }
        }
    }

    public void salvarParaArquivo(String arquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(this);
        }
    }

    public static Consola carregarDeArquivo(String arquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (Consola) ois.readObject();
        }
    }
}
