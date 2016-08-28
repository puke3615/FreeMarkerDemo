package com.mogujie.callback.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * @author zijiao
 * @version 16/8/26
 *          Mark
 */
public class MethodsTemplate implements TemplateDirectiveModel {
    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (body != null) {
            body.render(new MethodsWriter(env.getOut()));
        }
    }

    private static class MethodsWriter extends Writer {
        private Writer out;

        public MethodsWriter(Writer out) {
            this.out = out;
        }

        @Override
        public void write(char[] cbuf, int off, int len) throws IOException {
            String content = new String(cbuf, off, len);
            try {
                final StringBuilder methodBuilder = new StringBuilder();
                Class cls = Class.forName(content);
                Method[] methods = cls.getMethods();
                for (Method method : methods) {
                    int mode = method.getModifiers();
                    final String methodModifiers = Modifier.toString(mode);
                    final String methodName = method.getName();
                    final String returnType = method.getReturnType().getName();
                    final StringBuilder paramsBuilder = new StringBuilder();
                    for (Parameter parameter : method.getParameters()) {
                        final String parameterType = parameter.getType().getName();
                        final String parameterName = parameter.getName();
                        if (paramsBuilder.length() > 0) {
                            paramsBuilder.append(", ");
                        }
                        paramsBuilder.append(String.format("%s %s", parameterType, parameterName));
                    }
                    String methodStr = String.format(
                            "\t%s %s %s(%s){\n" +
                                    "\t\tif (mCallback != null && mCallback instanceof %s) {\n" +
                                    "\t\t\t((%s) mCallback).%s(%s);\n" +
                                    "\t\t}\n" +
                                    "\t}"
                            , methodModifiers, returnType, methodName, paramsBuilder.toString()
                            , cls.getName()
                            , cls.getName(), methodName, paramsBuilder.toString());
                    methodBuilder.append(methodStr);
                }
                out.write(methodBuilder.toString());
            } catch (ClassNotFoundException e) {
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
