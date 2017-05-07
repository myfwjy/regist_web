package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.domain.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.UUIDUtils;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// �������ݣ�
			// ������������
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			// ��װ����
			User user = new User();
			user.setUserName(username);
			user.setPassword(password);
			user.setNickname(nickname);
			user.setEmail(email);
			user.setState(0); // 0��δ���� 1���Ѿ�����
			String code = UUIDUtils.getUUID() + UUIDUtils.getUUID();
			user.setCode(code);
			// ����ҵ��㴦������
			UserService service = new UserServiceImpl();
			service.regist(user);
			// ҳ����ת
			request.setAttribute("msg", "����ע��ɹ�����ȥ���伤�"); 
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
