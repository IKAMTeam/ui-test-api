package com.onevizion.uitest.api.helper.userpage.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.helper.Grid;
import com.onevizion.uitest.api.helper.Js;
import com.onevizion.uitest.api.vo.ConfigFieldType;
import com.onevizion.uitest.api.vo.FilterOperatorType;

@Component
public class TbTimeField {

    @Autowired
    private Js js;

    @Autowired
    private Grid grid;

    @Autowired
    private UserpageFilter userpageFilter;

    @SuppressWarnings("unchecked")
    public void test(String columnId, String columnId2, String value, boolean supportFieldOperations) {
        int rowsCnt = grid.getGridRowsCount(0L);

        int columnIndex = js.getColumnIndexById(0L, columnId);
        String fieldName = js.getGridColumnLabelByColIndex(0L, columnIndex, 0);
        List<String> cellVals = (List<String>) js.getGridCellsValuesTxtForColumnByColIndex(0L, rowsCnt, columnIndex);

        List<FilterOperatorType> operators = FilterOperatorType.getTimeOperators(supportFieldOperations);
        userpageFilter.checkFilterOperators(fieldName, null, operators);

        userpageFilter.checkFilter(fieldName, value, null, FilterOperatorType.EQUAL, ConfigFieldType.TIME, columnIndex, cellVals);
        userpageFilter.checkFilter(fieldName, value, null, FilterOperatorType.MORE, ConfigFieldType.TIME, columnIndex, cellVals);
        userpageFilter.checkFilter(fieldName, value, null, FilterOperatorType.LESS, ConfigFieldType.TIME, columnIndex, cellVals);
        userpageFilter.checkFilter(fieldName, value, null, FilterOperatorType.MORE_AND_EQUAL, ConfigFieldType.TIME, columnIndex, cellVals);
        userpageFilter.checkFilter(fieldName, value, null, FilterOperatorType.LESS_AND_EQUAL, ConfigFieldType.TIME, columnIndex, cellVals);
        userpageFilter.checkFilter(fieldName, value, null, FilterOperatorType.NOT_EQUAL, ConfigFieldType.TIME, columnIndex, cellVals);
        userpageFilter.checkFilter(fieldName, value, null, FilterOperatorType.NULL, ConfigFieldType.TIME, columnIndex, cellVals);
        userpageFilter.checkFilter(fieldName, value, null, FilterOperatorType.NOT_NULL, ConfigFieldType.TIME, columnIndex, cellVals);

        if (supportFieldOperations) {
            int columnIndex2 = js.getColumnIndexById(0L, columnId2);
            String fieldName2 = js.getGridColumnLabelByColIndex(0L, columnIndex2, 0);
            List<String> cellVals2 = (List<String>) js.getGridCellsValuesTxtForColumnByColIndex(0L, rowsCnt, columnIndex2);

            userpageFilter.checkFilterWithFieldOperation(fieldName, fieldName2, value, null, FilterOperatorType.EQUAL_FIELD, ConfigFieldType.TIME, columnIndex, columnIndex2, cellVals, cellVals2);
            userpageFilter.checkFilterWithFieldOperation(fieldName, fieldName2, value, null, FilterOperatorType.NOT_EQUAL_FIELD, ConfigFieldType.TIME, columnIndex, columnIndex2, cellVals, cellVals2);
            userpageFilter.checkFilterWithFieldOperation(fieldName, fieldName2, value, null, FilterOperatorType.MORE_FIELD, ConfigFieldType.TIME, columnIndex, columnIndex2, cellVals, cellVals2);
            userpageFilter.checkFilterWithFieldOperation(fieldName, fieldName2, value, null, FilterOperatorType.LESS_FIELD, ConfigFieldType.TIME, columnIndex, columnIndex2, cellVals, cellVals2);
            userpageFilter.checkFilterWithFieldOperation(fieldName, fieldName2, value, null, FilterOperatorType.MORE_AND_EQUAL_FIELD, ConfigFieldType.TIME, columnIndex, columnIndex2, cellVals, cellVals2);
            userpageFilter.checkFilterWithFieldOperation(fieldName, fieldName2, value, null, FilterOperatorType.LESS_AND_EQUAL_FIELD, ConfigFieldType.TIME, columnIndex, columnIndex2, cellVals, cellVals2);
        }
    }

}