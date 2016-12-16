package aitipachong.xdp.session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

/**
 * Token(����)������
 * @author Lai.Qiang
 *
 */
public class TokenProccessor {

	/**
	 * �������ģʽ����֤��Ķ������ڴ���ֻҪһ����
	 * 1.����Ĺ��캯��˽��
	 * 2.�Լ�����һ����Ķ���
	 * 3.�����ṩһ�������ķ�����������Ķ���
	 */
	private TokenProccessor() {	}
	
	private static final TokenProccessor instance = new TokenProccessor();
	
	/**
	 * ������Ķ���
	 * @return
	 */
	public static TokenProccessor getInstance() {
		return instance;
	}
	
	/**
	 * ����Token
	 * @return
	 */
	public String makeToken() {
		String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
		//����ָ��   128λ��   16���ֽ�   md5
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte md5[] = md.digest(token.getBytes());
			//base64���� -- ��������Ʊ��������ַ�
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);
		} catch(NoSuchAlgorithmException ex) {
			throw new RuntimeException(ex);
		}
	}
}