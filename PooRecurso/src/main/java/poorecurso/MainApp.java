package poorecurso;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private ObservableList<String> compartimentos = FXCollections.observableArrayList();
    private ListView<String> compartimentoListView;

    @Override
    public void start(Stage primaryStage) {
        compartimentoListView = new ListView<>(compartimentos);

        Button createCompartimentoButton = new Button("Criar Compartimento");
        createCompartimentoButton.setOnAction(e -> handleCreateCompartimento());

        Button editCompartimentoButton = new Button("Editar Compartimento");
        editCompartimentoButton.setOnAction(e -> handleEditCompartimento());

        VBox vbox = new VBox(10, compartimentoListView, createCompartimentoButton, editCompartimentoButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 300, 250);

        primaryStage.setTitle("Gerenciamento de Compartimentos");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleCreateCompartimento() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Criar Compartimento");
        dialog.setHeaderText("Digite o nome do novo compartimento:");
        dialog.setContentText("Nome:");

        dialog.showAndWait().ifPresent(nome -> {
            if (nome == null || nome.trim().isEmpty()) {
                showAlert("Nome inválido", "O nome do compartimento não pode ser nulo ou vazio.");
            } else if (compartimentos.contains(nome)) {
                showAlert("Compartimento já existe", "Já existe um compartimento com este nome.");
            } else {
                compartimentos.add(nome);
            }
        });
    }

    private void handleEditCompartimento() {
        String selectedCompartimento = compartimentoListView.getSelectionModel().getSelectedItem();
        if (selectedCompartimento == null) {
            showAlert("Nenhum selecionado", "Por favor, selecione um compartimento para editar.");
            return;
        }

        // Cria e mostra a janela de edição do compartimento
        new CompartimentoEditWindow(selectedCompartimento).show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
