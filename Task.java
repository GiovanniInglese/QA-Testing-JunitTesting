package Task;

import java.util.Objects;


public class Task {
    private final String task_id;
	private String task_name;
	private String description;
	
	
	public Task(String task_id, String task_name, String description) {
		this.task_id = validateID(task_id);
		this.task_name = validateName(task_name);
		this.description = validateDES(description);
		
		
	}
	//Getter Methods
	public String getTaskID() {return task_id;}
	public String getTaskName() {return task_name;}
	public String getDescription() {return description;}
	
	//Setter methods
	
    public void setTaskName(String task_name) { this.task_name = validateName(task_name);}
    public void setDescription(String description) {this.description = validateDES(description);}
    
    private static String validateID(String task_id) {
 	   Objects.requireNonNull(task_id, "Task ID must not be null");


    
    	// task_id must not be longer than 10 chars
    	if(task_id.length() > 10) throw new IllegalArgumentException("Task ID must be <= 10 characters");
    	
    	//task id must not be blank or error will throw
    	if(task_id.isBlank()) throw new IllegalArgumentException("Task ID must not be blank");
    	
    	 return task_id;
    	 
    	}
    
    private static String validateName(String task_name) {
	   Objects.requireNonNull(task_name, "Task name must not be null");
	   
	   if(task_name.length() > 20) throw new IllegalArgumentException("Task name must be <= 20 characters");
	   
	   if(task_name.isBlank()) throw new IllegalArgumentException("Task name must not be blank");
	   
	   return task_name;
   }
    
    //Validates description
    private static String validateDES(String description) {
    	Objects.requireNonNull(description, "Description must not be null");
    	
    	if(description.length() >50) throw new IllegalArgumentException("Task description must be 50 chars or less");
    	
    	if(description.isBlank()) throw new IllegalArgumentException("Task description cannot be blank");
    	
    	
    	return description;
    	
    	
    }
   
    	
}



	
	
	
	
	
	
	
	
	
	
	

