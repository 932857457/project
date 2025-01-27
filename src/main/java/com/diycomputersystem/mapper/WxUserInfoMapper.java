package com.diycomputersystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.diycomputersystem.entity.BigType;
import com.diycomputersystem.entity.WxUserInfo;


public interface WxUserInfoMapper extends BaseMapper<WxUserInfo> {
    public WxUserInfo findByOpenId(String openId);
}
