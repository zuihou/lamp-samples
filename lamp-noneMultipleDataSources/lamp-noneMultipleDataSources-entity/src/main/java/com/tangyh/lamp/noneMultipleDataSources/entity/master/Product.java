package com.tangyh.lamp.noneMultipleDataSources.entity.master;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tangyh.basic.annotation.echo.Echo;
import com.tangyh.basic.base.entity.Entity;
import com.tangyh.basic.model.EchoVO;
import com.tangyh.lamp.common.constant.DictionaryType;
import com.tangyh.lamp.noneMultipleDataSources.enumeration.master.ProductType;
import com.tangyh.lamp.noneMultipleDataSources.enumeration.master.ProductType2Enum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;
import static com.tangyh.basic.utils.DateUtils.DEFAULT_DATE_TIME_FORMAT;
import static com.tangyh.lamp.common.constant.EchoConstants.DICTIONARY_ITEM_FEIGN_CLASS;
import static com.tangyh.lamp.common.constant.EchoConstants.ORG_ID_FEIGN_CLASS;
import static com.tangyh.lamp.common.constant.EchoConstants.USER_ID_FEIGN_CLASS;

/**
 * <p>
 * 实体类
 * 商品
 * </p>
 *
 * @author zuihou
 * @since 2021-05-18
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("b_product")
@ApiModel(value = "Product", description = "商品")
@AllArgsConstructor
public class Product extends Entity<Long> implements EchoVO {

    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Map<String, Object> echoMap = new HashMap<>();
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "名称不能为空")
    @Size(max = 24, message = "名称长度不能超过24")
    @TableField(value = "name", condition = LIKE)
    @Excel(name = "名称")
    private String name;

    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    @NotNull(message = "库存不能为空")
    @TableField("stock")
    @Excel(name = "库存")
    private Integer stock;

    /**
     * 商品类型
     * #ProductType{ordinary:普通;gift:赠品}
     */
    @ApiModelProperty(value = "商品类型")
    @TableField("type_")
    @Excel(name = "商品类型", replace = {"普通_ORDINARY", "赠品_GIFT",  "_null"})
    private ProductType type;

    /**
     * 商品类型2
     * #{ordinary:普通;gift:赠品;}
     */
    @ApiModelProperty(value = "商品类型2")
    @TableField("type2")
    @Excel(name = "商品类型2", replace = {"普通_ORDINARY", "赠品_GIFT",  "_null"})
    private ProductType2Enum type2;

    /**
     * 学历
     *
     * @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, dictType = DictionaryType.EDUCATION)
     */
    @ApiModelProperty(value = "学历")
    @Size(max = 255, message = "学历长度不能超过255")
    @TableField(value = "type3", condition = LIKE)
    @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, dictType = DictionaryType.EDUCATION)
    @Excel(name = "学历")
    private String type3;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    @TableField("state")
    @Excel(name = "状态", replace = {"是_true", "否_false", "_null"})
    private Boolean state;

    /**
     * 测试
     */
    @ApiModelProperty(value = "测试")
    @TableField("test4")
    @Excel(name = "测试")
    private Integer test4;

    /**
     * 时间
     */
    @ApiModelProperty(value = "时间")
    @TableField("test5")
    @Excel(name = "时间", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDate test5;

    /**
     * 日期
     */
    @ApiModelProperty(value = "日期")
    @TableField("test6")
    @Excel(name = "日期", format = DEFAULT_DATE_TIME_FORMAT, width = 20)
    private LocalDateTime test6;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    @TableField("parent_id")
    @Excel(name = "父id")
    private Long parentId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Size(max = 255, message = "名称长度不能超过255")
    @TableField(value = "label", condition = LIKE)
    @Excel(name = "名称")
    private String label;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @TableField("sort_value")
    @Excel(name = "排序")
    private Integer sortValue;

    /**
     * 测试字段
     * @InjectionField(api = "userApi", method = USER_ID_NAME_METHOD) RemoteData<Long, String>
     */
    @ApiModelProperty(value = "测试字段")
    @Size(max = 10, message = "测试字段长度不能超过10")
    @TableField(value = "test7", condition = LIKE)
    @Excel(name = "测试字段")
    private String test7;

    /**
     * 用户
     * @Echo(api = USER_ID_FEIGN_CLASS)
     */
    @ApiModelProperty(value = "用户")
    @TableField("user_id")
    @Echo(api = USER_ID_FEIGN_CLASS)
    @Excel(name = "用户")
    private Long userId;

    /**
     * 组织
     * @Echo(api = ORG_ID_FEIGN_CLASS)
     */
    @ApiModelProperty(value = "组织")
    @TableField("org_id")
    @Echo(api = ORG_ID_FEIGN_CLASS)
    @Excel(name = "组织")
    private Long orgId;


    @Builder
    public Product(Long id, LocalDateTime createTime, Long createdBy, LocalDateTime updateTime, Long updatedBy,
                   String name, Integer stock, ProductType type, ProductType2Enum type2, String type3,
                   Boolean state, Integer test4, LocalDate test5, LocalDateTime test6, Long parentId, String label,
                   Integer sortValue, String test7, Long userId, Long orgId) {
        this.id = id;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.updateTime = updateTime;
        this.updatedBy = updatedBy;
        this.name = name;
        this.stock = stock;
        this.type = type;
        this.type2 = type2;
        this.type3 = type3;
        this.state = state;
        this.test4 = test4;
        this.test5 = test5;
        this.test6 = test6;
        this.parentId = parentId;
        this.label = label;
        this.sortValue = sortValue;
        this.test7 = test7;
        this.userId = userId;
        this.orgId = orgId;
    }

}
