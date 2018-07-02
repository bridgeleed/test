package test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.sun.xml.internal.messaging.saaj.soap.StringDataContentHandler;

public class Test {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String string  = "Ìì½ò";
		String str = URLEncoder.encode(string,"utf-8");
		System.out.println("str:"+str);
	    String str2 = URLDecoder.decode(str,"utf-8");
	    System.out.println("str2:"+str2);
	}

}
