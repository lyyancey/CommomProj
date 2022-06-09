package com.yancey.mall2.service;

import com.yancey.mall2.mbg.model.PmsBrand;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PmsBrandService
 * @Description TODO PmsBrandService
 * @Author Yancey
 * @Date 2022/6/3 14:54
 * @Version 1.0
 */
@Service
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();
    int createBrand(PmsBrand pmsBrand);
    int updateBrand(Long id, PmsBrand pmsBrand);
    int deleteBrand(Long id);
    PmsBrand getBrand(Long id);
    List<PmsBrand> listBrand(int pageNum, int pageSize);
}
