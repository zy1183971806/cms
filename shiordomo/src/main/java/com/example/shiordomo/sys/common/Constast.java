package com.example.shiordomo.sys.common;

public interface Constast {


/**
 * 常量表，避免遇到硬编码
 */

	/**
	 * 状态码
	 *
	 */
	public static final Integer OK=200;
	public static final Integer ERROR=-1;

	/**
	 * 菜单权限类型
	 */
	public static final String TYPE_MNEU = "menu";
	public static final String TYPE_PERMISSION = "permission";
	/**
	 * 是否可以调用
	 */
	public static final Object AVAILABLE_TRUE = 1;
	public static final Object AVAILABLE_FALSE = 0;

	/**
	 * 用户类型，判断是否为超级管理员
	 */
	public static final Integer USER_TYPE_SUPER = 0;
	public static final Integer USER_TYPE_NORMAL = 1;

	/**
	 * 展开类型,判断左侧导航树是否展开
	 */
	public static final Integer OPEN_TRUE = 1;
	public static final Integer OPEN_FALSE = 0;

	/**
	 * 用户默认密码
	 */
	public static final String USER_DEFAULT_PWD="123456";


}
