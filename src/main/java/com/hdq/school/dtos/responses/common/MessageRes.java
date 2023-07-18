/**
T * The class is used for Rest controllers as a response object with fail response
 * 
 *  @author hoatlv
 *  @since v1.0
 */

package com.hdq.school.dtos.responses.common;

import java.util.Date;

import com.hdq.school.common.enums.MessageType;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Data response object, used to response message (error, info, warning) to
 * client
 * 
 * @author Hoatlv
 * @since v1.0
 */

@Getter
@AllArgsConstructor
public class MessageRes<T> {

	// Status message 
	private final MessageType status;

	// General message ERROR/WARN/INFO
	private final T message;

	private final Date timestamp;

	/**
	 * The constructor with current date
	 * 
	 * @param _error
	 */
	public MessageRes(MessageType status, final T message) {
		this.status = status;
		this.message = message;
		this.timestamp = new java.util.Date();
	}
}
