package com.prabhash.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Handles a server side channel.
 * 
 * @author Prabhash Rathore
 *
 */
public class DiscardServer extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object message) {
		// discard the received data
		((ByteBuf) message).release();
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// close the connection when an exception is raised
		cause.printStackTrace();
		ctx.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
