package Task;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;





public class TaskServiceTest {
	
	private Task makeTask(String task_id, String taskname, String description) {
		return new Task(task_id, taskname, description);
	
	}

	
	@Test
	void AddTaskSuccessfully() {
		TaskService service = new TaskService();
		Task t1 = makeTask("1001","Organization", "Organize entire office");
		
		assertDoesNotThrow(() -> service.addTask(t1));
		assertNotNull(service.getTask("1001"));
		assertEquals("1001",service.getTask("1001").getTaskID());
		
		
		
	}
	
	
    @Test
    void AddTaskRejectsDuplicateId() {
        TaskService service = new TaskService();
        Task t1 = makeTask("A123", "Cleaning","cleaning office");
        Task t2 = makeTask("A123", "Trash duty", "Trash day take out trash");

        service.addTask(t1);

        assertThrows(IllegalArgumentException.class, () -> service.addTask(t2));
    }
    
    @Test
    void testDeleteTaskSuccessfully() {
        TaskService service = new TaskService();
        Task t1 = new Task("A123", "Cleaning", "Cleaning entire office building");

        service.addTask(t1);
        service.deleteTask("A123");

      
        assertNull(service.getTask("A123"));
    }
    
    @Test
    void addTask_nullTask_throws() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.addTask(null));
    }
    
    @Test
    void deleteTask_idNotFound_throws() {
        TaskService service = new TaskService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("doesNotExist"));
    }
    
    @Test
    void UpdateTaskNameSuccessfully() {
        TaskService service = new TaskService();
        Task t1 = makeTask("A123", "Notes", "Same Description");
        service.addTask(t1);

        service.updateTaskName("A123", "New Name");

        Task updated = service.getTask("A123");
        assertEquals("New Name", updated.getTaskName());
        assertEquals("Same Description", updated.getDescription());
       
    
}
    
    @Test
    void testUpdateDescriptionSuccessfully() {
        TaskService service = new TaskService();
        Task t1 = makeTask("B222", "Notes", "Old Description");
        service.addTask(t1);

        service.updateTaskDescription("B222", "New Description");

        Task updated = service.getTask("B222");
        assertEquals("Notes", updated.getTaskName());
        assertEquals("New Description", updated.getDescription());
    }

    @Test
    void deleteTask_nullId_throws() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask(null));
    }
    
    @Test
    void updateTask_idNotFound_throws() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class,
            () -> service.updateTaskName("NOPE", "New Name"));
    }


    
    
    
}