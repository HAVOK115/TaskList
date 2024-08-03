package Methods.Controller.Task;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Model.Task;

public class TaskControllerMethods {
	public List<Task> getEndpointResponse(HttpURLConnection con) throws Exception {
		String line = "";
		StringBuffer content = new StringBuffer();

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

		while ((line = br.readLine()) != null) {
			content.append(line);
		}
		br.close();
		con.disconnect();

		List<Task> taskList = stringToJSON(content.toString());
		return taskList;
	}

	// http://localhost:8080/API/v1/tasks/get
	public HttpURLConnection fetchApi(String endpoint) throws Exception {
		URL url = new URL(endpoint);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("Content-Type", "application/json");
		con.setConnectTimeout(5000);
		con.setReadTimeout(5000);
		return con;
	}

	public List<Task> stringToJSON(String res) {
		Gson gson = new Gson();
		Type taskListType = new TypeToken<List<Task>>() {
		}.getType();
		List<Task> taskList = gson.fromJson(res, taskListType);
		return taskList;
	}
}
