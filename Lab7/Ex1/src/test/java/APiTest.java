import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.when;

public class APiTest {

    @Test
    public void listAll_isAvailable()
    {
        when().get("https://jsonplaceholder.typicode.com/todos").then().assertThat().statusCode(200);
    }

    @Test
    public void toDo_4(){
        when().get("https://jsonplaceholder.typicode.com/todos/4").then().assertThat().statusCode(200).and().body("title", equalTo("et porro tempora")).and().body("id",equalTo(4));
    }

    @Test
    public void when_GetALlReturn198or199(){
        when().get("https://jsonplaceholder.typicode.com/todos").then().assertThat().statusCode(200).and().body("id", hasItems(198,199));

    }
}
