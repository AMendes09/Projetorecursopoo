package poorecurso;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GerirCompartimentos {

    private Habitacao habitacao;
    private Stage stage;

    public GerirCompartimentos(Habitacao habitacao) {
        this.habitacao = habitacao;
        this.stage = new Stage();
        inicializarTela();
    }

    private void inicializarTela() {
        VBox root = new VBox(10); // Layout com espaçamento de 10 pixels

        // Criar TextField para adicionar compartimentos
        TextField nomeCompartimentoTextField = new TextField();
        nomeCompartimentoTextField.setPromptText("Nome do Compartimento");

        // Criar ListView para exibir compartimentos
        ListView<Compartimento> compartimentoListView = new ListView<>();
        compartimentoListView.setItems(habitacao.getCompartimentos());

        // Botão para adicionar compartimento
        Button adicionarCompartimentoButton = new Button("Adicionar Compartimento");
        adicionarCompartimentoButton.setOnAction(e -> {
            String nome = nomeCompartimentoTextField.getText();
            if (!nome.isEmpty()) {
                Compartimento novoCompartimento = new Compartimento(nome);
                habitacao.adicionarCompartimento(novoCompartimento);
                compartimentoListView.getItems().add(novoCompartimento);
                nomeCompartimentoTextField.clear();
            }
        });

        // Botão para remover compartimento
        Button removerCompartimentoButton = new Button("Remover Compartimento");
        removerCompartimentoButton.setOnAction(e -> {
            Compartimento selecionado = compartimentoListView.getSelectionModel().getSelectedItem();
            if (selecionado != null) {
                habitacao.removerCompartimento(selecionado);
                compartimentoListView.getItems().remove(selecionado);
            }
        });

        // Adicionar controles ao layout
        root.getChildren().addAll(nomeCompartimentoTextField, adicionarCompartimentoButton, removerCompartimentoButton, compartimentoListView);

        // Configurar a cena e o palco
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Gerir Compartimentos");
    }

    public void show() {
        stage.show();
    }
}
