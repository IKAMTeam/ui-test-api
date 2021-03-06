package com.onevizion.uitest.api.helper.page.button;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.onevizion.uitest.api.AbstractSeleniumCore;
import com.onevizion.uitest.api.SeleniumSettings;
import com.onevizion.uitest.api.helper.Alert;
import com.onevizion.uitest.api.helper.Element;
import com.onevizion.uitest.api.helper.ElementWait;
import com.onevizion.uitest.api.helper.Wait;
import com.onevizion.uitest.api.helper.Window;
import com.onevizion.uitest.api.helper.grid.Grid2;
import com.onevizion.uitest.api.helper.tab.Tab;
import com.onevizion.uitest.api.helper.tree.Tree;

@Component
public class PageButton {

    private static final String BUTTON_EDIT_ID_BASE = "btnEdit";

    private static final String BUTTON_OPTIONS_ID_BASE = "btnoptionsGroupOpener";
    private static final String BUTTON_OPTIONS_PANEL_ID_BASE = "optionsGrouppopupMenu";

    private static final String BUTTON_APPLETS_ID_BASE = "btneditGroupOpener";
    private static final String BUTTON_APPLETS_PANEL_ID_BASE = "editGrouppopupMenu";

    private static final String BUTTON_APPLET_TASKS_ID_BASE = "itemTask";
    private static final String BUTTON_APPLET_WF_ID_BASE = "itemWF";

    private static final String BUTTON_WF_START_ID_BASE = "newWf";
    private static final String BUTTON_WF_START_TEMPLATE_ID_BASE = "wftmpl_";
    private static final String BUTTON_WF_START_MASS_ID_BASE = "massNewWf";
    private static final String BUTTON_WF_START_MASS_TEMPLATE_ID_BASE = "masswftmpl_";

    private static final String BUTTON_ADD_GRID_ID_BASE = "itemAdd";
    private static final String BUTTON_GRID_ROW_EDITOR_ID_BASE = "itemEditRow";
    private static final String BUTTON_SHOW_SQL_ID_BASE = "itemSQL";
    private static final String BUTTON_RULES_ID_BASE = "itemRules";
    private static final String BUTTON_CLONE_ID_BASE = "itemClone";
    private static final String BUTTON_EXPORT_RUN_ID_BASE = "itemGridExport";
    private static final String BUTTON_EXPORT_HISTORY_ID_BASE = "itemExportHistory";
    private static final String BUTTON_SAVE_AS_GLOBAL_TREE_ID_BASE = "itemSaveAsGlobalTree";
    private static final String BUTTON_DELETE_TREE_ID_BASE = "itemDeleteTree";
    private static final String BUTTON_DELETE_GRID_ID_BASE = "itemDelete";
    private static final String BUTTON_UP_TREE_ID_BASE = "itemUpTree";
    private static final String BUTTON_DOWN_TREE_ID_BASE = "itemDownTree";
    private static final String BUTTON_UP_GRID_ID_BASE = "itemUp";
    private static final String BUTTON_DOWN_GRID_ID_BASE = "itemDown";
    private static final String BUTTON_CALL_STACK_ID_BASE = "itemCallStack";
    private static final String BUTTON_BULK_FILE_UPLOAD_ID_BASE = "itemBulkUpload";

    private static final String BUTTON_COMPONENT_EXPORT_ID_BASE = "itemExportRun";
    private static final String BUTTON_COMPONENT_IMPORT_ID_BASE = "itemImportRun";
    private static final String BUTTON_FIELD_COLORS_ID_BASE = "itemColors";
    private static final String BUTTON_FIELD_COORDINATES_ID_BASE = "itemCoordLinks";
    private static final String BUTTON_FIELD_VALIDATIONS_ID_BASE = "itemValidation";
    private static final String BUTTON_FIELD_CASCADING_FIELDS_ID_BASE = "itemFieldsMap";
    private static final String BUTTON_CASCADE_FIELDS_IMPORT_RELATIONS_ID_BASE = "itemVtableLinksValueTree";
    private static final String BUTTON_CASCADE_FIELDS_RELATIONS_ID_BASE = "itemVtableLinksTree";
    private static final String BUTTON_REPORT_REPORT_WIZARD_ID = "itemReportWizard";
    private static final String BUTTON_REPORT_GROUPS_ID_BASE = "itemReportGroup";
    private static final String BUTTON_REPORT_TEST_SQL_ID_BASE = "itemTestSql";
    private static final String BUTTON_REPORT_SCAN_PARAMS_ID_BASE = "itemScanParams";
    private static final String BUTTON_REPORT_INSERT_RANGE_ID_BASE = "itemInsertRange";
    private static final String BUTTON_REPORT_SHIFT_RANGE_ID_BASE = "itemShiftCols";
    private static final String BUTTON_REPORT_REMOVE_RANGE_ID_BASE = "itemRemoveRange";
    private static final String BUTTON_WP_DISCIPLINES_ID_BASE = "itemDiscp";
    private static final String BUTTON_WP_DATE_PAIRS_ID_BASE = "itemDatePairs";
    private static final String BUTTON_WP_CALENDARS_ID_BASE = "itemCalendar";
    private static final String BUTTON_APPLET_REORDER_ID_BASE = "itemReorderApplets";
    private static final String BUTTON_WF_EDITOR_ID_BASE = "itemVisualEditor";
    private static final String BUTTON_DG_DELETE_CONFIG_ID_BASE = "itemDelConfig";
    private static final String BUTTON_LABEL_REPLACE_TEXT_ID_BASE = "itemReplace";
    private static final String BUTTON_INTEGRATION_ADD_ID_BASE = "itemAddIntegration";
    private static final String BUTTON_V_TABLE_REORDER_ID_BASE = "itemReorder";
    private static final String BUTTON_IMPORT_RECOVERY_ID_BASE = "itemRecover";
    private static final String BUTTON_IMPORT_RECOVERY_HISTORY_ID_BASE = "itemRecoveryHistory";
    private static final String BUTTON_IMPORT_INTERRUPT_ID_BASE = "itemImpStop";
    private static final String BUTTON_TF_EMAIL_ACCOUNT_ID_BASE = "itemEmailAccountSettings";
    private static final String BUTTON_TT_TRACKOR_MAIL_ID_BASE = "itemTmSetup";
    private static final String BUTTON_AUDIT_LOG_RECOVERY_ID_BASE = "itemRecover";
    private static final String BUTTON_BPDOC_ITEM_PREVIEW_ID_BASE = "itemReport";

    private static final String BUTTON_REPORT_DETAILS_ID_BASE = "btnDetails";
    private static final String BUTTON_PROCESS_DETAILS_ID_BASE = "btnDetails";

    @Autowired
    private SeleniumSettings seleniumSettings;

    @Autowired
    private ElementWait elementWait;

    @Autowired
    private Window window;

    @Autowired
    private Grid2 grid2;

    @Autowired
    private Wait wait;

    @Autowired
    private Element element;

    @Autowired
    private Tree tree;

    @Autowired
    private Tab tab;

    @Autowired
    private PageButtonWait gridButtonWait;

    @Autowired
    private Alert alert;

    public void openAppletForm(Long gridIdx, Long configAppId) {
        openAppletsPanel(gridIdx);
        waitButtonInPanel("item" + configAppId);

        window.openModal(By.id("item" + configAppId));
    }

    public void checkAppletNotExist(Long gridIdx, Long configAppId) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id("item" + configAppId)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 0);

        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        count = seleniumSettings.getWebDriver().findElements(By.id("btn" + configAppId)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 0);
    }

    public void openAppletTasks(Long gridIdx) {
        openAppletsPanel(gridIdx);
        waitButtonInPanel(BUTTON_APPLET_TASKS_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_APPLET_TASKS_ID_BASE + gridIdx));
        grid2.waitLoad();
    }

    public void openAppletWf(Long gridIdx) {
        openAppletsPanel(gridIdx);
        waitButtonInPanel(BUTTON_APPLET_WF_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_APPLET_WF_ID_BASE + gridIdx));
        wait.waitWebElement(By.id("Close"));
        tab.waitLoad(1);
    }

    public void openStartWfForm(Long gridIdx, Long wfTemplateId) {
        openAppletsPanel(gridIdx);
        waitButtonInPanel(BUTTON_APPLET_WF_ID_BASE + gridIdx);

        seleniumSettings.getWebDriver().findElement(By.id(BUTTON_APPLET_WF_ID_BASE + gridIdx)).click();
        waitButtonInPanel(BUTTON_WF_START_ID_BASE);

        seleniumSettings.getWebDriver().findElement(By.id(BUTTON_WF_START_ID_BASE)).click();
        waitButtonInPanel(BUTTON_WF_START_TEMPLATE_ID_BASE + wfTemplateId);

        window.openModal(By.id(BUTTON_WF_START_TEMPLATE_ID_BASE + wfTemplateId));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openMassStartWfForm(Long gridIdx, Long wfTemplateId) {
        openAppletsPanel(gridIdx);
        waitButtonInPanel(BUTTON_APPLET_WF_ID_BASE + gridIdx);

        seleniumSettings.getWebDriver().findElement(By.id(BUTTON_APPLET_WF_ID_BASE + gridIdx)).click();
        waitButtonInPanel(BUTTON_WF_START_MASS_ID_BASE);

        seleniumSettings.getWebDriver().findElement(By.id(BUTTON_WF_START_MASS_ID_BASE)).click();
        waitButtonInPanel(BUTTON_WF_START_MASS_TEMPLATE_ID_BASE + wfTemplateId);

        window.openModal(By.id(BUTTON_WF_START_MASS_TEMPLATE_ID_BASE + wfTemplateId));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openGridRowEditorForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_GRID_ROW_EDITOR_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_GRID_ROW_EDITOR_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitGridRowEditorLoad();
    }

    public void openShowSqlForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_SHOW_SQL_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_SHOW_SQL_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
        wait.waitFormLoad();
    }

    public void openRulesForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_RULES_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_RULES_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        grid2.waitLoad(1L);
    }

    public void openCloneForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_CLONE_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_CLONE_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openExportRunForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_EXPORT_RUN_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_EXPORT_RUN_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openExportHistoryGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_EXPORT_HISTORY_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_EXPORT_HISTORY_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_CLOSE_ID_BASE + AbstractSeleniumCore.getGridIdx()));
        grid2.waitLoad();
    }

    public void clickSaveAsGlobalTree(Long treeIdx) {
        openOptionsPanel(treeIdx);
        waitButtonInPanel(BUTTON_SAVE_AS_GLOBAL_TREE_ID_BASE + treeIdx);

        element.clickById(BUTTON_SAVE_AS_GLOBAL_TREE_ID_BASE + treeIdx);
        tree.waitLoad(treeIdx);
    }

    public void clickDeleteTree(Long treeIdx) {
        openOptionsPanel(treeIdx);
        waitButtonInPanel(BUTTON_DELETE_TREE_ID_BASE + treeIdx);

        element.clickById(BUTTON_DELETE_TREE_ID_BASE + treeIdx);
        alert.accept();
        tree.waitLoad(treeIdx);
    }

    public void clickDeleteGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_DELETE_GRID_ID_BASE + gridIdx);

        element.clickById(BUTTON_DELETE_GRID_ID_BASE + gridIdx);
    }

    public void clickDeleteGridAndWait(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_DELETE_GRID_ID_BASE + gridIdx);

        element.clickById(BUTTON_DELETE_GRID_ID_BASE + gridIdx);
        alert.accept();
        grid2.waitLoad(gridIdx);
    }

    public void clickDeleteGridAndWait(Long gridIdx, String message) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_DELETE_GRID_ID_BASE + gridIdx);

        element.clickById(BUTTON_DELETE_GRID_ID_BASE + gridIdx);
        alert.accept(message);
        grid2.waitLoad(gridIdx);
    }

    public void clickUpTree(Long treeIdx) {
        openOptionsPanel(treeIdx);
        waitButtonInPanel(BUTTON_UP_TREE_ID_BASE + treeIdx);

        element.clickById(BUTTON_UP_TREE_ID_BASE + treeIdx);
        tree.waitLoad(treeIdx);
    }

    public void clickDownTree(Long treeIdx) {
        openOptionsPanel(treeIdx);
        waitButtonInPanel(BUTTON_DOWN_TREE_ID_BASE + treeIdx);

        element.clickById(BUTTON_DOWN_TREE_ID_BASE + treeIdx);
        tree.waitLoad(treeIdx);
    }

    public void clickUpGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_UP_GRID_ID_BASE + gridIdx);

        element.clickById(BUTTON_UP_GRID_ID_BASE + gridIdx);
        grid2.waitLoad(gridIdx);
    }

    public void clickDownGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_DOWN_GRID_ID_BASE + gridIdx);

        element.clickById(BUTTON_DOWN_GRID_ID_BASE + gridIdx);
        grid2.waitLoad(gridIdx);
    }

    public void openCallStackGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_CALL_STACK_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_CALL_STACK_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_CLOSE_ID_BASE + AbstractSeleniumCore.getGridIdx()));
        grid2.waitLoad();
    }

    public void openBulkFileUploadForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_BULK_FILE_UPLOAD_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_BULK_FILE_UPLOAD_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openComponentExportForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_COMPONENT_EXPORT_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_COMPONENT_EXPORT_ID_BASE + gridIdx));
        wait.waitReloadForm("form=1");
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void clickComponentImport(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_COMPONENT_IMPORT_ID_BASE + gridIdx);

        element.clickById(BUTTON_COMPONENT_IMPORT_ID_BASE + gridIdx);
        grid2.waitLoad(gridIdx);
    }

    public void openFieldColorsGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_FIELD_COLORS_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_FIELD_COLORS_ID_BASE + gridIdx));
        grid2.waitLoad();
    }

    public void openFieldCoordinatesGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_FIELD_COORDINATES_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_FIELD_COORDINATES_ID_BASE + gridIdx));
        grid2.waitLoad();
    }

    public void openFieldValidationsGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_FIELD_VALIDATIONS_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_FIELD_VALIDATIONS_ID_BASE + gridIdx));
        grid2.waitLoad();
    }

    public void openFieldCascadingFieldsForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_FIELD_CASCADING_FIELDS_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_FIELD_CASCADING_FIELDS_ID_BASE + gridIdx));
        tree.waitLoad(AbstractSeleniumCore.getTreeIdx());
    }

    public void openCascadeFieldsImportRelationsForm(Long treeIdx) {
        openOptionsPanel(treeIdx);
        waitButtonInPanel(BUTTON_CASCADE_FIELDS_IMPORT_RELATIONS_ID_BASE + treeIdx);

        window.openModal(By.id(BUTTON_CASCADE_FIELDS_IMPORT_RELATIONS_ID_BASE + treeIdx));
        tree.waitLoad(AbstractSeleniumCore.getTreeIdx());
        wait.waitFormLoad();
    }

    public void openCascadeFieldsRelationsForm(Long treeIdx) {
        openOptionsPanel(treeIdx);
        waitButtonInPanel(BUTTON_CASCADE_FIELDS_RELATIONS_ID_BASE + treeIdx);

        window.openModal(By.id(BUTTON_CASCADE_FIELDS_RELATIONS_ID_BASE + treeIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openReportWizardForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_REPORT_REPORT_WIZARD_ID + gridIdx);

        window.openModal(By.id(BUTTON_REPORT_REPORT_WIZARD_ID + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
        wait.waitFormLoad();
    }

    public void openReportGroupsGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_REPORT_GROUPS_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_REPORT_GROUPS_ID_BASE + gridIdx));
        grid2.waitLoad();
    }

    public void openReportTestSqlForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_REPORT_TEST_SQL_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_REPORT_TEST_SQL_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
        wait.waitFormLoad();
        wait.waitCodeMirrorLoad("SQL");
        elementWait.waitElementNotVisibleById("lblSuccess");
        elementWait.waitElementNotDisplayById("lblSuccess");
        elementWait.waitElementNotVisibleById("lblFailure");
        elementWait.waitElementNotDisplayById("lblFailure");
    }

    public void openReportInsertRangeForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_REPORT_INSERT_RANGE_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_REPORT_INSERT_RANGE_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openReportShiftRangeForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_REPORT_SHIFT_RANGE_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_REPORT_SHIFT_RANGE_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openReportRemoveRangeForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_REPORT_REMOVE_RANGE_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_REPORT_REMOVE_RANGE_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void clickReportScanParams(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_REPORT_SCAN_PARAMS_ID_BASE + gridIdx);

        element.clickById(BUTTON_REPORT_SCAN_PARAMS_ID_BASE + gridIdx);
        grid2.waitLoad(gridIdx);
    }

    public void openReportDetailsForm(Long gridIdx) {
        window.openModal(By.id(BUTTON_REPORT_DETAILS_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openProcessDetailsForm(Long gridIdx) {
        window.openModal(By.id(BUTTON_PROCESS_DETAILS_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openWpDisciplinesGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_WP_DISCIPLINES_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_WP_DISCIPLINES_ID_BASE + gridIdx));
        grid2.waitLoad();
    }

    public void openWpDatePairsGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_WP_DATE_PAIRS_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_WP_DATE_PAIRS_ID_BASE + gridIdx));
        grid2.waitLoad();
    }

    public void openWpCalendarsGrid(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_WP_CALENDARS_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_WP_CALENDARS_ID_BASE + gridIdx));
        grid2.waitLoad();
    }

    public void openAppletReorderForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_APPLET_REORDER_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_APPLET_REORDER_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openWfEditorForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_WF_EDITOR_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_WF_EDITOR_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
        wait.waitFormLoad();
    }

    public void openDgDeleteConfigForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_DG_DELETE_CONFIG_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_DG_DELETE_CONFIG_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
        grid2.waitLoad(1L);
    }

    public void openLabelReplaceTextForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_LABEL_REPLACE_TEXT_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_LABEL_REPLACE_TEXT_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openIntegrationAddForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_INTEGRATION_ADD_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_INTEGRATION_ADD_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void clickVtableReorder(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_V_TABLE_REORDER_ID_BASE + gridIdx);

        element.clickById(BUTTON_V_TABLE_REORDER_ID_BASE + gridIdx);
        alert.accept("Are you sure you want to reorder the entries based on alphabetically sorting the values?");
        grid2.waitLoad(gridIdx);
    }

    public void clickImportRecover(Long gridIdx, String processId) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_IMPORT_RECOVERY_ID_BASE + gridIdx);

        element.clickById(BUTTON_IMPORT_RECOVERY_ID_BASE + gridIdx);
        alert.accept("Are you sure you want to recover selected import (Process ID = " + processId + ")?");
    }

    public void openImportRecoveryHistoryForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_IMPORT_RECOVERY_HISTORY_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_IMPORT_RECOVERY_HISTORY_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
        grid2.waitLoad();
    }

    public void clickImportInterrupt(Long gridIdx, String processId) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_IMPORT_INTERRUPT_ID_BASE + gridIdx);

        element.clickById(BUTTON_IMPORT_INTERRUPT_ID_BASE + gridIdx);
        alert.accept("Are you sure you want to interrupt selected import (Process ID = " + processId + ")?");
    }

    public void openTfEmailAccountForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_TF_EMAIL_ACCOUNT_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_TF_EMAIL_ACCOUNT_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openTtTrackorMailForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_TT_TRACKOR_MAIL_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_TT_TRACKOR_MAIL_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openAuditLogRecoverForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_AUDIT_LOG_RECOVERY_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_AUDIT_LOG_RECOVERY_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_OK_ID_BASE));
        wait.waitFormLoad();
    }

    public void openBpdocItemPreviewForm(Long gridIdx) {
        openOptionsPanel(gridIdx);
        waitButtonInPanel(BUTTON_BPDOC_ITEM_PREVIEW_ID_BASE + gridIdx);

        window.openModal(By.id(BUTTON_BPDOC_ITEM_PREVIEW_ID_BASE + gridIdx));
        wait.waitWebElement(By.id(AbstractSeleniumCore.BUTTON_CANCEL_ID_BASE));
        wait.waitFormLoad();
    }

    public void checkAddButtonExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_ADD_GRID_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 1);
    }

    public void checkAddButtonNotExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_ADD_GRID_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 0);
    }

    public void checkCloneButtonExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_CLONE_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 1);
    }

    public void checkCloneButtonNotExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_CLONE_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 0);
    }

    public void checkEditButtonExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_EDIT_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 1);
    }

    public void checkEditButtonNotExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_EDIT_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 0);
    }

    public void checkDeleteButtonExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_DELETE_GRID_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 1);
    }

    public void checkDeleteButtonNotExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_DELETE_GRID_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 0);
    }

    public void checkAppletReorderButtonExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_APPLET_REORDER_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 1);
    }

    public void checkAppletReorderButtonNotExist(Long gridIdx) {
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        int count = seleniumSettings.getWebDriver().findElements(By.id(BUTTON_APPLET_REORDER_ID_BASE + gridIdx)).size();
        seleniumSettings.getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(count, 0);
    }

    public void waitButtonEditDisabled(Long gridIdx) {
        gridButtonWait.waitButtonDisabledById(BUTTON_EDIT_ID_BASE + gridIdx);
    }

    public void waitButtonEditEnabled(Long gridIdx) {
        gridButtonWait.waitButtonEnabledById(BUTTON_EDIT_ID_BASE + gridIdx);
    }

    private void openOptionsPanel(Long gridIdx) {
        elementWait.waitElementById(BUTTON_OPTIONS_ID_BASE + gridIdx);
        seleniumSettings.getWebDriver().findElement(By.id(BUTTON_OPTIONS_ID_BASE + gridIdx)).click();

        elementWait.waitElementById(BUTTON_OPTIONS_PANEL_ID_BASE + gridIdx);
        elementWait.waitElementVisibleById(BUTTON_OPTIONS_PANEL_ID_BASE + gridIdx);
        elementWait.waitElementDisplayById(BUTTON_OPTIONS_PANEL_ID_BASE + gridIdx);
    }

    private void openAppletsPanel(Long gridIdx) {
        elementWait.waitElementById(BUTTON_APPLETS_ID_BASE + gridIdx);
        seleniumSettings.getWebDriver().findElement(By.id(BUTTON_APPLETS_ID_BASE + gridIdx)).click();

        elementWait.waitElementById(BUTTON_APPLETS_PANEL_ID_BASE + gridIdx);
        elementWait.waitElementVisibleById(BUTTON_APPLETS_PANEL_ID_BASE + gridIdx);
        elementWait.waitElementDisplayById(BUTTON_APPLETS_PANEL_ID_BASE + gridIdx);
    }

    private void waitButtonInPanel(String id) {
        element.moveToElementById(id);
        elementWait.waitElementById(id);
        elementWait.waitElementVisibleById(id);
        elementWait.waitElementDisplayById(id);
        gridButtonWait.waitButtonEnabledById(id);
    }

}