package com.yancey.mall2.service.impl;

import com.github.pagehelper.PageHelper;
import com.yancey.mall2.mbg.mapper.PmsBrandMapper;
import com.yancey.mall2.mbg.model.PmsBrand;
import com.yancey.mall2.mbg.model.PmsBrandExample;
import com.yancey.mall2.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PmsBrandServiceImpl
 * @Description TODO
 * @Author Yancey
 * @Date 2022/6/3 14:55
 * @Version 1.0
 */

@Service
public class PmsBrandServiceImpl implements PmsBrandService {
     @Autowired
    private PmsBrandMapper pmsBrandMapper;
    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }
}
