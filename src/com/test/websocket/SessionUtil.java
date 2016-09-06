package com.test.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;

public class SessionUtil {
	public static Map<String, Session> clients = new ConcurrentHashMap<>(); 
	
	public static void put(String sid,Session s){
		clients.put(sid, s);
	}
	
	public static Session get(String sid){
		return clients.get(sid);
	}
	
	public static void remove(String sid){
		clients.remove(sid);
	}
	
	public static boolean hasConnection(String sid){
		return clients.containsKey(sid);
	}
	
}
