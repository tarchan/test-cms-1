package org.seasar.cms.framework;

import javax.servlet.ServletContextEvent;

import org.seasar.framework.container.servlet.S2ContainerListener;

public class FrameworkListener extends S2ContainerListener {
    
    public void contextInitialized(ServletContextEvent event) {
        
        super.contextInitialized(event);
    }
}
