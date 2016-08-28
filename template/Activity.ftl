package ${packageName};

import android.app.Activity;

public class ${activityName} extends Activity {

    <#list views><#items as view>
    private ${view.type!"View"} ${view.name};
    </#items></#list>

    @Override
    public void onCreate() {
        super.onCreate();
        initView();
    }

    private void initView() {
        setContentView(R.layout.${layout});
        <#list views as view>
        ${view.name} = <#if view.type?? || view.type == "View">(${view.type}) </#if>findViewById(R.id.${view.name});
        </#list>
    }

}
