package com.onevizion.uitest.api.helper.userpage.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.helper.Grid;
import com.onevizion.uitest.api.helper.Js;
import com.onevizion.uitest.api.vo.ConfigFieldType;
import com.onevizion.uitest.api.vo.FilterOperatorType;

@Component
public class TbPsSelectorField {

    @Autowired
    private Js js;

    @Autowired
    private Grid grid;

    @Autowired
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

        List<FilterOperatorType> operators = FilterOperatorType.getPsSelectorOperators(supportOuterOperations, supportFieldOperations);
        userpageFilter.checkFilterOperators(fieldName, null, operators);

        userpageFilter.checkFilter(fieldName, fieldName2, value, null, FilterOperatorType.EQUAL, ConfigFieldType.SELECTOR, columnIndex, columnIndex2, cellVals, cellVals2);
        userpageFilter.checkFilter(fieldName, fieldName2, value, null, FilterOperatorType.NOT_EQUAL, ConfigFieldType.SELECTOR, columnIndex, columnIndex2, cellVals, cellVals2);
        userpageFilter.checkFilter(fieldName, fieldName2, value, null, FilterOperatorType.NULL, ConfigFieldType.SELECTOR, columnIndex, columnIndex2, cellVals, cellVals2);
        userpageFilter.checkFilter(fieldName, fieldName2, value, null, FilterOperatorType.NOT_NULL, ConfigFieldType.SELECTOR, columnIndex, columnIndex2, cellVals, cellVals2);

        if (supportFieldOperations) {
            userpageFilter.checkFilter(fieldName, fieldName2, value, null, FilterOperatorType.EQUAL_FIELD, ConfigFieldType.SELECTOR, columnIndex, columnIndex2, cellVals, cellVals2);
            userpageFilter.checkFilter(fieldName, fieldName2, value, null, FilterOperatorType.NOT_EQUAL_FIELD, ConfigFieldType.SELECTOR, columnIndex, columnIndex2, cellVals, cellVals2);
        }

        if (supportOuterOperations) {
            userpageFilter.checkFilter(fieldName, fieldName2, value, null, FilterOperatorType.EQUAL_AND_EMPTY_FOR_OTHER, ConfigFieldType.SELECTOR, columnIndex, columnIndex2, cellVals, cellVals2, cellValsKeys);
            userpageFilter.checkFilter(fieldName, fieldName2, value, null, FilterOperatorType.NOT_EQUAL_AND_EMPTY_FOR_OTHER, ConfigFieldType.SELECTOR, columnIndex, columnIndex2, cellVals, cellVals2, cellValsKeys);
        }
    }

}