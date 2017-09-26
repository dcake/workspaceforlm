package com.thinkgem.jeesite.mobile.shipper.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.dao.AgentOrderMapper;
import com.thinkgem.jeesite.common.dao.AgentsMapper;
import com.thinkgem.jeesite.common.dao.DriveLineMapper;
import com.thinkgem.jeesite.common.dao.DriveOrderMapper;
import com.thinkgem.jeesite.common.dao.DriversMapper;
import com.thinkgem.jeesite.common.dao.GoodsBillingMapper;
import com.thinkgem.jeesite.common.dao.GoodsMapper;
import com.thinkgem.jeesite.common.dao.GoodsownerAgentJingjiaMapper;
import com.thinkgem.jeesite.common.dao.GoodsownerDealMapper;
import com.thinkgem.jeesite.common.dao.GoodsownerOrderMapper;
import com.thinkgem.jeesite.common.dao.InfoFeeRuleMapper;
import com.thinkgem.jeesite.common.dao.IntegralRuleMapper;
import com.thinkgem.jeesite.common.dao.OrderRemarkMapper;
import com.thinkgem.jeesite.common.dao.UsersAccountOperateMapper;
import com.thinkgem.jeesite.common.dao.UsersCollectMapper;
import com.thinkgem.jeesite.common.dao.UsersIntegralRecordMapper;
import com.thinkgem.jeesite.common.dao.UsersMapper;
import com.thinkgem.jeesite.common.entity.AgentOrder;
import com.thinkgem.jeesite.common.entity.Agents;
import com.thinkgem.jeesite.common.entity.DriveLine;
import com.thinkgem.jeesite.common.entity.DriveOrder;
import com.thinkgem.jeesite.common.entity.Drivers;
import com.thinkgem.jeesite.common.entity.Goods;
import com.thinkgem.jeesite.common.entity.GoodsBilling;
import com.thinkgem.jeesite.common.entity.GoodsownerAgentJingjia;
import com.thinkgem.jeesite.common.entity.GoodsownerDeal;
import com.thinkgem.jeesite.common.entity.GoodsownerOrder;
import com.thinkgem.jeesite.common.entity.InfoFeeRule;
import com.thinkgem.jeesite.common.entity.IntegralRule;
import com.thinkgem.jeesite.common.entity.OrderRemark;
import com.thinkgem.jeesite.common.entity.Users;
import com.thinkgem.jeesite.common.entity.UsersAccountOperate;
import com.thinkgem.jeesite.common.entity.UsersCollect;
import com.thinkgem.jeesite.common.entity.UsersIntegralRecord;
import com.thinkgem.jeesite.common.utils.AjaxBeanUtil;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.mobile.utils.PageParam;
import com.thinkgem.jeesite.mobile.utils.alipay.AlipayConfig;
import com.thinkgem.jeesite.mobile.utils.alipay.AlipayCore;
import com.thinkgem.jeesite.mobile.utils.wxpay.WxPayConfig;
import com.thinkgem.jeesite.modules.sys.utils.DictUtils;

/**
 * @description 货主端-竞价
 * @author 文帅
 * @date 2017年8月24日 上午11:42:00
 */
@Service
@Transactional
public class MobileBidService {
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsownerAgentJingjiaMapper goodsownerAgentJingjiaMapper;
	@Autowired
	private DriversMapper driversMapper;
	@Autowired
	private DriveOrderMapper driveOrderMapper;
	@Autowired
	private UsersCollectMapper usersCollectMapper;
	@Autowired
	private AgentsMapper agentsMapper;
	@Autowired
	private AgentOrderMapper agentOrderMapper;
	@Autowired
	private GoodsownerOrderMapper goodsownerOrderMapper;
	@Autowired
	private OrderRemarkMapper orderRemarkMapper;
	@Autowired
	private DriveLineMapper driveLineMapper;
	@Autowired
	private GoodsownerDealMapper goodsownerDealMapper;
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private UsersAccountOperateMapper usersAccountOperateMapper;
	@Autowired
	private GoodsBillingMapper goodsBillingMapper;
	@Autowired
	private InfoFeeRuleMapper infoFeeRuleMapper;
	@Autowired
	private IntegralRuleMapper integralRuleMapper; // 积分规则
	@Autowired
	private UsersIntegralRecordMapper usersIntegralRecordMapper; // 积分

	/**
	 * @description 根据用户ID查询竞价列表
	 * @author 文帅
	 * @date 2017年8月24日 下午3:16:26
	 * @param currentPage
	 * @param userId
	 * @return
	 */
	public AjaxBeanUtil findBidList(String pageNo, String userId) {
		int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
		int pageSize = PageParam.DEFAULT_PAGESIZE;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		List<Goods> list = goodsMapper.findBidList(paramMap);
		if (list.size() == 0) {
			return new AjaxBeanUtil("暂无更多数据", false);
		} else {
			for (Goods g : list) {
				g.setGoodCurrStatus(DictUtils.getDictLabel(g.getGoodCurrStatus(), "order_status", g.getGoodCurrStatus()));
				g.setGoodsType(DictUtils.getDictLabel(g.getGoodsType(), "goods_type", g.getGoodsType()));
				g.setNeedTruckLength(DictUtils.getDictLabel(g.getNeedTruckLength(), "truck_length", g.getNeedTruckLength()));
				g.setNeedTruckWidth(DictUtils.getDictLabel(g.getNeedTruckWidth(), "	truck_width", g.getNeedTruckWidth()));
				g.setNeedTruckType(DictUtils.getDictLabel(g.getNeedTruckType(), "truck_type", g.getNeedTruckType()));
			}
		}
		return new AjaxBeanUtil("查询成功", true, list);
	}

	/**
	 * @description 查看竞价或查看经纪人
	 * @author 文帅
	 * @date 2017年8月25日 上午10:00:13
	 * @param goodsownerOrderId
	 *            货主订单ID
	 * @param type
	 *            用于判断是查看竞价还是查看经纪人（0-查看竞价，1-查看经纪人）
	 * @param userId
	 *            当前用户ID
	 * @return
	 */
	public AjaxBeanUtil lookBidOrAgent(String goodsownerOrderId, String type, String userId) {
		if ("0".equals(type)) {// 查看竞价
			List<GoodsownerAgentJingjia> list = goodsownerAgentJingjiaMapper.findJingjiaList(goodsownerOrderId);
			if (list.size() == 0) {
				return new AjaxBeanUtil("暂无数据", false);
			} else {
				for (GoodsownerAgentJingjia g : list) {
					if ("1".equals(g.getUserSort())) {// 车主
						Drivers drivers = driversMapper.findByUserId(g.getUserId());
						g.setTruckType(DictUtils.getDictLabel(drivers.getTruckType(), "truck_type", drivers.getTruckType()));
						g.setTruckLength(DictUtils.getDictLabel(drivers.getTruckLength(), "truck_length", drivers.getTruckLength()));
						g.setGoodsType(DictUtils.getDictLabel(g.getGoodsType(), "goods_type", g.getGoodsType()));
						g.setTruckMaxwight(drivers.getTruckMaxwight());
						Integer transportCount = driveOrderMapper.findCountByDriverId(drivers.getId());
						g.setTransportCount(transportCount);
					} else if ("2".equals(g.getUserSort())) {// 经纪人
						Agents agents = agentsMapper.findAgentsByUserId(g.getUserId());
						g.setCompanyName(agents.getCompanyName());
					}
					UsersCollect usersCollect = usersCollectMapper.findCollect(g.getUserId(), userId);
					// 判断该车主或经纪人是否被当前用户收藏（0-否，1-是）
					if (usersCollect != null) {
						g.setIsCollect("1");
					} else {
						g.setIsCollect("0");
					}
				}
			}
			return new AjaxBeanUtil("查看竞价成功", true, list);
		} else if ("1".equals(type)) {// 查看经纪人
			AgentOrder agentOrder = agentOrderMapper.findByGoodsownerOrderId(goodsownerOrderId);
			Agents agents = agentsMapper.selectByPrimaryKey(agentOrder.getAgentsId());
			UsersCollect usersCollect = usersCollectMapper.findCollect(agents.getUserid(), userId);
			// 判断该车主或经纪人是否被当前用户收藏（0-否，1-是）
			if (usersCollect != null) {
				agentOrder.setIsCollect("1");
			} else {
				agentOrder.setIsCollect("0");
			}
			return new AjaxBeanUtil("查询经纪人成功", true, agentOrder);
		}
		return new AjaxBeanUtil("type没有传参数（0-查看竞价，1-查看经纪人）", true);
	}

	/**
	 * @description 根据货主订单ID查询货物信息
	 * @author 文帅
	 * @date 2017年8月25日 下午5:36:21
	 * @param goodsownerOrderId
	 * @return
	 */
	public AjaxBeanUtil lookGoodsDetail(String goodsownerOrderId) {
		GoodsownerOrder goodsownerOrder = goodsownerOrderMapper.selectByPrimaryKey(goodsownerOrderId);
		Goods g = goodsMapper.selectByPrimaryKey(goodsownerOrder.getGoodsId());
		g.setGoodsType(DictUtils.getDictLabel(g.getGoodsType(), "goods_type", g.getGoodsType()));
		g.setNeedTruckLength(DictUtils.getDictLabel(g.getNeedTruckLength(), "truck_length", g.getNeedTruckLength()));
		g.setNeedTruckWidth(DictUtils.getDictLabel(g.getNeedTruckWidth(), "	truck_width", g.getNeedTruckWidth()));
		g.setNeedTruckType(DictUtils.getDictLabel(g.getNeedTruckType(), "truck_type", g.getNeedTruckType()));
		return new AjaxBeanUtil("查询成功", true, g);
	}

	/**
	 * @description 根据车主ID查询车主评价列表
	 * @author 文帅
	 * @date 2017年8月26日 上午10:22:39
	 * @param pageNo
	 * @param driversId
	 * @return
	 */
	public AjaxBeanUtil findDriverEvaluationList(String pageNo, String driversId) {
		int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
		int pageSize = PageParam.DEFAULT_PAGESIZE;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("driversId", driversId);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		List<OrderRemark> list = orderRemarkMapper.findDriverEvaluationList(paramMap);
		if (list.size() == 0) {
			return new AjaxBeanUtil("暂无数据", false);
		}
		return new AjaxBeanUtil("查询成功", true, list);
	}

	/**
	 * @description 根据车主ID查询车主路线
	 * @author 文帅
	 * @date 2017年8月26日 上午10:38:49
	 * @param currentPage
	 * @param driversId
	 * @return
	 */
	public AjaxBeanUtil findDriveLineList(String pageNo, String driversId) {
		int currentPage = Integer.parseInt(pageNo) * PageParam.DEFAULT_PAGESIZE;
		int pageSize = PageParam.DEFAULT_PAGESIZE;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("driversId", driversId);
		paramMap.put("currentPage", currentPage);
		paramMap.put("pageSize", pageSize);
		List<DriveLine> list = driveLineMapper.findDriveLineList(paramMap);
		if (list.size() == 0) {
			return new AjaxBeanUtil("暂无数据", false);
		}
		return new AjaxBeanUtil("查询成功", true, list);
	}

	/**
	 * @description 确认交易
	 * @author 文帅
	 * @date 2017年8月30日 上午10:53:04
	 * @param goodsownerDeal
	 * @param type
	 *            用于判断是查看竞价还是查看经纪人（0-查看竞价，1-查看经纪人）
	 * @return
	 */
	public AjaxBeanUtil confrimTransaction(GoodsownerDeal goodsownerDeal, HttpServletRequest request) {
		if (StringUtils.isEmpty(goodsownerDeal.getCompanyName())) {
			return new AjaxBeanUtil("请输入公司名称！", false);
		}
		if (goodsownerDeal.getCompanyName().length() > 30) {
			return new AjaxBeanUtil("公司名称字数过长，30个字符以内！", false);
		}
		if (StringUtils.isEmpty(goodsownerDeal.getTaxpayerNo())) {
			return new AjaxBeanUtil("请输入纳税人识别号！", false);
		}
		if (StringUtils.isEmpty(goodsownerDeal.getAdress())) {
			return new AjaxBeanUtil("请输入地址！", false);
		}
		if (goodsownerDeal.getAdress().length() > 50) {
			return new AjaxBeanUtil("地址字数过长，50个字符以内！", false);
		}
		if (StringUtils.isEmpty(goodsownerDeal.getTel().trim())) {
			return new AjaxBeanUtil("请输入电话！", false);
		}
		if (!checkCellphone(goodsownerDeal.getTel().trim()) && !checkTelephone(goodsownerDeal.getTel().trim())) {
			return new AjaxBeanUtil("请输入正确的电话号码", false);
		}
		if (StringUtils.isEmpty(goodsownerDeal.getBankName())) {
			return new AjaxBeanUtil("请输入开户行！", false);
		}
		if (goodsownerDeal.getBankName().length() > 30) {
			return new AjaxBeanUtil("开户行名称字数过长，30个字符以内！", false);
		}
		if (StringUtils.isEmpty(goodsownerDeal.getBankCardno())) {
			return new AjaxBeanUtil("请输入账号！", false);
		}
		if (goodsownerDeal.getBankCardno().length() > 30) {
			return new AjaxBeanUtil("账号字数过长，30个数字以内", false);
		}
		if (StringUtils.isEmpty(goodsownerDeal.getBillToAddress())) {
			return new AjaxBeanUtil("请输入发票邮寄地址！", false);
		}
		if (goodsownerDeal.getBillToAddress().length() > 50) {
			return new AjaxBeanUtil("发票邮寄地址字数过长，50个字符以内！", false);
		}
		goodsownerDeal.setId(IdGen.uuid());
		goodsownerDeal.setIsSettleAccounts("0");
		goodsownerDeal.preAppInsert();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println("支付类型：" + goodsownerDeal.getPayStyle());
		GoodsownerOrder goodsownerOrder = goodsownerOrderMapper.selectByPrimaryKey(goodsownerDeal.getGoodsownerOrderId());
		Goods goods = goodsMapper.selectByPrimaryKey(goodsownerOrder.getGoodsId());
		// 获取用户信息
		Users user = usersMapper.selectByPrimaryKey(goodsownerDeal.getUserId());
		// 支付
		if ("0".equals(goodsownerDeal.getPayStyle())) {// 垫资及开票支付
			goodsownerDealMapper.insertSelective(goodsownerDeal);
			//当选择垫资及开票时，默认开票
			//goodsownerDeal.setIsBill("1");
			
			goodsownerDeal.setIsDealOk("1");	//更新为交易成功状态
			// 修改订单信息
			updateOrder(goods,goodsownerOrder,goodsownerDeal,user);
		} else if ("1".equals(goodsownerDeal.getPayStyle())) {// 余额支付
			// 判断账户余额是否小于支付金额
			if (user.getAccountMoney() < goodsownerDeal.getPayMoney()) {
				return new AjaxBeanUtil("账户余额不足！", false);
			} else {
				user.setAccountMoney(user.getAccountMoney() - goodsownerDeal.getPayMoney());
				
			}
			// 添加确认支付信息
			goodsownerDeal.setIsDealOk("1");	//更新为交易成功状态
			goodsownerDealMapper.insertSelective(goodsownerDeal);
			// 更新用户账户信息
			usersMapper.updateByPrimaryKeySelective(user);
			// 修改订单信息
			updateOrder(goods,goodsownerOrder,goodsownerDeal,user);
		} else if ("2".equals(goodsownerDeal.getPayStyle())) {// 支付宝支付
			String orderInfo = AlipayCore.getOrderInfo("九州物流商品支付", "九州物流", new BigDecimal("0.01"), goods.getOrderNo());
			String sign = AlipayCore.sign(orderInfo, AlipayConfig.private_key);
			try {
				sign = URLEncoder.encode(sign, "UTF-8");
				
				/**如果接口支付状态返回成功，则更新交易状态，0表失败，1表成功**/
				goodsownerDeal.setIsDealOk("1");	//更新为交易成功状态
				goodsownerDealMapper.insertSelective(goodsownerDeal);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			String linkString = orderInfo + "&sign=\"" + sign + "\"&" + "sign_type=\"RSA\"";
			System.out.println("*****************" + linkString);
			resultMap.put("result", linkString);
		} else if ("3".equals(goodsownerDeal.getPayStyle())) {// 微信支付
			WxPayConfig wx = new WxPayConfig();
			String ip = request.getRemoteAddr();
			String payJson = wx.getpPepay_id(goods.getOrderNo(), ip, "0.01", "jiuzhouwuliu");
			System.out.println("payJson============" + payJson);
			if (payJson == null) {
				return new AjaxBeanUtil("支付回话创建失败", false);
			}
			/**如果接口支付状态返回成功，则更新交易状态，0表失败，1表成功**/
			goodsownerDeal.setIsDealOk("1");	//更新为交易成功状态
			goodsownerDealMapper.insertSelective(goodsownerDeal);
			resultMap.put("result", payJson);
		} else {
			return new AjaxBeanUtil("未知的支付方式", false);
		}

		return new AjaxBeanUtil("支付会话创建成功", true, resultMap);
	}


	/**
	 * @description 校验手机号是否正确
	 * @author 文帅
	 * @date 2017年8月23日 上午11:06:50
	 * @param cellphone
	 * @return
	 */
	public static boolean checkCellphone(String cellphone) {
		String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,1,2,5-9])|(177))\\d{8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(cellphone);
		return matcher.matches();
	}

	/**
	 * 验证固话号码
	 * 
	 * @author 文帅
	 * @param telephone
	 * @return
	 */
	public static boolean checkTelephone(String telephone) {
		String regex = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telephone);
		return matcher.matches();
	}

	/**
	 * @description 取消委托
	 * @author 文帅
	 * @date 2017年9月1日 上午9:47:54
	 * @param goodsownerOrderId
	 * @param userId
	 * @return
	 */
	public AjaxBeanUtil cancleWeiTuo(String goodsownerOrderId, String userId) {
		Users user = usersMapper.selectByPrimaryKey(userId);
		GoodsownerOrder goodsownerOrder = goodsownerOrderMapper.selectByPrimaryKey(goodsownerOrderId);
		// 更新货主订单信息
		goodsownerOrder.setGoodCurrStatus("2");
		goodsownerOrder.setUpdateDate(new Date());
		goodsownerOrder.setUpdateBy(user.getTruename());
		goodsownerOrderMapper.updateByPrimaryKeySelective(goodsownerOrder);
		// 更新经纪人订单信息
		AgentOrder agentOrder = agentOrderMapper.findByGoodsownerOrderId(goodsownerOrderId);
		agentOrder.setGoodCurrStatus("2");
		agentOrder.setUpdateBy(user.getTruename());
		agentOrder.setUpdateDate(new Date());
		agentOrderMapper.updateByPrimaryKeySelective(agentOrder);
		return new AjaxBeanUtil("取消委托成功", true);
	}

	/**
	 * @description 取消竞价
	 * @author 文帅
	 * @date 2017年9月1日 上午10:22:20
	 * @param goodsownerOrderId
	 * @param userId
	 * @return
	 */
	public AjaxBeanUtil cancleJingJia(String goodsownerOrderId, String userId) {
		GoodsownerOrder goodsownerOrder = goodsownerOrderMapper.selectByPrimaryKey(goodsownerOrderId);
		// 更新货主订单信息
		goodsownerOrder.setGoodCurrStatus("2");
		goodsownerOrder.setCompetePriceViewCount(0);
		goodsownerOrder.setPublicCompetePriceTime(null);
		goodsownerOrder.setPublicSel(null);
		goodsownerOrder.setJingjiaOrWeituo(null);
		goodsownerOrder.setPriceMin(0.00);
		goodsownerOrder.setPriceMax(0.00);
		goodsownerOrder.preAppUpdate();
		goodsownerOrderMapper.updateByPrimaryKey(goodsownerOrder);
		// 重置货物状态
		Goods goods = goodsMapper.selectByPrimaryKey(goodsownerOrder.getGoodsId());
		goods.setIsCheckPass("0");
		goods.setCheckRemark("");
		goods.setCheckTime(null);
		goods.setExamRemark("");
		goods.setExamTime(null);
		goods.setIsExamPass("0");

		goodsMapper.updateByPrimaryKeySelective(goods);

		// 删除竞价列表中的竞价记录
		goodsownerAgentJingjiaMapper.deleteByOrderId(goodsownerOrderId);
		return new AjaxBeanUtil("取消竞价成功", true);
	}

	/**
	 * @description 查看竞价时选择竞价人
	 * @author 文帅
	 * @date 2017年9月1日 上午11:18:03
	 * @param goodsownerOrderId
	 *            货主订单ID
	 * @param jingJiaRenId
	 *            竞价人ID
	 * @param Type
	 *            用于判断是确认还是取消（1-确认，0-取消）
	 * @return
	 */
	public AjaxBeanUtil chooseOrCancleJingJiaRen(String goodsownerOrderId, String jingJiaRenId, String type) {
		if ("1".equals(type)) {
			goodsownerAgentJingjiaMapper.updateByOrderIdAndJJRId(goodsownerOrderId, jingJiaRenId, type);
			return new AjaxBeanUtil("选择竞价人成功", true);
		} else if ("0".equals(type)) {
			goodsownerAgentJingjiaMapper.updateByOrderIdAndJJRId(goodsownerOrderId, jingJiaRenId, type);
			return new AjaxBeanUtil("取消竞价人成功", true);
		}
		return new AjaxBeanUtil("type没有传值", false);
	}

	/**
	 * @description 修改订单状态
	 * @author 文帅
	 * @date 2017年9月2日 上午9:45:06
	 * @param orderNo
	 * @param type
	 *            用于判断是查看竞价还是查看经纪人（0-查看竞价，1-查看经纪人）
	 * @param jingJiaRenId
	 *            竞价人ID
	 * @return
	 */
	public AjaxBeanUtil updateOrder(Goods goods,GoodsownerOrder goodsownerOrder,GoodsownerDeal goodsownerDeal,Users user) {
		
		//当交易失败时，返回交易失败状态
		if(!"1".equals(goodsownerDeal.getIsDealOk())){
			return new AjaxBeanUtil("交易失败", false);
		}
		// 根据货物类型去查信息费
		InfoFeeRule infoFeeRule = infoFeeRuleMapper.findByDictValue(goods.getGoodsType());
		// 获取积分规则
		IntegralRule integralRule = integralRuleMapper.findEntity();
		// 当选中开具增值税发票时，添加开票信息
		if ("1".equals(goodsownerDeal.getIsBill())) {
			GoodsBilling goodsBilling = new GoodsBilling();
			goodsBilling.setId(IdGen.uuid());
			goodsBilling.setGoodsid(goodsownerOrder.getGoodsId());
			goodsBilling.setBillingMoney(goodsownerDeal.getDealMoney());
			goodsBilling.preAppInsert();
			goodsBillingMapper.insertSelective(goodsBilling);
		}
		//当支付方式为余额支付时，添加账户操作记录
		if ("1".equals(goodsownerDeal.getPayStyle())) {
			// 添加用户账户操作记录
			UsersAccountOperate aco = new UsersAccountOperate();
			aco.setId(IdGen.uuid());
			aco.setUserid(user.getId());
			aco.setOperateType("0");
			aco.setOperatMoney(-goodsownerDeal.getPayMoney());
			aco.setPayStyle("余额");
			aco.setOrderNo(goods.getOrderNo());
			aco.setRestMoney(user.getAccountMoney());
			// 设置本次获取的积分
			aco.setIntegralScore(integralRule.getCompleteOrder() + 0.00);
			// 设置目前总积分
			aco.setTotalScore(usersIntegralRecordMapper.findUserAllInserance(user.getAgentId()) + aco.getIntegralScore());
			// 保存账户操作记录
			aco.preAppInsert();
			usersAccountOperateMapper.insert(aco);
		}
		
		// 添加用户积分记录
		UsersIntegralRecord uir = new UsersIntegralRecord();
		uir.setId(IdGen.uuid());
		uir.setUserid(user.getId());
		uir.setParams(goods.getId());
		uir.setIntegralScore(integralRule.getCompleteOrder());
		uir.setIntegralDescribe("订单-支付");
		
		if ("0".equals(goodsownerDeal.getType())) {// 查看竞价
			Users jingJiaRen = usersMapper.selectByPrimaryKey(goodsownerDeal.getJingJiaRenId());
			if ("1".equals(jingJiaRen.getUserSort())) {// 竞价人是车主
				Drivers drivers = driversMapper.findByUserId(goodsownerDeal.getJingJiaRenId());
				// 给车主添加订单
				DriveOrder driveOrder = new DriveOrder();
				driveOrder.setGoodsId(goods.getId());
				driveOrder.setDriversId(drivers.getId());
				driveOrder.setUserOrderId(goodsownerOrder.getId());
				driveOrder.setUserType("0");
				if (null == infoFeeRule) {
					driveOrder.setDeposit(0.00);
				} else {
					driveOrder.setDeposit(infoFeeRule.getInfoFee());
				}
				GoodsownerAgentJingjia goodsownerAgentJingjia = goodsownerAgentJingjiaMapper.findByOrderIdAndJJRId(goodsownerOrder.getId(), goodsownerDeal.getJingJiaRenId());
				driveOrder.setJingjiaStatus(goodsownerAgentJingjia.getJingjiaStatus());
				driveOrder.setJingjiaMoney(goodsownerAgentJingjia.getJingjiaPrice());
				driveOrder.setIsAssign("0");
				driveOrder.setGoodsStatus("12");// 信息费未缴纳
				driveOrder.setReciveGoodsName(goods.getReciverName());
				driveOrder.preAppInsert();
				driveOrderMapper.insertSelective(driveOrder);
			} else if ("2".equals(jingJiaRen.getUserSort())) {// 竞价人是经纪人
				Agents agent = agentsMapper.findByUserId(goodsownerDeal.getJingJiaRenId());
				// 给经纪人添加订单
				AgentOrder agentOrder = new AgentOrder();
				agentOrder.setId(IdGen.uuid());
				agentOrder.setGoodsId(goods.getId());
				agentOrder.setAgentsId(agent.getId());
				agentOrder.setGoodCurrStatus("0");// 未发布状态
				agentOrder.setWeituoOrFabu("0");
				agentOrder.setCompetePriceViewCount(0);
				agentOrder.setGoodsownerOrderid(goodsownerOrder.getId());
				agentOrder.preAppInsert();
				agentOrderMapper.insertSelective(agentOrder);
			}
			// 修改货主订单信息
			goodsownerOrder.setGoodCurrStatus("3");// 待装载
			goodsownerOrderMapper.updateByPrimaryKeySelective(goodsownerOrder);
			// 修改竞价状态
			goodsownerAgentJingjiaMapper.updateJingJiaStatus(goodsownerOrder.getId(), goodsownerDeal.getJingJiaRenId(), "0");// 修改状态未竞价成功
			goodsownerAgentJingjiaMapper.updateJingJiaStatus(goodsownerOrder.getId(), goodsownerDeal.getJingJiaRenId(), "1");// 修改状态未竞价失败
		} else if ("1".equals(goodsownerDeal.getType())) {// 查看经纪人
			// 修改经纪人订单信息
			AgentOrder agentOrder = agentOrderMapper.findByGoodsownerOrderId(goodsownerOrder.getId());
			agentOrder.setGoodCurrStatus("0");// 未发布状态
			agentOrder.setEntrustPrice(0.0);
			agentOrder.preAppUpdate();
			agentOrderMapper.updateByPrimaryKeySelective(agentOrder);
			// 修改货主订单信息
			goodsownerOrder.setGoodCurrStatus("9");// 已委托
			goodsownerOrder.preAppUpdate();
			goodsownerOrderMapper.updateByPrimaryKeySelective(goodsownerOrder);
		}
		return new AjaxBeanUtil("修改成功", true);
	}

}
