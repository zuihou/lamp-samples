package top.tangyh.lamp.example.controller.validator;

import top.tangyh.basic.annotation.user.LoginUser;
import top.tangyh.basic.base.R;
import top.tangyh.basic.security.model.SysUser;
import top.tangyh.lamp.example.entity.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import static top.tangyh.lamp.common.constant.SwaggerConstants.DATA_TYPE_BOOLEAN;
import static top.tangyh.lamp.common.constant.SwaggerConstants.DATA_TYPE_LONG;
import static top.tangyh.lamp.common.constant.SwaggerConstants.DATA_TYPE_MULTIPART_FILE;
import static top.tangyh.lamp.common.constant.SwaggerConstants.PARAM_TYPE_QUERY;

/**
 * @author zuihou
 * @date 2020年03月31日10:10:36
 */
@Slf4j
@RestController
@RequestMapping("/validator")
@AllArgsConstructor
@Api(value = "validator", tags = "validator")
@Validated
public class ValidatorTestController {

    /**
     * 用 postman post 方式调用： http://ip:port/form/validator/validator/postJson 看返回结果
     * <p>
     * 想要配合前端使用，参考lamp-web-plus的前端formValidateService.ts源码
     */
    @PostMapping(value = "/postJson")
    public R postJson(@ApiIgnore @LoginUser SysUser user, @Validated @RequestBody Order order) {
        log.info("order={}", order);
        return R.success(order);
    }


    /**
     * 用 postman post 方式调用： http://ip:port/form/validator/validator/postFrom 看返回结果
     * <p>
     * 想要配合前端使用，参考lamp-web-plus的前端formValidateService.ts源码
     */
    @PostMapping(value = "/postFrom")
    public R postFrom(@Valid Order order) {
        log.info("user={}", order);
        return R.success(order);
    }

    /**
     * 用 postman post 方式调用： http://ip:port/form/validator/validator/upload 看返回结果
     * <p>
     * 想要配合前端使用，参考lamp-web-plus的前端formValidateService.ts源码
     */
    @ApiOperation(value = "附件上传", notes = "附件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "isSingle", value = "是否单文件", dataType = DATA_TYPE_BOOLEAN, paramType = PARAM_TYPE_QUERY),
            @ApiImplicitParam(name = "id", value = "文件id", dataType = DATA_TYPE_LONG, paramType = PARAM_TYPE_QUERY),
            @ApiImplicitParam(name = "bizId", value = "业务id", dataType = DATA_TYPE_LONG, paramType = PARAM_TYPE_QUERY),
            @ApiImplicitParam(name = "bizType", value = "业务类型", dataType = DATA_TYPE_LONG, paramType = PARAM_TYPE_QUERY),
            @ApiImplicitParam(name = "file", value = "附件", dataType = DATA_TYPE_MULTIPART_FILE, allowMultiple = true, required = true),
    })
    @PostMapping(value = "/upload")
    public R upload(
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "isSingle", required = false, defaultValue = "false") Boolean isSingle,
            @Max(value = 10, message = "id 不能大于10") @RequestParam(value = "id", required = false) Long id,
            @NotNull(message = "bizId不能为空") @RequestParam(value = "bizId", required = false) String bizId,
            @RequestParam(value = "bizType", required = false) String bizType) {
        return R.success();
    }
}
