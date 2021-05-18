package com.tangyh.lamp.noneMultipleDataSources.controller.master;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.tangyh.basic.annotation.security.PreAuth;
import com.tangyh.basic.base.R;
import com.tangyh.basic.base.controller.SuperController;
import com.tangyh.basic.echo.core.EchoService;
import com.tangyh.lamp.noneMultipleDataSources.dto.master.ProductPageQuery;
import com.tangyh.lamp.noneMultipleDataSources.dto.master.ProductSaveDTO;
import com.tangyh.lamp.noneMultipleDataSources.dto.master.ProductUpdateDTO;
import com.tangyh.lamp.noneMultipleDataSources.entity.master.Product;
import com.tangyh.lamp.noneMultipleDataSources.service.master.ProductService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * <p>
 * 前端控制器
 * 商品
 * </p>
 *
 * @author zuihou
 * @date 2021-05-18
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/product")
@Api(value = "Product", tags = "商品")
@PreAuth(replace = "noneMultipleDataSources:product:", enabled = false)
public class ProductController extends SuperController<ProductService, Long, Product, ProductPageQuery, ProductSaveDTO, ProductUpdateDTO> {

    @Autowired
    private EchoService echoService;

    @Override
    public void handlerResult(IPage<Product> page) {
        // 想让返回值实现自动回显，请将此行代码打开
        echoService.action(page);
    }

    @PostMapping("/saveBatch")
    public R<List<Product>> saveBatch(@RequestBody List<Product> saveDTO) {
        this.getBaseService().saveBatch(saveDTO);
        return R.success(saveDTO);
    }


    /**
     * Excel导入后的操作
     *
     * @param list
     */
    @Override
    public R<Boolean> handlerImport(List<Map<String, String>> list) {
        List<Product> productList = list.stream().map((map) -> {
            Product product = Product.builder().build();
            //TODO 请在这里完成转换
            return product;
        }).collect(Collectors.toList());

        return R.success(baseService.saveBatch(productList));
    }
}
