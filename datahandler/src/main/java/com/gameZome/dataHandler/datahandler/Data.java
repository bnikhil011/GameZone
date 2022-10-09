package com.gameZome.dataHandler.datahandler;

import java.util.ArrayList;
import java.util.List;

import com.gamezone.models.gamezone_models.Room;
import com.gamezone.models.gamezone_models.User;

public class Data {
	
	private static List<User> users = new ArrayList<User>();
	private static List<Room> rooms = new ArrayList<Room>();
	public static List<User> getUsers() {
		return users;
	}
	public static void setUsers(List<User> users) {
		Data.users = users;
	}
	public static List<Room> getRooms() {
		return rooms;
	}
	public static void setRooms(List<Room> rooms) {
		Data.rooms = rooms;
	}
	
	

}
