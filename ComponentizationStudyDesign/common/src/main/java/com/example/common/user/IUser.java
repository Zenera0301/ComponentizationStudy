package com.example.common.user;

import com.example.arouter_api.core.Call;

public interface IUser extends Call {

    /**
     * @return 根据不同子模块的具体实现，调用得到不同的结果
     */
    BaseUser getUserInfo();
}
