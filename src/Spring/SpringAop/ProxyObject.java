package Spring.SpringAop;

/**
 * @ClassName ProxyObeject
 * @Auhtor ygh
 * @DATE 2019/7/4 14:38
 **/
public class ProxyObject implements BuyHouse{
    private People people;

    public ProxyObject(People people){
        this.people = people;
    }
    @Override
    public void buyHouse() {
        System.out.println("买之前");
        people.buyHouse();
        System.out.println("买之后");
    }
}
