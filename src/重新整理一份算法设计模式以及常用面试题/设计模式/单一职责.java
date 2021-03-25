package 重新整理一份算法设计模式以及常用面试题.设计模式;

public class 单一职责 {
}

/**
 * 编写单一职责
 */
class single{
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("单车");
    }
}



/**
 * 交通工具类
 */
class Vehicle {
    public void run (String vehicle) {
        System.out.println(vehicle + "在跑");
    }
}


//在类上，保持单一职责
/**
 * 单一职责好处：
 * 1、降低类复杂度，一个类只负责一个职责
 * 2、提高类可读性
 * 3、降低变更引起的风险
 * 4、只有类中方法数量足够少，可以在方法级别保持单一职责
 */

/**
 * 路上交通工具
 */
class RoadVehicle {
    public void run (String vehicle) {
        System.out.println("路上运行");
    }
}

/**
 * 天上交通
 */
class SkyVehicle {
    public void run(String vehicle) {
        System.out.println("天上飞");
    }
}


//看B站看到接口隔离原则
