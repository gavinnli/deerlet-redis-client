/**
 * 
 */
package cn.zxl.deerlet.redis.client.command;

import cn.zxl.deerlet.redis.client.connection.Connection;
import cn.zxl.deerlet.redis.client.io.DeerletInputStream;
import cn.zxl.deerlet.redis.client.util.IOUtil;
import cn.zxl.deerlet.redis.client.util.ResponseUtil;

/**
 * 结果为int类型的命令的实现类
 * @author zuoxiaolong
 *
 */
public class IntResultCommand extends AbstractCommand<Integer> {

	/**
	 * @param connection
	 */
	public IntResultCommand(Connection connection, Commands command) {
		super(connection, command);
	}

	@Override
	protected Integer receive(DeerletInputStream inputStream, Commands command, Object... arguments) throws Exception {
		String response = IOUtil.readLineWithoutR(inputStream);
		if (ResponseUtil.isIntResultOk(response)) {
			return Integer.valueOf(ResponseUtil.extractResult(response));
		} else {
			return 0;
		}
	}

}
