/**
 * The class is used for Rest controllers as a response object with success response
 * 
 *  @author lamva
 *  @since v1.0
 */

package com.hdq.school.dtos.responses.common;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Data response object, used to response data for success request
 * 
 * @author Hoatlv
 * @since v1.0
 */

@Getter
@NoArgsConstructor
public class DataRes<T> {
	private String status;

	private T data;

	/**
	 * The constructor
	 * 
	 * @param _data
	 */
	public DataRes(String _message, T _data) {
		this.status = _message;
		this.data = _data;
	}

}
