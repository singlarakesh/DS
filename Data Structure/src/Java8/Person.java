package Java8;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparator<Person>,Comparable<Person>{
	private String name;
	private String lastName;
	private int age;
	public Person() {}
	public Person(String name, String lastName, int age) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compare(Person o1, Person o2) {
		// TODO Auto-generated method stub
		return o1.age-o2.age;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.age-o.age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, lastName, name);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(lastName, other.lastName) && Objects.equals(name, other.name);
	}

}
