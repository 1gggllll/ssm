package com.my.ioc_05;

import org.springframework.beans.factory.FactoryBean;

import javax.swing.*;

/**
 * ClassName: HappyFactoryBean
 * Package: com.my.ioc_05
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/5/8 19:33
 * @Version 1.0
 */
// 实现FactoryBean接口时需要指定泛型
// 泛型类型就是当前工厂要生产的对象的类型
public class HappyFactoryBean implements FactoryBean<HappyMachine> {

    private Spring machineName;

    public Spring getMachineName() {
        return machineName;
    }

    public void setMachineName(Spring machineName) {
        this.machineName = machineName;
    }

    @Override
    public HappyMachine getObject() throws Exception {

        // 方法内部模拟创建、设置一个对象的复杂过程
        HappyMachine happyMachine = new HappyMachine();

        happyMachine.setMachineName(this.machineName);

        return happyMachine;
    }

    @Override
    public Class<?> getObjectType() {

        // 返回要生产的对象的类型
        return HappyMachine.class;
    }
}