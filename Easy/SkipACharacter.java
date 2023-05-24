package Easy;

public class SkipACharacter {
    public static void main(String[] args) {
//        skip("","Hallo");
//        System.out.println(skipchar("badcad"));
        System.out.println(skipNotApple("baccdahappleapple"));
    }
    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p,up.substring(1));
        }else{
            skip(p+ch, up.substring(1));
        }
    }
    static String skipchar(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skipchar(up.substring(1));
        }else{
            return ch + skipchar(up.substring(1));
        }
    }
    static String skipApple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return skipApple(up.substring(5));
        }else{
            return up.charAt(0) + skipApple(up.substring(1));
        }
    }
    static String skipNotApple(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("app") && !up.startsWith("apple")){
            return skipNotApple(up.substring(3));
        }
        else{
            return up.charAt(0) + skipNotApple(up.substring(1));
        }
    }
}
