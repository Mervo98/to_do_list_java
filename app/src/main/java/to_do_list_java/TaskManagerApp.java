package to_do_list_java;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskManagerApp extends Application {


    private TaskManager taskManager = new TaskManager();
    private ObservableList<String> taskList = FXCollections.observableArrayList();
    private ListView<String> listView = new ListView<>(taskList);

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        // Boutons pour ajouter, supprimer et marquer une tâche comme terminée
        Button addButton = new Button("Ajouter une tâche");
        Button deleteButton = new Button("Supprimer");
        Button completeButton = new Button("Marquer comme terminée");

        // Actions des boutons
        addButton.setOnAction(e -> addTask());
        deleteButton.setOnAction(e -> deleteTask());
        completeButton.setOnAction(e -> markTaskAsCompleted());

        // Organisation des éléments
        VBox root = new VBox(10, listView, addButton, deleteButton, completeButton);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Gestionnaire de Tâches");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Méthode pour ajouter une tâche via une boîte de dialogue
    private void addTask() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Nouvelle Tâche");
        dialog.setHeaderText("Ajouter une tâche");
        dialog.setContentText("Entrez le titre de la tâche:");

        dialog.showAndWait().ifPresent(title -> {
            taskManager.addtask(title, " ");; // Ajout avec description vide
            updateTaskList();
        });
    }

    // Méthode pour supprimer une tâche sélectionnée
    private void deleteTask() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            taskManager.deletetask(selectedIndex +1);;
            updateTaskList();
        }
    }

    // Méthode pour marquer une tâche comme terminée
    private void markTaskAsCompleted() {
        int selectedIndex = listView.getSelectionModel().getSelectedIndex();
        if (selectedIndex != -1) {
            taskManager.markAscompleted(selectedIndex+1);;
            updateTaskList();
        }
    }

    // Met à jour la liste des tâches affichées
    private void updateTaskList() {
        taskList.clear();
        for (Task task : taskManager.getTasks()) {
            taskList.add(task.toString());
        }
    }
}
