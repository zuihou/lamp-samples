package com.tangyh.lamp.noneMultipleDataSources.dto.slave;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.tangyh.basic.annotation.echo.Echo;
import com.baomidou.mybatisplus.annotation.TableId;
import com.tangyh.basic.base.entity.Entity;
import com.baomidou.mybatisplus.annotation.TableField;
import static com.tangyh.lamp.common.constant.EchoConstants.FIND_NAME_BY_IDS;
import com.tangyh.basic.model.RemoteData;
import static com.tangyh.lamp.common.constant.EchoConstants.DICTIONARY_ITEM_FEIGN_CLASS;
import static com.tangyh.lamp.common.constant.EchoConstants.ORG_ID_FEIGN_CLASS;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import com.tangyh.lamp.common.constant.DictionaryType;
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
@ApiModel(value = "OrderPageQuery", description = "订单")
public class OrderPageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 学历 
     * @Echo(api = "orderServiceImpl", method = FIND_NAME_BY_IDS, dictType = DictionaryType.EDUCATION)
     */
    @ApiModelProperty(value = "学历")
    private String education;
    /**
     * 民族 
     * @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, method = FIND_NAME_BY_IDS, dictType = DictionaryType.NATION)
     */
    @ApiModelProperty(value = "民族")
    private String nation;
    /**
     * 组织ID 
     * #c_org@Echo(api = ORG_ID_FEIGN_CLASS, method = FIND_NAME_BY_IDS)
     */
    @ApiModelProperty(value = "组织ID")
    private Long orgId;
    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    private String code;

}
