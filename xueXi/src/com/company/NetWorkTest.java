package com.company;

public class NetWorkTest {
    public static void main(String[] args) {
        Server server=new Server();
        PoxyNetWork poxyNetWork=new PoxyNetWork(server);
        poxyNetWork.brows();
    }
}

/**
 * 网络接口
 */
interface NetWork{
    public void brows();
}

/**
 * 被代理
 */
class Server implements NetWork{

    @Override
    public void brows() {
        System.out.println("真实服务器");
    }
}

/**
 * 代理
 */
class PoxyNetWork implements NetWork{

    private NetWork netWork;

    public PoxyNetWork(NetWork netWork) {
        this.netWork = netWork;
    }

    public void check(){
        System.out.println("检测");
    }
    @Override
    public void brows() {
        check();
        netWork.brows();
    }
}