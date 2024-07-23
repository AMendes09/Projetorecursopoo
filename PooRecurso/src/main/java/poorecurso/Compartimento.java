package poorecurso;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Compartimento implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private Map<String, Equipamento> equipamentos;

    public Compartimento(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("A designação do compartimento não pode ser nula ou vazia.");
        }
        this.nome = nome;
        this.equipamentos = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }
    
    public void adicionarEquipamento(Equipamento equipamento) {
        if (equipamentos.containsKey(equipamento.getNome())) {
            throw new IllegalArgumentException("Equipamento já existente no compartimento.");
        }
        equipamentos.put(equipamento.getNome(), equipamento);
        equipamento.setCompartimento(this); // Associar o equipamento ao compartimento
    }

    public void removerEquipamento(String nome) {
        Equipamento equipamento = equipamentos.remove(nome);
        if (equipamento != null) {
            equipamento.setCompartimento(null); // Remover a associação
        }
    }

    public Equipamento getEquipamento(String nome) {
        return equipamentos.get(nome);
    }

    public Collection<Equipamento> getEquipamentos() {
        return equipamentos.values();
    }

    public void resetEquipamentos() {
        for (Equipamento equipamento : equipamentos.values()) {
            equipamento.desligar();  // Supondo que o valor por omissão é desligado
        }
    }
    
    @Override
    public String toString() {
        return "Compartimento{" +
                "nome='" + nome + '\'' +
                ", equipamentos=" + equipamentos.values() +
                '}';
    }
}
