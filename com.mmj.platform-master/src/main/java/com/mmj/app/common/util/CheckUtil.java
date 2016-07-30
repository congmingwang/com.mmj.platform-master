package com.mmj.app.common.util;

import java.util.Arrays;

import com.mmj.app.common.security.SHA1;

public class CheckUtil {
	private static final String token = "token1QAZ2wsxKJhlj097KJN";
	
	public static boolean checkSignature(String signature ,String token ,String timestamp ,String nonce){
		//		校验流程如下：
		//		1. 将token、timestamp、nonce三个参数进行字典序排序
		String[] arr = new String[]{token,timestamp,nonce};
		Arrays.sort(arr);
		//		2. 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuffer sb = new StringBuffer();
		for(String s:arr){
			sb.append(s);
		}
		//		3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		String mySignature = SHA1.sha1(sb.toString());
		return signature.equals(mySignature);
	}
}
