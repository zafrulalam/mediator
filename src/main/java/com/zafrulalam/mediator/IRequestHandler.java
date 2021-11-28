package com.zafrulalam.mediator;

/**
 * @author zafrul
 * Defines a handler for a request
 * @param <T> is a type of IRequest
 */
public interface IRequestHandler<T>{
	
	/**
	 * Handles a request
	 * @param req is a type of IRequest
	 * @return Response
	 */
	public Response handle(T req);
}
