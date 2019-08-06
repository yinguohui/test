package JAVA排序;

/**
 * @ClassName InsertSort
 * @Auhtor ygh
 * @DATE 2019/7/9 15:52
 **/
/*
* 冒泡排序的原理是相邻元素进行比较，如果第一个元素比第二个元素大，那么交换第一个元素和第二个元素；再第二个元素和第三个
* 元素比，如果第二个元素比第三个元素大，那么交换第二个元素和第三个元素；知道比较到最后一个元素，那么这一趟下类，数组中
* 最大元素就在最后一个。再进行第二趟比较，方式和上面一样只是不用再比较最后一个元素了，因为第一趟最后一个元素就是最大的
* 了。通过循环进行这样的比较直到没有元素需要比较了
* */
public class Bubble_Sort {
    private  void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private void bubble(int[]a){
//        for (int i=0;i<a.length-1;i++){
//            for (int j=i+1;j<a.length;j++){
//                if(a[j]<a[i]){
//                    swap(a,i,j);
//                }
//            }
//        }
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length-1-i;j++){
                if(a[j] > a[j+1]){
                    swap(a, j, j+1);
                }
            }
        }
        for (int x:a) {
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args) {
        Bubble_Sort sort = new Bubble_Sort();
        int[] a = {1,22,3,4,11};
        sort.bubble(a);

    }
}
