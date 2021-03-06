# Đề kiểm tra kiến thức lớp SpringBoot 1A + 1B

- Thời gian làm 180 phút.
- Cách làm: viết ra giấy ghi rõ {họ và tên, email}
- Làm câu nào hãy ghi rõ số thứ tự câu hỏi.
- Thực hành đến đâu thì ghi lại câu trả lời đến đó.
- Câu nào khó quá thì bỏ, tất nhiên là mất 1 điểm.
- Viết lời giải trên cả 2 mặt giấy, nếu hơn 1 tờ thì giập ghim để không thất lạc


## Bài 1: căn bản
1. Spring Boot khác gì với Spring Framework? Cái này chỉ có Google rồi tóm tắt lại

2. Những cải tiến Spring Boot so với Servlet JSP trước đây? Cũng vậy

3. JAR khác WAR ở những điểm nào? Xem slide ở [thư mục này](https://github.com/TechMaster/SpringBootBasic/tree/main/basic/slides)

4. Maven khác Gradle ở những điểm nào? Xem slide tiếp.

5. annotation ```@ResponseBody``` có ý nghĩa gì?

6. annotation ```@GetMapping``` có tác dụng gì đối với phương thức trong Controller?

7. annotation ```@Controller``` thuộc package nào?

8. annotation ```@SpringBootApplication``` bao gồm những annotation nào bên trong?

9. Khi biên dịch một ứng dụng SpringBoot tải trên mạng, IDE báo lỗi không tìm thấy JDK version phù hợp vậy phải vào file pom.xml để sửa thuộc tính nào?

10. Khi muốn trả về dữ liệu kiểu JSON cần phải thêm tham số nào vào ```@GetMapping```?

11. Nếu có hai controller khác nhau nhưng có 2 phương thức mà ```@GetMapping``` cùng trỏ vào một đường dẫn khi chạy ứng dụng, điều gì sẽ xảy ra?

12. Trong file pom.xml có nhiều element <dependency>, trong đó lại có element <scope>, thường có 2 giá trị trong scope là ```runtime``` và ```test```
	```xml
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-devtools</artifactId>
		<scope>runtime</scope>
		<optional>true</optional>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
	```
Khác biệt của scope  ```<scope>runtime</scope>``` với ```<scope>test</scope>``` là gì?

13. Khi ta tạo một class Book như dưới đây
	```java
	public class Book {
	 private int id;
	 private String title;
	 private String author;
	}
	```
Hãy liệt kê các cách trong Visual Studio Code hay IntelliJ để tự động sinh ra các phương thức getter, setters, equalsTo, hash, toString

14. Cách để thay đổi port mặc định của ứng dụng Spring Boot sang port 9000 trong file application.yml như thế nào?

15. Có thể định nghĩa một key/value mới trong application.properties được không?

16. Trong một dự án SpringBoot có thể có 2 file cấu hình application.yml và application.properties cùng song song tồn tại được không?

17. Tại sao các thuộc tính của một class trong Model thường có access modifier là private? Tại không để mặc định hoặc là public cho dễ truy xuất?
	```java
	public class Book {
	  private int id;  //thường là private
	}
	```

18. Trong thư mục dự án Spring Boot, chúng ta thường thấy các thư mực controller, model, service, repository. Hỏi liệu có thể để các file class XXXController.java ở thư mục cùng cấp với Application.java?
Việc bố trí thư mục này có ý nghĩa gì?


19. Trong tiến trình khởi động ứng dụng Spring Boot, web server TomCat khởi động trước hay là đối tượng Application khởi động trước?

20. Tính năng NIO trong web server TomCat là gì? Câu này cứ Google thôi.

21. Ta có một mảng các đối tượng kiểu Book cần trả về kiểu application/json vậy phải dùng thư viện gì để convert mảng này sang JSON string?

22. Sau khi bạn tạo xong Spring Boot project, bạn phát hiện ra bạn quên không chọn dependency Thymeleaf, vậy bạn phải làm gì để bổ xung dependency này?

23. Hãy mô tả cú pháp Thymeleaf để gán giá trị động vào 2 thuộc tính ```src``` và ```alt``` của thẻ ```<img>```. Xem bài này [](../05bookcollection/bookstore/)

24. Ta có một mảng 20 phần tử nhưng khách hàng chỉ muốn hiển thị ra tất cả các phần tử ở vị trí lẻ: 1, 3, 5, 7, 9,.. vậy phải làm thế nào? Gợi ý xử lý trong Controller hoặc sử dụng cú pháp Thymeleaf

25. Khái niệm POJO trong java là gì?


## Bài 2: Bean, Dependency Injection
26. Hãy giải thích tóm tắt cơ chế Dependency Injection cho người không giỏi CNTT cũng có thể hiểu được.

27. Hãy liệt ít nhất 2 cách để lấy Application Context. Xem [02ApplicationContextAware](../../bean/02ApplicationContextAware/demobean)

28. Cơ chế nào giúp ApplicationContext có thể có được danh sách tất cả các component and bean?

29. ```@Component``` khác với ```@Bean``` ở những điểm nào?

30. Annotation ```@Configuration``` có tác dụng gì. Xem [02ApplicationContextAware](../../bean/02ApplicationContextAware/demobean)

31. Khi có 2 bean trả về cùng kiểu, dùng annotation nào để ưu tiên dùng mặc định một bean?

32. Tên của bean mặc định sẽ là tên phương thức được annotated bởi @Bean, tuy nhiên chúng ta có thể đổi lại tên bean khác với tên phương thức. Cú pháp sẽ là gì?

33. Khi có 2 bean khác tên, nhưng trả về cùng 1 kiểu, cùng với annotation ```@Autowired```, chúng ta cần thêm annotation nào khác để chọn bean theo tên trước khi gán vào biến?

34. Trong một ứng dụng, có thể có nhiều class được đánh dấu ```@Configuration``` hay chỉ được phép duy nhất một?

35. Mặc định mỗi bean được tạo ra dưới dạng một Singleton, cơ chế nào cho phép bean được đăng ký ApplicationContext nhưng chỉ khởi tạo khi cần?

## Bài 3: Đọc CSV, Excel
36. Hãy kể tên thư viện dependency đọc CSV vào POJO

37. Hãy kể tên 2 thư viện depedency đọc Excel vào POJO

38. Tại sao cách đọc dữ liệu vào POJO lại được ưa chuộng hơn cách đọc từng dòng rồi cắt chuỗi
