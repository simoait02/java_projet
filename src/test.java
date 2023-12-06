import java.util.ArrayList;
import java.util.Arrays;

public class test {
        public static void main(String[] args){
            ArrayList<Integer> list1 =new ArrayList(Arrays.asList(1,2));
            ArrayList<Integer> list2 = new ArrayList(list1.subList(0,list1.size()-1));
//            list2.retainAll(list1);
            System.out.println(list2);
        }
    }
