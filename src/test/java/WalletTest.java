import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author yangjian
 */
public class WalletTest extends BaseTester {


	@Test
	public void  getBalance()
	{
		String address = "t1esjjrygs7adcfbjnodbpdjzulzobznnln4tmsxq";
		BigDecimal balance = filecoin.getBalance(address);
		logger.info(balance);
	}


}
