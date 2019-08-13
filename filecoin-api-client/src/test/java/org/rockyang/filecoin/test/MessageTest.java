package org.rockyang.filecoin.test;

import org.junit.Test;
import org.rockyang.filecoin.vo.res.MessageStatusRes;

import java.math.BigDecimal;

/**
 * @author yangjian
 */
public class MessageTest extends BaseTester {

	@Test
	public void sendTransaction()
	{
		String from = "t1uoarr4r2kw2g24c7lrnsxcsv3xfiknlbcp6zpda";
		String to = "t1esjjrygs7adcfbjnodbpdjzulzobznnln4tmsxq";
		BigDecimal value = BigDecimal.valueOf(123.456);
		BigDecimal gasPrice = BigDecimal.valueOf(0.001);
		Integer gasLimit = 300;
		String cid = filecoin.sendTransaction(from, to, value, gasPrice, gasLimit);
		logger.info("CID: " + cid);
	}

	/**
	 * 查询交易状态
	 */
	@Test
	public void getTransactionStatus()
	{
		String cid = "zDPWYqFCyLg59nnNTFHTERpKqjxsK5651d6ZGg6bqjYZn315U6Ux";
		MessageStatusRes.Message message = filecoin.getTransaction(cid);
		logger.info("message： " + message);
		if (message.isSuccess()) {
			logger.info("Success.");
		} else {
			logger.warn("Message is unconfirmed");
		}
	}
}
