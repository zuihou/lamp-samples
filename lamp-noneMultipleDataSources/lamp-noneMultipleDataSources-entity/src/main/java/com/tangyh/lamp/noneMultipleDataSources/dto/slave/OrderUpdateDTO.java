package com.tangyh.lamp.noneMultipleDataSources.dto.slave;

import com.tangyh.basic.base.entity.SuperEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p>
 * 实体类
 * 订单
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
@ApiModel(value = "OrderUpdateDTO", description = "订单")
public class OrderUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @NotNull(message = "id不能为空", groups = SuperEntity.Update.class)
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Size(max = 255, message = "名称长度不能超过255")
    private String name;
    /**
     * 学历
     *
     * @Echo(api = "orderServiceImpl", dictType = DictionaryType.EDUCATION)
     */
    @ApiModelProperty(value = "学历")
    @Size(max = 255, message = "学历长度不能超过255")
    private String education;
    /**
     * 民族
     * @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, dictType = DictionaryType.NATION)
     */
    @ApiModelProperty(value = "民族")
    @Size(max = 255, message = "民族长度不能超过255")
    private String nation;
    /**
     * 组织ID
     * #c_org@Echo(api = ORG_ID_FEIGN_CLASS)
     */
    @ApiModelProperty(value = "组织ID")
    private Long orgId;
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    @Size(max = 255, message = "编号长度不能超过255")
    private String code;
}
