package by.malinouski.horserace.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.malinouski.horserace.constant.RequestConsts;
import by.malinouski.horserace.constant.RequestMapKeys;

/**
 * Servlet implementation class PartServlet
 */
@WebServlet("/part")
@MultipartConfig
public class PartServlet extends AbstractServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(PartServlet.class);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
		try {
			requestMap.put(RequestMapKeys.PART, request.getPart(RequestConsts.PART_NAME));
		} catch (IOException e) {
			logger.error("IO error " + e);
		} catch (ServletException e) {
			logger.error("The request is not multipart " + e);
		}
		
		execCommand(request);
	}
	
	

}
