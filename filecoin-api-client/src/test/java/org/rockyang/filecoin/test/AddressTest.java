package org.rockyang.filecoin.test;

import org.junit.Test;

import java.util.List;

/**
 * @author yangjian
 */
public class AddressTest extends BaseTester {


	@Test
	public void  newAddress()
	{
		String address = filecoin.newAddress();
		logger.info("Address: " + address);
	}

	@Test
	public void getAddressList()
	{
		List<String> addresses = filecoin.getAddressList();
		for (String address : addresses) {
			logger.info("Address: " + address);
		}
	}

	@Test
	public void getDefaultAddress()
	{
		String address = filecoin.getDefaultAddress();
		logger.info("Default Address: " + address);
	}

}
