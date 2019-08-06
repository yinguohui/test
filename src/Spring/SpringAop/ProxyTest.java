package Spring.SpringAop;

/**
 * @ClassName ProxyTest
 * @Auhtor ygh
 * @DATE 2019/7/4 14:44
 **/
public class ProxyTest {
    public static void main(String[] args) {
        People people = new People();
        people.buyHouse();
        ProxyObject proxyObject = new ProxyObject(people);
        proxyObject.buyHouse();
    }
}
