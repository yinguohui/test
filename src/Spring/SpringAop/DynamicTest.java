package Spring.SpringAop;

import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicTest
 * @Auhtor ygh
 * @DATE 2019/7/4 14:54
 **/
public class DynamicTest {
    public static void main(String[] args) {
        People people = new People();
        BuyHouse buyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(),new Class[]{BuyHouse.class},new DynamicProxy(people));
        buyHouse.buyHouse();

    }
}
