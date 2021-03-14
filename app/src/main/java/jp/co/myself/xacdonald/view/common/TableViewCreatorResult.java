package jp.co.myself.xacdonald.view.common;

import android.view.View;

import java.util.Map;

public class TableViewCreatorResult {

    private View v;
    private Map<String, Integer> uiIdViewIdMap;

    public TableViewCreatorResult(View v, Map<String, Integer> uiIdViewIdMap) {
        this.v = v;
        this.uiIdViewIdMap = uiIdViewIdMap;
    }

    public View getV() {
        return v;
    }

    public void setV(View v) {
        this.v = v;
    }

    public Map<String, Integer> getUiIdViewIdMap() {
        return uiIdViewIdMap;
    }

    public void setUiIdViewIdMap(Map<String, Integer> uiIdViewIdMap) {
        this.uiIdViewIdMap = uiIdViewIdMap;
    }

}
