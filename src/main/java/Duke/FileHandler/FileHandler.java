package Duke.FileHandler;
import Duke.DukeException;
import Duke.Task.Deadline;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.Task.Todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class FileHandler {
    public static final String emptyplaceholder = "   ";
    private File file;
    private String name;
    private String dir;
    private int task_count;
    
    public FileHandler(String name, String dir){
        this.name=name;
        this.dir=dir;
        createFile();
    }
    
    public void createFile(){
        try{
            file=new File(dir);
            file.getParentFile().mkdirs();
            if(file.createNewFile()){
                System.out.println("File created: "+file.getName());
            } else{
                System.out.println("File already exists");
            }
        } catch(IOException e){
            System.out.println("Error:");
            e.printStackTrace();
        }
    }

    public void getInfo(){
        if(file.exists()) {
            System.out.println("File name: " + file.getName());
            System.out.println("Absolute path: " + file.getAbsolutePath());
        } else{
            System.out.println("File does not exist");
        }
    }

    public void readFile(ArrayList<Task> tasks) throws FileNotFoundException, DukeException {
        Scanner s= new Scanner(file);
        while(s.hasNext()) {
            Task t;
            String entry = s.nextLine();
            String[] entry_words = entry.split("\\|");
            switch (entry_words[0]) {
            case "T":
                t = new Todo(entry_words[2]);
                tasks.add(t);
                break;
            case "D":
                t = new Deadline(entry_words[2], emptyplaceholder +entry_words[3]);
                tasks.add(t);
                break;
            case "E":
                t = new Event(entry_words[2], emptyplaceholder+entry_words[3]);
                tasks.add(t);
                break;
            }
            if (entry_words[1].equals("1")) {
                tasks.get(task_count).isDone(true);
            }
            task_count++;
        }
        System.out.println("File Read");

    }
    public int getTask_count(){
        return task_count;
    }

    public void updateFile(ArrayList<Task> tasks) throws IOException {
        String line = new String();
        FileWriter fw=new FileWriter(file);
        for(Task t: tasks){
            if(t instanceof Todo){
                line+="T|"+ (t.checkDone()?1:0)+"|"+t.getDesc();
            }else if(t instanceof  Deadline){
                line+="D|"+ (t.checkDone()?1:0)+"|"+t.getDesc()+"|"+((Deadline) t).getTime();
            }else if(t instanceof Event){
                line+="E|"+ (t.checkDone()?1:0)+"|"+t.getDesc()+"|"+ ((Event) t).getTime();
            }
            line+=System.lineSeparator();
        }
        fw.write(line);
        fw.close();

    }

}
