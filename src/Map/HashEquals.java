package Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashEquals {
    public static void main(String[] args) {
        Map<Chel,String> cc = new HashMap<>();
        Chel bob = new Chel("roman",11);
        Chel bob1 = new Chel("roman",11);
        cc.put(bob,"sfdsdf");
        cc.put(bob1,"sfdsdf");

        for (Map.Entry<Chel,String> entry : cc.entrySet()){
            System.out.println(entry.getKey() + "" + entry.getValue());
        }

    }
    public static class Chel{
        private String name;

        private int id;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Chel chel = (Chel) o;

            if (id != chel.id) return false;
            return name != null ? name.equals(chel.name) : chel.name == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + id;
            return result;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Chel{");
            sb.append("name='").append(name).append('\'');
            sb.append(", id=").append(id);
            sb.append('}');
            return sb.toString();
        }

        public Chel(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }
}
