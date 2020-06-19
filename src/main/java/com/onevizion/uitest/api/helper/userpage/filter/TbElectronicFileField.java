package com.onevizion.uitest.api.helper.userpage.filter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.helper.Grid;
import com.onevizion.uitest.api.helper.Js;
import com.onevizion.uitest.api.vo.ConfigFieldType;
import com.onevizion.uitest.api.vo.FilterOperatorType;

@Component
public class TbElectronicFileField {

    @Autowired
    private Js js;

    @Autowired
    private Grid grid;

    @Autowired
    private UserpageFilter userpageFilter;

    @SuppressWarnings("unchecked")
    public void test(String columnId, String value) {
        Long columnIndex = js.getGridColIndexById(0L, columnId);

        String fieldName = js.getGridColumnLabelByColIndex(0L, columnIndex, 0L);

        Long rowsCnt = grid.getGridRowsCount(0L);
        List<String> cellVals = (List<String>) js.getGridCellsValuesTxtForColumnByColIndex(0L, rowsCnt, columnIndex);

        List<FilterOperatorType> operators = FilterOperatorType.getElectronicFileOperators();
        userpageFilter.checkFilterOperators(fieldName, null, operators);

        userpageFilter.checkFilter(fieldName, null, value, null, FilterOperatorType.EQUAL, ConfigFieldType.ELECTRONIC_FILE, columnIndex, null, cellVals, null);
        userpageFilter.checkFilter(fieldName, null, value, null, FilterOperatorType.NOT_EQUAL, ConfigFieldType.ELECTRONIC_FILE, columnIndex, null, cellVals, null);
        userpageFilter.checkFilter(fieldName, null, value, null, FilterOperatorType.NULL, ConfigFieldType.ELECTRONIC_FILE, columnIndex, null, cellVals, null);
        userpageFilter.checkFilter(fieldName, null, value, null, FilterOperatorType.NOT_NULL, ConfigFieldType.ELECTRONIC_FILE, columnIndex, null, cellVals, null);
    }

}