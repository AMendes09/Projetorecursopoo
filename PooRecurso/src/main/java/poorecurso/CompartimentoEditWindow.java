package poorecurso;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CompartimentoEditWindow {

    private String compartimentoNome;
    private ObservableList<String> equipamentos = FXCollections.observableArrayList();

    public CompartimentoEditWindow(String compartimentoNome) {
        this.compartimentoNome = compartimentoNome;
    }

    public void show() {
        Stage editStage = new Stage();
        editStage.setTitle("Editar Compartimento: " + compartimentoNome);

        ListView<String> equipamentosListView = new ListView<>(equipamentos);

        Button createEquipamentoButton = new Button("Criar Equipamento");
        createEquipamentoButton.setOnAction(e -> handleCreateEquipamento());

        VBox vbox = new VBox(10, new Label("Compartimento: " + compartimentoNome), equipamentosListView, createEquipamentoButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);
        editStage.setScene(scene);
        editStage.show();
    }

    private void handleCreateEquipamento() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("Tipo1", "Tipo1", "Tipo2", "Tipo3");
        dialog.setTitle("Criar Equipamento");
        dialog.setHeaderText("Escolha o tipo de equipamento:");
        dialog.setContentText("Tipo:");

        dialog.showAndWait().ifPresent(tipo -> {
            TextInputDialog nameDialog = new TextInputDialog();
            nameDialog.setTitle("Nome do Equipamento");
            nameDialog.setHeaderText("Digite o nome do novo equipamento:");
            nameDialog.setContentText("Nome:");

            nameDialog.showAndWait().ifPresent(nome -> {
                if (nome == null || nome.trim().isEmpty()) {
                    showAlert("Nome inválido", "O nome do equipamento não pode ser nulo ou vazio.");
                } else {
                    equipamentos.add(tipo + ": " + nome);
                }
            });
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
