package JAVA排序;

/**
 * @ClassName SortUtils
 * @Auhtor ygh
 * @DATE 2019/7/9 16:15
 **/
public class SortUtils {
    public static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
