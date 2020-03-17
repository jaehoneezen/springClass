package validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import spring.model.Address;
import spring.model.MemberInfo;

@Component
public class MemberInfoValidator {
	public boolean supports(Class<?> clazz) {
		// MemberInfo 객체부분만 수정해서 사용 validator가 검증하는 type 알려주는 용도
		return MemberInfo.class.isAssignableFrom(clazz);
	}
	
	public void validata(Object target, Errors errors) {
		MemberInfo memberInfo = (MemberInfo) target;
		if(memberInfo.getId() == null || memberInfo.getId().trim().isEmpty()) {
			errors.rejectValue("id", "required");
		}
		if (memberInfo.getName() == null || memberInfo.getName().trim().isEmpty()) {
			errors.rejectValue("name", "required");
		}
		Address address = memberInfo.getAddress();
		if (address == null) {
			errors.rejectValue("address", "required");
		}
		
		if (address != null) {
			errors.pushNestedPath("address");
			try {
				if (address.getZipcode() == null || address.getZipcode().trim().isEmpty()) {
					errors.rejectValue("zipcode", "required");
				}
				if (address.getAddress1() == null || address.getAddress1().trim().isEmpty()) {
					errors.rejectValue("address1", "required");
				}
			} finally {
				errors.popNestedPath();
			}
		}
	}

}
