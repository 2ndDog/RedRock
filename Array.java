import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Array {
    public static void main(String[] args) {
        List<String> animal = new ArrayList<>();
        animal.add("狗");
        animal.add("猫");
        //方法一
        for(int i = 0;i<=animal.size()-1;i++) {
            System.out.println(animal.get(i));
        }
        //方法二
        for(String tmp:animal) {
            System.out.println(tmp);
        }
        //方法三
        Iterator it1 = animal.iterator();
        while(it1.hasNext()) {
            System.out.println(it1.next());
        }
        //方法四
        for(Iterator it2 = animal.iterator();it2.hasNext();) {
            System.out.println(it2.next());
        }
    }
}
