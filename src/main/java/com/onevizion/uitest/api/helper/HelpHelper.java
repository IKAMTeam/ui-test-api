package com.onevizion.uitest.api.helper;

import java.util.List;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.AbstractSeleniumCore;
import com.onevizion.uitest.api.SeleniumSettings;
import com.onevizion.uitest.api.exception.SeleniumUnexpectedException;

@Component
public class HelpHelper {

    private final static String BUTTON_OPEN = "btnHelp";
    private final static String BUTTON_OPEN_ON_FILTER_FORM = "btnHelpFilter";
    private final static String BUTTON_OPEN_ON_VIEW_FORM = "btnHelpView";
    private final static String SERIAL_NUMBER_ID = "SerialNumber";

    @Resource
    private AssertHelper assertHelper;

    @Resource
    private WindowHelper windowHelper;

    @Resource
    private WaitHelper waitHelper;

    @Resource
    private ElementHelper elementHelper;

    @Resource
    private ElementWaitHelper elementWaitHelper;

    @Resource
    private SeleniumSettings seleniumSettings;

    public void checkHelp(final String name, final String number, final String type) {
        elementWaitHelper.waitElementAttributeById(SERIAL_NUMBER_ID, "innerText", number);
        assertHelper.AssertLink(SERIAL_NUMBER_ID, number);

        elementHelper.clickById(BUTTON_OPEN);

        windowHelper.openModal(getHelpContainerItem("BPD Help Editor for current Tab"));
        waitHelper.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        waitHelper.waitFormLoad();
        assertHelper.AssertText("name", name);
        assertHelper.AssertText("formNumber", number);
        assertHelper.AssertText("formNumber", number);
        assertHelper.AssertSelect("itemTypeId", type);
        windowHelper.closeModal(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
    }

    public void checkHelpOnFilterForm(Long gridIdx, final String name, final String number, final String type) {
        elementWaitHelper.waitElementAttributeById(SERIAL_NUMBER_ID, "innerText", number);
        assertHelper.AssertLink(SERIAL_NUMBER_ID, number);

        elementHelper.clickById(BUTTON_OPEN_ON_FILTER_FORM + gridIdx);

        windowHelper.openModal(getHelpContainerItem("BPD Help Editor for current Tab"));
        waitHelper.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        waitHelper.waitFormLoad();
        assertHelper.AssertText("name", name);
        assertHelper.AssertText("formNumber", number);
        assertHelper.AssertText("formNumber", number);
        assertHelper.AssertSelect("itemTypeId", type);
        windowHelper.closeModal(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
    }

    public void checkHelpOnViewForm(Long gridIdx, final String name, final String number, final String type) {
        elementWaitHelper.waitElementAttributeById(SERIAL_NUMBER_ID, "innerText", number);
        assertHelper.AssertLink(SERIAL_NUMBER_ID, number);

        elementHelper.clickById(BUTTON_OPEN_ON_VIEW_FORM + gridIdx);

        windowHelper.openModal(getHelpContainerItem("BPD Help Editor for current Tab"));
        waitHelper.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        waitHelper.waitFormLoad();
        assertHelper.AssertText("name", name);
        assertHelper.AssertText("formNumber", number);
        assertHelper.AssertText("formNumber", number);
        assertHelper.AssertSelect("itemTypeId", type);
        windowHelper.closeModal(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
    }

    private WebElement getHelpContainerItem(String helpName) {
        List<WebElement> helpContainers = seleniumSettings.getWebDriver().findElements(By.className("dhtmlxMebu_SubLevelArea_Tbl"));
        for (WebElement helpContainer : helpContainers) {
            List<WebElement> helpItems = helpContainer.findElements(By.tagName("div"));
            for (WebElement helpItem : helpItems) {
                if (helpName.equals(helpItem.getText())) {
                    return helpItem;
                }
            }
        }

        throw new SeleniumUnexpectedException("");
    }

}