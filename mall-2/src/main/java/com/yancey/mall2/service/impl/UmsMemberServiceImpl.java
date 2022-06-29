package com.yancey.mall2.service.impl;

import com.yancey.mall2.common.api.CommonResult;
import com.yancey.mall2.service.RedisService;
import com.yancey.mall2.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAutoCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int AUTH_CODE_LENGTH = 6;
        for(int i=0; i<AUTH_CODE_LENGTH; i++){
            sb.append(random.nextInt(10));
        }
        String redisKey = REDIS_KEY_PREFIX_AUTH_CODE+telephone;
        redisService.set(redisKey, sb.toString());
        redisService.expire(redisKey, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功！");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if(StringUtils.isEmpty(authCode)){
            return CommonResult.failed("请输入验证码!");
        }
        String redisKey = REDIS_KEY_PREFIX_AUTH_CODE+telephone;
        String realAuthCode = redisService.get(redisKey);
        boolean result = authCode.equals(realAuthCode);
        if(result){
            return CommonResult.success(null, "验证码校验成功");
        }else{
            return CommonResult.failed("验证码不正确");
        }
    }
}
