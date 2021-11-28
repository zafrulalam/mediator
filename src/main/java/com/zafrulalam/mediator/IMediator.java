package com.zafrulalam.mediator;

/**
 * @author zafrul
 * Defines the mediator
 */
public interface IMediator {

	/**
	 * Defines the register handler
	 * @param <T>
	 * @param classTypeName is a type of IRequest
	 * @param handler type of IRequestHandler for the Request
	 */
	<T> void registerHandler(String classTypeName, IRequestHandler<T> handler);

	/**
	 * Defines the send that activates a single handler 
	 * @param <T>
	 * @param req
	 * @return
	 */
	<T> Response send(T req);

}