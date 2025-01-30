package to_do_list_java;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class TaskManager {
    public ArrayList< Task> tasks;
    public int nextid;

    public TaskManager (){
        this.tasks= new ArrayList<>();
        this.nextid=1;
    }

    public void addtask(String title, String description ){
        for (Task task :tasks){
            if (task.gettitle().equals(title)){
                System.out.println("la tache existe deja " + title);
            }
        }
        Task task = new Task( nextid,title,description);
        tasks.add(task);
        nextid++;
        System.out.println("tache ajouté avec succes"+ title);

    }

    public void displaytask(){
        if (tasks.isEmpty()){
            System.out.println("aucune tache n'est disponible");
        }
        else{
            System.out.println("--liste des taches--");
        }
        for ( Task task : tasks){
            System.out.println(task);
            System.err.println("-------------");
        }
    }

    public void deletetask(int id){
        for( int i=0 ; i< tasks.size();i++){
            if ( tasks.get(i).getid()== id){
                System.out.println("la tache supprimé est :"+ tasks.get(i).gettitle());
                tasks.remove(i);
                return;
            }
        }
        System.out.println("aucune tache n'est trouvée avec ce id");

    }

    public void markAscompleted(int id){
        for (Task task : tasks){
            if (task.getid()== id){
                task.markAscompleted();
                System.out.println("la tache a ete marqué comme lu avce succes"+ task.gettitle());
                return;
            }
        }
        System.out.println("aucune tache n'est trouvée avec ce id");

    }

    public void savetofile(String filepath){
       try( BufferedWriter bw = new BufferedWriter(new FileWriter ( filepath))){
        for( Task task: tasks){
            bw.write( task.getid() + ";" + task.gettitle() + ";" + task.getdescriptin() +";"+ task.getisCompleted());
            bw.newLine();
        }
        System.out.println("tous les fichiers sont sauvegarder"+ filepath);
       } catch( IOException e){
        System.out.println("les fichiers n'ont pas pu etre sauvegarder" + e);
       }

    }

    public void loadfromfile( String filepath){
        File file = new File(filepath);
        if (!file.exists()){

            System.out.println("Le fichier n'existe pas. Création d'un nouveau fichier : " + filepath);

            try {
                file.createNewFile();

            }
            catch ( IOException e){
                System.err.println(e.getMessage());
                return;
            }

        }


        try( BufferedReader br = new BufferedReader( new FileReader(filepath))){
            String line ;
            while ((line = br.readLine()) != null){
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String description =parts[2];
                //boolean statut = Boolean.parseBoolean(parts[3]);
                Task task = new Task(id, title, description);
                tasks.add(task);
                nextid=Math.max(nextid, id+1);

            }
        }catch( IOException e){
            System.out.println("message d'erreur " + e);
        }
    }

    public void searchtasks( String keyword){
        boolean found = false;
        for (Task task : tasks ){
            if (task.gettitle().toLowerCase().contains(keyword.toLowerCase())|| task.getdescriptin().toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(task);
                found=true;

            }
        }
        if (!found){
            System.out.println("aucune tache trouvée pour cette recherche avec le mot clé :" + keyword);
        }
    }
    public List<Task> getTasks() {
    return tasks;
}

    
}
