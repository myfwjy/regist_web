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
 * �ʼ����͹�����
 * @author Sherry
 * 
 */
public class MailUtils {
	/**
	 * �����ʼ��ķ���
	 * 
	 * @param to
	 *            :����Ŀ��
	 * @param code
	 *            :������
	 * @throws
	 * @throws Exception
	 */
	public static void sendMail(String to, String code) throws Exception {
		// �������Ӷ������ӵ��ʼ�������
		Properties props = new Properties();// ���������������������ʼ���������Ϣ��
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@store.com", "111");
			}
		});
		// �����ʼ�����
		Message message = new MimeMessage(session);
		// ���÷�����
		message.setFrom(new InternetAddress("service@store.com"));
		// �����ռ���
		message.setRecipient(RecipientType.TO, new InternetAddress(to));
		// ��������
		message.setSubject("����xx��վ���ʼ�");
		// �����ʼ�������
		message.setContent(
				"<h1>����xx��վ���ʼ�����������һ�����ӣ�</h1><h3><a href='http:///idea-pc:12345/regist_web/ActiveServlet?code="
						+ code
						+ "'>http:///idea-pc:12345/regist_web/ActiveServlet?code="
						+ code + "</a></h3>", "text/html;charset=UTF-8");
		// �����ʼ�
		Transport.send(message);
	}
}
