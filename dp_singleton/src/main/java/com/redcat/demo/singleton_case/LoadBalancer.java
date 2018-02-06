package com.redcat.demo.singleton_case;

/**
 * Created by zhiyu.zhou on 2018/2/6.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * case:负载均衡服务器,将并发访问和数据流量分发到服务器集群中的多台设备上进行并发处理，提高系统的整体处理能力，缩短响应时间
 * 由于集群中的服务器需要动态删减，且客户端请求需要统一分发，因此需要确保负载均衡器的唯一性，只能有一个负载均衡器来负责服务器的管理和请求的分发，
 * 否则将会带来服务器状态的不一致以及请求分配冲突等问题。如何确保负载均衡器的唯一性是该软件成功的关键
 */
public class LoadBalancer {

    //私有静态成员变量，存储唯一实例
    private static LoadBalancer instance = null;

    //服务器集合
    private List serverList = null;

    //私有构造函数
    private LoadBalancer() {
        serverList = new ArrayList();
    }

    //公有静态成员方法，返回唯一实例
    public static LoadBalancer getLoadBalancer() {
        if(instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }

    //删除服务器
    public void deleteServer(String server) {
        serverList.remove(server);
    }

    //随机获取服务器
    public String getServer() {
        //轮询、Hash一致性算法等，这里利用Random模拟
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }
}
