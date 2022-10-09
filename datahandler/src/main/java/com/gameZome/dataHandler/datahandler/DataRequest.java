package com.gameZome.dataHandler.datahandler;

import java.util.List;

import com.gamezone.models.gamezone_models.Room;
import com.gamezone.models.gamezone_models.User;

public class DataRequest {
	private List<User> users;
	private List<Room>rooms;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Room> getRooms() {
		return rooms;
	}
	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	

}
