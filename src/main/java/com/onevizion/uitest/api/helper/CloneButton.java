package com.onevizion.uitest.api.helper;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.AbstractSeleniumCore;
import com.onevizion.uitest.api.SeleniumSettings;

@Component
public class CloneButton {

    private static final String BUTTON_OPTIONS_ID_BASE = "btnoptions";
    static final String BUTTON_CLONE_ID_BASE = "itemClone";

    @Autowired
    private SeleniumSettings seleniumSettings;

    @Autowired
    private Wait wait;

    @Autowired
    private Window window;

    @Autowired
    private ElementWait elementWait;

    public void openCloneForm(Long gridIdx) {
        showCloneButton(gridIdx);

        window.openModal(By.id(BUTTON_CLONE_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    private void showCloneButton(Long gridIdx) {
        elementWait.waitElementById(BUTTON_OPTIONS_ID_BASE + gridIdx);
        seleniumSettings.getWebDriver().findElement(By.id(BUTTON_OPTIONS_ID_BASE + gridIdx)).click();

        elementWait.waitElementById(BUTTON_CLONE_ID_BASE + gridIdx);
        elementWait.waitElementVisibleById(BUTTON_CLONE_ID_BASE + gridIdx);
        elementWait.waitElementDisplayById(BUTTON_CLONE_ID_BASE + gridIdx);
    }

}