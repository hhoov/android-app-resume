package com.example.android.justjava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NullObject {

    private static class NullInvocationHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Class<?> returnType = method.getReturnType();
            if (returnType == Byte.TYPE || returnType == Short.TYPE || returnType == Integer.TYPE ||
                    returnType == Long.TYPE || returnType == Float.TYPE || returnType == Double.TYPE ||
                    returnType == Character.TYPE) {
                return 0;
            } else if (returnType == Boolean.TYPE) {
                return false;
            } else {
                return null;
            }
        }
    }

    public static <T> T create(Class<T> nullObjClazz) {
        Object proxy = Proxy.newProxyInstance(nullObjClazz.getClassLoader(), new Class<?>[]{nullObjClazz}, new NullInvocationHandler());
        return nullObjClazz.cast(proxy);
    }
}