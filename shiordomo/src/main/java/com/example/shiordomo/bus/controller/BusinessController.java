package com.example.shiordomo.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bus")
public class BusinessController {

	/**
	 * 跳转到供应商管理
	 */
	@RequestMapping("toOrderManager")
	public String toOrderManager() {
		return "business/order/orderManager";
	}
	/**
	 * 跳转到商品管理
	 */
	@RequestMapping("toBookManager")
	public String toGoodsManager() {
		return "business/book/bookManager";
	}
	/**
	 * 跳转到进货管理
	 */
	@RequestMapping("toInportManager")
	public String toInportManager() {
		return "business/inport/inportManager";
	}
	/**
	 * 跳转到退货查询管理
	 */
	@RequestMapping("toOutportManager")
	public String toOutportManager() {
		return "business/outport/outportManager";
	}
}
