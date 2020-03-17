package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import common.CommonLogger;

@Component("authenticator")
public class MockAuthenticator implements Authenticator {
	private CommonLogger commonLogger;
	
	public void authenticate(LoginCommand loginCommand) throws AuthenticationException {
		if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			commonLogger.log("인증에러 -" + loginCommand.getUserId());
			throw new AuthenticationException();
		}
	}
	
	@Autowired
	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;
	}
}
