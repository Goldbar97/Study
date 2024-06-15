# Nested DTO 와 Swagger Schemas 인식 오류
프로젝트를 하던 도중 Swagger 의 Schemas 인식이 제대로 되지 않는 문제를 만났다.

```java
package kang.tableorder.dto;

public class MenuDto {

  public static class Update {

    @Getter
    @Setter
    public static class Request {

      private MenuCategory category;

      @NotBlank(message = "Name cannot be blank")
      @Pattern(regexp = "^[a-zA-Z0-9가-힣 ]*$",
          message = "Invalid characters")
      private String name;

      @NotBlank(message = "ImageUrl cannot be blank")
      private String imageUrl;

      @Min(value = 0, message = "Price minimum is 0")
      private int price;

      @NotBlank(message = "Description cannot be blank")
      private String description;

      @Min(value = 0, message = "Spiciness minimum is 0")
      @Max(value = 4, message = "Spiciness maximum is 4")
      private int spiciness;

      private Boolean isAvailable;
    }

    @Builder
    @Getter
    @Setter
    public static class Response {

      private Long id;
      private MenuCategory category;
      private String name;
      private String imageUrl;
      private int price;
      private String description;
      private int spiciness;
      private Boolean isAvailable;

      public static MenuDto.Update.Response toDto(MenuEntity menuEntity) {

        return MenuDto.Update.Response.builder()
            .id(menuEntity.getId())
            .category(menuEntity.getCategory())
            .name(menuEntity.getName())
            .imageUrl(menuEntity.getImageUrl())
            .price(menuEntity.getPrice())
            .description(menuEntity.getDescription())
            .spiciness(menuEntity.getSpiciness())
            .isAvailable(menuEntity.getIsAvailable())
            .build();
      }
    }
  }
}
```

Chat GPT 에게 아무리 질문을 반복해도 각 필드에 @Schema 를 붙이라는 답변만 오고 확실하게 해결이 안되던 중 한 블로그에서 해결 방법을 발견했다.

[블로그 링크](https://velog.io/@rockstar/Spring-SpringDocs-Swagger-Inner-Class-인식-못-하는-경우)

## 해결 방법
```
springdoc:
  use-fqn: true
```

프로젝트 설정 파일인 application.yml 에 다음과 같이 추가했더니 드디어 Swagger-UI 의 Schemas 에 제대로 표시된다.

Swagger 의 클래스 인식은 패키지 위치와는 상관없이 이름만으로 구분을 하며, 내 DTO 는 다른 DTO 와 이름은 다르지만 같은 내부 클래스 이름인 Request 와 Response 를 사용하고 있다.

따라서 실제로 다른 클래스이지만 이름이 같기 때문에 충돌이 발생하게 되고 Swagger Schemas 가 정상적으로 인식을 하지 않던 것이었다.

Fully Quilified Name 설정을 true 로 바꿔주면 패키지 위치까지 포함하여 클래스를 찾아주므로 정확하게 식별할 수 있다.

![image](https://github.com/Goldbar97/Study/assets/100333239/c9f0e140-8676-4e45-ae5b-6bd0533a27be)
