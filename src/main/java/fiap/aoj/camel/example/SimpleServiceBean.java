package fiap.aoj.camel.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("simpleServiceBean")
public class SimpleServiceBean {

	@Value("${greeting}")
	private String say;

	public String saySomething() {
		return say;
	}

}