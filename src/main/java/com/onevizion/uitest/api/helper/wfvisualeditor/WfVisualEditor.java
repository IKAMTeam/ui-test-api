package com.onevizion.uitest.api.helper.wfvisualeditor;

import java.util.List;

import javax.annotation.Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.AbstractSeleniumCore;
import com.onevizion.uitest.api.SeleniumSettings;
import com.onevizion.uitest.api.helper.ElementHelper;
import com.onevizion.uitest.api.helper.WaitHelper;
import com.onevizion.uitest.api.helper.Window;

@Component
public class WfVisualEditor {

    @Resource
    private ElementHelper elementHelper;

    @Resource
    private WaitHelper waitHelper;

    @Resource
    private Window window;

    @Resource
    private SeleniumSettings seleniumSettings;

    private WebElement getStepNode(String text) {
        List<WebElement> stepNodes = seleniumSettings.getWebDriver().findElements(By.className("node"));

        for (WebElement stepNode:stepNodes) {
            String innerText = stepNode.findElement(By.id("lbl" + stepNode.getAttribute("id"))).getAttribute("innerText");
            if (innerText.equals(text)) {
                return stepNode;
            }
        }
        return null;
    }

    public void selectStepNode(String text) {
        WebElement stepNode = getStepNode(text);
        WebElement stepNodeLabel = stepNode.findElement(By.id("lbl" + stepNode.getAttribute("id")));
        elementHelper.click(stepNodeLabel);
    }

    public void openAddFormStepBefore() {
        window.openModal(By.id("btnAddStepBefore"));
        waitHelper.waitFormLoad();
    }

    public void openAddFormStepAfter() {
        window.openModal(By.id("btnAddStep"));
        waitHelper.waitFormLoad();
    }

    public void openStepEditForm(String text) {
        selectStepNode(text);
        window.openModal(By.id("btnEdit"));
        waitHelper.waitFormLoad();
    }

    public void openStepNotificationsGrid(String text) {
        selectStepNode(text);
        window.openModal(By.id("btnNotifications"));
        waitHelper.waitGridLoad(AbstractSeleniumCore.getGridIdx(), AbstractSeleniumCore.getGridIdx());
    }

    public void openStepLinksGrid(String text) {
        selectStepNode(text);
        window.openModal(By.id("btnLinks"));
        waitHelper.waitGridLoad(AbstractSeleniumCore.getGridIdx(), AbstractSeleniumCore.getGridIdx());
    }

    public void deleteStep(String text) {
        selectStepNode(text);
        elementHelper.clickById("btnDelete");
        waitHelper.waitAlert();
        seleniumSettings.getWebDriver().switchTo().alert().accept();
        waitHelper.waitFormLoad();
    }

}