import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserContainer {


        static Map<String, String> map = new HashMap<String, String>();

        public UserContainer() {
        }

        public static boolean isNameExists(String name, String password) {
            boolean flag = false;

            if (map.containsKey(name) && map.containsValue(password)) {
                flag = true;
            }
            return flag;
        }
        public void getList() {
            Set<String> list = map.keySet();
            for(String k:list) {
                System.out.print("username" + " " + k + "\n");
            }
        }
    }


