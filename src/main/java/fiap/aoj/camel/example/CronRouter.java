package fiap.aoj.camel.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CronRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:hello?period={{timer.period}}")
			.routeId("hello").group("hello-group")
			.transform()
			.method("simpleServiceBean", "saySomething").filter(simple("${body} contains 'foo'"))
			.to("log:foo").end()
			.to("stream:out");
	}

}