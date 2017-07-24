import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class BasicSimulation extends Simulation {
  val users = 10
  val ramp = 60L
  val testTime = 300L

  val httpConf = http
    .baseURL("http://localhost:8080")
    .doNotTrackHeader("1")

  val headers = Map("Content-Type" -> "application/json")


  val scn = scenario("Create Customer").during(testTime seconds) {
    uniformRandomSwitch(
      exec(http("get all")
        .get("/customer/all").headers(headers)
        .check(status.is(200))),
      exec(http("cust")
        .post("/customer").headers(headers)
        .body(RawFileBody("CustomerInput.txt"))
        .check(status.is(200)))

    )
  }

  setUp(scn.inject(rampUsers(users) over (ramp seconds))).protocols(httpConf)
}