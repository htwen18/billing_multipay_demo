package com.billing.multipay.model.marketing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> {
	public String retCode;
	public String retMsg;
	public String resCode;
	public String errCode;
	public String errCodeDes;
	private T data;
}
