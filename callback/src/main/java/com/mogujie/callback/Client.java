package com.mogujie.callback;

import com.mogujie.callback.core.CallbackHolder;

import java.util.ArrayList;
import java.util.List;

import static com.mogujie.callback.FreeMarkerHelper.generate;
import static com.mogujie.callback.FreeMarkerHelper.init;

/**
 * @author zijiao
 * @version 16/8/26
 *          Mark
 */
public class Client {

    public static void main(String[] args) throws Exception {
        init("template");
        generate("Activity.ftl", getData());
    }

    private static Object getData() {
        ActivityInfo activityInfo = new ActivityInfo();
        activityInfo.packageName = "com.puke.freemarkerdemo";
        activityInfo.activityName = "LoginActivity";
        activityInfo.layout = "activity_login";
        List<ActivityInfo.View> views = activityInfo.views = new ArrayList<ActivityInfo.View>();

        for (int i = 1; i <= 5; i++) {
            ActivityInfo.View view = new ActivityInfo.View();
            view.id = "id" + i;
            view.name = "name" + i;
            view.type = "TextView";
            views.add(view);
        }

        return activityInfo;
    }

}
