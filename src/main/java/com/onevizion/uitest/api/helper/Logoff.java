package com.onevizion.uitest.api.helper;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.SeleniumSettings;
import com.onevizion.uitest.api.helper.document.Document;
import com.onevizion.uitest.api.helper.jquery.Jquery;

@Component
public class Logoff {

    private static final String ID_USER = "topPanelUserNameLbl";
    private static final String ID_USERMENU = "userPopupMenu";
    private static final String ID_USERMENU_LOGOFF = "itemLogoff";

    @Autowired
    private Wait wait;

    @Autowired
    private ElementWait elementWait;

    @Autowired
    private Element element;

    @Autowired
    private SeleniumSettings seleniumSettings;

    @Autowired
    private Document document;

    @Autowired
    private Jquery jquery;

    @Autowired
    private Alert alert;

    public void logoff() {
        elementWait.waitElementById(ID_USER);
        elementWait.waitElementVisibleById(ID_USER);
        elementWait.waitElementDisplayById(ID_USER);

        element.clickById(ID_USER);

        elementWait.waitElementById(ID_USERMENU);
        elementWait.waitElementVisibleById(ID_USERMENU);
        elementWait.waitElementDisplayById(ID_USERMENU);

        elementWait.waitElementById(ID_USERMENU_LOGOFF);
        elementWait.waitElementVisibleById(ID_USERMENU_LOGOFF);
        elementWait.waitElementDisplayById(ID_USERMENU_LOGOFF);

        element.clickById(ID_USERMENU_LOGOFF);

        alert.accept();

        elementWait.waitElementById("auth_header");
        elementWait.waitElementById("auth_login");
        elementWait.waitElementById("auth_recovery");

        elementWait.waitElementById("username");
        elementWait.waitElementById("password");
        elementWait.waitElementById("btn");

        document.waitReadyStateComplete();
        jquery.waitLoad();
    }

    public void logoffFromSystemAndApiV3() {
        document.open(seleniumSettings.getServerUrl());

        wait.waitWebElement(By.id("mainContainer"));
        wait.waitWebElement(By.id("messageInfoDivContainer"));
        wait.waitWebElement(By.id("messageErrorDivContainer"));

        elementWait.waitElementById(ID_USER);
        elementWait.waitElementVisibleById(ID_USER);
        elementWait.waitElementDisplayById(ID_USER);

        wait.waitWebElement(By.id(ID_USERMENU_LOGOFF));

        logoff();
    }

    public void logoffFromApiV3() {
        seleniumSettings.getWebDriver().findElement(By.className("authorize__btn")).click();
        seleniumSettings.getWebDriver().findElement(By.className("auth_logout__button")).click();

        wait.waitWebElement(By.className("info_title"));
        wait.waitWebElement(By.className("authorize__btn"));
    }

}