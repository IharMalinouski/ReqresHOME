package tests;

import com.google.gson.Gson;
import objects.VacanciesList;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class HeadHunterTest {

    @Test
    public void vacancyTest(){
        String body = given()
       //given()
             //   .log().all()
                .when()
                    .get("https://api.hh.ru/vacancies?text=QA")
                .then()
               // .log().all()
                .statusCode(200)
                .extract().body().asString();

        VacanciesList vacanciesList = new Gson().fromJson(body, VacanciesList.class);
        int salaryTo = vacanciesList.getItems().get(0).getSalary().getTo();
        System.out.println("Salary 'to' is: " + salaryTo);
//        Assert.assertEquals("", "");
        System.out.print(vacanciesList);

    }
}
