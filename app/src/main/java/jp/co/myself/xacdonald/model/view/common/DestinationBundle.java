package jp.co.myself.xacdonald.model.view.common;

import android.os.Bundle;

public class DestinationBundle {

    private Integer id;

    private Bundle bundle;

    public DestinationBundle(Integer id, Bundle bundle) {
        this.id = id;
        this.bundle = bundle;
    }

    public Integer getId() {
        return id;
    }

    public Bundle getBundle() {
        return bundle;
    }

}
