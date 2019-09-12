package utils;

import org.junit.Test;
import p3_stack.MinStack;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RefletTestDemo {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, Class[]> methodParamsMap = new HashMap<>();
        methodParamsMap.put("push", new Class[]{int.class});
        methodParamsMap.put("pop", null);
        methodParamsMap.put("top", null);
        methodParamsMap.put("getMin", null);

        String[] methods = new String[]{"push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop", "push", "top", "getMin", "push", "top", "getMin", "pop", "getMin"};
        Object[] paramsArray = {2147483646, 2147483646, 2147483647, null, null, null, null, null, null, 2147483647, null, null, -2147483648, null, null, null, null};

        Class<MinStack> stackClass = MinStack.class;
        MinStack instance = new MinStack();

        for (int i = 0; i < methods.length; i++) {
            String methodName = methods[i];
            Object params = paramsArray[i];
            Class[] paramTypes = methodParamsMap.get(methodName);
            System.out.printf("%s, %s, %s -> ", methodName, Arrays.toString(paramTypes), params);
            Object result;
            Method method;
            if (paramTypes == null) {
                method = stackClass.getMethod(methodName);
                result = method.invoke(instance);
            } else {
                method = stackClass.getMethod(methodName, paramTypes);
                result = method.invoke(instance, params);
            }
            System.out.println(result);
        }
    }
}
