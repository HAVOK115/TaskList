package Controller;

import java.net.HttpURLConnection;
import java.util.List;

import Methods.Controller.Task.TaskControllerMethods;
import Model.Task;

public class TaskController {
	private static TaskControllerMethods tcm = new TaskControllerMethods();

	public List<Task> get() throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/get");
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<Task> tList = tcm.getEndpointResponse(con);
			System.out.println(tList);
			return tList;
		} else {
			System.out.println(con.getErrorStream().toString());
			return null;
		}
	}

	public List<Task> getByUserId(int id) throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/get?user_id=" + id);
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<Task> tList = tcm.getEndpointResponse(con);
			System.out.println(tList);
			return tList;
		} else {
			System.out.println(con.getErrorStream().toString());
			return null;
		}
	}

	public Task getByTaskId(int id) throws Exception {
		HttpURLConnection con = tcm.fetchApi("http://localhost:8080/API/v1/tasks/get?task_id=" + id);
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<Task> tList = tcm.getEndpointResponse(con);
			if (tList.size() == 1) {
				System.out.println(tList.get(0));
				return tList.get(0);
			} else {
				System.out.println(con.getErrorStream().toString());
			}
		}
		return null;
	}
}