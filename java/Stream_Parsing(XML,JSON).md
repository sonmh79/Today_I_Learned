# 220728 Stream, Parsing(XML,JSON)

# Stream

데이터를 주고 받을 때 `Stream`을 사용한다.

외부에서 들어오는 데이터 -`InputStream`

외부로 보내는 데이터 -`OutputStream`

# Parsing

## 1. XML

### What

Extensible Markup Language

태그를 이용해 데이터를 정의한다.

사용자 정의 태그를 통해 확장 가능하다는 특징이 있다.

구조적이고 직관적이나 큰 용량이 필요하다

**XML parser** - 문서에서 필요한 정보를 얻기 위해 태그를 구별하고 내용을 추출하는 과정

**SAX(Simple APi for XML)Parser -** 문서를 읽다가 발생하는 이벤트 기반으로 문서를 처리한다.

1. `SAXPArserFactory` 만들기
2. `parser` 생성 (예외 처리가 필요하다)
3. xml파일과 `DefaultHandler` 넘겨주기
4. `startElement()` 메서드를 통해 이벤트를 캐치하고 로직을 작성한다.

**DOM Parser - 문서를 완전히 메모리에 로딩 후** 태그 단위로 데이터를 검색해 찾는다

- DOM 트리 형태로 구성된다. 각 요소는 Node(태그, 속성, 값)으로 구성된다.
- root 노드부터 부모-자식 관계로 구성된다.
- `getChildNode()`, `getNodeName()` 등 처럼 API 메서드들이 직관적이다.

### How

```java
// DOM Parser 예시
public static void connetXML() {
		File inputFile = new File("dweather.rss");
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(inputFile);

			Element root = doc.getDocumentElement();

			datas = root.getElementsByTagName("data");

			for (int i=0;i<datas.getLength();i++) {
				Node data = datas.item(i);
				NodeList tags = data.getChildNodes();
				Weather nWeather = new Weather();
				for (int j=0;j<tags.getLength();j++) {
					Node tag = tags.item(j);
					if (tag.getNodeName().equals("hour")) {
						nWeather.setHour(Integer.parseInt(tag.getTextContent()));
					} else if (tag.getNodeName().equals("temp")) {
						nWeather.setTemp(Double.parseDouble(tag.getTextContent()));
					} else if (tag.getNodeName().equals("wfKor")) {
						nWeather.setWfKor(tag.getTextContent());
					} else if (tag.getNodeName().equals("reh")) {
						nWeather.setReh(i);
					}
				}
				weatherList.add(nWeather);
				System.out.println(nWeather.toString());
			}

	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
```

---

## 2. JSON

Javascript Object Notation

객체의 형태로 다른 언어와 호환된다.

## 3. CSV

Comma Seperated Value

용량이 작지만 구조적이지 못하다.
