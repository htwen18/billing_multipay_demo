package com.billing.multipay.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "billing.multipay")
@Component
public class MultiPayProperties {

	private String baseUrl;
	private String mchId;
	private String resKey;
	private String miniProgramsAppid;

}
