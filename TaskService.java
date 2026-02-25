package Task;
import java.util.HashMap;
import java.util.Map;



public class TaskService {
	private final Map<String, Task> tasks = new HashMap<>();
	
	
	public void  addTask(Task task) {
		
		if(task == null) throw new IllegalArgumentException("Task must not be null");
		
		String id = task.getTaskID();
		
		if(tasks.containsKey(id)) {
			
			throw new IllegalArgumentException("Task ID already exists: " + id);
			
		}
		tasks.put(id, task);
		
		
		
		
		
		
		
	}
	
	public void deleteTask(String task_id) {
		if(task_id == null) throw new IllegalArgumentException("Task ID must not be null");
		
		if(!tasks.containsKey(task_id)){
			throw new IllegalArgumentException("No task found with ID: "+ task_id);
			
		}
		tasks.remove(task_id);
		
	}
	
	
	public void updateTask(String task_id, String task_name, String description) {
		if(task_id == null) throw new IllegalArgumentException("Task IDmust not be null");
		
		Task task =tasks.get(task_id);
		if (task == null) {
			throw new IllegalArgumentException("No task found with task ID:"+ task_id);
		}
		if(task_name != null) task.setTaskName(task_name);
		if(description != null) task.setDescription(description);
		

		
	}
	 public void updateTaskName(String task_id, String task_name) {
	        updateTask(task_id, task_name, null);
	    }

	 public void updateTaskDescription(String task_id, String description) {
	        updateTask(task_id, null, description);
	    }
	
	 //Helpful for testing
	 public Task getTask(String task_id) {
		    return tasks.get(task_id);
		}


}
