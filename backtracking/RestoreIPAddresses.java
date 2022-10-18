import java.util.*;


public class RestoreIPAddresses {
    public List<String> RestoreIPAddresses(String s) {

        List<String> res = new ArrayList<String>();

        backtracking(res, "", s, 0, 4);

        return res;
    }

    public void backtracking(List<String> res, String temp, String s, int index, int counts) {

        if (counts < 0)
            return;

        if (counts == 0 && index == s.length()) {
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }

        for (int i = index; i < Math.min(index + 3, s.length()); i++) {

            String candi = s.substring(index, i + 1);

            if (Integer.parseInt(candi) <= 255 && (i == index || candi.charAt(0) != '0')) {

                backtracking(res, temp + candi + ".", s, i + 1, counts - 1);

            }

        }

    }
}