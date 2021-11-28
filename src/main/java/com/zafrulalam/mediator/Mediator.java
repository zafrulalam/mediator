package com.zafrulalam.mediator;

import java.util.HashMap;
import java.util.Map;

public class Mediator implements IMediator {

	/**
	 * Stores request type and it's handler
	 */
	private Map<String, IRequestHandler<?>> handlerMap = new HashMap<String, IRequestHandler<?>>();

	/**
	 * Every request must have a handler and both of them must be registered.
	 */
	public <T> void registerHandler(String classTypeName, IRequestHandler<T> handler) {
		this.handlerMap.put(classTypeName, handler);
	}

	/**
	 * Finds the associated RequestHandler for the request
	 * and activates the handler
	 */
	public <T> Response send(T req) {
		try {
			IRequestHandler<T> handler = (IRequestHandler<T>) handlerMap.get(req.getClass().getTypeName());
			return handler.handle(req);
		} catch (Exception e) {
			Response<String> err = new Response<String>();
			err.success = false;
			err.message = e.getMessage();
			err.data = e.getMessage();

			return err;
		}
	}
}
