package com.billing.multipay.model.marketing;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 查询代金券详情结果对象
 *
 * @author thinsstar
 */
@NoArgsConstructor
@Data
public class FavorCouponsGetResult implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 创建批次的商户号
   * <p>
   * 批次创建方商户号
   * 示例值：9800064
   */
  private String stockCreatorMchid;

  /**
   * 批次号
   * <p>
   * 微信为每个代金券批次分配的唯一id。
   * 示例值：9865888
   */
  private String stockId;

  /**
   * 代金券id
   * <p>
   * 微信为代金券唯一分配的id。
   * 示例值：98674556
   */
  private String couponId;

  /**
   * 单品优惠特定信息
   * <p>
   * 单品优惠特定信息
   */
  private CutToMessage cutToMessage;

  /**
   * 代金券名称
   * <p>
   * 代金券名称
   * 示例值：微信支付代金券
   */
  private String couponName;

  /**
   * 代金券状态
   * <p>
   * 代金券状态：
   * SENDED：可用
   * USED：已实扣
   * EXPIRED：已过期
   * 示例值：EXPIRED
   */
  private String status;

  /**
   * 使用说明
   * <p>
   * 代金券描述说明字段。
   * 示例值：微信支付营销
   */
  private String description;

  /**
   * 领券时间
   * <p>
   * 领券时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 示例值: 2015-05-20T13:29:35.120+08:00
   */
  private String createTime;

  /**
   * 券类型
   * <p>
   * 券类型：
   * NORMAL：满减券
   * CUT_TO：减至券
   * 示例值：CUT_TO
   */
  private String couponType;

  /**
   * 是否无资金流
   * <p>
   * 枚举值：
   * true：是
   * false：否
   * 示例值：true
   */
  private Boolean noCash;

  /**
   * 可用开始时间
   * <p>
   * 可用开始时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 示例值: 2015-05-20T13:29:35.120+08:00
   */
  private String availableBeginTime;

  /**
   * 可用结束时间
   * <p>
   * 可用结束时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 示例值: 2015-05-20T13:29:35.120+08:00
   */
  private String availableEndTime;

  /**
   * 是否单品优惠
   * <p>
   * 枚举值：
   * true：是
   * false：否
   * 示例值：true
   */
  private Boolean singleitem;

  /**
   * 满减券信息
   * <p>
   * 普通满减券面额、门槛信息。
   */
  private NormalCouponInformation normalCouponInformation;

  @Data
  @NoArgsConstructor
  public static class CutToMessage implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 可用优惠的商品最高单价
     * <p>
     * 可用优惠的商品最高单价，单位：分。
     * 示例值：100
     */
    private Integer singlePriceMax;

    /**
     * 减至后的优惠单价
     * <p>
     * 减至后的优惠单价，单位：分。
     * 示例值：100
     */
    private Integer cutToPrice;
  }

  @Data
  @NoArgsConstructor
  public static class NormalCouponInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 面额
     * <p>
     * 面额，单位：分。
     * 示例值：100
     */
    private Integer couponAmount;

    /**
     * 门槛
     * <p>
     * 使用券金额门槛，单位：分。
     * 示例值：100
     */
    private Integer transactionMinimum;
  }
}
