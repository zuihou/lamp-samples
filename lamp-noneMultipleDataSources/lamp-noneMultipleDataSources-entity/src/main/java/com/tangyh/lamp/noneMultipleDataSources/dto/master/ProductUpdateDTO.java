package com.tangyh.lamp.noneMultipleDataSources.dto.master;

import com.tangyh.basic.annotation.echo.Echo;
import java.time.LocalDateTime;
import static com.tangyh.lamp.common.constant.EchoConstants.USER_ID_FEIGN_CLASS;
import com.baomidou.mybatisplus.annotation.TableField;
import com.tangyh.basic.model.RemoteData;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.tangyh.basic.base.entity.Entity;
import static com.tangyh.lamp.common.constant.EchoConstants.FIND_NAME_BY_IDS;
import static com.tangyh.lamp.common.constant.EchoConstants.DICTIONARY_ITEM_FEIGN_CLASS;
import static com.tangyh.lamp.common.constant.EchoConstants.ORG_ID_FEIGN_CLASS;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.tangyh.basic.base.entity.SuperEntity;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.tangyh.lamp.common.constant.DictionaryType;
import com.tangyh.lamp.noneMultipleDataSources.enumeration.master.ProductType;
import com.tangyh.lamp.noneMultipleDataSources.enumeration.master.ProductType2Enum;
import java.io.Serializable;

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
@AllArgsConstructor
@Accessors(chain = true)
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Builder
@ApiModel(value = "ProductUpdateDTO", description = "商品")
public class ProductUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @NotEmpty(message = "名称不能为空")
    @Size(max = 24, message = "名称长度不能超过24")
    private String name;
    /**
     * 库存
     */
    @ApiModelProperty(value = "库存")
    @NotNull(message = "库存不能为空")
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
     * @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, method = FIND_NAME_BY_IDS, dictType = DictionaryType.EDUCATION)
     */
    @ApiModelProperty(value = "学历")
    @Size(max = 255, message = "学历长度不能超过255")
    private String type3;
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
     * @InjectionField(api = "userApi", method = USER_ID_NAME_METHOD) RemoteData<Long, String>
     */
    @ApiModelProperty(value = "测试字段")
    @Size(max = 10, message = "测试字段长度不能超过10")
    private String test7;
    /**
     * 用户 
     * @Echo(api = USER_ID_FEIGN_CLASS, method = FIND_NAME_BY_IDS)
     */
    @ApiModelProperty(value = "用户")
    private Long userId;
    /**
     * 组织 
     * @Echo(api = ORG_ID_FEIGN_CLASS, method = FIND_NAME_BY_IDS)
     */
    @ApiModelProperty(value = "组织")
    private Long orgId;
}
