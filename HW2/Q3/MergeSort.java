import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    /*
        an optimized version of MergeSort-topdown
        it will check if the two subsequences that are going to merge has been in-order
     */

    private int cnt = 0;
//    private int cutoff = 0;
//
//    public void topdown(List<Integer> list){
//        int start = 0;
//        int end = list.size()-1;
//        List<Integer> temp = new ArrayList<>(list);
//        cnt = 0;
//        sort_topdown(list, temp, start, end);
//        System.out.println("The number of comparisons of topdown is "+cnt);
//    }
//
//    private void sort_topdown(List<Integer> list, List<Integer> temp, int start, int end){
//        if(end - start <= 0){
//            return;
//        }
//
//        int mid = start + (end - start)/2;
//        sort_topdown(list, temp, start, mid);
//        sort_topdown(list, temp, mid+1, end);
//        merge(list, temp, start, mid, end);
//    }
//
//    public void bottomup(List<Integer> list){
//        int length = list.size();
//        List<Integer> temp = new ArrayList<>(list);
//        cnt = 0;
//
//        int sz = 1;
//        while(sz < length){
//            for(int i = 0; i<length; i+=sz*2){
//                int mid = i + sz - 1;
//                int end = Math.min(length-1, i+sz*2-1);
//                merge(list, temp, i, mid, end);
//            }
//            sz = sz*2;
//        }
//
//        System.out.println("The number of comparisons of bottomup is "+cnt);
//    }
//
//    public void cutoff(List<Integer> list, int co){
//        cutoff = co;
//
//        int start = 0;
//        int end = list.size()-1;
//        List<Integer> temp = new ArrayList<>(list);
//        cnt = 0;
//        sort_cutoff(list, temp, start, end);
//        System.out.println("The number of comparisons of topdown is "+cnt);
//    }
//
//    private void sort_cutoff(List<Integer> list, List<Integer> temp, int start, int end){
//        if(end - start <= 0){
//            return;
//        }
//
//        if(end - start <= cutoff){
//            InsertionSort.sort(list, start, end);
//            return;
//        }
//
//        int mid = start + (end - start)/2;
//        sort_cutoff(list, temp, start, mid);
//        sort_cutoff(list, temp, mid+1, end);
//        merge(list, temp, start, mid, end);
//    }

    public void chksorted(List<Integer> list){
        int start = 0;
        int end = list.size()-1;
        List<Integer> temp = new ArrayList<>(list);
        cnt = 0;
        sort_chksorted(list, temp, start, end);
        System.out.println("The number of comparisons of chksorted is "+cnt);
    }

    private void sort_chksorted(List<Integer> list, List<Integer> temp, int start, int end){
        if(end - start <= 0){
            return;
        }

        int mid = start + (end - start)/2;
        sort_chksorted(list, temp, start, mid);
        sort_chksorted(list, temp, mid+1, end);

        //check if in-order
        if (list.get(mid) <= list.get(mid+1)){
            cnt++;
            return;
        }

        merge(list, temp, start, mid, end);
    }

    private void merge(List<Integer> list, List<Integer> temp, int start, int mid, int end){
        int left = start;
        int right = mid+1;

        //copy list to temp
        for(int i = start; i<=end;i++){
            temp.set(i, list.get(i));
        }

        for(int i = start; i<= end; i++){
            if(left>mid){
                list.set(i, temp.get(right++));
            }else if(right>end){
                list.set(i, temp.get(left++));
            }else if(temp.get(left) <= temp.get(right)){
                cnt++;
                list.set(i, temp.get(left++));
            }else {
                cnt++;
                list.set(i, temp.get(right++));
            }
        }
    }

}
