import java.util.Arrays;


public class UnorderedPair {

	public static int count = 0;  
	  
    public static void main(String[] args) {  
        int arr[] = { 6, 5, 4, 3, 2, 1 };  
        int[] result = sort_and_count(arr);  
        System.out.println("逆序数："+count);  
        for(int i=0;i<result.length;i++){  
            System.out.print(result[i]+" ");  
        }  
    }  
  
    private static int[] sort_and_count(int[] arr) {  
        if (arr.length == 1) {  
            return arr;  
        }  
        int length = arr.length;  
        int alength = length / 2;  
        int A[] = Arrays.copyOfRange(arr, 0, alength);  
        int B[] = Arrays.copyOfRange(arr, alength, length);  
        A = sort_and_count(A);  
        B = sort_and_count(B);  
        arr = merge_and_count(A, B);  
        return arr;  
    }  
    //此函数有两个功能：  
    //(1)归并排序中的归并  
    //（2）计算逆序数  
    private static int[] merge_and_count(int[] a, int[] b) {  
        int i = 0;  
        int j = 0;  
        int result[] = new int[a.length+b.length];  
        int current = 0;  
        while (i < a.length && j < b.length) {  
            if(a[i]<b[j]){         
                result[current++] = a[i];  
                i++;  
            }  
            if(a[i]>b[j]){  
                result[current++] = b[j];  
                count += (a.length - i);  
                j++;  
            }  
        }  
        if(i==a.length){      
            for(;j<b.length;j++){  
                result[current++] = b[j];   
            }  
        }  
        if(j==b.length){  
            for(;i<a.length;i++){  
                result[current++] = a[i];   
            }  
        }  
        return result;  
    }  

}
