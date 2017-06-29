package com.rockyou.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import com.rockyou.command.CommandManager;

public class TcpServer {

	private CommandManager commandMgr;
	private ServerSocketChannel serverSocketChannel;

	public boolean startServer(int port) {
		return startServer(new InetSocketAddress(port));
	}

	public boolean startServer(InetSocketAddress sockAddr) {
		try {
			serverSocketChannel = ServerSocketChannel.open();
		} catch (IOException e) {
			//Log error
			return false;
		}

		try {
			serverSocketChannel.socket().bind(sockAddr);
		} catch (IOException e) {
		}

		while(true){
		    try {
				SocketChannel socketChannel = serverSocketChannel.accept();
			} catch (IOException e) {
			}

		    //do something with socketChannel...
		}
	}

	public boolean stopServer() {
		return true;
	}
}
