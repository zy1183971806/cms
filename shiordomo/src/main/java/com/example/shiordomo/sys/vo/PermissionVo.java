package com.example.shiordomo.sys.vo;



import com.example.shiordomo.sys.domain.Permission;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//创建eq和hashcode方法，false代表不调用父类属性
@EqualsAndHashCode(callSuper=false)
public class PermissionVo extends Permission {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer page=1;
	private Integer limit=10;


}
