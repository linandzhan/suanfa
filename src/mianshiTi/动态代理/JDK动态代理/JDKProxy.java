package mianshiTi.动态代理.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object targetObject;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("在对象被代理之后，添加了权限检查操作");
        return method.invoke(targetObject,args);
    }


    public Object newProxy(Object targetObject){
        //targetObject就是被代理对象（叫目标对象）
        //this代表当前对象，当前代理器
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }
}



class TestJDKProxy {
    public static void main(String[] args) {
        JDKProxy proxy = new JDKProxy();
        UserManager proxyManager = (UserManager) proxy.newProxy(new UserManagerImpl());
        proxyManager.addUser("1","123456");
    }
}
