package DP.Knapsack;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, 0);
    }

    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int local_min = directBuy(price, needs);

        for (int i = pos; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<Integer>();
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) - offer.get(j) < 0) {
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - offer.get(j));
            }
            if (temp != null)
                local_min = Math.min(local_min, offer.get(offer.size() - 1) + dfs(price, special, temp, i));
        }

        return local_min;
    }

    public int directBuy(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += needs.get(i) * price.get(i);
        }
        return total;
    }
}