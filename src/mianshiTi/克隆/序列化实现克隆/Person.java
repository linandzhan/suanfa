package mianshiTi.克隆.序列化实现克隆;

import java.io.*;

public class Person implements Serializable {

    private String name;

    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


class TestCopy1{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person("李四",12);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(p);  //序列化，将对象转为二进制

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Person newP = (Person) ois.readObject();

        System.out.println(newP);
        System.out.println(p==newP);
    }
}
