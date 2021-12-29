package com.billing.multipay.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

@Slf4j
public class SignUtil {

	public static String sign(Map<String, Object> map, String key,String... ignoreKey) {
		for (String ignore : ignoreKey) {
			map.remove(ignore);
		}
		return sign(map, key);
	}

	private static String sign(Map<String, Object> map, String key) {
		ArrayList<String> list = new ArrayList<>();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (!"".equals(entry.getValue()) && null != entry.getValue()) {
				list.add(entry.getKey() + "=" + entry.getValue() + "&");
			}
		}
		int size = list.size();
		String[] arrayToSort = list.toArray(new String[size]);
		Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append(arrayToSort[i]);
		}
		String result = sb.toString();
		result += "key=" + key;
		log.info("Sign Before MD5:" + result);
		result = DigestUtils.md5DigestAsHex(result.getBytes()).toUpperCase();;
		log.info("Sign Result:" + result);
		return result;
	}


}
