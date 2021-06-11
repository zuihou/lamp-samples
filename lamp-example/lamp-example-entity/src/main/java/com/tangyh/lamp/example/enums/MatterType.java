package com.tangyh.lamp.example.enums;

import com.tangyh.basic.base.BaseEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

/**
 * @author tangyh
 * @version v1.0
 * @date 2021/6/11 10:18 上午
 * @create [2021/6/11 10:18 上午 ] [tangyh] [初始创建]
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "MatterType", description = "物料类型-枚举")
public enum MatterType implements BaseEnum {
    /**
     * BEI_JIAN="备品备件"
     */
    BEI_JIAN("备品备件"),
    /**
     * CHENG_PIN="成品"
     */
    CHENG_PIN("成品"),
    /**
     * BAN_CHENG_PIN="半成品"
     */
    BAN_CHENG_PIN("半成品"),
    /**
     * WU_LIAO="物料"
     */
    WU_LIAO("物料"),
    /**
     * OTHER="其它"
     */
    OTHER("其它"),
    ;

    @ApiModelProperty(value = "描述")
    private String desc;


    /**
     * 根据当前枚举的name匹配
     */
    public static MatterType match(String val, MatterType def) {
        return Stream.of(values()).parallel().filter(item -> item.name().equalsIgnoreCase(val)).findAny().orElse(def);
    }

    public static MatterType get(String val) {
        return match(val, null);
    }

    public boolean eq(MatterType val) {
        return val != null && eq(val.name());
    }

    @Override
    @ApiModelProperty(value = "编码", allowableValues = "BEI_JIAN,CHENG_PIN,BAN_CHENG_PIN,WU_LIAO,OTHER", example = "BEI_JIAN")
    public String getCode() {
        return this.name();
    }
}
