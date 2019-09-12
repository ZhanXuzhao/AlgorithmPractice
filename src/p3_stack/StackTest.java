package p3_stack;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.*;

public class StackTest {

    @Test
    public void test() {
        Map<String, Class[]> methodParamsMap = new HashMap<>();
        methodParamsMap.put("push", new Class[]{int.class});
        methodParamsMap.put("pop", null);
        methodParamsMap.put("top", null);
        methodParamsMap.put("getMin", null);

        String[] methods = {"push", "push", "push", "top", "pop", "getMin", "pop", "getMin", "pop", "push", "top", "getMin", "push", "top", "getMin", "pop", "getMin"};
        Object[] paramsArray = {2147483646, 2147483646, 2147483647, null, null, null, null, null, null, 2147483647, null, null, -2147483648, null, null, null, null};

        List<Object> res = test(MinStack.class, null, null, methodParamsMap, methods, paramsArray);
        System.out.println(res.toString());
    }

    public List<Object> test(Class clazz, Class[] constructorParamTypes, Object[] constructorParams, Map<String, Class[]> methodParamsMap, String[] methods, Object[] paramsArray) {
        List<Object> resList = new LinkedList<>();
        try {
            Object instance = clazz.getConstructor(constructorParamTypes).newInstance(constructorParams);
            for (int i = 0; i < methods.length; i++) {
                String methodName = methods[i];
                Object params = paramsArray[i];
                Class[] paramTypes = methodParamsMap.get(methodName);
                System.out.printf("%s, %s, %s -> ", methodName, Arrays.toString(paramTypes), params);
                Object result;
                Method method;
                if (paramTypes == null) {
                    method = clazz.getMethod(methodName);
                    result = method.invoke(instance);
                } else {
                    method = clazz.getMethod(methodName, paramTypes);
                    result = method.invoke(instance, params);
                }
                System.out.println(result);
                resList.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resList;
    }
}
