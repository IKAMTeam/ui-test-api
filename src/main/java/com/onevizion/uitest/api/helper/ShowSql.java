package com.onevizion.uitest.api.helper;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.onevizion.uitest.api.AbstractSeleniumCore;
import com.onevizion.uitest.api.SeleniumSettings;
import com.onevizion.uitest.api.helper.page.button.PageButton;

@Component
public class ShowSql {

    private static final String SQL = "divPage1";
    private static final String RUNTIME_DB = "runtime_db";
    private static final String RUNTIME_SERVER = "runtime_server";
    private static final String RUNTIME_RESPONSE = "runtime_response";
    private static final String RUNTIME_BROWSER = "runtime_browser";
    private static final String RUNTIME_USER = "runtime_user";
    private static final String RESPONSE_SIZE = "response_size";

    @Autowired
    private SeleniumSettings seleniumSettings;

    @Autowired
    private Window window;

    @Autowired
    private ShowSqlWait showSqlWait;

    @Autowired
    private PageButton pageButton;

    public void openShowSqlForm(Long gridIdx) {
        showSqlWait.waitIsUsageLogUpdated(gridIdx);
        pageButton.openShowSqlForm(gridIdx);
    }

    public void checkShowSqlForm() {
        String sql = seleniumSettings.getWebDriver().findElement(By.id(SQL)).getText();
        Assert.assertEquals(sql.contains("select"), true);

        String runtimeDbStr = seleniumSettings.getWebDriver().findElement(By.id(RUNTIME_DB)).getText();
        double runtimeDb = Double.parseDouble(runtimeDbStr);
        Assert.assertEquals(Double.compare(runtimeDb, 1000) < 0, true);

        String runtimeServerStr = seleniumSettings.getWebDriver().findElement(By.id(RUNTIME_SERVER)).getText();
        double runtimeServer = Double.parseDouble(runtimeServerStr);
        Assert.assertEquals(Double.compare(runtimeServer, 1000) < 0, true);

        String runtimeResponseStr = seleniumSettings.getWebDriver().findElement(By.id(RUNTIME_RESPONSE)).getText();
        double runtimeResponse = Double.parseDouble(runtimeResponseStr);
        Assert.assertEquals(Double.compare(runtimeResponse, 1000) < 0, true);

        String runtimeBrowserStr = seleniumSettings.getWebDriver().findElement(By.id(RUNTIME_BROWSER)).getText();
        double runtimeBrowser = Double.parseDouble(runtimeBrowserStr);
        Assert.assertEquals(Double.compare(runtimeBrowser, 1000) < 0, true);

        String runtimeUserStr = seleniumSettings.getWebDriver().findElement(By.id(RUNTIME_USER)).getText();
        double runtimeUser = Double.parseDouble(runtimeUserStr);
        Assert.assertEquals(Double.compare(runtimeUser, 1000) < 0, true);

        String responseSizeStr = seleniumSettings.getWebDriver().findElement(By.id(RESPONSE_SIZE)).getText();
        double responseSize = Double.parseDouble(responseSizeStr);
        Assert.assertEquals(Double.compare(responseSize, 1000) < 0, true);
    }

    public void closeShowSqlForm() {
        window.closeModal(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
    }

}