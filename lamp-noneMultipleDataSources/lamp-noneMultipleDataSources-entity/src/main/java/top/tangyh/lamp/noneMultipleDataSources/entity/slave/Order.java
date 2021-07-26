package top.tangyh.lamp.noneMultipleDataSources.entity.slave;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import top.tangyh.basic.annotation.echo.Echo;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.basic.model.EchoVO;
import top.tangyh.lamp.common.constant.DictionaryType;
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
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;
import static top.tangyh.lamp.common.constant.EchoConstants.DICTIONARY_ITEM_FEIGN_CLASS;
import static top.tangyh.lamp.common.constant.EchoConstants.ORG_ID_FEIGN_CLASS;

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
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("b_order")
@ApiModel(value = "Order", description = "订单")
@AllArgsConstructor
public class Order extends Entity<Long> implements EchoVO {

    private static final long serialVersionUID = 1L;
    @TableField(exist = false)
    private Map<String, Object> echoMap = new HashMap<>();
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    @Size(max = 255, message = "名称长度不能超过255")
    @TableField(value = "name", condition = LIKE)
    @Excel(name = "名称")
    private String name;

    /**
     * 学历
     *
     * @Echo(api = "orderServiceImpl", dictType = DictionaryType.EDUCATION)
     */
    @ApiModelProperty(value = "学历")
    @Size(max = 255, message = "学历长度不能超过255")
    @TableField(value = "education", condition = LIKE)
    @Echo(api = "orderServiceImpl", dictType = DictionaryType.EDUCATION)
    @Excel(name = "学历")
    private String education;

    /**
     * 民族
     * @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, dictType = DictionaryType.NATION)
     */
    @ApiModelProperty(value = "民族")
    @Size(max = 255, message = "民族长度不能超过255")
    @TableField(value = "nation", condition = LIKE)
    @Echo(api = DICTIONARY_ITEM_FEIGN_CLASS, dictType = DictionaryType.NATION)
    @Excel(name = "民族")
    private String nation;

    /**
     * 组织ID
     * #c_org@Echo(api = ORG_ID_FEIGN_CLASS)
     */
    @ApiModelProperty(value = "组织ID")
    @TableField("org_id")
    @Echo(api = ORG_ID_FEIGN_CLASS)
    @Excel(name = "组织ID")
    private Long orgId;

    /**
     * 编号
     */
    @ApiModelProperty(value = "编号")
    @Size(max = 255, message = "编号长度不能超过255")
    @TableField(value = "code", condition = LIKE)
    @Excel(name = "编号")
    private String code;


    @Builder
    public Order(Long id, LocalDateTime createTime, Long createdBy, LocalDateTime updateTime, Long updatedBy,
                 String name, String education, String nation, Long orgId, String code) {
        this.id = id;
        this.createTime = createTime;
        this.createdBy = createdBy;
        this.updateTime = updateTime;
        this.updatedBy = updatedBy;
        this.name = name;
        this.education = education;
        this.nation = nation;
        this.orgId = orgId;
        this.code = code;
    }

}
