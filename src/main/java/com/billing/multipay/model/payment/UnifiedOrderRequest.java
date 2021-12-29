package com.billing.multipay.model.payment;

import com.billing.multipay.model.marketing.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 微信统一下单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnifiedOrderRequest extends BaseRequest implements Serializable {

	private String mchOrderNo;
	private String channelId;
	private String amount;
	private String clientIp;
	private String device;
	private String extra;
	private String attach;
	private String subject;
	private String body;
	private Integer reserve;
	private String sign;
	private String notifyUrl;
	private String userCreid;
	private String userTruename;

}
