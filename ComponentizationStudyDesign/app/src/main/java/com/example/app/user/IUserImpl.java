package com.example.app.user;

import com.example.annotation.ARouter;
import com.example.common.user.BaseUser;
import com.example.common.user.IUser;
import com.example.app.model.UserInfo;

/**
 * personal模块实现的内容
 */
@ARouter(path = "/app/getUserInfo")
public class IUserImpl implements IUser {

    @Override
    public BaseUser getUserInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("丁老mia");
        userInfo.setAccount("lalalala");
        userInfo.setPassword("12345678");
        userInfo.setVipLevel(9);
        return userInfo;
    }
}
