package com.rudderlabs.android.sdk.core.ecomm.events;

import com.google.gson.Gson;
import com.rudderlabs.android.sdk.core.RudderProperty;
import com.rudderlabs.android.sdk.core.ecomm.ECommerceEvents;
import com.rudderlabs.android.sdk.core.ecomm.ECommerceOrder;
import com.rudderlabs.android.sdk.core.ecomm.ECommercePropertyBuilder;
import com.rudderlabs.android.sdk.core.util.Utils;

public class OrderUpdatedEvent extends ECommercePropertyBuilder {
    private ECommerceOrder order;

    public OrderUpdatedEvent withOrder(ECommerceOrder order) {
        this.order = order;
        return this;
    }

    public OrderUpdatedEvent withOrderBuilder(ECommerceOrder.Builder builder) {
        this.order = builder.build();
        return this;
    }

    @Override
    public String event() {
        return ECommerceEvents.ORDER_UPDATED;
    }

    @Override
    public RudderProperty build() {
        RudderProperty property = new RudderProperty();
        if (this.order != null) {
            property.putValue(Utils.convertToMap(new Gson().toJson(this.order)));
        }
        return property;
    }
}