package com.mercury.finalProject.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.mercury.finalProject.dao.UserDao;
import com.mercury.finalProject.http.AuthenticationSuccessResponse;
import com.mercury.finalProject.http.Response;
import com.mercury.finalProject.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	private List<String> sessions = new ArrayList<String>();
	public static final String COUNTER = "session-counter";

	@Autowired
	private UserDao userDao;
	@Override
	public Response checklogin(Authentication authentication) {
		if (authentication != null) {
			Response response = new AuthenticationSuccessResponse(true, 200, "Logged In!", userDao.findByUsername(authentication.getName()));
			return response;
		} else {
			return new Response(false);
		}
	}
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		HttpSession session = event.getSession();
        sessions.add(session.getId());
        session.setAttribute(AuthServiceImpl.COUNTER, this);
		
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
        sessions.remove(session.getId());
        session.setAttribute(AuthServiceImpl.COUNTER, this);
		
	}
	@Override
	public int getActiveSessionNumber() {
        return sessions.size();
    }

}
