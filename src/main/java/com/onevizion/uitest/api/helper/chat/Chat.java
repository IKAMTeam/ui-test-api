package com.onevizion.uitest.api.helper.chat;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.onevizion.uitest.api.AbstractSeleniumCore;
import com.onevizion.uitest.api.SeleniumSettings;
import com.onevizion.uitest.api.exception.SeleniumUnexpectedException;
import com.onevizion.uitest.api.helper.AssertElement;
import com.onevizion.uitest.api.helper.Element;
import com.onevizion.uitest.api.helper.ElementWait;
import com.onevizion.uitest.api.helper.jquery.Jquery;

@Component
public class Chat {

    static final String ID_MAIN_PANEL = "slideChatPanel";

    private static final String ID_MAIN_BUTTON = "btnComments";
    private static final String ID_CLOSE_BUTTON = "btnCloseChat";
    private static final String ID_MAIN_LOADER = "loaderChatLoader";
    private static final String ID_MANAGE = "btnManage";
    private static final String ID_MANAGE_PANEL = "managePanel";
    private static final String CLASS_MANAGE_PANEL_SUBTITLE = "p_subtitle";
    private static final String ID_COMMENT_TEXT = "replyForm";
    private static final String ID_COMMENT_FILE = "btnAddFile";
    private static final String ID_COMMENT_SEND = "btnSend";
    private static final String ID_COMMENT_LOADER = "loaderReply";
    private static final String CLASS_TOGGLE = "toggle";
    private static final String ID_SUBSCRIBE = "btnSubscribe";
    private static final String ID_CLOSE_MANAGE_PANEL = "btnOffManagePanel";
    private static final String CLASS_USER_ON_MANAGE_PANEL = "user_item";
    private static final String CLASS_USER_NAME_ON_MANAGE_PANEL = "ui_name";

    private static final String ID_MY_TEAM = "myTeam";

    private static final String ID_COMMENT_LIST = "chatListMessages";
    private static final String ID_SEARCH_COMMENT_LIST = "chatListFilterMessages";
    private static final String ID_SUBSCRIBE_LIST = "chatListUsers";

    private static final String ID_SEARCH_PANEL = "filterPanel";
    private static final String ID_SEARCH_PANEL_OPEN = "btnToSearchPanel";
    private static final String ID_SEARCH_PANEL_CLOSE = "btnOffFilterPanel";
    private static final String ID_SEARCH_PANEL_USERS = "btnPerson";

    private static final String ID_SEARCH_TEXT = "chatFilterSearch";
    private static final String ID_SEARCH_SEARCH = "filterStartSearch";
    private static final String ID_SEARCH_CLEAR = "filterClearSearch";

    @Autowired
    private SeleniumSettings seleniumSettings;

    @Autowired
    private Element element;

    @Autowired
    private ElementWait elementWait;

    @Autowired
    private ChatWait chatWait;

    @Autowired
    private Jquery jquery;

    @Autowired
    private AssertElement assertElement;

    @Autowired
    private ChatJs chatJs;

    public void checkMainPanelOnFormExist() {
        checkElementExist(ID_MAIN_BUTTON);
        checkElementExist(ID_MAIN_PANEL);
    }

    public void checkMainPanelOnFormNotExist() {
        checkElementNotExist(ID_MAIN_BUTTON);
        checkElementNotExist(ID_MAIN_PANEL);
    }

    public void checkMainPanelInGridExist() {
        checkElementExist(ID_MAIN_BUTTON + AbstractSeleniumCore.getGridIdx());
        checkElementExist(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
    }

    public void checkMainPanelInGridNotExist() {
        checkElementNotExist(ID_MAIN_BUTTON + AbstractSeleniumCore.getGridIdx());
        checkElementNotExist(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
    }

    public void checkAddNewCommentOnFormExist() {
        elementWait.waitElementVisibleById(ID_COMMENT_TEXT);
        elementWait.waitElementDisplayById(ID_COMMENT_TEXT);
        elementWait.waitElementVisibleById(ID_COMMENT_FILE);
        elementWait.waitElementDisplayById(ID_COMMENT_FILE);
        elementWait.waitElementVisibleById(ID_COMMENT_SEND);
        elementWait.waitElementDisplayById(ID_COMMENT_SEND);
    }

    public void checkAddNewCommentOnFormNotExist() {
        elementWait.waitElementNotVisibleById(ID_COMMENT_TEXT);
        elementWait.waitElementNotDisplayById(ID_COMMENT_TEXT);
        elementWait.waitElementNotVisibleById(ID_COMMENT_FILE);
        elementWait.waitElementNotDisplayById(ID_COMMENT_FILE);
        elementWait.waitElementNotVisibleById(ID_COMMENT_SEND);
        elementWait.waitElementNotDisplayById(ID_COMMENT_SEND);
    }

    public void checkAddNewCommentInGridExist() {
        elementWait.waitElementVisibleById(ID_COMMENT_TEXT + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_COMMENT_TEXT + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVisibleById(ID_COMMENT_FILE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_COMMENT_FILE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVisibleById(ID_COMMENT_SEND + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_COMMENT_SEND + AbstractSeleniumCore.getGridIdx());
    }

    public void checkAddNewCommentInGridNotExist() {
        elementWait.waitElementNotVisibleById(ID_COMMENT_TEXT + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotDisplayById(ID_COMMENT_TEXT + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotVisibleById(ID_COMMENT_FILE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotDisplayById(ID_COMMENT_FILE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotVisibleById(ID_COMMENT_SEND + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotDisplayById(ID_COMMENT_SEND + AbstractSeleniumCore.getGridIdx());
    }

    public void checkManageSubscribersOnFormExist() {
        elementWait.waitElementVisibleById(ID_MANAGE);
        elementWait.waitElementDisplayById(ID_MANAGE);
    }

    public void checkManageSubscribersOnFormNotExist() {
        elementWait.waitElementNotVisibleById(ID_MANAGE);
        elementWait.waitElementNotDisplayById(ID_MANAGE);
    }

    public void checkManageSubscribersInGridExist() {
        elementWait.waitElementVisibleById(ID_MANAGE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_MANAGE + AbstractSeleniumCore.getGridIdx());
    }

    public void checkManageSubscribersInGridNotExist() {
        elementWait.waitElementNotVisibleById(ID_MANAGE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotDisplayById(ID_MANAGE + AbstractSeleniumCore.getGridIdx());
    }

    public void checkSubscribeToggleOnFormExists() {
        int count = getToggleCount(ID_SUBSCRIBE_LIST);
        Assert.assertEquals(count > 0, true, "Toggles not found");
    }

    public void checkSubscribeToggleOnFormNotExists() {
        int count = getToggleCount(ID_SUBSCRIBE_LIST);
        Assert.assertEquals(count == 0, true, "Toggles found");
    }

    public void checkSubscribeToggleInGridExists() {
        int count = getToggleCount(ID_SUBSCRIBE_LIST + AbstractSeleniumCore.getGridIdx());
        Assert.assertEquals(count > 0, true, "Toggles not found");
    }

    public void checkSubscribeToggleInGridNotExists() {
        int count = getToggleCount(ID_SUBSCRIBE_LIST + AbstractSeleniumCore.getGridIdx());
        Assert.assertEquals(count == 0, true, "Toggles found");
    }

    public void openChatPanelOnForm() {
        elementWait.waitElementEnabledById(ID_MAIN_BUTTON);
        element.clickById(ID_MAIN_BUTTON);
        elementWait.waitElementVelocityAnimatedFinishById(ID_MAIN_PANEL);
        elementWait.waitElementVisibleById(ID_MAIN_PANEL);
        elementWait.waitElementDisplayById(ID_MAIN_PANEL);
        elementWait.waitElementNotVisibleById(ID_MAIN_LOADER);
        elementWait.waitElementNotDisplayById(ID_MAIN_LOADER);
    }

    public void openChatPanelInGrid() {
        elementWait.waitElementEnabledById(ID_MAIN_BUTTON + AbstractSeleniumCore.getGridIdx());
        element.clickById(ID_MAIN_BUTTON + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVelocityAnimatedFinishById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVisibleById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotVisibleById(ID_MAIN_LOADER + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotDisplayById(ID_MAIN_LOADER + AbstractSeleniumCore.getGridIdx());
    }

    public void closeChatPanelOnForm() {
        element.clickById(ID_MAIN_BUTTON);
        elementWait.waitElementVelocityAnimatedFinishById(ID_MAIN_PANEL);
        elementWait.waitElementNotVisibleById(ID_MAIN_PANEL);
        elementWait.waitElementNotDisplayById(ID_MAIN_PANEL);
    }

    public void closeChatPanelInGrid() {
        element.clickById(ID_CLOSE_BUTTON + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVelocityAnimatedFinishById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotVisibleById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotDisplayById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
    }

    public void openSubscribePanelOnForm() {
        element.clickById(ID_MANAGE);
        elementWait.waitElementVisibleById(ID_MANAGE_PANEL);
        elementWait.waitElementDisplayById(ID_MANAGE_PANEL);
        chatWait.waitIsReadySubscribePanel();
    }

    public void openSubscribePanelInGrid() {
        element.clickById(ID_MANAGE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVisibleById(ID_MANAGE_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_MANAGE_PANEL + AbstractSeleniumCore.getGridIdx());
        chatWait.waitIsReadySubscribePanel();
    }

    public void closeSubscribePanelOnForm() {
        element.clickById(ID_CLOSE_MANAGE_PANEL);
        elementWait.waitElementNotVisibleById(ID_MANAGE_PANEL);
        elementWait.waitElementNotDisplayById(ID_MANAGE_PANEL);
        elementWait.waitElementVisibleById(ID_MAIN_PANEL);
        elementWait.waitElementDisplayById(ID_MAIN_PANEL);
    }

    public void closeSubscribePanelInGrid() {
        element.clickById(ID_CLOSE_MANAGE_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotVisibleById(ID_MANAGE_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotDisplayById(ID_MANAGE_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVisibleById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
    }

    public void openSearchPanelOnForm() {
        element.clickById(ID_SEARCH_PANEL_OPEN);
        elementWait.waitElementVisibleById(ID_SEARCH_PANEL);
        elementWait.waitElementDisplayById(ID_SEARCH_PANEL);
    }

    public void openSearchPanelInGrid() {
        element.clickById(ID_SEARCH_PANEL_OPEN + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVisibleById(ID_SEARCH_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_SEARCH_PANEL + AbstractSeleniumCore.getGridIdx());
    }

    public void closeSearchPanelOnForm() {
        element.clickById(ID_SEARCH_PANEL_CLOSE);
        elementWait.waitElementNotVisibleById(ID_SEARCH_PANEL);
        elementWait.waitElementNotDisplayById(ID_SEARCH_PANEL);
        elementWait.waitElementVisibleById(ID_MAIN_PANEL);
        elementWait.waitElementDisplayById(ID_MAIN_PANEL);
    }

    public void closeSearchPanelInGrid() {
        element.clickById(ID_SEARCH_PANEL_CLOSE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotVisibleById(ID_SEARCH_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotDisplayById(ID_SEARCH_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementVisibleById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementDisplayById(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx());
    }

    public void selectUserOnSearchPanelOnForm(String userName) {
        seleniumSettings.getWebDriver().findElement(By.id(ID_SEARCH_PANEL_USERS)).click();

        WebElement dialog = getDialog();
        jquery.waitLoad();
        WebElement user = getUserFromSearchPanel(userName);
        element.click(user);
        dialog.findElement(By.id("buttonOk")).click();
        jquery.waitLoad();
    }

    public void selectUserOnSearchPanelInGrid(String userName) {
        seleniumSettings.getWebDriver().findElement(By.id(ID_SEARCH_PANEL_USERS + AbstractSeleniumCore.getGridIdx())).click();

        WebElement dialog = getDialog();
        jquery.waitLoad();
        WebElement user = getUserFromSearchPanel(userName);
        element.click(user);
        dialog.findElement(By.id("buttonOk")).click();
        jquery.waitLoad();
    }

    public void unselectUserOnSearchPanelOnForm(String userName) {
        seleniumSettings.getWebDriver().findElement(By.id(ID_SEARCH_PANEL_USERS)).click();

        WebElement dialog = getDialog();
        jquery.waitLoad();
        WebElement user = getUserFromSearchPanel(userName);
        element.click(user);
        dialog.findElement(By.id("buttonOk")).click();
        jquery.waitLoad();
    }

    public void unselectUserOnSearchPanelInGrid(String userName) {
        seleniumSettings.getWebDriver().findElement(By.id(ID_SEARCH_PANEL_USERS + AbstractSeleniumCore.getGridIdx())).click();

        WebElement dialog = getDialog();
        jquery.waitLoad();
        WebElement user = getUserFromSearchPanel(userName);
        element.click(user);
        dialog.findElement(By.id("buttonOk")).click();
        jquery.waitLoad();
    }

    public void subscribeCurrentUserOnForm() {
        element.clickById(ID_SUBSCRIBE);
        elementWait.waitElementNotVisibleById(ID_SUBSCRIBE);
    }

    public void subscribeCurrentUserInGrid() {
        element.clickById(ID_SUBSCRIBE + AbstractSeleniumCore.getGridIdx());
        elementWait.waitElementNotVisibleById(ID_SUBSCRIBE + AbstractSeleniumCore.getGridIdx());
    }

    public void subscribeUserOnForm(String userName) {
        int beforeCount = getSubscribedUsersCountOnForm();
        WebElement user = getUserFromManagePanelOnForm(userName);
        element.click(user);
        chatWait.waitSubscribedUsersCountOnForm(beforeCount + 1);
    }

    public void subscribeUserInGrid(String userName) {
        int beforeCount = getSubscribedUsersCountInGrid();
        WebElement user = getUserFromManagePanelInGrid(userName);
        element.click(user);
        chatWait.waitSubscribedUsersCountInGrid(beforeCount + 1);
    }

    public void unsubscribeUserOnForm(String userName) {
        int beforeCount = getSubscribedUsersCountOnForm();
        WebElement user = getUserFromManagePanelOnForm(userName);
        element.click(user);
        chatWait.waitSubscribedUsersCountOnForm(beforeCount - 1);
    }

    public void unsubscribeUserInGrid(String userName) {
        int beforeCount = getSubscribedUsersCountInGrid();
        WebElement user = getUserFromManagePanelInGrid(userName);
        element.click(user);
        chatWait.waitSubscribedUsersCountInGrid(beforeCount - 1);
    }

    public void checkCurrentUserIsSubscribedOnForm() {
        boolean isSubscribe = !seleniumSettings.getWebDriver().findElement(By.id(ID_SUBSCRIBE)).isDisplayed();
        Assert.assertEquals(isSubscribe, true);
    }

    public void checkCurrentUserIsSubscribedInGrid() {
        boolean isSubscribe = !seleniumSettings.getWebDriver().findElement(By.id(ID_SUBSCRIBE + AbstractSeleniumCore.getGridIdx())).isDisplayed();
        Assert.assertEquals(isSubscribe, true);
    }

    public void checkCurrentUserIsUnsubscribedOnForm() {
        boolean isSubscribe = !seleniumSettings.getWebDriver().findElement(By.id(ID_SUBSCRIBE)).isDisplayed();
        Assert.assertEquals(isSubscribe, false);
    }

    public void checkCurrentUserIsUnsubscribedInGrid() {
        boolean isSubscribe = !seleniumSettings.getWebDriver().findElement(By.id(ID_SUBSCRIBE + AbstractSeleniumCore.getGridIdx())).isDisplayed();
        Assert.assertEquals(isSubscribe, false);
    }

    public void checkUserIsSubscribedOnForm(String userName) {
        WebElement user = getUserFromManagePanelOnForm(userName);
        boolean isSubscribe = isUserSubscribed(user);
        Assert.assertEquals(isSubscribe, true);
    }

    public void checkUserIsSubscribedInGrid(String userName) {
        WebElement user = getUserFromManagePanelInGrid(userName);
        boolean isSubscribe = isUserSubscribed(user);
        Assert.assertEquals(isSubscribe, true);
    }

    public void checkUserIsUnsubscribedOnForm(String userName) {
        WebElement user = getUserFromManagePanelOnForm(userName);
        boolean isSubscribe = isUserSubscribed(user);
        Assert.assertEquals(isSubscribe, false);
    }

    public void checkUserIsUnsubscribedInGrid(String userName) {
        WebElement user = getUserFromManagePanelInGrid(userName);
        boolean isSubscribe = isUserSubscribed(user);
        Assert.assertEquals(isSubscribe, false);
    }

    public int getSubscribedUsersCountOnForm() {
        String subtitle = seleniumSettings.getWebDriver().findElement(By.id(ID_MANAGE_PANEL)).findElement(By.className(CLASS_MANAGE_PANEL_SUBTITLE)).getText();
        String subscribedUsersCount = subtitle.substring(0, subtitle.indexOf("of")).trim();
        return Integer.parseInt(subscribedUsersCount);
    }

    public int getSubscribedUsersCountInGrid() {
        String subtitle = seleniumSettings.getWebDriver().findElement(By.id(ID_MANAGE_PANEL + AbstractSeleniumCore.getGridIdx())).findElement(By.className(CLASS_MANAGE_PANEL_SUBTITLE)).getText();
        String subscribedUsersCount = subtitle.substring(0, subtitle.indexOf("of")).trim();
        return Integer.parseInt(subscribedUsersCount);
    }

    public void sendMessageOnFormAndWait(String message) {
        sendMessageOnForm(message);
        elementWait.waitElementNotDisplayById(ID_COMMENT_LOADER);
    }

    public void sendMessageOnForm(String message) {
        seleniumSettings.getWebDriver().findElement(By.id(ID_COMMENT_TEXT)).sendKeys(message);
        element.clickById(ID_COMMENT_SEND);
    }

    public void sendMessageInGridAndWait(String message) {
        sendMessageInGrid(message);
        elementWait.waitElementNotDisplayById(ID_COMMENT_LOADER + AbstractSeleniumCore.getGridIdx());
    }

    public void sendMessageInGrid(String message) {
        seleniumSettings.getWebDriver().findElement(By.id(ID_COMMENT_TEXT + AbstractSeleniumCore.getGridIdx())).sendKeys(message);
        element.clickById(ID_COMMENT_SEND + AbstractSeleniumCore.getGridIdx());
    }

    public void searchMessageOnForm(String text) {
        element.clickById(ID_SEARCH_CLEAR);
        seleniumSettings.getWebDriver().findElement(By.id(ID_SEARCH_TEXT)).sendKeys(text);
        element.clickById(ID_SEARCH_SEARCH);
        jquery.waitLoad();
    }

    public void searchMessageInGrid(String text) {
        element.clickById(ID_SEARCH_CLEAR + AbstractSeleniumCore.getGridIdx());
        seleniumSettings.getWebDriver().findElement(By.id(ID_SEARCH_TEXT + AbstractSeleniumCore.getGridIdx())).sendKeys(text);
        element.clickById(ID_SEARCH_SEARCH + AbstractSeleniumCore.getGridIdx());
        jquery.waitLoad();
    }

    public void checkMyTeamIsOnOnForm() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL)).findElement(By.id(ID_MY_TEAM));
        boolean toggleIsOn = isToggleOn(toggle);
        Assert.assertEquals(toggleIsOn, true);
    }

    public void checkMyTeamIsOnInGrid() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx())).findElement(By.id(ID_MY_TEAM));
        boolean toggleIsOn = isToggleOn(toggle);
        Assert.assertEquals(toggleIsOn, true);
    }

    public void checkMyTeamIsOffOnForm() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL)).findElement(By.id(ID_MY_TEAM));
        boolean toggleIsOn = isToggleOn(toggle);
        Assert.assertEquals(toggleIsOn, false);
    }

    public void checkMyTeamIsOffInGrid() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx())).findElement(By.id(ID_MY_TEAM));
        boolean toggleIsOn = isToggleOn(toggle);
        Assert.assertEquals(toggleIsOn, false);
    }

    public void checkMyTeamEnabledOnForm() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL)).findElement(By.id(ID_MY_TEAM));
        WebElement toggleCheckbox = getToggleCheckbox(toggle);
        assertElement.assertElementEnabled(toggleCheckbox);
    }

    public void checkMyTeamEnabledInGrid() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx())).findElement(By.id(ID_MY_TEAM));
        WebElement toggleCheckbox = getToggleCheckbox(toggle);
        assertElement.assertElementEnabled(toggleCheckbox);
    }

    public void checkMyTeamDisabledOnForm() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL)).findElement(By.id(ID_MY_TEAM));
        WebElement toggleCheckbox = getToggleCheckbox(toggle);
        assertElement.assertElementDisabled(toggleCheckbox);
    }

    public void checkMyTeamDisabledInGrid() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx())).findElement(By.id(ID_MY_TEAM));
        WebElement toggleCheckbox = getToggleCheckbox(toggle);
        assertElement.assertElementDisabled(toggleCheckbox);
    }

    public void switchMyTeamOnForm() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL)).findElement(By.id(ID_MY_TEAM));
        element.click(toggle);
        chatWait.waitIsReadySubscribePanel();
    }

    public void switchMyTeamInGrid() {
        WebElement toggle = seleniumSettings.getWebDriver().findElement(By.id(ID_MAIN_PANEL + AbstractSeleniumCore.getGridIdx())).findElement(By.id(ID_MY_TEAM));
        element.click(toggle);
        chatWait.waitIsReadySubscribePanel();
    }

    public void scrollUpListWithMessagesOnForm() {
        chatJs.scrollUpList(ID_COMMENT_LIST);
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollUpListWithMessagesInGrid() {
        chatJs.scrollUpList(ID_COMMENT_LIST + AbstractSeleniumCore.getGridIdx());
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollDownListWithMessagesOnForm() {
        chatJs.scrollDownList(ID_COMMENT_LIST);
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollDownListWithMessagesInGrid() {
        chatJs.scrollDownList(ID_COMMENT_LIST + AbstractSeleniumCore.getGridIdx());
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollUpListWithSearchMessagesOnForm() {
        chatJs.scrollUpList(ID_SEARCH_COMMENT_LIST);
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollUpListWithSearchMessagesInGrid() {
        chatJs.scrollUpList(ID_SEARCH_COMMENT_LIST + AbstractSeleniumCore.getGridIdx());
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollDownListWithSearchMessagesOnForm() {
        chatJs.scrollDownList(ID_SEARCH_COMMENT_LIST);
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollDownListWithSearchMessagesInGrid() {
        chatJs.scrollDownList(ID_SEARCH_COMMENT_LIST + AbstractSeleniumCore.getGridIdx());
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollUpListWithSubscribersOnForm() {
        chatJs.scrollUpList(ID_SUBSCRIBE_LIST);
        AbstractSeleniumCore.correctSleep(1000L);
        jquery.waitLoad();
    }

    public void scrollUpListWithSubscribersInGrid() {
        chatJs.scrollUpList(ID_SUBSCRIBE_LIST + AbstractSeleniumCore.getGridIdx());
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollDownListWithSubscribersOnForm() {
        chatJs.scrollDownList(ID_SUBSCRIBE_LIST);
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    public void scrollDownListWithSubscribersInGrid() {
        chatJs.scrollDownList(ID_SUBSCRIBE_LIST + AbstractSeleniumCore.getGridIdx());
        AbstractSeleniumCore.correctSleep(100L);
        jquery.waitLoad();
    }

    private WebElement getUserFromSearchPanel(String userName) {
        WebElement result = null;

        List<WebElement> users = seleniumSettings.getWebDriver().findElement(By.className("md_dialog")).findElements(By.className(CLASS_USER_ON_MANAGE_PANEL));
        for (WebElement user : users) {
            if (userName.equals(user.findElement(By.className(CLASS_USER_NAME_ON_MANAGE_PANEL)).getAttribute("textContent"))) {
                if (result != null) {
                    throw new SeleniumUnexpectedException("User [" + userName + "] found many times");
                }
                result = user;
            }
        }

        if (result == null) {
            throw new SeleniumUnexpectedException("User [" + userName + "] not found");
        }

        return result;
    }

    private WebElement getUserFromManagePanelOnForm(String userName) {
        WebElement result = null;

        List<WebElement> users = seleniumSettings.getWebDriver().findElement(By.id(ID_MANAGE_PANEL)).findElements(By.className(CLASS_USER_ON_MANAGE_PANEL));
        for (WebElement user : users) {
            if (userName.equals(user.findElement(By.className(CLASS_USER_NAME_ON_MANAGE_PANEL)).getAttribute("textContent"))) {
                if (result != null) {
                    throw new SeleniumUnexpectedException("User [" + userName + "] found many times");
                }
                result = user;
            }
        }

        if (result == null) {
            throw new SeleniumUnexpectedException("User [" + userName + "] not found");
        }

        return result;
    }

    private WebElement getUserFromManagePanelInGrid(String userName) {
        WebElement result = null;

        List<WebElement> users = seleniumSettings.getWebDriver().findElement(By.id(ID_MANAGE_PANEL + AbstractSeleniumCore.getGridIdx())).findElements(By.className(CLASS_USER_ON_MANAGE_PANEL));
        for (WebElement user : users) {
            if (userName.equals(user.findElement(By.className(CLASS_USER_NAME_ON_MANAGE_PANEL)).getAttribute("textContent"))) {
                if (result != null) {
                    throw new SeleniumUnexpectedException("User [" + userName + "] found many times");
                }
                result = user;
            }
        }

        if (result == null) {
            throw new SeleniumUnexpectedException("User [" + userName + "] not found");
        }

        return result;
    }

    private boolean isUserSubscribed(WebElement user) {
        String userClass = user.getAttribute("class");
        String toggleClass = user.findElement(By.className(CLASS_TOGGLE)).getAttribute("class");
        if (userClass.contains("selected") && toggleClass.contains("toggle_on")) {
            return true;
        }
        return false;
    }

    private void checkElementExist(String id) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(id)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertEquals(count, 1, "Element not found");
    }

    private void checkElementNotExist(String id) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(id)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertEquals(count, 0, "Element found");
    }

    private int getToggleCount(String id) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElement(By.id(id)).findElements(By.className(CLASS_TOGGLE)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return count;
    }

    private boolean isToggleOn(WebElement toggle) {
        return toggle.getAttribute("class").contains("toggle_on");
    }

    private WebElement getToggleCheckbox(WebElement toggle) {
        return toggle.findElement(By.className("tg_checkbox"));
    }

    private WebElement getDialog() {
        return seleniumSettings.getWebDriver().findElement(By.className("md_dialog"));
    }

}