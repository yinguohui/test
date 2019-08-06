package JAVA排序;

/**
 * @ClassName Selection_Sort
 * @auhtor ygh
 * @DATE 2019/7/9 16:16
 **/
/*
* 选择排序的思想是在所有元素中找出最小元素，将最小元素放到第一个位置，再在剩下的元素中找到最小的元素，放在之前找的最小元素的
* 后面，知道找完整个数组。具体实现过程是min记录最小元素的位置，假设未比较的数组中第一个元素就是最小的即min=0，通过循环把所
* 有元素进行比较，如果有一个元素比最小元素要小，那么就把这个元素的位置给min，比较完所有元素就找到了哪个元素最小，如果最小元
* 素不是第一个把最小元素与数组第一个元素交换。再从第二个元素开始进行如上操作，知道把整个数组找完
*/
public class SelectionSort {

    public void selectionSort(int[] a){
        for (int i = 0; i<a.length-1;i++){
            int min = i;
            for (int j=i+1;j<a.length;j++){
                if (a[min]>a[j]){
                    min = j;
                }
            }
            if (min!=i){
                SortUtils.swap(a,min,i);
            }
        }
        for (int x:a){
            System.out.println(x+" ");
        }
    }
    /*
    * 一趟循环直接找出最大和最小的位置，将最大的交换到最后的位置、最小的交换到第一个位置，但是要注意当最大的元素正好在最左面
    * 时，交换了最小元素和最左面的元素，这时最大元素的位置已经变了，要注意进行判断
    * */
    //加强
    public void strengthenSelectionSort(int[] a){
        int left = 0;
        int right = a.length-1;
        while (left<right){
            int min = left;
            int max = right-1;
            for (int i=left+1;i<=right;i++){
                if (a[min]>a[i]){
                    min = i;
                }
                if (a[max]<a[i]){
                    max = i;
                }
            }
            if (min != left){
                SortUtils.swap(a,min,left);
            }
            if (max == min){
                max = min;
            }
            if (max != left){
                SortUtils.swap(a,max,right);
            }
            left++;
            right--;
        }
        for (int x:a) {
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args) {
        new SelectionSort().strengthenSelectionSort(new int[]{1,2,4,9,55,11,22,33,66,3});
    }
}
