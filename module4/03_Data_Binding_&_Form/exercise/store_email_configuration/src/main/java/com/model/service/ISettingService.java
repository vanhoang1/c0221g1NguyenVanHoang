package com.model.service;

import com.model.bean.Setting;

public interface ISettingService {
    Setting findSetting();
    void saveSetting(Setting setting);
}
