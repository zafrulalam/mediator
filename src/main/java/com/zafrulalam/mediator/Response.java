package com.zafrulalam.mediator;

/**
 * @author zafrul
 *
 * @param <T>
 */
public class Response<T>{
    /**
     * Indicate if the operation was succesful or not
     */
    public boolean success;
    /**
     * Response message
     */
    public String message;
    /**
     * Response data
     */
    public T data;
}
