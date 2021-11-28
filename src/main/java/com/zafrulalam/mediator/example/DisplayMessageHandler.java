package com.zafrulalam.mediator.example;

import com.zafrulalam.mediator.IRequestHandler;
import com.zafrulalam.mediator.Response;

public class DisplayMessageHandler implements IRequestHandler<DisplayMessageCommand> {

	public Response handle(DisplayMessageCommand req) {
		Response<MessageResult> result = new Response<MessageResult>();

		MessageResult data = new MessageResult();
		data.setMessage("This msg is in response to " + req.getMsg());

		result.success = true;
		result.message = "Command executed succesfully!";
		result.data = data;

		return result;
	}
}
