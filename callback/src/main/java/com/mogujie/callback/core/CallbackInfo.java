package com.mogujie.callback.core;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zijiao
 * @version 16/8/26
 *          Mark
 */
public class CallbackInfo {

    private List<String> callbacks;
    private String rootClass;
    private String simpleClassName;
    private String proxyClassName;
    private String packageName;

    public String getPackageName() {
        if (packageName == null) {
            packageName = "";
        }
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }


    public List<String> getCallbacks() {
        if (callbacks == null) {
            callbacks = new ArrayList<>();
        }
        return callbacks;
    }

    public void setCallbacks(List<String> callbacks) {
        this.callbacks = callbacks;
    }

    public String getRootClass() {
        return rootClass;
    }

    public void setRootClass(String rootClass) {
        this.rootClass = rootClass;
    }

    public String getSimpleClassName() {
        if (simpleClassName == null) {
            simpleClassName = "";
        }
        return simpleClassName;
    }

    public void setSimpleClassName(String simpleClassName) {
        this.simpleClassName = simpleClassName;
    }

    public String getProxyClassName() {
        if (proxyClassName == null) {
            proxyClassName = "";
        }
        return proxyClassName;
    }

    public void setProxyClassName(String proxyClassName) {
        this.proxyClassName = proxyClassName;
    }
}
