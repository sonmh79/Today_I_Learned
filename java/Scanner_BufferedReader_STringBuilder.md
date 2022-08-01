# 220801_Scanner_BufferedReader_STringBuilder

# java.util.Scanner

### What

파일, 입력 스트림 등에서 데이터를 읽어 **구분자로 토큰화**하고 **다양한 타입으로 형변환**하여 리턴해주는 클래스이다.

다량의 데이터 처리 시 수행시간 비효율적이다.

### How

`nextInt()`, `nextDouble()`, `next()` - 유효 문자열 후 White space( ``,`\t`,`\n`)문자를 만나면 그 직전까지 처리한다. →개행문자나 구분자를 남긴다.

`nextLine()` - **개행문자(`\n`)까지** 읽어와서 개행문자는 버리고 준다.

### Use

비교적 간단한 입력을 받을 때 사용하기 좋다.

# java.io.BufferedReader

### What

필터스트림의 유형이다. `Scanner` 보다 빠르다

### How

줄 단위로 문자열을 읽을 수 있다.

InputStream(`System.in`) → InputStreamReader → BufferedReader

### Use

여러 줄의 입력을 받을 때 사용하기 좋다.

# java.lang.StringBuilder

### What

문자열의 조작을 지원하는 클래스이다.

문자열을 조작 시마다 새로운 문자열이 생성되는 것을 방지해준다.

### How

`append()` - 문자열을 계속 추가한다.

`toString()` - 문자열로 리턴한다.

### Use

많은 문자열들을 StringBuilder에 담았다가 필요 시 한 번에 출력한다.
