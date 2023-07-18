/**
 * The class is used for Rest controllers as a response object with success response
 * 
 *  @author lamva
 *  @since v1.0
 */

package com.hdq.school.dtos.responses.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Data response object, used to response data for success request
 * 
 * @author Hoatlv
 * @since v1.0
 */

@Getter
@AllArgsConstructor
public class MesageDataRes<T> {
	private String messageContent;

	private T messageCode;

	private String field;

	private String type;

	public MesageDataRes(String messageContent, T messageCode) {
		this.messageContent = messageContent;
		this.messageCode = messageCode;
	}
}
