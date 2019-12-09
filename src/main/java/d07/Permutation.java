package d07;

import java.util.*;

public class Permutation {

    protected Set<List<Integer>> permutations = new HashSet<>();

    public void permute(java.util.List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, k);
            permute(arr, k + 1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            permutations.add(new ArrayList<>(arr));
        }
    }

    public void prepareSet() {
        permute(Arrays.asList(0, 1, 2, 3, 4), 0);
    }

    public Set<List<Integer>> getPermutations() {
        return permutations;
    }

    public void setPermutations(Set<List<Integer>> permutations) {
        this.permutations = permutations;
    }
}