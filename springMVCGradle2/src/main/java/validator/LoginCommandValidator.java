package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import service.LoginCommand;

public class LoginCommandValidator implements Validator {
	
	// Validator 구현 supports, validate 상속
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		//required.loginCommand.userId
		//에러코드.객체타입.필드명
		//에러코드.필드명
		//에러코드
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
	}

}
