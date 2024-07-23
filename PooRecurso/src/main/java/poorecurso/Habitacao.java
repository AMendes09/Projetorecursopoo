package poorecurso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.Serializable;

public class Habitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    private ObservableList<Compartimento> compartimentos;

    public Habitacao() {
        compartimentos = FXCollections.observableArrayList();
    }

    public ObservableList<Compartimento> getCompartimentos() {
        return compartimentos;
    }

    public void adicionarCompartimento(Compartimento compartimento) {
        if (compartimentos.stream().anyMatch(c -> c.getNome().equals(compartimento.getNome()))) {
            throw new IllegalArgumentException("Compartimento já existente.");
        }
        compartimentos.add(compartimento);
    }

    public void removerCompartimento(Compartimento compartimento) {
        compartimentos.remove(compartimento);
    }
}
