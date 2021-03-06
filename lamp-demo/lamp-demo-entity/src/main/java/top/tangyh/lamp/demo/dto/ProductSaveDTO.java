package top.tangyh.lamp.demo.dto;

import top.tangyh.basic.annotation.echo.Echo;
import top.tangyh.basic.model.RemoteData;
import top.tangyh.lamp.common.constant.DictionaryType;
import top.tangyh.lamp.demo.enumeration.ProductType;
import top.tangyh.lamp.demo.enumeration.ProductType2Enum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static top.tangyh.lamp.common.constant.EchoConstants.DICTIONARY_ITEM_FEIGN_CLASS;
import static top.tangyh.lamp.common.constant.EchoConstants.ORG_ID_FEIGN_CLASS;
import static top.tangyh.lamp.common.constant.EchoConstants.USER_ID_FEIGN_CLASS;

/**
 * <p>
 * 实体类
 * 商品
 * </p>
 *
 * @author zuihou
 * @since 2020-12-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "ProductSaveDTO", description = "商品")
public class ProductSaveDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Size(max = 24, message = "名称长度不能超过24")
    private String name;
    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    private Integer stock;
    /**
     * 商品类型
     * #ProductType{ordinary:普通;gift:赠品}
     */
    @ApiModelProperty(value = "商品类型")
    private ProductType type;
    /**
     * 商品类型2
     * #{ordinary:普通;gift:赠品;}
     */
    @ApiModelProperty(value = "商品类型2")
    private ProductType2Enum type2;
    /**
     * 学历
     *
     * @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, dictType = DictionaryType.EDUCATION) RemoteData<String, String>
     */
    @ApiModelProperty(value = "学历")
    @Size(max = 255, message = "学历长度不能超过255")
    @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, dictType = DictionaryType.EDUCATION)
    private RemoteData<String, String> type3;
    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Boolean state;
    /**
     * 测试
     */
    @ApiModelProperty(value = "测试")
    private Integer test4;
    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    private LocalDate test5;
    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    private LocalDateTime test6;
    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Long parentId;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Size(max = 255, message = "名称长度不能超过255")
    private String label;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sortValue;
    /**
     * 测试字段
     *
     * @Echo(api = "userApi") RemoteData<Long, String>
     */
    @ApiModelProperty(value = "测试字段")
    @Size(max = 10, message = "测试字段长度不能超过10")
    @Echo(api = "userApi")
    private RemoteData<Long, String> test7;
    /**
     * 用户
     *
     * @Echo(api = USER_ID_FEIGN_CLASS) RemoteData<Long, String>
     */
    @ApiModelProperty(value = "用户")
    @Echo(api = USER_ID_FEIGN_CLASS)
    private RemoteData<Long, String> user;
    /**
     * 组织
     *
     * @Echo(api = ORG_ID_FEIGN_CLASS) RemoteData<Long, String>
     */
    @ApiModelProperty(value = "组织")
    @Echo(api = ORG_ID_FEIGN_CLASS)
    private RemoteData<Long, String> org;

}
