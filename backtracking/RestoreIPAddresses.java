import java.util.*;


public class RestoreIPAddresses {
    public List<String> RestoreIPAddresses(String s) {

        List<String> res = new ArrayList<String>();

        backtracking(res, "", s, 0, 0);
        
        return res;
    }

    public void backtracking(List<String> res, String temp, String s, int index, int begin){
       
        if(temp.length() > 4) return;

        if(temp.length() == s.length()){ 
            res.add(temp);
            return;
        }

        for(int i=index; i < s.length(); i++){

            String candi =  s.substring(begin, index+1);

            if(candi.equals("0") || ((candi.charAt(0) != '0') && Integer.parseInt(candi) <= 255 && 0 <= Integer.parseInt(candi))){

                temp = temp + candi; 

                backtracking(res, temp, s, i + 1, i + candi.length());

                temp = temp.substring(0,  temp.length() - candi.length() + 1);

            }else{
                continue;
            }

        }

    }
}
