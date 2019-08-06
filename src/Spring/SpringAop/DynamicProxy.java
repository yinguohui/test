package Spring.SpringAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName DynamicProxy
 * @Auhtor ygh
 * @DATE 2019/7/4 14:51
 **/
public class DynamicProxy implements InvocationHandler{

    private Object object;

    public DynamicProxy(Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("准备");
        Object result = method.invoke(object,args);
        System.out.println("结束");
        return result;
    }
}
