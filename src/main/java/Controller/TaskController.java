package Controller;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import Methods.Controller.Task.TaskControllerMethods;
import Model.Task;

public class TaskController {
	private static TaskControllerMethods tcm = new TaskControllerMethods();

	public List<Task> get() throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/get");
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<Task> tList = tcm.getResponseData(con);
			System.out.println(tList);
			return tList;
		} else {
			System.out.println(con.getErrorStream().toString());
			return null;
		}
	}

	public List<Task> getByUserId(int id) throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/get?userId=" + id);
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<Task> tList = tcm.getResponseData(con);
			System.out.println(tList);
			return tList;
		} else {
			System.out.println(con.getErrorStream().toString());
			return null;
		}
	}

	public Task getByTaskId(int id) throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/get?taskId=" + id);
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<Task> tList = tcm.getResponseData(con);
			if (tList.size() == 1) {
				System.out.println(tList.get(0));
				return tList.get(0);
			} else {
				if(con.getErrorStream() != null) {
					System.out.println(con.getErrorStream().toString());
				}else {
					System.out.println("ERROR");
				}
			}
		}
		return null;
	}

	public void create(Task t) throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/create");
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");

		String body = "{\"task_id\": " + t.getTask_id() + ", \"user_id\": " + t.getUser_id() + ", \"content\": \""
				+ t.getContent() + "\"}";
		DataOutputStream os = new DataOutputStream(con.getOutputStream());
		os.writeBytes(body);
		os.flush();
		os.close();

		int status = con.getResponseCode();

		if (status == 200) {
			System.out.println(body);
		} else {
			System.out.println(con.getErrorStream().toString());
		}
	}

	public void deleteByTaskId(int id) throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/delete?taskId=" + id);
		con.setRequestMethod("DELETE");

		int status = con.getResponseCode();

		if (status == 200) {
			System.out.println("Task with the task id[" + id + "] has been deleted");
		} else {
			System.out.println(con.getErrorStream().toString());
		}
	}

	public void deleteByUserId(int id) throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/delete?userId=" + id);
		con.setRequestMethod("DELETE");

		int status = con.getResponseCode();

		if (status == 200) {
			System.out.println("All tasks with the user id[" + id + "] has been deleted");
		} else {
			System.out.println(con.getErrorStream().toString());
		}
	}
	
	public void deleteMany(List<Task> list) throws Exception{
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/delete?list=" + list);
		con.setRequestMethod("DELETE");
		
		int status = con.getResponseCode();
		
		if(status == 200) {
			System.out.println("SELECTED TASKS DELETED");
		}else {
			con.getErrorStream().toString();
		}
	}
}