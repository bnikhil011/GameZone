package com.gameZome.dataHandler.datahandler;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gamezone.models.gamezone_models.Room;
import com.gamezone.models.gamezone_models.User;

@RestController
@RequestMapping("/data")
public class DataController {

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> getUsers()
	{
		return Data.getUsers();
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/users")
	public void setUsers(@RequestBody DataRequest request)
	{
		 Data.setUsers(request.getUsers());
	}
	@RequestMapping(method = RequestMethod.GET, value = "/rooms")
	public List<Room> getRooms()
	{
		return Data.getRooms();
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/rooms")
	public void setRooms(@RequestBody DataRequest request)
	{
		 Data.setRooms(request.getRooms());
	}
}
