# Maven Dependency 추가하기
```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.9.0</version>
</dependency>
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <version>1.18.30</version>
</dependency>
```

#### lombok을 사용하면 Getter, Setter, 생성자 설정을 편하게 할 수 있다.

# JSON 형식에 맞게 클래스 설계하기
```json
{
    "TbPublicWifiInfo": {
        "list_total_count": 25160,
        "RESULT": {
            "CODE": "INFO-000",
            "MESSAGE": "정상 처리되었습니다"
        },
        "row": [
            {
                "X_SWIFI_MGR_NO": "-WF171016",
                "X_SWIFI_WRDOFC": "중구",
                "X_SWIFI_MAIN_NM": "다동어린이공원",
                "X_SWIFI_ADRES1": "다동 51-2",
                "X_SWIFI_ADRES2": "을지로 3길 49(다동 51-2, 공-16)",
                "X_SWIFI_INSTL_FLOOR": "",
                "X_SWIFI_INSTL_TY": "3. 공원(하천)",
                "X_SWIFI_INSTL_MBY": "협력형_서울(SKT)",
                "X_SWIFI_SVC_SE": "공공WiFi",
                "X_SWIFI_CMCWR": "자가망U-무선망",
                "X_SWIFI_CNSTC_YEAR": "2017",
                "X_SWIFI_INOUT_DOOR": "실외",
                "X_SWIFI_REMARS3": "",
                "LAT": "37.56817",
                "LNT": "126.98076",
                "WORK_DTTM": "2024-03-12 11:12:43.0"
            },
            {
                "X_SWIFI_MGR_NO": "-WF171017",
                "X_SWIFI_WRDOFC": "중구",
                "X_SWIFI_MAIN_NM": "다동어린이공원",
                "X_SWIFI_ADRES1": "다동 51-2",
                "X_SWIFI_ADRES2": "을지로 3길 49(다동 51-2, 공-16)",
                "X_SWIFI_INSTL_FLOOR": "",
                "X_SWIFI_INSTL_TY": "3. 공원(하천)",
                "X_SWIFI_INSTL_MBY": "협력형_서울(SKT)",
                "X_SWIFI_SVC_SE": "공공WiFi",
                "X_SWIFI_CMCWR": "자가망U-무선망",
                "X_SWIFI_CNSTC_YEAR": "2017",
                "X_SWIFI_INOUT_DOOR": "실외",
                "X_SWIFI_REMARS3": "",
                "LAT": "37.56817",
                "LNT": "126.98076",
                "WORK_DTTM": "2024-03-12 11:12:43.0"
            }
        ]
    }
}
```

```java
package project1;

import lombok.Data;
import lombok.AllArgsConstructor;
import com.google.gson.annotations.SerializedName;

@Data
@AllArgsConstructor
public class WifiJson {
	private TbPublicWifiInfo TbPublicWifiInfo;
	
	@Data
	@AllArgsConstructor
	public class TbPublicWifiInfo {
		private int list_total_count;
		private Result RESULT;
		private Row[] row;
		
		@Data
		@AllArgsConstructor
		public class Result {
			private String CODE;
			private String MESSAGE;
		}
		
		@Data
		@AllArgsConstructor
		public class Row {
			@SerializedName("X_SWIFI_MGR_NO")
			private String mgrNo;
			
			@SerializedName("X_SWIFI_WRDOFC")
			private String wrdofc;
			
			@SerializedName("X_SWIFI_MAIN_NM")
			private String mainNm;
			
			@SerializedName("X_SWIFI_ADRES1")
			private String adres1;
			
			@SerializedName("X_SWIFI_ADRES2")
			private String adres2;
			
			@SerializedName("X_SWIFI_INSTL_FLOOR")
			private String instlFloor;
			
			@SerializedName("X_SWIFI_INSTL_TY")
			private String instlTy;
			
			@SerializedName("X_SWIFI_INSTL_MBY")
			private String instlMby;
			
			@SerializedName("X_SWIFI_SVC_SE")
			private String svcSe;
			
			@SerializedName("X_SWIFI_CMCWR")
			private String cmcwr;
			
			@SerializedName("X_SWIFI_CNSTC_YEAR")
			private String cnstcYear;
			
			@SerializedName("X_SWIFI_INOUT_DOOR")
			private String inoutDoor;
			
			@SerializedName("X_SWIFI_REMARS3")
			private String remars3;
			
			@SerializedName("LAT")
			private String lat;
			
			@SerializedName("LNT")
			private String lnt;
			
			@SerializedName("WORK_DTTM")
			private String workDttm;
		}
	}
}
```

#### lombok의 @Data 주석을 달면 @Getter, @Setter, @ToString, @RequiredArgsConstructor, @EqualsAndHashCode 를 모두 사용한다.
#### JSON의 데이터 이름과 같아야하고 gson의 @SerializedName을 사용해서 자바 내에서 다른 이름으로 사용할 수 있다.

# 사용해보기
```java
String URL = "http://openapi.seoul.go.kr:8088/sample/json/TbPublicWifiInfo/1/2/";
URL url = new URL(URL);
HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
httpConn.setRequestMethod("GET");
httpConn.setRequestProperty("Content-type", "application/json");
BufferedReader br;

if(httpConn.getResponseCode() >= 200 && httpConn.getResponseCode() <= 300) {
  br = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
} else {
  br = new BufferedReader(new InputStreamReader(httpConn.getErrorStream()));
}

StringBuilder sb = new StringBuilder();
String line;

while ((line = br.readLine()) != null) {
    sb.append(line);
}

Gson gson = new Gson();
WifiJson wifiJson = gson.fromJson(sb.toString(), WifiJson.class);
Row[] wifiRows = wifiJson.getTbPublicWifiInfo().getRow();
```

#### wifiRows 는 이제 json - "row"의 중괄호로 구분된 것마다 Row 클래스를 만들고 @SerializedName와 같은 항목으로 지정된 멤버변수에 데이터를 할당하여 만들어진 Row의 배열이다.
#### row를 받아올 때 List형태로 받을 수도 있다. ```private Row[] row; -> private List<Row> row;```
