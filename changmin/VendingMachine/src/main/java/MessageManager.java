import java.util.HashMap;
import java.util.Map;

public class MessageManager {
    public static Map<String, Object> getMessage(Object obj){
        Map<String, Object> map = new HashMap<>();
        map.put("massage", obj);
        return map;
    }

    public static Map<String, Object> getMessage(String tag, Object obj){
        Map<String, Object> map = new HashMap<>();
        map.put(tag, obj);
        return map;
    }

}
