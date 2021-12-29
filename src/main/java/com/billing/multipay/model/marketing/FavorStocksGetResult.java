package com.billing.multipay.model.marketing;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 查询批次详情结果对象
 *
 * @author thinsstar
 */
@NoArgsConstructor
@Data
public class FavorStocksGetResult implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 批次号
   * <p>
   * 微信为每个代金券批次分配的唯一id。
   * 示例值：9836588
   */
  private String stockId;

  /**
   * 创建批次的商户号
   * <p>
   * 批次创建方商户号。
   * 示例值：123456
   */
  private String stockCreatorMchid;

  /**
   * 批次名称
   * <p>
   * 批次名称
   * 示例值：微信支付批次
   */
  private String stockName;

  /**
   * 批次状态
   * <p>
   * 批次状态
   * 枚举值：
   * unactivated：未激活
   * audit：审核中
   * running：运行中
   * stoped：已停止
   * paused：暂停发放
   * 示例值：paused
   */
  private String status;

  /**
   * 创建时间
   * <p>
   * 批次创建时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 示例值：2015-05-20T13:29:35.120+08:00
   */
  private String create_time;

  /**
   * 使用说明
   * <p>
   * 批次描述信息
   * 示例值：微信支付营销
   */
  private String description;

  /**
   * 满减券批次使用规则
   * <p>
   * 普通发券批次特定信息。
   * 示例值：1900000109
   */
  private StockUseRule stockUseRule;

  /**
   * 可用开始时间
   * <p>
   * 可用开始时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 示例值：2015-05-20T13:29:35.120+08:00
   */
  private String availableBeginTime;

  /**
   * 可用结束时间
   * <p>
   * 可用结束时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 示例值：2015-05-20T13:29:35.120+08:00
   */
  private String availableEndTime;

  /**
   * 已发券数量
   * <p>
   * 已发券数量
   * 示例值：100
   */
  private Integer distributedCoupons;

  /**
   * 是否无资金流
   * <p>
   * 是否无资金流。
   * ture：是
   * false：否
   * 示例值：true
   */
  private Boolean noCash;

  /**
   * 激活批次的时间
   * <p>
   * 批次激活开启时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 示例值：2015-05-20T13:29:35.120+08:00
   */
  private String startTime;

  /**
   * 终止批次的时间
   * <p>
   * 批次永久停止时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss.sss+TIMEZONE，YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss.sss表示时分秒毫秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35.120+08:00表示，北京时间2015年5月20日 13点29分35秒。
   * 示例值：2015-05-20T13:29:35.120+08:00
   */
  private String stopTime;

  /**
   * 单品优惠特定信息
   * <p>
   * 单品优惠特定信息
   */
  private CutToMessage cutToMessage;

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
   * 批次类型
   * <p>
   * 批次类型， 枚举值：
   * NORMAL：代金券批次
   * DISCOUNT_CUT：立减与折扣
   * OTHER：其他
   * 示例值：NORMAL
   */
  private String stockType;

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
  public static class StockUseRule implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 发放总上限
     * <p>
     * 最大发券数
     * 示例值：100
     */
    private Integer maxCoupons;

    /**
     * 总预算
     * <p>
     * 总消耗金额，单位：分。
     * 示例值：5000
     */
    private Integer maxAmount;

    /**
     * 单天发放上限金额
     * <p>
     * 单天最高消耗金额，单位：分。
     * 示例值：400
     */
    private Integer maxAmountByDay;

    /**
     * 固定面额批次特定信息
     * <p>
     * 固定面额发券批次特定信息。
     */
    private FixedNormalCoupon fixedNormalCoupon;

    /**
     * 单个用户可领个数
     * <p>
     * 单个用户可领个数，每个用户最多100张券
     * 示例值：3
     */
    private Integer maxCouponsPerUser;

    /**
     * 券类型
     * <p>
     * 枚举值：
     * NORMAL：满减券
     * CUT_TO：减至券
     * 示例值：NORMAL
     */
    private String couponType;

    /**
     * 订单优惠标记
     * <p>
     * 订单优惠标记
     * 特殊规则：单个优惠标记的字符长度为【1，128】,条目个数限制为【1，50】。
     * 示例值：{'123456','23456'}
     */
    private List<String> goodsTag;

    /**
     * 支付方式
     * <p>
     * 默认不限制
     * 枚举值：
     * MICROAPP：小程序支付
     * APPPAY：APP支付
     * PPAY：免密支付
     * CARD：付款码支付
     * FACE：人脸支付
     * OTHER：（公众号、扫码等）
     * 示例值：MICROAPP
     */
    private List<String> tradeType;

    /**
     * 是否可叠加其他优惠
     * <p>
     * 枚举值：
     * true：是
     * false：否
     * 示例值：true
     */
    private Boolean combineUse;
  }

  @Data
  @NoArgsConstructor
  public static class FixedNormalCoupon implements Serializable {

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
