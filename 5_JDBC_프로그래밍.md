# JDBC(Java Database Connectivity)
애플리케이션의 대부분은 실행 중에 발생한 데이터를 어떤 형태로든 보관하는 것이 일반적  
파일 시스템을 사용할 수도 있지만, 데이터베이스를 이용하는 것이 현실적으로 가장 보편적인 방식

## RDBMS
- 관계형 데이터베이스
- `ORACLE`, `MSSQL`, `MySQL`, `MariaDB`, `Postgresql`

## JDBC 프로그래밍을 위한 API 용어들
### java.sql.Connection
- `Connection` 인터페이스는 데이터베이스와 네트워크상의 연결을 의미
- 데이터베이스에 `SQL`을 실행하기 위해서 반드시 Connection 타입의 객체를 생성해야 한다
- `Connection`이라는 인터페이스를 활용하고 실제 구현 클래스는 JDBC 드라이버 파일 내부의 클래스를 이용한다
- 중요: **Connection은 반드시 close() 해야한다**
  - 데이터베이스는 많은 연결을 처리해야 하는데 연결이 종료되지 않으면 새로운 연결을 받을 수 없는 상황이 발생
- `try-catch-finally`을 이용해서 종료하거나 `try-with-resourecs` 방식을 이용

### java.sql.Statement/PreparedStatement
- JDBC에서 SQL을 데이터베이스로 보내기 위해 Statement/PreparedStatement 타입을 이용
- PreparedStatement: SQL 문을 미리 전달하고 나중에 데이터를 보내는 방식
- Statement: SQL 문 내부에 모든 데이터를 같이 전송하는 방식

### java.sql.ResultSet
`PreparedStatement`를 이용해서 insert/update/delete를 처리하는 DML의 경우, int로 반환되는 것과 달리 쿼리(select)를 실행했을 때,  
데이터베이스에서 반환하는 데이터를 읽어 들이기 위해 `ResultSet`이라는 인터페이스를 이용
- `getInt()`, `getString()` 등의 메소드를 이용해서 필요한 타입으로 데이터를 읽어들임

### Connection Pool과 DataSource
JDBC 프로그램은 필요한 순간에 데이터베이스와 네트워크로 연결하고 데이터를 보내고 받는 방식으로 구성됨  
이 과정에서 데이터베이스와의 연결을 맺는 작업은 많은 시간과 자원을 쓰기 때문에 여러 번 SQL을 실행할수록 성능 저하가 발생됨  
-> JDBC에서는 보통 `Connection Pool`이라는 것을 이용해서 문제를 해결함

### DAO(Data Access Object)
- 데이터를 전문적으로 처리하는 객체
- 데이터베이스의 접근과 처리를 전담하는 객체
- 주로 VO(값 자체를 표현하는 객체) 단위로 처리함
- DAO를 호출하는 객체는 DAO가 내부에서 어떤식으로 데이터를 처리하는지 알 수 없도록 구성

### VO(Value Object)
데이터베이스에서 하나의 데이터를 `entity`라고 하는데 자바 프로그램에서는 이를 처리하기 위해 테이블과 유사한 구조의 클래스를 만들어 객체로 처리하는 방식을 사용  
-> 이때 만든 객체는 '값을 보관하는 용도'라는 의미에서 VO라고 함
- VO는 DTO와 유사하지만, `DTO`가 각 계층을 오고가는데 사용되고, `VO`는 데이터베이스의 entity를 자바 객체로 표현한 것
- `DTO`는 `getter/setter`을 이용해서 자유롭게 데이터 가공할 수 있는데 비해, `VO`는 주로 데이터 자체를 의미해 `getter`만 이용하는 경우가 많다
- 