package com.billing.multipay.model.marketing;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 核销事件回调内容
 *
 * @author thinsstar
 */
@NoArgsConstructor
@Data
public class FavorCouponsUseResult implements Serializable {

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
   * 单品优惠特定信息。
   */
  private SingleitemDiscountOff singleitemDiscountOff;

  /**
   * 减至优惠特定信息
   * <p>
   * 减至优惠限定字段，仅减至优惠场景有返回。
   */
  private DiscountTo discountTo;

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
   * 普通满减券信息
   * <p>
   * 普通满减券面额、门槛信息。
   */
  private NormalCouponInformation normalCouponInformation;

  /**
   * 实扣代金券信息
   * <p>
   * 普通满减券面额、门槛信息。
   */
  private ConsumeInformation consumeInformation;

  @Data
  @NoArgsConstructor
  public static class SingleitemDiscountOff implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 单品最高优惠价格
     * <p>
     * 单品最高优惠价格，单位：分。
     * 示例值：100
     */
    private Integer singlePriceMax;
  }

  @Data
  @NoArgsConstructor
  public static class DiscountTo implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 减至后优惠单价
     * <p>
     * 减至后优惠单价，单位：分。
     * 示例值：100
     */
    private Integer cutToPrice;

    /**
     * 最高价格
     * <p>
     * 可享受优惠的最高价格，单位：分。
     * 示例值：20
     */
    private Integer maxPrice;
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

  @Data
  @NoArgsConstructor
  public static class ConsumeInformation implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 核销时间
     * <p>
     * 代金券核销时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
     * 示例值：2015-05-20T13:29:35.120+08:00
     */
    private String consumeTime;

    /**
     * 核销商户号
     * <p>
     * 核销代金券的商户号。
     * 示例值：9856081
     */
    private String consumeMchid;

    /**
     * 核销订单号
     * <p>
     * 核销订单号
     * 示例值：2345234523
     */
    private String transactionId;

    /**
     * 单品信息
     * <p>
     * 商户下单接口传的单品信息。
     */
    private List<GoodsDetail> goodsDetail;
  }

  @Data
  @NoArgsConstructor
  public static class GoodsDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 单品编码
     * <p>
     * 单品券创建时录入的单品编码。
     * 示例值：a_goods1
     */
    private String goodsId;

    /**
     * 单品数量
     * <p>
     * 单品数据
     * 示例值：7
     */
    private Integer quantity;

    /**
     * 单品单价
     * <p>
     * 单品单价
     * 示例值：1
     */
    private Integer price;

    /**
     * 优惠金额
     * <p>
     * 优惠金额
     * 示例值：4
     */
    private Integer discountAmount;
  }
}
