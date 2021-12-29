package com.billing.multipay.model.marketing.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 批次类型
 *
 * @author yujam
 */
@Getter
@AllArgsConstructor
public enum CouponCodeModeEnum {
	/**
	 * 系统分配券code。（固定22位纯数字）
	 */
	WECHATPAY_MODE("WECHATPAY_MODE"),
	/**
	 * 商户发放时接口指定券code
	 */
	MERCHANT_API("MERCHANT_API"),
	/**
	 * 商户上传自定义code，发券时系统随机选取上传的券code
	 */
	MERCHANT_UPLOAD("MERCHANT_UPLOAD");
	/**
	 * 批次类型
	 */
	private final String value;
}
