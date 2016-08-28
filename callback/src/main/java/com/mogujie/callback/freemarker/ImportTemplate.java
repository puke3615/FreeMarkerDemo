package com.mogujie.callback.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author zijiao
 * @version 16/8/26
 *          Mark
 */
public class ImportTemplate implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (body != null) {
            body.render(new ImportWriter(env.getOut()));
        }
    }

    private static class ImportWriter extends Writer {

        private final Writer out;

        public ImportWriter(Writer out) {
            this.out = out;
        }

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            String content = new String(cbuf, off, len);
            try {
                if (content.contains(".")) {
                    out.write(String.format("import %s;", content.replace('$', '.')));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void flush() throws IOException {
            out.flush();
        }

        @Override
        public void close() throws IOException {
            out.close();
        }
    }

}
