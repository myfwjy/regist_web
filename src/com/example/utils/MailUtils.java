package com.example.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件发送工具类
 * @author Sherry
 * 
 */
public class MailUtils {
	/**
	 * 发送邮件的方法
	 * 
	 * @param to
	 *            :发送目标
	 * @param code
	 *            :激活码
	 * @throws
	 * @throws Exception
	 */
	public static void sendMail(String to, String code) throws Exception {
		// 创建连接对象，连接到邮件服务器
		Properties props = new Properties();// 可以用来设置主机或者邮件服务器信息等
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@store.com", "111");
			}
		});
		// 创建邮件对象
		Message message = new MimeMessage(session);
		// 设置发件人
		message.setFrom(new InternetAddress("service@store.com"));
		// 设置收件人
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// 设置主题
		message.setSubject("来自xx网站的邮件");
		// 设置邮件的正文
		message.setContent(
				"<h1>来自xx网站的邮件，激活请点击一下链接：</h1><h3><a href='http:///idea-pc:12345/regist_web/ActiveServlet?code="
						+ code
						+ "'>http:///idea-pc:12345/regist_web/ActiveServlet?code="
						+ code + "</a></h3>", "text/html;charset=UTF-8");
		// 发送邮件
		Transport.send(message);
	}
}
