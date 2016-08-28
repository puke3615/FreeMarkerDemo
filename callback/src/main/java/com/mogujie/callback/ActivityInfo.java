package com.mogujie.callback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zijiao
 * @version 16/8/26
 *          Mark
 */
public class ActivityInfo {

    public String packageName;
    public String activityName;
    public String layout;
    public List<View> views;

    public String getPackageName() {
        if (packageName == null) {
            packageName = "";
        }
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getActivityName() {
        if (activityName == null) {
            activityName = "";
        }
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getLayout() {
        if (layout == null) {
            layout = "";
        }
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public List<View> getViews() {
        if (views == null) {
            views = new ArrayList<View>();
        }
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }

    public static class View {
        public String name;
        public String type;

        public String getName() {
            if (name == null) {
                name = "";
            }
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            if (type == null) {
                type = "";
            }
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            if (id == null) {
                id = "";
            }
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String id;
    }
}
