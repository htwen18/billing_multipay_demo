package com.billing.multipay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.billing.multipay.model.payment.UnifiedOrderRequest;
import com.billing.multipay.properties.MultiPayProperties;
import com.billing.multipay.utils.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class Payment {

	@Resource
	private MultiPayProperties multiPayProperties;
	@Resource
	private RestTemplate restTemplate;

	@Test
	public void unifiedorder() {
		UnifiedOrderRequest request = new UnifiedOrderRequest();
		request.setMchOrderNo("123");
		request.setChannelId("WX_JSAPI");
		request.setAmount("1");
		request.setClientIp("127.0.0.1");
		request.setDevice("");
		request.setExtra("{\"openId\":\"oDURg5VpdAulER3tMtmyIUskbTNI\"}");
		request.setAttach("{\"order_type\":10}");
		request.setSubject("subject");
		request.setBody("body");
//		request.setReserve(0);
//		request.setSign("");
//		request.setNotifyUrl("");
//		request.setUserCreid("");
//		request.setUserTruename("");
		request.setMchId(multiPayProperties.getMchId());


		JSONObject jsonObject = (JSONObject) JSON.toJSON(request);

		String sign = SignUtil.sign(jsonObject, multiPayProperties.getResKey(), "sign");
		jsonObject.put("sign", sign);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity(jsonObject.toJSONString(), httpHeaders);
		ResponseEntity<String> response = restTemplate.postForEntity(multiPayProperties.getBaseUrl()+"/billing/wxpay/miniprogrampay/unifiedorder",
				httpEntity, String.class);

		if(response.getStatusCode() == HttpStatus.OK){
			log.info(JSON.toJSONString(response.getBody()));
		}

	}


}
