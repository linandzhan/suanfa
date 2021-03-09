package mianshiTi.动态代理.CGLib动态代理;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import mianshiTi.动态代理.JDK动态代理.UserManager;
import mianshiTi.动态代理.JDK动态代理.UserManagerImpl;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object createProxy(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);

        return enhancer.create(); //创建代理对象
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLib添加权限检查");

        return method.invoke(targetObject,objects);
    }


}


class CGLibTest{
    public static void main(String[] args) {
        UserManager userManager = (UserManager) new CGLibProxy().createProxy(new UserManagerImpl());

        userManager.addUser("2","张三");
    }
}
