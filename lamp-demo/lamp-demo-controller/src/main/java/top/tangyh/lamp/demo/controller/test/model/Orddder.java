package top.tangyh.lamp.demo.controller.test.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 订单测试DTO
 *
 * @author zuihou
 * @date 2019/08/01
 */
@Data
@ToString
public class Orddder implements Serializable {
    private Long id;
    private String name;
    private Producttt producttt;
}
