package com.redcat.demo.singleton_case;

/**
 * Created by zhiyu.zhou on 2018/2/6.
 */
public class ClientTest {

    public static void main(String args[]) {
      //创建LoadBalance实例
        LoadBalancer loadBalancer1, loadBalancer2, loadBalancer3;

        loadBalancer1 = LoadBalancer.getLoadBalancer();
        loadBalancer2 = LoadBalancer.getLoadBalancer();
        loadBalancer3 = LoadBalancer.getLoadBalancer();
        //LoaderBalance是否相同
        if(loadBalancer1 == loadBalancer2 && loadBalancer2 == loadBalancer3) {
            System.out.println("服务器负载均衡器具有唯一性");
        }
        //add server
        loadBalancer1.addServer("server1");
        loadBalancer1.addServer("server2");
        loadBalancer1.addServer("server3");

        //client请求的分发
        for (int i = 1; i < 5 ; i++) {
            String server = loadBalancer1.getServer();
            System.out.println("分发请求至服务器： " + server);
        }
    }
}
