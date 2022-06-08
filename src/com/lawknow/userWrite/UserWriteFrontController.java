package com.lawknow.userWrite;
//
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.lawyer.action.ActionInfo;

public class UserWriteFrontController extends HttpServlet{
	
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doProcess(req, resp);
	    }
	    
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       doProcess(req, resp);
	    }

	    protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	       String requestURL = req.getRequestURI();
	       String command = requestURL.substring(requestURL.lastIndexOf("/") + 1);
	       ActionInfo actionInfo = null;
	       
	       if(command.equals("UserWriteOk.uw")) {
	          actionInfo = new UserWriteOk().execute(req, resp);
	          	System.out.println("난 프론트컨트롤러");
	       }
	       else if(command.equals("UserWrite.uw")) { // 글 작성
	    	   actionInfo = new UserWrite().execute(req, resp);
	       }
	       else if(command.equals("UserWriteUpdateOk.uw")) { // 글 수정
	    	  System.out.println("난 업데이트 프론트 컨트롤러");
	          actionInfo = new UserWriteUpdateOk().execute(req, resp);
	       }else if(command.equals("UserWriteUpdate.uw")) {
	    	   actionInfo = new UserWriteUpdate().execute(req, resp);
	       }
	       else if(command.equals("UserWriteDeleteOk.uw")) {// 글 삭제
	    	  System.out.println("난 delete 프론트 컨트롤러");
	          actionInfo = new UserWriteDeleteOk().execute(req, resp);
	       }else if(command.equals("UserWriteDetailOk.uw")) {
	    	   actionInfo = new UserWriteDetailOk().execute(req, resp);
	       }else if(command.equals("UserWriteListsOk.uw")) {
	    	   actionInfo = new UserWriteListsOk().execute(req, resp);
	       }else if(command.equals("FileDownloadOk.uw")) {
	    	   actionInfo = new FileDownloadOk().execute(req, resp);
	       }else if(command.equals("UserAnswerOk.uw")) {
	    	   actionInfo = new UserAnswerOk().execute(req, resp);
	       }else if(command.equals("UserTotalDetailOk.uw")) {
	    	   actionInfo = new UserTotalDetailOk().execute(req, resp);
	       }else if(command.equals("CatagoryOneOk.uw")) {
	    	   actionInfo = new CatagoryOneOk().execute(req, resp);
	       }else if(command.equals("CatagoryTwoOk.uw")) {
	    	   actionInfo = new CatagoryTwoOk().execute(req, resp);
	       }else if(command.equals("CatagoryThreeOk.uw")) {
	    	   actionInfo = new CatagoryThreeOk().execute(req, resp);
	       }else if(command.equals("CatagoryFourOk.uw")) {
	    	   actionInfo = new CatagoryFourOk().execute(req, resp);
	       }else if(command.equals("CatagoryFiveOk.uw")) {
	    	   actionInfo = new CatagoryFiveOk().execute(req, resp);
	       }else if(command.equals("CatagorySixOk.uw")) {
	    	   actionInfo = new CatagorySixOk().execute(req, resp);
	       }else if(command.equals("SelectSeeCountOk.uw")) {
	             actionInfo = new SelectSeeCountOk().execute(req, resp);
	          }else if(command.equals("SelectChoiOk.uw")) {
	             actionInfo = new SelectChoiOk().execute(req, resp);
	          }
	       
	       else {
	          // 404 일 때 출력할 에러 페이지 경로 작성
	       }
	       
	       
	       if(actionInfo != null) { //actionInfo에 어떠한 값이라도 담겨있다면 
	          if(actionInfo.isRedirect()) {
	             resp.sendRedirect(actionInfo.getPath());
	          }else {
	             RequestDispatcher dispatcher = req.getRequestDispatcher(actionInfo.getPath());
	             dispatcher.forward(req, resp);
	          }
	       }
	       
	    }

}
