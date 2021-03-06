package sdk.security.service.factory;

import sdk.security.service.IAuthenticationProvider;
import sdk.security.service.IAuthorizationProvider;
import sdk.security.service.IMenuProvider;
import sdk.security.service.ISecurityProvider;
import sdk.security.service.IUserProvider;

public class SDKFactory {
	// 认证实现类
	private static IAuthenticationProvider authenticationProvider;
	// 授权实现类
	private static IAuthorizationProvider authorizationProvider;
	// 菜单实现类
    private static IMenuProvider menuProvider;
	// 用户实现类
	private static IUserProvider userProvider;
	
    private static ISecurityProvider securityProvider;
	

	static {
		try {
			String authenticationProviderClass = "sdk.security.service.impl.AuthenticationProviderImpl";
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			Class<?> clazz = classLoader.loadClass(authenticationProviderClass);
			authenticationProvider = (IAuthenticationProvider) clazz.newInstance();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static {
		try {
			String authorizationProviderClass = "sdk.security.service.impl.AuthorizationProviderImpl";
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			Class<?> clazz = classLoader.loadClass(authorizationProviderClass);
			authorizationProvider = (IAuthorizationProvider) clazz.newInstance();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	static {
		try {
			String userProviderClass = "sdk.security.service.impl.UserProviderImpl";
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			Class<?> clazz = classLoader.loadClass(userProviderClass);
			userProvider = (IUserProvider) clazz.newInstance();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static {
        try {
            String menuProviderClass = "sdk.security.service.impl.MenuProviderImpl";
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Class<?> clazz = classLoader.loadClass(menuProviderClass);
            menuProvider = (IMenuProvider) clazz.newInstance();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	static {
        try {
            String securityProviderClass = "sdk.security.service.impl.SecurityProviderImpl";
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Class<?> clazz = classLoader.loadClass(securityProviderClass);
            securityProvider = (ISecurityProvider) clazz.newInstance();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	/**
	 * 获得认证实现类
	 * 
	 * @return
	 */
	public static IAuthenticationProvider getAuthenticationProviderImpl() {
		return authenticationProvider;
	}

	/**
	 * 获得授权实现类
	 * 
	 * @return
	 */
	public static IAuthorizationProvider getAuthorizationProviderImpl() {
		return authorizationProvider;
	}

	/**
	 * 获得用户实现类
	 * 
	 * @return
	 */
	public static IUserProvider getUserProviderImpl() {
		return userProvider;
	}

	/**
     * 获得菜单实现类
     * 
     * @return
     */
    public static IMenuProvider getMenuProviderImpl() {
        return menuProvider;
    }
    
    /**
     * 获得认证中心实现类
     * 
     * @return
     */
    public static ISecurityProvider getSecurityProviderImpl() {
        return securityProvider;
    }
}
