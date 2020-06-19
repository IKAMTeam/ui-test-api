package com.onevizion.uitest.api.helper;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.AbstractSeleniumCore;
import com.onevizion.uitest.api.SeleniumSettings;

@Component
public class GridRowButton {

    private static final String BUTTON_LIST_EDIT_ID_BASE = "listEdit";
    private static final String BUTTON_EDIT_ROW_ID_BASE = "btnEditRow";

    @Autowired
    private SeleniumSettings seleniumSettings;

    @Autowired
    private Wait wait;

    @Autowired
    private Window window;

    @Autowired
    private ElementWait elementWait;

    public void openGridRowForm(Long gridIdx) {
        showGridRowButton(gridIdx);

        window.openModal(By.id(BUTTON_EDIT_ROW_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitGridRowEditorLoad();
    }

    private void showGridRowButton(Long gridIdx) {
        elementWait.waitElementById(BUTTON_LIST_EDIT_ID_BASE + gridIdx);
        seleniumSettings.getWebDriver().findElement(By.id(BUTTON_LIST_EDIT_ID_BASE + gridIdx)).click();

        elementWait.waitElementById(BUTTON_EDIT_ROW_ID_BASE + gridIdx);
        elementWait.waitElementVisibleById(BUTTON_EDIT_ROW_ID_BASE + gridIdx);
        elementWait.waitElementDisplayById(BUTTON_EDIT_ROW_ID_BASE + gridIdx);
    }

}