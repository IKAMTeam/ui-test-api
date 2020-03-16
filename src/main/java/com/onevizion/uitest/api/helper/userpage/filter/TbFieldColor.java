package com.onevizion.uitest.api.helper.userpage.filter;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.onevizion.uitest.api.helper.Grid;
import com.onevizion.uitest.api.helper.Js;

@Component
public class TbFieldColor {

    @Resource
    private Js js;

    @Resource
    private Grid grid;

    @Resource
    private UserpageFilter userpageFilter;

    @SuppressWarnings("unchecked")
    public void test(String columnId, String trackorColumnId, String value, Map<String, List<String>> colors) {
        Long columnIndex = js.getGridColIndexById(0L, columnId);

        String fieldName = js.getGridColumnLabelByColIndex(0L, columnIndex, 0L);

        Long rowsCnt = grid.getGridRowsCount(0L);
        Long trackorColumnIndex = js.getGridColIndexById(0L, trackorColumnId);
        String trackorFieldName = js.getGridColumnLabelByColIndex(0L, trackorColumnIndex, 0L);
        List<String> trackorCellVals = (List<String>) js.getGridCellsValuesTxtForColumnByColIndex(0L, rowsCnt, trackorColumnIndex);

        userpageFilter.checkFilterEqualColor(fieldName, trackorFieldName, value, trackorCellVals, colors);
        userpageFilter.checkFilterNotEqualColor(fieldName, trackorFieldName, value, trackorCellVals, colors);
        userpageFilter.checkFilterIsFieldColor(fieldName, trackorFieldName, trackorCellVals, colors);
        userpageFilter.checkFilterIsFieldNotColor(fieldName, trackorFieldName, trackorCellVals, colors);
    }

}