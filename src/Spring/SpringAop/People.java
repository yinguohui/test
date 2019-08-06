package Spring.SpringAop;

/**
 * @ClassName People
 * @Auhtor ygh
 * @DATE 2019/7/4 14:31
 **/
public class People implements BuyHouse,Marry{

    public void eat(){
        System.out.println("吃饭");
    }

    @Override
    public void buyHouse() {
        System.out.println("买房子");
    }

    @Override
    public void marry() {
        System.out.println("结婚");
    }
}
