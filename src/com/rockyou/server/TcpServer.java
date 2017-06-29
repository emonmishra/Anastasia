package com.rockyou.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

import com.rockyou.command.CommandManager;

public class TcpServer {

	private CommandManager commandMgr;
	private ServerSocketChannel serverSocketChannel;
	private Selector selector;

	public TcpServer() {
		commandMgr = new CommandManager();
	}

	public boolean startServer(int port) {
		return startServer(new InetSocketAddress(port));
	}

	public boolean startServer(InetSocketAddress sockAddr) {
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.socket().bind(sockAddr);
			serverSocketChannel.configureBlocking(false);
			
			selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT, null);

		} catch (ClosedChannelException e1) {
			return false;
		} catch (IOException e) {
			//Log error
			return false;
		}

		while(true){
			try {
				selector.select();

				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> keyIterator = keys.iterator();

				while (keyIterator.hasNext()) {
					SelectionKey myKey = keyIterator.next();
	 
					if (myKey.isAcceptable()) {
						SocketChannel client = serverSocketChannel.accept();
						client.configureBlocking(false);
	 
						client.register(selector, SelectionKey.OP_READ);
					} else if (myKey.isReadable()) {
						read(myKey);
					}
					keyIterator.remove();
				}

			} catch (IOException e1) {
			}
		}
	}

	private void read(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel) key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int numRead = -1;
		numRead = channel.read(buffer);

		if (numRead == -1) {
			channel.close();
			key.cancel();
			return;
		}

	}

	public boolean stopServer() {
		
		return true;
	}
}
