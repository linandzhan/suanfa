package mianshiTi.克隆.序列化实现克隆.出现不想序列化的字段;



import java.io.*;

public class Person1 implements Serializable {


    private transient String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class TestCopy2{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person1 p = new Person1("李四",12);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(p);  //序列化，将对象转为二进制

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Person1 newP = (Person1) ois.readObject();

        System.out.println(newP);
        System.out.println(p==newP);
    }
}
