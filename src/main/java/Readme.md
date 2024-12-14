## HashMap 초기화 , List 초기화
```java
public Map<Character, List<Character>> numListMap = new HashMap<Character, List<Character>>() {{
put('2', Arrays.asList('a', 'b', 'c'));
put('3', Arrays.asList('d', 'e', 'f'));
put('4', Arrays.asList('g', 'h', 'i'));
put('5', Arrays.asList('j', 'k', 'l'));
put('6', Arrays.asList('m', 'n', 'o'));
put('7', Arrays.asList('p', 'q', 'r', 's'));
put('8', Arrays.asList('t', 'u', 'v'));
put('9', Arrays.asList('w', 'x', 'y', 'z'));
}};
```
## String char loop
```java
for (char c : digits.toCharArray());
```

## string 에서 index 로 char 뽑는것 
```java
string.charAt(index);
```
## stream 관련
```java
List<String> stringList;
stringList.map(s -> s+"A").collect(Collectors.toList());

stringList.map(s -> {
return s+"A"
}).collect(Collectors.toList());

Collections.emptyList();
```
