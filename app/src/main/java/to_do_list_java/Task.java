package to_do_list_java;
public class Task{
    private int id;
    private String title;
    private String description;
    private boolean isCompleted ;

    public Task (int id ,String title, String description){
        this.id=id;
        this.title=title;
        this.description= description;
        this.isCompleted=false;

    }
    public void markAscompleted(){
        this.isCompleted=true;
    }
    public int  getid(){
        return id;
    }
    public String gettitle(){
        return title;
    }
    public String getdescriptin(){
        return description;
    }
    public boolean getisCompleted(){
        return isCompleted;
    }
    @Override
    public String toString(){
        return "id ="+ id + "\n" + "title= "+ title+ "\n"+ "description ="+ description + "\n"+ "statut =" + (isCompleted ? "terminé" : "non terminé");
    }


}