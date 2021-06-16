package com.model.service;

import com.model.bean.Setting;
import org.springframework.stereotype.Service;

@Service
public class SettingService implements ISettingService {
   private static  Setting setting  = new Setting();

    @Override
    public Setting findSetting() {
        return setting;
    }

    @Override
    public void saveSetting(Setting setting) {
        SettingService.setting =setting;
    }
}
