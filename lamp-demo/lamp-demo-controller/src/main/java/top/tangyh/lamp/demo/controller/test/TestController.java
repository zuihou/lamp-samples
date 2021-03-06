package top.tangyh.lamp.demo.controller.test;

import top.tangyh.basic.annotation.user.LoginUser;
import top.tangyh.basic.base.R;
import top.tangyh.basic.log.entity.OptLogDTO;
import top.tangyh.basic.security.model.SysUser;
import top.tangyh.lamp.authority.entity.auth.Resource;
import top.tangyh.lamp.authority.entity.auth.User;
import top.tangyh.lamp.demo.controller.test.model.EnumDTO;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 注入登录用户信息 测试类
 *
 * @author zuihou
 * @date 2019/07/10
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/test")
@Api(value = "Test", tags = "测试类")
public class TestController {

    @GetMapping("/{id}")
    public R<String> get(@PathVariable Long id, @ApiIgnore @LoginUser(isFull = true) SysUser user) {
        return R.success("Id");
    }

    @GetMapping("/get")
    public R<String> get2(@RequestParam("id") Long id, @ApiIgnore @LoginUser SysUser user) {
        return R.success("Id");
    }

    @PostMapping
    public R<OptLogDTO> save(@RequestBody OptLogDTO data) {
        return R.success(data);
    }

    @PostMapping("post2")
    public R<OptLogDTO> post2(@RequestBody OptLogDTO data, @ApiIgnore @LoginUser(isOrg = true, isStation = true) SysUser user) {
        return R.success(data);
    }


    @GetMapping("get3")
    public R<OptLogDTO> get3(OptLogDTO data, @ApiIgnore @LoginUser(isOrg = true, isStation = true) SysUser user) {
        return R.success(data);
    }

    @PostMapping("post3")
    public R<EnumDTO> post3(@RequestBody EnumDTO data) {
        return R.success(data);
    }

    @PostMapping("post4")
    public R<EnumDTO> post4(@RequestBody EnumDTO data) {
        int a = 1 / 0;
        log.info("a=", a);
        return R.success(data);
    }

    @PostMapping("post5")
    public R<EnumDTO> post5(@RequestBody EnumDTO data) throws Exception {
        new EnumDTO().testEx();
        return R.success(data);
    }

    @PostMapping("post6")
    public R<EnumDTO> post6(@RequestBody EnumDTO data) throws Exception {

        return R.success(data);
    }


    @PostMapping("post7")
    public R<User> post7(@RequestBody(required = false) User data) throws Exception {

        return R.success(data);
    }

    @PostMapping("post8")
    public R<Resource> post8(@RequestBody(required = false) Resource data) throws Exception {

        return R.success(data);
    }


}
