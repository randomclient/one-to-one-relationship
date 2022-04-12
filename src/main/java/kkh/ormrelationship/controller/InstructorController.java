package kkh.ormrelationship.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kkh.ormrelationship.datamodel.Instructor;
import kkh.ormrelationship.datamodel.InstructorDetail;
import kkh.ormrelationship.formmodel.InstructorBean;
import kkh.ormrelationship.service.InstructorDetailService;
import kkh.ormrelationship.service.InstructorService;

@Controller
@RequestMapping("/instructor")
public class InstructorController {
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private InstructorDetailService instructorDetailService;
	
	@GetMapping(value="/")
	public ModelAndView showInstructorPage(ModelMap map) {
		List<Instructor> infoDetail = instructorService.findAll();
		map.addAttribute("list", infoDetail);
		return new ModelAndView("instructor","bean",new InstructorBean());
	}
	
	@PostMapping(value="/")
	public String addInstructor(@ModelAttribute("bean") InstructorBean bean, BindingResult br, ModelMap map) {
		if(br.hasErrors())
			return "instructor";
		
		Instructor dto = new Instructor();
		InstructorDetail detailDto = new InstructorDetail();
		
		dto.setFirstName(bean.getFirstName());
		dto.setLastName(bean.getLastName());
		dto.setEmail(bean.getEmail());
		detailDto.setYoutubeChannel(bean.getYoutubeChannel());
		detailDto.setHobby(bean.getHobby());
		
		dto.setInstructorDetail(detailDto);
		
		instructorService.save(dto);
		
		map.addAttribute("status", "Successfully created.");
		
		
		return "redirect:/instructor/";
	}
	
	@GetMapping(value="/delete")
	public String deleteInstructor(@RequestParam("id") int id) {
		instructorService.deleteById(id);

		return "redirect:/instructor/";
	}
}
