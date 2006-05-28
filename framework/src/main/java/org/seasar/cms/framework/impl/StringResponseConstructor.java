package org.seasar.cms.framework.impl;

import org.seasar.cms.framework.Response;
import org.seasar.cms.framework.ResponseConstructor;

public class StringResponseConstructor implements ResponseConstructor {

    public static final String TARGETCLASSNAME = String.class.getName();

    private StrategySelector strategySelector_;

    public String getTargetClassName() {

        return TARGETCLASSNAME;
    }

    public Response constructResponse(Object value) {

        String string = (String) value;
        if (string == null) {
            return null;
        }

        String scheme;
        String path;
        int colon = string.indexOf(':');
        if (colon < 0) {
            scheme = PageStrategy.SCHEME;
            path = string;
        } else {
            scheme = string.substring(0, colon);
            path = string.substring(colon + 1);
        }
        Strategy strategy = strategySelector_.getStrategy(scheme);
        if (strategy == null) {
            throw new RuntimeException("Unknown scheme '" + scheme
                + "' is specified: " + string);
        }
        return strategy.constructResponse(path);
    }

    public static interface StrategySelector {

        Strategy getStrategy(String scheme);
    }

    public static interface Strategy {

        String getScheme();

        Response constructResponse(String path);
    }

    public void setStrategySelector(StrategySelector strategySelector) {

        strategySelector_ = strategySelector;
    }
}
