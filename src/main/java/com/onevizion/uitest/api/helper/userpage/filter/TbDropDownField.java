package com.onevizion.uitest.api.helper.userpage.filter;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.helper.Grid;
import com.onevizion.uitest.api.helper.Js;
import com.onevizion.uitest.api.vo.ConfigFieldType;

@Component
public class TbDropDownField {

    @Resource
    private Js js;

    @Resource
    private Grid grid;

    @Resource
    private UserpageFilter userpageFilter;

    @SuppressWarnings("unchecked")
    public void test(String columnId, String columnId2, String value, boolean supportOuterOperations, boolean supportFieldOperations, List<String> ... cellValsKeys) {
        Long columnIndex = js.getGridColIndexById(0L, columnId);
        Long columnIndex2 = null;
        if (supportFieldOperations) {
            columnIndex2 = js.getGridColIndexById(0L, columnId2);
        }

        String fieldName = js.getGridColumnLabelByColIndex(0L, columnIndex, 0L);
        String fieldName2 = null;
        if (supportFieldOperations) {
            fieldName2 = js.getGridColumnLabelByColIndex(0L, columnIndex2, 0L);
        }

        Long rowsCnt = grid.getGridRowsCount(0L);
        List<String> cellVals = (List<String>) js.getGridCellsValuesTxtForColumnByColIndex(0L, rowsCnt, columnIndex);
        List<String> cellVals2 = null;
        if (supportFieldOperations) {
            cellVals2 = (List<String>) js.getGridCellsValuesTxtForColumnByColIndex(0L, rowsCnt, columnIndex2);
        }

        if (supportOuterOperations && supportFieldOperations) {
            userpageFilter.checkFilterOperators(fieldName, null, Arrays.asList("=", "(+)=", "<>", "(+)<>", "Is Null", "Is Not Null", "=Field", "<>Field"));
        } else if (supportOuterOperations && !supportFieldOperations) {
            userpageFilter.checkFilterOperators(fieldName, null, Arrays.asList("=", "(+)=", "<>", "(+)<>", "Is Null", "Is Not Null"));
        } else if (!supportOuterOperations && supportFieldOperations) {
            userpageFilter.checkFilterOperators(fieldName, null, Arrays.asList("=", "<>", "Is Null", "Is Not Null", "=Field", "<>Field"));
        } else {
            userpageFilter.checkFilterOperators(fieldName, null, Arrays.asList("=", "<>", "Is Null", "Is Not Null"));
        }

        userpageFilter.checkFilterAttributeAndOperatorAndValue(fieldName, fieldName2, value, null, "=", ConfigFieldType.DROP_DOWN, columnIndex, columnIndex2, cellVals, cellVals2);
        userpageFilter.checkFilterAttributeAndOperatorAndValue(fieldName, fieldName2, value, null, "<>", ConfigFieldType.DROP_DOWN, columnIndex, columnIndex2, cellVals, cellVals2);
        userpageFilter.checkFilterAttributeAndOperatorAndValue(fieldName, fieldName2, value, null, "Is Null", ConfigFieldType.DROP_DOWN, columnIndex, columnIndex2, cellVals, cellVals2);
        userpageFilter.checkFilterAttributeAndOperatorAndValue(fieldName, fieldName2, value, null, "Is Not Null", ConfigFieldType.DROP_DOWN, columnIndex, columnIndex2, cellVals, cellVals2);

        if (supportFieldOperations) {
            userpageFilter.checkFilterAttributeAndOperatorAndValue(fieldName, fieldName2, value, null, "=Field", ConfigFieldType.DROP_DOWN, columnIndex, columnIndex2, cellVals, cellVals2);
            userpageFilter.checkFilterAttributeAndOperatorAndValue(fieldName, fieldName2, value, null, "<>Field", ConfigFieldType.DROP_DOWN, columnIndex, columnIndex2, cellVals, cellVals2);
        }

        if (supportOuterOperations) {
            userpageFilter.checkFilterAttributeAndOperatorAndValue(fieldName, fieldName2, value, null, "(+)=", ConfigFieldType.DROP_DOWN, columnIndex, columnIndex2, cellVals, cellVals2, cellValsKeys);
            userpageFilter.checkFilterAttributeAndOperatorAndValue(fieldName, fieldName2, value, null, "(+)<>", ConfigFieldType.DROP_DOWN, columnIndex, columnIndex2, cellVals, cellVals2, cellValsKeys);
        }
    }

}