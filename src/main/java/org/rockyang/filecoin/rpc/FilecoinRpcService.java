package org.rockyang.filecoin.rpc;

import org.rockyang.filecoin.vo.res.MessageStatusRes;
import org.rockyang.filecoin.vo.res.SendMessageRes;
import org.rockyang.filecoin.vo.res.WalletExportRes;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Filecoin 钱包 RPC 服务接口
 * @author yangjian
 */
public interface FilecoinRpcService {

	/**
	 * create a new wallet
	 * @return  return wallet address
	 */
	@GET("/api/address/new")
	Call<Map<String, String>> newAddress();

	/**
	 * export wallet by wallet address
	 * @param address
	 * @return
	 */
	@GET("/api/wallet/export")
	Call<WalletExportRes> exportWallet(@Query("arg") String address);

	/**
	 * send a message to transfer FIL
	 * @param target
	 * @param from
	 * @param value
	 * @param gasPrice
	 * @param gasLimit
	 * @return
	 */
	@GET("/api/message/send/{target}")
	Call<SendMessageRes> sendMessage(@Path("target") String target,
	                                 @Query("from") String from,
	                                 @Query("value") BigDecimal value,
	                                 @Query("gas-price") BigDecimal gasPrice,
	                                 @Query("gas-limit") Integer gasLimit);

	/**
	 * query specified message status by message Cid
	 * @param cid
	 * @return
	 */
	@GET("/api/message/status")
	Call<MessageStatusRes> getMessageStatus(@Query("arg") String cid);

	/**
	 * query the balance of wallet by specified address
	 * @param address
	 * @return
	 */
	@GET("/api/wallet/balance")
	Call<BigDecimal> getBalance(@Query("arg") String address);


}
