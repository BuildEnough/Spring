# HttpServlet
- `HttpServlet`을 상속받은 클래스 객체는 `Tomcat`과 같은 `WAS`의 내부에서 자동으로 객체를 생성하고 관리하기 때문에 개발자가 객체 관리에 신경 쓸 필요가 없다
- `HttpServlet`은 멀티 스레드에 의해서 동시에 실행될 수 있도록 처리되기 때문에 동시에 많은 사용자를 어떻게 처리해야 하는지에 대한 고민을 줄일 수 있다
- `Get`/`Post`에 맞게 doGet(), doPost() 등을 제공하므로 필요한 메소드를 `오버라이드`하는 것만으로 `Get`/`Post`방식 처리를 나누어 처리할 수 있다

## HttpServletRequest의 주요 기능
- HTTP 메시지 형태로 들어오는 요청(Request)에 대한 정보를 파악하기 위해 제공됨

### getParameter()
- `HttpServletReuqest`에서 가장 빈번하게 사용되는 메서드
- '?name=AAA&age=20'과 같은 쿼리 스트링에서 `name`이나 `age`라는 key를 이용해 value를 얻는 역할을 위해 사용
- `getParameter()`의 결과는 항상 `String`(숫자 처리시 예외 발생 주의!)
- 파라미터가 존재하지 않는다면 `null`을 반환할 수 있다(`null` 체크 주의!)

### getParameterValues()
- 동일한 이름의 파라미터가 여러 개 있는 경우 사용
- `String[]` 타입으로 반환됨

### setAttribute
- JSP로 전달할 데이터를 추가할 때 사용
- `key`와 `value`의 형태로 데이터를 저장할 수 있다
- `key`는 문자열로 지정, `value`는 모든 객체 타입을 이용할 수 있다

## HttpServletResponse의 주요 기능
- 응답(Response)에 대한 기능
- HttpServletResponse는 `JSP`에서 주로 처리되기 때문에 서블릿 내에서 직접 사용되는 일은 많지 많고 `sendRedirect`를 이용하는 경우가 많다

### sendRedirect()
- HttpServletResponse의 메소드들 중 가장 많이 사용
- 브라우저에게 '다른 곳으로 가라'는 응답(Response) 메시지를 전달함
- HTTP에서 `Location` 이름의 HTTP 헤더로 전달됨
  - 브라우저는 `Location`이라는 응답을 받으면 화면을 처리하는 대신에 주소창에 지정된 주소로 이동하고, 다시 호출하게 됨
- `sendRedirect()`를 사용하면 브라우저의 주소가 아예 변경되기 때문에 사용자의 '새로고침'과 같은 요청을 미리 방지 가능하여, 특정한 작업이 끝나고 새로 시작하는 흐름을 만들 수 있다

