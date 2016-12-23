package com.ice.simplebanksite.dao;

import com.ice.simplebanksite.model.UserInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Bartek on 2016-12-14.
 */

public interface UserInfoDAO {

    UserInfo findUserInfo(String userName);

    List<String> getUserRoles(String userName);
}