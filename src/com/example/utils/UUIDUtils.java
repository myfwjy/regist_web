package com.example.utils;

import java.util.UUID;

/**
 * ��������ַ����Ĺ�����
 * 
 * @author Sherry
 * 
 */
public class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
