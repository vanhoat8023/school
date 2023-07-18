package com.hdq.school.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * This is map data for class and list
 * 
 * @author hoatvt on 12/04/2022
 * @since 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BeanUtils {

	public static <U, V> V copy(U source, V target) {
		return copy(source, target, (String[]) null);
	}

	public static <U, V> V copy(U source, V target, String... ignoreProperties) {
		if (source == null) {
			return target;
		}
		org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
		return target;
	}

	public static <U, V> V createAndCopy(U source, Class<V> clazz) {
		return createAndCopy(source, clazz, (String[]) null);
	}

	public static <U, V> V createAndCopy(U source, Class<V> clazz, String... ignoreProperties) {
		if (source == null) {
			return null;
		}
		return copy(source, org.springframework.beans.BeanUtils.instantiateClass(clazz), ignoreProperties);
	}

	public static <U, V> List<V> copyList(List<U> sources, Class<V> clazz) {
		return copyList(sources, clazz, (String[]) null);
	}

	public static <U, V> List<V> copyList(List<U> sources, Class<V> clazz, String... ignoreProperties) {
		List<V> targetList = new ArrayList<>();
		if (CollectionUtils.isEmpty(sources)) {
			return targetList;
		}
		sources.forEach(source -> targetList.add(createAndCopy(source, clazz, ignoreProperties)));
		return targetList;
	}
}
