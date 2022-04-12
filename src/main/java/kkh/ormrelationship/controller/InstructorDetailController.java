package kkh.ormrelationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kkh.ormrelationship.datamodel.Instructor;
import kkh.ormrelationship.datamodel.InstructorDetail;
import kkh.ormrelationship.formmodel.InstructorDetailBean;
import kkh.ormrelationship.service.InstructorDetailService;
import kkh.ormrelationship.service.InstructorService;

@Controller
public class InstructorDetailController {
	@Autowired
	private InstructorService instructorService;

	@Autowired
	private InstructorDetailService instructorDetailService;

	@GetMapping(value = "/instructorDetail")
	public ModelAndView showInstructorDetailPage(ModelMap map) {
		List<InstructorDetail> list = instructorDetailService.findAll();
		map.addAttribute("list", list);
		InstructorDetailBean bean = new InstructorDetailBean();
		return new ModelAndView("instructor-detail", "bean", bean);
	}

	@PostMapping(value = "/instructorDetail")
	public String createInstructorDetail(@ModelAttribute("bean") InstructorDetailBean bean, BindingResult br,
			ModelMap map) {
		if (br.hasErrors())
			return "instructor-detail";

		Instructor dto = new Instructor();
		InstructorDetail detailDto = new InstructorDetail();

		detailDto.setYoutubeChannel(bean.getYoutubeChannel());
		detailDto.setHobby(bean.getHobby());
		dto.setFirstName(bean.getFirstName());
		dto.setLastName(bean.getLastName());
		dto.setEmail(bean.getEmail());

		dto.setInstructorDetail(detailDto);
		detailDto.setInstructor(dto);

		instructorDetailService.save(detailDto);
		
		map.addAttribute("status", "Successfully created.");

		return "redirect:/instructorDetail/";
	}
	
	@GetMapping(value="/instructorDetail/delete")
	public String deleteInstructor(@RequestParam("id") int id) {
		instructorDetailService.deleteById(id);

		return "redirect:/instructor/";
	}
}
