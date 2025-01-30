package to_do_list_java;
import java.util.Scanner;
public class Main {

    public static void main(String[] args ){
        TaskManager taskManager1 =new TaskManager();
        try (Scanner scanner = new Scanner(System.in)) {
            String filepath ="text";
            boolean running = true;

            taskManager1.loadfromfile(filepath);
            while (running){
                System.out.println("\n=== Gestionnaire de Tâches ===");
                System.out.println("1. Ajouter une tâche");
                System.out.println("2. Afficher les tâches");
                System.out.println("3. Marquer une tâche comme terminée");
                System.out.println("4. Supprimer une tâche");
                System.out.println("5. Rechercher une tâche");
                System.out.println("6. Sauvegarder les tâches");
                System.out.println("7. chargement du fichier");
                System.out.println("8. Quitter");
                System.out.print("Choisissez une option : ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice){
                    case 1 -> {
                        System.out.println("titre :");
                        String title = scanner.nextLine();
                        System.out.println("description");
                        String description = scanner.nextLine();
                        taskManager1.addtask(title, description);

                    }
                     case 2 -> {
                        taskManager1.displaytask();
                     }
                     case 3 ->{
                        System.out.print("Entrez l'ID de la tâche à marquer comme terminée : ");
                        int id = scanner.nextInt();
                        taskManager1.markAscompleted(id);
                     }
                     case 4 -> {
                        System.out.println("entrer le numero de id");
                        int id = scanner.nextInt();
                        taskManager1.deletetask(id);
                     }
                     case 5 ->{
                        System.out.print("Entrez un mot-clé pour rechercher une tâche : ");
                        String keyword = scanner.nextLine();
                        taskManager1.searchtasks(keyword);
                     }
                     case 6 -> {
                        System.out.print("Sauvegarder les tâches dans le fichier (nom du fichier) : ");
                        String saveFilePath = scanner.nextLine();
                        taskManager1.savetofile(saveFilePath);
                    }
                    case 7 ->{
                        System.out.println("chargement des fichier depuis : " + filepath);
                        String loadfile = scanner.nextLine();
                        taskManager1.loadfromfile(loadfile);
                    }
                

                    case 8-> {
                        System.out.println("Enregistrement des tâches et sortie..."+ filepath);
                        taskManager1.savetofile(filepath);
                        running = false;
                    }
                    default -> System.out.println("aucune option n'est valide");
                }
                

            }
        }
    }
}
