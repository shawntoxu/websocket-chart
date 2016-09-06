package com.test.websocket;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/hello")
public class TestEndpoint {
		@OnMessage
	    public void hello(String message) {
	        System.out.println("Received : "+ message);
//	    	System.out.println(session.getUserProperties().get("javax.websocket.endpoint.remoteAddress"));
	        
	        //return message;
	        
	    }
	 
	    @OnOpen
	    public void myOnOpen(Session session) {
	        String sid = session.getId() ;
	        SessionUtil.put(sid, session);
	        System.out.println("WebSocket opened: " + session.getId());
	        //test 
	        TestSendToClient.doTest();
	        
	    }
	 
	    @OnClose
	    public void myOnClose(CloseReason reason,Session session) {
	        System.out.println("Closing a WebSocket sessionID="+session.getId()+",due to " + reason.getReasonPhrase());
	        String sid = session.getId() ;
//	        SessionUtil.put(sid, session);
	        SessionUtil.remove(sid);
	    }
	 
	    

}
