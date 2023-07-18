package com.hdq.school.services.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdq.school.common.utils.BeanUtils;
import com.hdq.school.dtos.responses.DemoResponse;
import com.hdq.school.persistences.repositories.DemoRepository;
import com.hdq.school.services.DemoService;

@Service
public class DemoServiceImplement implements DemoService {

	@Autowired
	private DemoRepository demoRepository;

	@Override
	public DemoResponse createDemo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DemoResponse updateDemo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteDemo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DemoResponse> getListDemo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DemoResponse getDemo(Long id) {
		return BeanUtils.createAndCopy(demoRepository.findById(id).orElse(null), DemoResponse.class);
	}

}
