package com.tangyh.lamp.example.dto;

import com.tangyh.lamp.example.enums.MatterType;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author tangyh
 * @version v1.0
 * @date 2021/6/11 10:18 上午
 * @create [2021/6/11 10:18 上午 ] [tangyh] [初始创建]
 */
@Data
public class MatterInOutSumFormBean {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private MatterType matterType;
}
