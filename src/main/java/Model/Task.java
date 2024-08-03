package Model;

public class Task {
	private Integer task_id;
	private Integer user_id;
	private String content;
	
	public Task(Integer task_id, Integer user_id, String content) {
		super();
		this.task_id = task_id;
		this.user_id = user_id;
		this.content = content;
	}

	public Task() {
		super();
	}

	public Integer getTask_id() {
		return task_id;
	}

	public void setTask_id(Integer task_id) {
		this.task_id = task_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", user_id=" + user_id + ", content=" + content + "]";
	}
	
	
}