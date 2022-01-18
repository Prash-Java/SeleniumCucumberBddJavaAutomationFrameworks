package com.utilities;

import gherkin.formatter.model.DataTableRow;
import io.cucumber.datatable.DataTable;


import java.util.HashMap;
import java.util.Map;

public class CucumberUtil {
    private static Map<String, String> data = new HashMap<>();

    public static void set(DataTable table) {
        for (DataTableRow row : table.getGherkinRows()) {
            data.put(row.getCells().get(0), row.getCells().get(1));
        }
    }
    public static String get(String key) {
        return data.get(key);
    }
}
