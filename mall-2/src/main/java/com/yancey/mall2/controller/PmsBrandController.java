package com.yancey.mall2.controller;

import com.yancey.mall2.common.api.CommonPage;
import com.yancey.mall2.common.api.CommonResult;
import com.yancey.mall2.mbg.model.PmsBrand;
import com.yancey.mall2.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName PmsBrandController
 * @Description TODO manage brand controller
 * @Author Yancey
 * @Date 2022/6/3 14:49
 * @Version 1.0
 */
@Api(tags="PmsBrandController", description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController{
    @Autowired
    private PmsBrandService pmsBrandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("Get all brand list")
    @RequestMapping(value="/listAll", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('pms:brand:read')")
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @ApiOperation("Add brand information")
    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:create')")
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = pmsBrandService.createBrand(pmsBrand);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}", pmsBrand);
        }else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("Update brand information by id")
    @RequestMapping(value="/update/{id}", method=RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:update')")
    public CommonResult updateBrand(@RequestBody PmsBrand pmsBrand, @PathVariable("id") Long id, BindingResult result){
        CommonResult commonResult;
        int count = pmsBrandService.updateBrand(id, pmsBrand);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("updateBrand success:{}", pmsBrand);
        }else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("Delete brand information by id")
    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count = pmsBrandService.deleteBrand(id);
        if(count == 1){
            LOGGER.debug("deleteBrand success :id={}", id);
            return CommonResult.success(null);
        }else{
            LOGGER.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("Query brand list by split page ")
    @RequestMapping(value = "/list", method=RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<CommonPage> listBrand(@RequestParam(value="pageNum", defaultValue="1") @ApiParam("Page number") Integer pageNum,
                                              @RequestParam(value="pageSize", defaultValue="3") @ApiParam("Page size") Integer pageSize){
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("Get brand information by id")
    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id){
        return CommonResult.success(pmsBrandService.getBrand(id));
    }
}
