package backjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B1111 {
    public static void main(String[] args) {
        ArrayList<HashMap<String, Integer>> arr = new ArrayList<>();
        Map<String, Integer> result = new HashMap<>();
        int i =1;

        arr = [ { "answer": 1, "score" : 5 }, { answer : 3, score : 3 }, { answer : 2, score : 4 } ]
        for(HashMap<String,Integer> scores :arr){

            if(scores.get("answer") == i){
                if(i==1)
                    result.put("a",scores.get("score"));
                 else if(i==3)
                    result.put("b",scores.get("score"));
                 else if(i==5)
                    result.put("c",scores.get("score"));
            }
            i += 2;
        }


    }
}
