package com.prabhash.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server side channel.
 * 
 * @author Prabhash Rathore
 *
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// print the received data
		ByteBuf in = (ByteBuf) msg;
		try {
	        while (in.isReadable()) {
	            System.out.print((char) in.readByte());
	            System.out.flush();
	        }
	    } finally {
	        ReferenceCountUtil.release(msg);
	    }
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// close the connection when an exception is raised
		cause.printStackTrace();
		ctx.close();
	}
}
