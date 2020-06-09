package com.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 反射-动态代理
 * @author RZ
 * @date 2020/6/3 14:04
 */

interface Human{

    String getBelief();
    void eat(String food);
}
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {

        System.out.println("我喜欢吃"+food);
    }
}

/**
 *
 * 要想实现动态代理，需要解决的问题？
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
 *
 */
class ProxyFactory {

    // 调用此方法，返回一个代理类的对象。解决问题一
    // obj 被代理类的对象
    public static Object getProxyInstance(Object obj) {

        MyInvocationHandler handler =new MyInvocationHandler();
        handler.bind(obj);
        // getClassLoader()运行时加载类
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);

    }

}
class MyInvocationHandler implements InvocationHandler{

    // 需要使用被代理类对象
    private Object obj;

    public void bind(Object obj){
        this.obj=obj;
    }
    // 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    // 将被代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

       // method：即为代理类对象调用的方法，此方法也就作为了被代理类对象方法
       // obj：被代理类对象
       Object ob = method.invoke(obj,args);
       // 上述方法返回值
       return  ob;
    }
}

public class ProxyTest{

    public static void main(String[] args) {
        SuperMan superMan =new SuperMan();
        // 代理类对象
        Human human = (Human) ProxyFactory.getProxyInstance(superMan);
        System.out.println(human.getBelief());
        human.eat("青菜");
    }
}