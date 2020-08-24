package com.xiaobai.multi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UrlEncodeUtils {
	/**
	 * ����url���ļ�����
	 * @param path
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String encodeUrl(String path) throws UnsupportedEncodingException{
		// url������ַ�
		String allow = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.~!*'();:@&=+$,/?#[]";
		// �����б�, �洢�����ַ���λ��
		List<Integer> position = new ArrayList<Integer>();
		// ����url�е�ÿ���ַ�,�ҳ������ַ�
		for (int i = 0; i < path.length(); i++) {
			// ��ǰ�ַ�
			char current = path.charAt(i);
			String currentString = String.valueOf(current);
			// ��ǰ�ַ����������ַ���
			if (!allow.contains(currentString)) {
				// ��¼�����ַ���λ��
				position.add(i);
			}
		}
		// ���ݼ�¼��λ��, �洢��Ҫ������ַ��б�, ʹ�ü���ȥ���ظ����ַ�
		Set<String> replaceSet = new HashSet<String>();
		// ���������ַ���λ���б�
		for (int i = 0; i < position.size(); i++) {
			// ȡ����Ҫ�滻���ַ�
			String cuStr = String.valueOf(path.charAt(position.get(i)));
			// ����Ҫ�滻�������ַ�, ����
			replaceSet.add(cuStr);
		}
		// ������Ҫ�滻���ַ�����
		for (String word:replaceSet) {
			// ����Ҫ�滻���ַ�, ���б���, �滻
			path = path.replace(word, URLEncoder.encode(word, "UTF-8"));
		}
		return path;
	}
}
