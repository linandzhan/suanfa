package mianshiTi.动态代理.静态代理;

import mianshiTi.动态代理.JDK动态代理.UserManager;
import mianshiTi.动态代理.JDK动态代理.UserManagerImpl;

/**
 * 静态代理
 */
public class UserManagerImplProxy implements UserManager {

    public UserManager userManager;

    public UserManagerImplProxy(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void addUser(String id, String password) {
        System.out.println("添加用户前，进行权限检查");
        userManager.addUser(id,password);
    }

    @Override
    public void delUser(String id) {

    }
}



class TestStaticProxy{
    public static void main(String[] args) {
        UserManager userManager = new UserManagerImplProxy(new UserManagerImpl());
        userManager.addUser("1","三");
    }


}
