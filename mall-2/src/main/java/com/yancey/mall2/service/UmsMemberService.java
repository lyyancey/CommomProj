package com.yancey.mall2.service;

import com.yancey.mall2.common.api.CommonResult;

public interface UmsMemberService {
    CommonResult generateAutoCode(String telephone);
    CommonResult verifyAuthCode(String telephone, String authCode);
}
