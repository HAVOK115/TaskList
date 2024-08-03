package Controller;

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
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
