package com.hdq.school.services;

import java.util.List;

import com.hdq.school.dtos.responses.DemoResponse;

public interface DemoService {

	DemoResponse createDemo();

	DemoResponse updateDemo();

	String deleteDemo();

	List<DemoResponse> getListDemo();

	DemoResponse getDemo(Long id);

}
