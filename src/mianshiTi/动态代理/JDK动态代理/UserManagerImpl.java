package mianshiTi.动态代理.JDK动态代理;

public class UserManagerImpl implements UserManager {
    @Override
    public void addUser(String id, String password) {
        System.out.println("调用了addUser");
    }

    @Override
    public void delUser(String id) {
        System.out.println("调用了delUser方法");
    }



}
