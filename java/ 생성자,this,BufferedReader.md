# 220719 생성자, this, BufferedReader

# 생성자(Constructor)

## What

객체를 생성할 때 초기화하는 함수이다.

## How

클래스와 동일한 이름이며, `return` 타입이 없이 정의한다.

생성자가 없으면, 컴파일러가 아무 내용 없는 기본 생성자 생성

```java
// 정의
public MyClass(){};

// 언제 호출 ? -> 새로운 객체 생성 시
MyClass myClass = new MyClass();

// 오버로딩 가능
public MyClass(){};
public MyClass(int a){};
public MyClass(char b){};
```

## Use

생성자 정의를 통해 사용자로부터 **원하는 데이터 타입**을 명시할 수 있다.

---

# this

## What

자신의 객체 주소를 가진 참조변수이다. 모든 인스턴스가 this 를 통해 자기 자신에 접근할 수 있다.

## How

```java
// 1. 멤버변수와 지역변수의 이름이 같을 때
public MyClass(int age){
	this.age = age;
	System.out.println("1번")
}

// 2. this - 다른 생성자 호출
public MyClass() {
	this(20) // 무조건 맨 윗줄에 위치해야 한다.
	System.out.println("2번")
}

MyClass myClass = new MyClass(20);

// 실행 결과
>> 1번
>> 2번
```

`static` 으로 선언된 함수 내에서는 사용할 수 없다.

→ 아직 객체가 생성되기 전이므로, 참조할 수 없다.

## Use

메서드 내에서 자신의 멤버에 접근해야 할 경우 사용할 수 있다.

멤버변수의 이름과 파라미터 변수의 이름이 같을 때, 이를 구분하기 위해서 사용할 수도 있다.

---

# BufferedReader

## What

버퍼 단위 혹은 문장 단위로 입력 값을 읽어 프로그램에 전달한다.

## How

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int t = Integer.parseInt(br.readLine()); // String to Int 로 형변환 필요
String str = br.readLine().split(" "); // 공백을 기준으로 나눈다.
```

## Use

주로 알고리즘 문제를 풀 때 입력값을 받아와야 할 경우 사용한다.

버그가 있는 `Scanner`보다 자주 쓰인다.
