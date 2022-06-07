package com.lawknow.userWrite;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lawknow.domain.dao.UserDAO;
import com.lawknow.domain.dao.UserWriteDAO;
import com.lawknow.domain.vo.UserVO;
import com.lawknow.domain.vo.UserWriteVO;
import com.lawyer.action.Action;
import com.lawyer.action.ActionInfo;

public class CatagoryTwoOk implements Action{

	@Override
	public ActionInfo execute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		ActionInfo actionInfo = new ActionInfo();
		
		UserVO userVO = new UserVO();
		UserWriteVO userWriteVO = new  UserWriteVO();
		
		UserDAO userDAO = new UserDAO();
		UserWriteDAO userWriteDAO = new UserWriteDAO();
		
		
		
		req.setAttribute("catagoryOne",userWriteDAO.selectField("성범죄"));
		System.out.println(userWriteDAO.selectField("성범죄"));
		
		actionInfo.setRedirect(false);
		actionInfo.setPath("/category3.jsp");
		
		return actionInfo;
	
	}

}
