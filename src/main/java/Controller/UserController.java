package Controller;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.util.List;

import Methods.Controller.User.UserControllerMethods;
import Model.User;

public class UserController {
	private static UserControllerMethods ucm = new UserControllerMethods();

	public List<User> get() throws Exception {
		HttpURLConnection con = ucm.fetchApi("http://localhost:8080/API/v1/users/get");
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<User> uList = ucm.getEndpointResponse(con);
			return uList;
		} else {
			System.out.println(con.getErrorStream().toString());
			return null;
		}
	}

	public List<User> getByTaskId(int id) throws Exception {
		HttpURLConnection con = ucm.fetchApi("http://localhost:8080/API/v1/users/get?task_id=" + id);
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<User> uList = ucm.getEndpointResponse(con);
			return uList;
		} else {
			System.out.println(con.getErrorStream().toString());
			return null;
		}

	}

	public User getByUserId(int id) throws Exception {
		HttpURLConnection con = ucm.fetchApi("http://localhost:8080/API/v1/users/get?user_id=" + id);
		con.setRequestMethod("GET");

		int status = con.getResponseCode();

		if (status == 200) {
			List<User> uList = ucm.getEndpointResponse(con);

			if (uList.size() == 1) {
				return uList.get(0);
			} else {
				System.out.println(con.getErrorStream().toString());
			}
		}
		return null;
	}

	public void create(User u) throws Exception {
		HttpURLConnection con = ucm.fetchApi("http://localhost:8080/API/v1/users/create");
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");

		String body = "{\"id\": " + u.getId() + ", \"username\": \"" + u.getUsername() + "\", \"mail\": \""
				+ u.getMail() + "\", \"password\": \"" + u.getPassword() + "\"}";
		DataOutputStream os = new DataOutputStream(con.getOutputStream());
		os.writeBytes(body);
		os.flush();
		os.close();

		int status = con.getResponseCode();

		if (status == 200) {
			System.out.println("New user created");
		} else {
			System.out.println(con.getErrorStream().toString());
		}
	}

	public void delete(int id) throws Exception {
		HttpURLConnection con = ucm.fetchApi("http://localhost:8080/API/v1/users/delete?id=" + id);
		con.setRequestMethod("DELETE");

		int status = con.getResponseCode();

		if (status == 200) {
			System.out.println("The user with the id [" + id + "] has been deleted");
		} else {
			System.out.println(con.getErrorStream().toString());
		}
	}
}
