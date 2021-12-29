package com.billing.multipay.model.marketing;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 创建代金券批次返回结果对象
 *
 * @author thinsstar
 */
@NoArgsConstructor
@Data
public class FavorStocksCreateResult implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 批次号
   * <p>
   * 微信为每个代金券批次分配的唯一ID。
   * 示例值：98065001
   */
  private String stockId;
}
