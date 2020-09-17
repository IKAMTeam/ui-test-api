package com.onevizion.uitest.api.helper;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.SeleniumSettings;

@Component
public class CompAuditLog {

    private static final String COLUMN_ID_USER = "3";
    private static final String COLUMN_ID_ACTION = "5";
    private static final String COLUMN_ID_TABLE = "7";
    private static final String COLUMN_ID_FIELD = "8";
    private static final String COLUMN_ID_NEW_VAL = "9";
    private static final String COLUMN_ID_OLD_VAL = "10";

    @Autowired
    private Grid grid;

    @Autowired
    private SeleniumSettings seleniumSettings;

    public void checkGridRowsByRowIndex(Long gridId, int rowIndexStart, int rowIndexEnd, String action, String table) {
        Map<String, String> gridVals = new HashMap<>();

        gridVals.put(COLUMN_ID_USER, seleniumSettings.getTestUser());
        gridVals.put(COLUMN_ID_ACTION, action);
        gridVals.put(COLUMN_ID_TABLE, table);

        grid.checkGridRowsByRowIndex(gridId, rowIndexStart, rowIndexEnd, gridVals);
    }

    public int checkGridRowByRowIndex(Long gridId, int rowIndex, String action, String table, String field, String newVal, String oldVal) {
        Map<String, String> gridVals = new HashMap<>();

        gridVals.put(COLUMN_ID_USER, seleniumSettings.getTestUser());
        gridVals.put(COLUMN_ID_ACTION, action);
        gridVals.put(COLUMN_ID_TABLE, table);
        gridVals.put(COLUMN_ID_FIELD, field);
        gridVals.put(COLUMN_ID_NEW_VAL, newVal);
        gridVals.put(COLUMN_ID_OLD_VAL, oldVal);

        grid.checkGridRowByRowIndex(gridId, rowIndex, gridVals);

        rowIndex = rowIndex + 1;

        return rowIndex;
    }
}