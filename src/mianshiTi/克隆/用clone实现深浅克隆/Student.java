package mianshiTi.克隆.用clone实现深浅克隆;



public class Student implements Cloneable {
    private String name;

    private Integer age;

    private Address address;

    public Student(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return (Student)super.clone();这是浅克隆

        //这是深拷贝！！！！
        Student newStu = (Student) super.clone();
        newStu.setAddress((Address) newStu.getAddress().clone());

        return newStu;
    }
}


class TestCopy{
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student("张三",12,new Address("广州","1"));
        Student stuClone = (Student) student.clone();
        System.out.println(stuClone.hashCode());
        System.out.println(student.hashCode());
        System.out.println(stuClone==student);
        System.out.println("------");
        System.out.println(stuClone.getAddress() == student.getAddress());
    }
}
