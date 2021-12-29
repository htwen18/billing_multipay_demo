package com.billing.multipay.model.marketing;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 条件查询代金券批次列表结果对象
 *
 * @author thinsstar
 */
@NoArgsConstructor
@Data
public class FavorCouponsQueryResult implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 查询结果总数
   * <p>
   * 查询结果总数
   * 示例值：100
   */
  private Integer totalCount;

  /**
   * 批次详情
   * <p>
   * 批次详情
   */
  private List<FavorCouponsGetResult> data;

  /**
   * 分页大小
   * <p>
   * 分页大小
   * 示例值：10
   */
  private Integer limit;

  /**
   * 分页页码
   * <p>
   * 分页页码
   * 示例值：10
   */
  private Integer offset;
}
