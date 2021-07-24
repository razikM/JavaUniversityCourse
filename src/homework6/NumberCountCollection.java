package homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberCountCollection  {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(4,5,-6,4,5,3,4,2,4,5,7));
        Map<Integer, Integer> map = new NumberCountCollection().countElement(list);
        System.out.println(map.toString());
    }

    public Map<Integer,Integer> countElement(ArrayList<Integer> input){
        Map<Integer,Integer> result = new HashMap<>();
        for(int i = 0; i < input.size(); i++){
            if(result.containsKey(input.get(i))){
                result.put(input.get(i),result.get(input.get(i)) + 1);
            } else {
                result.put(input.get(i),1);
            }
        }
        return result;
    }

    private void increaseValue(Integer i){
        i++;
    }
}


