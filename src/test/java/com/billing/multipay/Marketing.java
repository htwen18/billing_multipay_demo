package com.billing.multipay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.billing.multipay.model.marketing.BusiFavorStocksCreateRequest;
import com.billing.multipay.model.marketing.busifavor.CouponAvailableTime;
import com.billing.multipay.model.marketing.busifavor.CouponUseRule;
import com.billing.multipay.model.marketing.busifavor.FixedNormalCoupon;
import com.billing.multipay.model.marketing.busifavor.StockSendRule;
import com.billing.multipay.model.marketing.enums.CouponCodeModeEnum;
import com.billing.multipay.model.marketing.enums.StockTypeEnum;
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
public class Marketing {

	@Resource
	private MultiPayProperties multiPayProperties;
	@Resource
	private RestTemplate restTemplate;


	@Test
	public void create(){
		BusiFavorStocksCreateRequest request = new BusiFavorStocksCreateRequest();
		request.setMchId(multiPayProperties.getMchId());
		request.setStockName("测试券1");
		request.setGoodsName("所有商品");
		request.setStockType(StockTypeEnum.NORMAL);
		CouponUseRule couponUseRule = new CouponUseRule();
		CouponAvailableTime couponAvailableTime = new CouponAvailableTime();
		couponAvailableTime.setAvailableBeginTime("2021-12-28T13:29:35+08:00");
		couponAvailableTime.setAvailableEndTime("2021-12-31T13:29:35+08:00");
//		couponAvailableTime.setAvailableDayAfterReceive(0);
//		couponAvailableTime.setAvailableWeek(new AvailableWeek());
//		couponAvailableTime.setIrregularyAvaliableTime(Lists.newArrayList());
//		couponAvailableTime.setWaitDaysAfterReceive(0);
		couponUseRule.setCouponAvailableTime(couponAvailableTime);
		FixedNormalCoupon fixedNormalCoupon = new FixedNormalCoupon();
		fixedNormalCoupon.setDiscountAmount(500);
		fixedNormalCoupon.setTransactionMinimum(10000);
		couponUseRule.setFixedNormalCoupon(fixedNormalCoupon);
//		couponUseRule.setDiscountCoupon(new DiscountCoupon());
//		couponUseRule.setExchangeCoupon(new ExchangeCoupon());
		couponUseRule.setUseMethod("MINI_PROGRAMS");
		couponUseRule.setMiniProgramsAppid(multiPayProperties.getMiniProgramsAppid());
		couponUseRule.setMiniProgramsPath("pages/home/index");
		request.setCouponUseRule(couponUseRule);
		StockSendRule stockSendRule = new StockSendRule();
		stockSendRule.setMaxCoupons(10);
		stockSendRule.setMaxCouponsPerUser(1);
//		stockSendRule.setMaxCouponsByDay(0);
//		stockSendRule.setNaturalPersonLimit(false);
//		stockSendRule.setPreventApiAbuse(false);
//		stockSendRule.setTransferable(false);
//		stockSendRule.setShareable(false);
		request.setStockSendRule(stockSendRule);
//		request.setCustomEntrance(new CustomEntrance());
//		request.setDisplayPatternInfo(new DisplayPatternInfo());
		request.setCouponCodeMode(CouponCodeModeEnum.WECHATPAY_MODE);
//		request.setNotifyConfig(new NotifyConfig());

		JSONObject jsonObject = (JSONObject)JSON.toJSON(request);

		String sign = SignUtil.sign(jsonObject, multiPayProperties.getResKey(), "sign");
		jsonObject.put("sign", sign);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity httpEntity = new HttpEntity(jsonObject.toJSONString(), httpHeaders);
		ResponseEntity<String> response = restTemplate.postForEntity(multiPayProperties.getBaseUrl()+"/billing/wxpay/marketing/busifavor/stocks",
				httpEntity, String.class);

		if(response.getStatusCode() == HttpStatus.OK){
			log.info(JSON.toJSONString(response.getBody()));
		}

	}

}
