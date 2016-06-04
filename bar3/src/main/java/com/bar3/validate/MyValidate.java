package com.bar3.validate;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
* @ClassName: MyValidate
* @Description: 自定义效验器实现类
* @author shl
* @date 2016年2月21日 下午8:52:19
*/
public class MyValidate extends FieldValidatorSupport {
    //该效验器的参数
	private String name;
	public void validate(Object object) throws ValidationException {
		//被效验的字段名
		String fieldName=super.getFieldName();
		//返回被效验对象的被效验字段的值
		String value=super.getFieldValue(fieldName, object).toString();
		if(!name.equals(value)){
			super.addFieldError(super.getFieldName(), object);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
