/*
*
*
*                               每日一题 6.23
*
*
*
* 题目：春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，
 * 某个红包金额出现的次数超过了红包总的一半。请帮小明找到该红包金额。
 * 写出具体算法思路和代码实现，要求算法尽可能高效。给定一个红包的金额数组gifts及它的大小n，
 * 请返回所求红包的金额。
*
* 这个用快速排序的方法适用于没有这句"若没有金额超过总数的一半，返回0。"
*
*
*
* */
public class Test1 {

    public static void quickSort(int[] array, int n){
        quickSortHelper(array,0,array.length-1);
    }

    //[left,riht]前闭后闭区间，针对当前范围进行快速排序
    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right){
            //区间中有0个元素或者1个元素
            return;
        }
        //返回值表示整理之后，基准值所处在的位置
        int index = partition(array,left,right);
        //递归访问左右区间
        //[left,index-1]
        //[index+1,right]
        quickSortHelper(array,left,index-1);
        quickSortHelper(array,index+1,right);
    }


    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j){
            //从左往右找到一个大于基准值baseValue的元素
            while (i < j && array[i] <= baseValue){
                i++;
            }
            //此时i指向的位置要么和j重合，要么就是一个比基准值大的元素

            //从右往左找到一个小于基准值baseValue的元素
            while (i < j && array[j] >= baseValue){
                j--;
            }
            //此时j指向的位置要么和i重合，要么就是一个比基准值小的元素

            //交换 i  j的值
            if (i < j ){
                swap(array,i,j);
            }
        }
        //循环结束交换重合位置元素和基准值元素
        swap(array,i,right);
        //返回的基准值所在位置
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp =array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public int getValue(int[] gifts, int n) {
        quickSort(gifts,n);
        return gifts[gifts.length / 2];
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int[] array = {1,4,5,5,5,45,6,55,5,5};
        int n = array.length;
        System.out.println(test1.getValue(array,n));
    }
}
