package cn.zxl.deerlet.redis.client.connection.pool;

import cn.zxl.deerlet.redis.client.connection.Connection;
import cn.zxl.deerlet.redis.client.io.DeerletInputStream;
import cn.zxl.deerlet.redis.client.io.DeerletOutputStream;

/**
 * 
 * 连接类的代理，为了屏蔽客户端对连接的错误关闭。
 *
 * @author zuoxiaolong
 * @since 2015 2015年3月6日 下午11:42:19
 *
 */
public class ConnectionProxy implements Connection {

	private Connection connection;

	private ConnectionPool connectionPool;

	public ConnectionProxy(Connection connection, ConnectionPool connectionPool) {
		this.connection = connection;
		this.connectionPool = connectionPool;
	}

	public DeerletOutputStream getOutputStream() {
		return connection.getOutputStream();
	}

	public DeerletInputStream getInputStream() {
		return connection.getInputStream();
	}

	public boolean isClosed() {
		return connection.isClosed();
	}

	public void close() {
		connectionPool.releaseConnection(this);
	}

	void realClose() {
		connection.close();
	}

}
