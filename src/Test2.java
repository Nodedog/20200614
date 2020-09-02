/*
*
* 题目：春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，
* 某个红包金额出现的次数超过了红包总的一半。请帮小明找到该红包金额。
* 写出具体算法思路和代码实现，要求算法尽可能高效。给定一个红包的金额数组gifts及它的大小n，
* 请返回所求红包的金额。若没有金额超过总数的一半，返回0。
测试样例：
[1,2,3,2,2],5
返回：2
*
*
*
*
* */
public class Test2 {
    public int getValue(int[] gifts, int n) {
        int key = gifts[0];
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (gifts[i] == key){
                count++;
            }else {
                count--;
            }
            if (count == 0){
                key = gifts[i];
                count = 1;
            }
        }
        //经过上面的循环一定能确定出来key 是重复次数最多的数


       //下面这个循环用来判断key重复的次数是否大于数组长度的一半
       //如果大于就返回key  如果小于就返回0
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (gifts[i] == key){
                num++;
            }
        }
        if (num > (n / 2)){
            return key;
        }else {
            return 0;
        }

    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[] array = {1,4,5,5,5,45,6,55,5,5,5,5,5};
        int n = array.length;
        System.out.println(test2.getValue(array,n));
    }


}
