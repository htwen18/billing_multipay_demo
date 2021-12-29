package com.billing.multipay.model.marketing;

import com.billing.multipay.model.marketing.busifavor.CouponUseRule;
import com.billing.multipay.model.marketing.busifavor.CustomEntrance;
import com.billing.multipay.model.marketing.busifavor.DisplayPatternInfo;
import com.billing.multipay.model.marketing.busifavor.NotifyConfig;
import com.billing.multipay.model.marketing.busifavor.StockSendRule;
import com.billing.multipay.model.marketing.enums.CouponCodeModeEnum;
import com.billing.multipay.model.marketing.enums.StockTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 创建商家券批次
 * <pre>
 *   文档地址：https://pay.weixin.qq.com/wiki/doc/apiv3/apis/chapter9_2_1.shtml
 * </pre>
 *
 * @author yujam
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusiFavorStocksCreateRequest extends BaseRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * <pre>
   * 字段名：批次名称
   * 变量名：stock_name
   * 是否必填：是
   * 类型：string[1,21]
   * 描述：
   *  批次名称
   *  校验规则：
   *  1、批次名称最多9个中文汉字
   *  2、批次名称最多20个字母
   *  3、批次名称中不能包含不当内容和特殊字符 _ , ; |
   *  示例值：微信支付代金券批次
   * </pre>
   */
  private String stockName;

  /**
   * <pre>
   * 字段名：批次备注
   * 变量名：comment
   * 是否必填：否
   * 类型：string[1,20]
   * 描述：
   *  仅制券商户可见，用于自定义信息。
   *  校验规则：批次备注最多60个UTF8字符数
   *  示例值：零售批次
   * </pre>
   */
  private String comment;

  /**
   * <pre>
   * 字段名：适用商品范围
   * 变量名：goods_name
   * 是否必填：是
   * 类型：string[1,15]
   * 描述：
   *  用来描述批次在哪些商品可用，会显示在微信卡包中。字数上限为15个，一个中文汉字/英文字母/数字均占用一个字数。
   *  示例值：xxx商品使用
   * </pre>
   */
  private String goodsName;

  /**
   * <pre>
   * 字段名：批次类型
   * 变量名：stock_type
   * 是否必填：是
   * 类型：string[1,32]
   * 描述：
   *  批次类型
   *  NORMAL：固定面额满减券批次
   *  DISCOUNT：折扣券批次
   *  EXCHANGE：换购券批次
   *  示例值：NORMAL
   * </pre>
   */
  private StockTypeEnum stockType;

  /**
   * <pre>
   * 字段名：核销规则
   * 变量名：coupon_use_rule
   * 是否必填：是
   * 类型：object
   * 描述：核销规则
   * </pre>
   */
  private CouponUseRule couponUseRule;

  /**
   * <pre>
   *   字段名：券发放相关规则
   *   变量名：stock_send_rule
   *   是否必填：是
   *   类型：object
   *   描述：券发放相关规则
   * </pre>
   */
  private StockSendRule stockSendRule;

  /**
   * <pre>
   *   字段名：自定义入口
   *   变量名：custom_entrance
   *   是否必填：否
   *   类型：object
   *   描述：卡详情页面，可选择多种入口引导用户。
   * </pre>
   */
  private CustomEntrance customEntrance;

  /**
   * <pre>
   *   字段名：样式信息
   *   变量名：display_pattern_info
   *   是否必填：否
   *   类型：object
   *   描述：创建批次时的样式信息。
   * </pre>
   */
  private DisplayPatternInfo displayPatternInfo;

  /**
   * <pre>
   *   字段名：券code模式
   *   变量名：coupon_code_mode
   *   是否必填：是
   *   类型：string[1,128]
   *   描述：枚举值：
   * WECHATPAY_MODE：系统分配券code。（固定22位纯数字）
   * MERCHANT_API：商户发放时接口指定券code。
   * MERCHANT_UPLOAD：商户上传自定义code，发券时系统随机选取上传的券code。
   * </pre>
   */
  private CouponCodeModeEnum couponCodeMode;

  /**
   * <pre>
   *   字段名：事件通知配置
   *   变量名：notify_config
   *   是否必填：否
   *   类型：object
   *   描述：事件回调通知商户的配置
   * </pre>
   */
  private NotifyConfig notifyConfig;

}
