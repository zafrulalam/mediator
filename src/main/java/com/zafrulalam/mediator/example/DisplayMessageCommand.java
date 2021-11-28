package com.zafrulalam.mediator.example;

import com.zafrulalam.mediator.IRequest;

public class DisplayMessageCommand implements IRequest{
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
