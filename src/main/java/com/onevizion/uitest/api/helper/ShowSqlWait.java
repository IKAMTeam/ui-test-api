package com.onevizion.uitest.api.helper;

import javax.annotation.Resource;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.SeleniumSettings;

@Component
class ShowSqlWait {

    @Resource
    private SeleniumSettings seleniumSettings;

    @Resource
    private ShowSqlJs showSqlJs;

    void waitIsUsageLogUpdated(Long gridId) {
        new WebDriverWait(seleniumSettings.getWebDriver(), seleniumSettings.getDefaultTimeout())
            .withMessage("Waiting for Usage Log updating is failed")
            .until(webdriver -> showSqlJs.isUsageLogUpdated(gridId));
    }

}