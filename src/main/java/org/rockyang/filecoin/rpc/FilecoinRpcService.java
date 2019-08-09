package org.rockyang.filecoin.rpc;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.rockyang.filecoin.vo.req.KeyInfoReq;
import org.rockyang.filecoin.vo.res.MessageStatusRes;
import org.rockyang.filecoin.vo.res.SendMessageRes;
import org.rockyang.filecoin.vo.res.WalletExportRes;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigDecimal;
import java.util.List;
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
	 * get address list
	 * @return
	 */
	@GET("/api/address/ls")
	Call<Map<String, List>> getAddressList();

	@GET("/api/address/default")
	Call<Map<String, String>> getDefaultAddress();

	/**
	 * export wallet by wallet address
	 * @param address
	 * @return
	 */
	@GET("/api/wallet/export")
	Call<WalletExportRes> walletExport(@Query("arg") String address);

	/**
	 * import wallet
	 * @param walletFile
	 * @return
	 */
	@POST("/api/wallet/import")
	@Multipart
	Call<Map<String, List>> walletImport(@Part("walletFile") KeyInfoReq keyInfoReq);

	/**
	 * query the balance of wallet by specified address
	 * @param address
	 * @return
	 */
	@GET("/api/wallet/balance")
	Call<BigDecimal> getBalance(@Query("arg") String address);

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


}
