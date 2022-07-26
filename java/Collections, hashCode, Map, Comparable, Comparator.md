# 220726 Collections, hashCode, Map, Comparable, Comparator

# Collections

### What

자료구조 모여있는 자바 라이브러리이다.

`java.utils.Collections`

### How

`ArrayList<>()`- 배열로 동작한다. 데이터를 원하는 만큼 추가할 수 있기 때문에 배열의 크기가 가변적일 때 사용하면 좋다. 배열의 크기가 고정적이면 단순 리스트를 사용하는 것이 효율적이다. 데이터가 연속적으로 있어 읽기는 빠르지만 데이터 추가, 삭제는 느리다.

`LinkedList<>()` - 노드(객체)를 만들어 서로 연결, 메모리 안에서 여기저기 만들어진다. 데이터 추가, 삭제에 용이하다. 나중에 `queue`로 사용 가능하다.

`HashSet<>()` -가장 기본적인 `set`이다. 중복을 허용하지 않는 집합이다.

`LinkedHashSet<>()` - 순서 보장하는 `set`이다

`TreeSet<>()` - 사전 순으로 정렬이 가능한 `set`이다.

### Use

문제의 상황에 따라 array, set를 적절하게 사용할 수 있을 것 같다.

# 중복 데이터 확인

### What

데이터가 객체로 들어올 때, 특정 데이터를 기준으로 중복 여부를 판단해야하는 경우가 있다.

### How

특정 데이터를 1차적으로 `.hashCode()` 로 변환 후 비교, 그래도 같으면 `equals` 로 비교할 수 있다.

해시로 변환하여 `int`로 비교하는 연산이 `equals` 연산보다 빠르기 때문이다.

### Use

객체가 가진 변수에 대해 중복을 검사해야 할 때 사용한다.

# Map

### What

`key`와 `value`가 `Entry`한 쌍으로 묶여 데이터를 관리한다.

### How

```java
HashMap<Integer, String> map1 = new HashMap<>();
map1.put(111,"Son");

//키를 모르는 경우 - 1. keySet
Set<Integer> keyset = map1.keySet();
for (int key:keyset) {
	System.out.println(map1.get(key));
}

// 2. entrySet
Set<Entry<Integer,String>> entrySet = map1.entrySet();

for (Entry<Integer,String> entry: entrySet) {
	System.out.println(entry.getKey());
	System.out.println(entry.getValue());
}
```

?? key는 무조건 Integer ? No

### Use

주로 `Json`을 이용해 데이터를 다룰 때 자주 사용한다.

# 정렬(객체 비교)

### What

객체를 비교한다.

`Comparable` - 자기 자신과 매개변수를 비교한다.

`Comparator` - 두 개의 매개변수를 비교한다.

### How

`Comparable` - 객체 내에 메서드를 오버라이드한다.

현재 객체가 더 크면 양수 리턴

같으면 0 리턴

파라미터로 넘어온 객체가 더 크면 음수 리턴

```java
public class Student implements Comparable<Student> {
	String name;

	...

	@Override
	public int compareTo(Student o) {
		return this.name().compareTo(o.getName()); // 이름 비교
		//int형 비교
		// return this.age - o.getAge();
}
}
```

`Comparator` - 비교 대상 객체를 새로 생성한다.

```java
// Student 객체의 학점으로 비교
public class GradeComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.grade > o2.grade) {
			return 1;
		} else if (o1.grade() < o2.grade()) {
			return -1;
		} else {
			return 0;
		}
	}
}

// Student객체의 이름으로 비교
public class NameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.name.compareTo(o2.name);
}

// 실행
List<Student> students = new ArrayList<Student>();

...

Collections.sort(students, new NameComparator()); // 생성한 Comparator 객체를 정렬 기준으로 넘겨준다.
```

익명 객체 사용법

```java
public static void main(String[] args) {
	...
	static Comparator<Student> comp1 = new Comparator<Student>(){

		@Override
		public int compare(Student o1, Student o2){
			return o1.age - o2.age;
}
}
}
```

### Use

사용자가 원하는 정렬 조건을 구현해 배열을 정렬할 수 있다.
