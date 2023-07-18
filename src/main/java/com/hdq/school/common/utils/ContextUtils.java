package com.hdq.school.common.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.hdq.school.dtos.responses.common.MesageDataRes;

/**
 * Utility support get bean instant form Bean Container
 * 
 * @author Hoatlv
 * @author 1.0
 */

@Component
public class ContextUtils {
	private static ApplicationContext applicationContext;

	@Autowired
	protected ContextUtils(ApplicationContext applicationContext) {
		ContextUtils.applicationContext = applicationContext; // Share applicationContext to all instance of
																// VCContextUtils
	}

	/**
	 * Get a bean by Class from application context
	 *
	 * @param clazz
	 * @return bean
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

	/**
	 * Get a bean by bean name from application context
	 *
	 * @param clazz
	 * @return bean
	 */
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	/**
	 * Get message form resources
	 * 
	 * @param code
	 * @return
	 */
	public static String getMessage(String code) {
		return ContextUtils.getMessage(code, "", new String[] {});
	}

	/**
	 * Get message form resources
	 * 
	 * @param code
	 * @return
	 */
	public static String getMessage(String code, String defaultMsg) {
		return ContextUtils.getMessage(code, defaultMsg, new String[] {});
	}

	/**
	 * Get message form resources
	 * 
	 * @param code
	 * @param args
	 * @return
	 */
	public static String getMessage(String code, String defaultMsg, Object[] args) {
		return applicationContext.getBean(MessageSource.class).getMessage(code, args, defaultMsg,
				LocaleContextHolder.getLocale());
	}

	/**
	 * Get message form resources
	 * 
	 * @param code
	 * @param args
	 * @return
	 */
	public static String getMessage(String code, Object[] args) {
		return applicationContext.getBean(MessageSource.class).getMessage(code, args, LocaleContextHolder.getLocale());
	}

	/**
	 * Get message form ObjectError
	 * 
	 * @param error
	 * @return
	 */
	public static MesageDataRes<String> getMessage(ObjectError error) {
		if (error instanceof FieldError fieldError) {
			String regex = "\\[([0-9]+)\\]";
			String field = fieldError.getField();
			String noIndexField = StringUtils.join(field.split(regex));
			if (!noIndexField.equals(field)) {
				int index = Integer.parseInt(field.substring(field.indexOf("[") + 1, field.indexOf("]")));
				// Add the field argument without index.
				Object[] args = fieldError.getArguments();
				if (args != null && args.length > 0 && args[0] instanceof DefaultMessageSourceResolvable args0) {
					String[] targetCode = ArrayUtils.addAll(args0.getCodes(),
							fieldError.getObjectName() + "." + noIndexField, noIndexField);

					args[0] = new DefaultMessageSourceResolvable(targetCode, args0.getArguments(),
							args0.getDefaultMessage());
					String message = getMessageContent(fieldError);
					String messageContent = ContextUtils.getMessage("error.row_index.message", message,
							new Object[] { index + 1, message });
					return new MesageDataRes<String>(messageContent, "error.row_index.message", field, "ERROR");
				}
			}
			String messageContent = getMessageContent(error);
			return new MesageDataRes<>(messageContent, error.getCode(), field, "ERROR");
		}
		String messageContent = getMessageContent(error);
		return new MesageDataRes<>(messageContent, error.getCode(), "", "ERROR");
	}

	public static String getMessageContent(ObjectError error) {
		return applicationContext.getBean(MessageSource.class).getMessage(error, LocaleContextHolder.getLocale());
	}

	public static Boolean getEnvProp(String property, String defaultValue) {
		return Boolean.valueOf(ContextUtils.getBean(Environment.class).getProperty(property, defaultValue));
	}

	public static String getEnvProStr(String property, String defaultValue) {
		return ContextUtils.getBean(Environment.class).getProperty(property, defaultValue);
	}

	public static long getRedisLiveTime() {
		return Long.valueOf(
				ContextUtils.getBean(Environment.class).getProperty("spring.vc.cache.redis.time-to-live", "-1"));
	}
}
