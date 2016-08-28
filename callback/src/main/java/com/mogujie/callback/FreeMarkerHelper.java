package com.mogujie.callback;

import com.mogujie.callback.freemarker.ImportTemplate;
import com.mogujie.callback.freemarker.InterfaceTemplate;
import com.mogujie.callback.freemarker.MethodsTemplate;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author zijiao
 * @version 16/8/26
 *          Mark
 */
public class FreeMarkerHelper {

    private static Configuration sConfiguration;

    public static void init(String path) {
        if (sConfiguration != null) {
            return;
        }
        try {
            sConfiguration = new Configuration(Configuration.VERSION_2_3_25);
            sConfiguration.setDirectoryForTemplateLoading(new File(path));
            sConfiguration.setDefaultEncoding("UTF-8");
            sConfiguration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            sConfiguration.setLogTemplateExceptions(true);

            sConfiguration.setSharedVariable("interface", new InterfaceTemplate());
            sConfiguration.setSharedVariable("import", new ImportTemplate());
            sConfiguration.setSharedVariable("methods", new MethodsTemplate());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generate(String ftl, Object data) {
        try {
            Template template = sConfiguration.getTemplate(ftl);
            template.process(data, new OutputStreamWriter(System.out));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
