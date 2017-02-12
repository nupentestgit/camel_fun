package camelroutes;

import org.apache.camel.builder.RouteBuilder;

import camelprocessor.MyTestProcessor;

public class MyTestRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("stream:in?promptMessage=Enter something:").process(new MyTestProcessor())
				.to("file://camel/output?fileName=console.txt");
		// from("file://camel/input").to("file://camel/output?fileName=console.txt");
	}

}
