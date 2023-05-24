package Easy;

import java.util.ArrayList;

public class PhoneLetters {
    public static void main(String[] args) {
//        System.out.println(padList("","12"));
        System.out.println(dicelist("", 4));
    }
    static void pad(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        for(int i=(digit - 1)*3; i<digit*3; i++){
            char ch = (char)('a' + i);
            pad(p+ch, up.substring(1));
        }
    }
    static ArrayList<String> padList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0';

        ArrayList<String> ans = new ArrayList<>();
        for(int i=(digit - 1)*3; i<digit*3; i++){
            char ch = (char)('a' + i);
            ans.addAll(padList(p+ch, up.substring(1)));
        }
        return ans;
    }
    static void dice(String p, int target){
        if(target == 0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=6 && i<= target; i++){
            dice(p+i, target - i);
        }
    }
    static ArrayList<String> dicelist(String p, int target){
        if(target == 0){
            ArrayList<String> list= new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i=1;i<=6 && i<= target; i++){
            ans.addAll(dicelist(p+i, target - i));
        }
        return ans;
    }
}
