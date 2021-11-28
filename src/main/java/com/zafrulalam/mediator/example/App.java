package com.zafrulalam.mediator.example;

import com.zafrulalam.mediator.IRequestHandler;
import com.zafrulalam.mediator.Mediator;
import com.zafrulalam.mediator.Response;

public class App {
	public static void main(String[] args) {
		/*
		 * Ideally _mediator should be passed by dependancy injection
		 */
		Mediator _mediator = new Mediator();

		IRequestHandler<MessageQuery> qryHandler = new MessageQueryHandler();
		IRequestHandler<DisplayMessageCommand> cmdHandler = new DisplayMessageHandler();
		
		/*
		 * Every Request and associated RequestHandler must be registered with _mediator
		 */
		_mediator.registerHandler(MessageQuery.class.getTypeName(), qryHandler);
		_mediator.registerHandler(DisplayMessageCommand.class.getTypeName(), cmdHandler);

		DisplayMessageCommand cmd = new DisplayMessageCommand();
		cmd.setMsg("Command example - request from DisplayMessageCommand");
		
		MessageQuery qry = new MessageQuery();
		qry.setMsg("Query example - query from MessageQuery");

		/*
		 * The send method returns Response<?> that needs to be casted to appropriate generic type
		 */
		Response<MessageResult> res = (Response<MessageResult>) _mediator.send(cmd);

		if (res.success) {
			System.out.println(res.message);
			System.out.println(res.data.getMessage());
		} else {
			System.out.println("Mediator did not work!");
			System.out.println(res.message);
		}
		
		res = (Response<MessageResult>) _mediator.send(qry);

		if (res.success) {
			System.out.println(res.message);
			System.out.println(res.data.getMessage());
		} else {
			System.out.println("Mediator did not work!");
			System.out.println(res.message);
		}
	}
}
