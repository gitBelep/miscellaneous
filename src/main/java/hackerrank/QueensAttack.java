package hackerrank;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueensAttack {
        //How much positions can reach a Queen?
        //n quadratic matrix; k pcs obstacles; (r,c) pos of Queen; list of pos of obstacles
    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        Set<List<Integer>> obs;
        if(k > 0) {
            obs = new HashSet<>(obstacles);
            obstacles = null;
        } else {
            obs = Collections.emptySet();
        }
        int counter = 0;
        int i, j;

        i = r_q + 1;           //fel
        for(; i <= n; i++){
            if(!obs.contains(List.of(i, c_q))){
                counter++;
            } else {
                break;
            }
        }

        i = r_q - 1;           //le
        for(; i > 0; i--){
            if(!obs.contains(List.of(i, c_q))){
                counter++;
            } else {
                break;
            }
        }

        i = c_q + 1;           //jobbra
        for(; i <= n; i++){
            if(!obs.contains(List.of(r_q, i))){
                counter++;
            } else {
                break;
            }
        }

        i = c_q - 1;           //balra
        for(; i > 0; i--){
            if(!obs.contains(List.of(r_q, i))){
                counter++;
            } else {
                break;
            }
        }

        i = r_q + 1;           //fel jobb
        j = c_q + 1;
        for(; i <= n && j <= n; i++){
            if(!obs.contains(List.of(i, j))){
                counter++;
                j++;
            } else {
                break;
            }
        }

        i = r_q - 1;           //le jobb
        j = c_q + 1;
        for(; i > 0 && j <= n; i--){
            if(!obs.contains(List.of(i, j))){
                counter++;
                j++;
            } else {
                break;
            }
        }

        i = r_q + 1;           //fel balra
        j = c_q - 1;
        for(; i <= n && j > 0; i++){
            if(!obs.contains(List.of(i, j))){
                counter++;
                j--;
            } else {
                break;
            }
        }

        i = r_q - 1;           //le balra
        j = c_q - 1;
        for(; i > 0 && j > 0; i--){
            if(!obs.contains(List.of(i, j))){
                counter++;
                j--;
            } else {
                break;
            }
        }

        return counter;
    }

}
