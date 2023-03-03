package com.covid.mis.controller;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JLabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.covid.mis.bean.CategoryBean;
import com.covid.mis.bean.ColourBean;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.json.gson.GsonFactory;
//import com.google.api.services.translate.Translate;
//import com.google.api.services.translate.model.TranslationsListResponse;
//import com.google.api.services.translate.model.TranslationsResource;
import com.covid.mis.bean.DistrictBean;
import com.covid.mis.bean.FeeBean;
import com.covid.mis.bean.HeadBean;
import com.covid.mis.bean.LocalityBean;
import com.covid.mis.bean.TypeBean;
import com.covid.mis.bean.ULBBean;
import com.covid.mis.bean.UserBean;
import com.covid.mis.service.CategoryService;
import com.covid.mis.service.ColourService;
import com.covid.mis.service.DistrictService;
import com.covid.mis.service.FeeService;
import com.covid.mis.service.HeadService;
import com.covid.mis.service.LocalityService;
import com.covid.mis.service.TypeService;
import com.covid.mis.service.ULBService;
import com.covid.mis.service.UserService;
import com.covid.mis.util.SmsApiIntegrationService;


@Controller
public class CovidMisController {
	private static final String RECEIPT_NUMBER_FORMAT_MONTHLY = "PL/%s/%s/%s/%s";
		private static final String APP_NUMBER_FORMAT = "PL/%s/%s/%s";
	private static final String DATE_FORMAT = "%04d-%02d-%02d";


	@Autowired
	HeadService headService;
	
	@Autowired
	FeeService feeService;
	
	@Autowired
	DistrictService districtService;
	
	@Autowired
	ULBService ulbService; 
	
	@Autowired
	LocalityService localityService; 
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TypeService typeService;
	
	@Autowired
	ColourService colourService;
	
	@Autowired
	UserService userService; 
	
	@Autowired
	SmsApiIntegrationService smsApiIntegrationService; 
	
	@Value("${file.upload-dir}")
	private String IMAGES_DIR;
	
	
	@RequestMapping(value = {"/","/login" })
	public String indexForm() {
		return "login";
	}
	
	@RequestMapping(value = {"/register" })
	public ModelAndView register(Model model) {
		ModelAndView lgmap = new ModelAndView("register");
		UserBean u=new UserBean();
		model.addAttribute("userBean", u);
		lgmap.addObject("message", "");
		return lgmap;
	}
	
	@ResponseBody
	@RequestMapping(value = {"/admin-login" })
	public ModelAndView Adminindex(@RequestParam("mobile") String mobile,@RequestParam("password") String password, HttpServletRequest request) {
		ModelAndView map = new ModelAndView("dashboard");
		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		UserBean user = null;
		//long totalTestingRecords,totalCovidPRecords;
		try {
		user = userService.getUserDatabyMobilePass(mobile,password);
//		totalTestingRecords =  testingDataService.totalRecords();
//		totalCovidPRecords = covidPatientDataService.totalRecords();
		if(user==null)
		{
			lgmap.addObject("message", "Please Enter Valid Mobile Or Password!");
			return lgmap;
		}
		else
		{
			session.setAttribute("userObj", user);
			session.setAttribute("userType", user.getUserType());
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("userId", user.getUserId());
			
				int numbers= headService.getAllRecords();
				map.addObject("totalHeadRecords", numbers);
			
			return map;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lgmap;
	}
	
	@PostMapping(value = "/register-user", headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView createEmployee(HttpServletRequest request, @ModelAttribute("userBean") UserBean userBean) {
		UserBean uBean = userBean;
		uBean.setUserType(1);
		UserBean response = userService.save(uBean);
		ModelAndView map = new ModelAndView("register");
		HttpSession session = request.getSession();
		map.addObject("errorMessage", "User Registered successfully. Please login");
		map.addObject("style","color:black");
		return map;
	}
	
	@RequestMapping(value = "/reset-password", headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView reset() throws SQLException {
		ModelAndView map = new ModelAndView("reset-password");
		return map;
	}
	
	
	@PostMapping(value = "/resetPassword", headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView resetPassword(@RequestParam("mobileNumber") String mobileNumber,@RequestParam("newpassword") String newpassword) throws SQLException {
		UserBean employeeBean = userService.findEmployeeByMobileNo(mobileNumber);
		ModelAndView map = new ModelAndView("reset-password");
		JLabel label = new JLabel(newpassword);
		label.setFont(new Font("Dialog", Font.BOLD, 10));
		if (employeeBean != null) {
			employeeBean.setPassword(newpassword);
			userService.update(employeeBean);
			String msg = "Password has been reset to  " + label.getText();
			boolean status = smsApiIntegrationService.smsCallService(employeeBean.getMobileNumber(), msg);
			map.addObject("errorMessage", "Password reset successful");

			return map;
		}
		
		else
		{	map.addObject("errorMessage", "No user with this mobile number found..");
			return map;
		}
		

	}
	

	
	  @GetMapping(value = "/generateOTP") 
	  public @ResponseBody String generateOTP(@RequestParam("mobileNo") String mobileNo) throws SQLException {
	  UserBean userBean = userService.findEmployeeByMobileNo(mobileNo); 
	  if(userBean != null) 
	  { Random rand = new Random();
	  int num = rand.nextInt(9999); 
	  String otp=String.format("%04d", num);
	  String msg = "OTP to reset password for your login is " +otp; 
	  boolean status =  smsApiIntegrationService.smsCallService(mobileNo,msg);
	  
	  return otp;
	  }
	  
	  else { return "Mobile number is not registered.Try again!!"; } }
	 

	@ResponseBody
	@GetMapping(value = { "/get-district" })
		public List<DistrictBean> getDistrict() {
		List<DistrictBean> districtList=null;
		try {
			districtList = districtService.getDistrict();
			return districtList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return districtList;
	}
	


	@ResponseBody
	@GetMapping(value = { "/get-colour" })
		public List<ColourBean> getColour() {
		List<ColourBean> districtList=null;
		try {
			districtList = colourService.getColour();
			return districtList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return districtList;
	}
	

	

	@ResponseBody
	@GetMapping(value = { "/get-type" })
		public List<TypeBean> getType() {
		List<TypeBean> districtList=null;
		try {
			districtList = typeService.getType();
			return districtList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return districtList;
	}
	

	

	@ResponseBody
	@GetMapping(value = { "/get-category" })
		public List<CategoryBean> getCategory() {
		List<CategoryBean> districtList=null;
		try {
			districtList = categoryService.getCategory();
			return districtList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return districtList;
	}
	

	@ResponseBody
	@GetMapping(value = { "/get-ulb" })
		public List<ULBBean> getUlb(@RequestParam("district") int district) {
		List<ULBBean> ulbList=null;
		try {
			ulbList = ulbService.getUlb(district);
			return ulbList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ulbList;
	}
	
	@GetMapping(value = { "/get-locality" })
	public @ResponseBody List<LocalityBean> getLocality(@RequestParam("ulb") int ulb) {
	List<LocalityBean> localityList=null;
	try {
		localityList = localityService.getLocality(ulb);
		return localityList;
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return localityList;
	}
	
	
	@RequestMapping(value = {"/dashboard" })
	public ModelAndView dashboard(Model model, HttpServletRequest request) {
		ModelAndView map = new ModelAndView("dashboard");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null)
		{
			UserBean user=userService.searchById((int)session.getAttribute("userId"));
			if(user.getUserType()==0)
			{
				session.setAttribute("userObj", user);
				session.setAttribute("userType", user.getUserType());
				session.setAttribute("userName", user.getUserName());
				session.setAttribute("userId", user.getUserId());
				
					int numbers= headService.getAllRecords();
					map.addObject("totalHeadRecords", numbers);
			}
			
			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}
	
	@RequestMapping(value = {"/editProfile" })
	public ModelAndView editProfile(Model model, HttpServletRequest request) {
		ModelAndView map = new ModelAndView("edit-profile");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null)
		{	int userId=(int) session.getAttribute("userId");
			UserBean u =userService.searchById(userId);
			map.addObject("user", u);
			return map;
		}
		else
		{
		
		return new ModelAndView("dashboard");
	}
	}
	
	@PostMapping(value = {"/user-data" })
	@ResponseBody
	public ModelAndView saveUserData(HttpServletRequest request, @RequestParam("userName") String userName,@RequestParam("emailAddress") String emailAddress,
			@RequestParam("mobileNumber") String mobileNumber) {
		HttpSession session = request.getSession();
		ModelAndView map = null;

		if(session.getAttribute("userId")!=null)
			
		{
			UserBean u=userService.searchById((int)session.getAttribute("userId"));
			u.setUserName(userName);
			u.setEmailAddress(emailAddress);
			u.setMobileNumber(mobileNumber);
			userService.save(u);
			map= new ModelAndView("edit-profile");

			map.addObject("testingErrorMsg", "Data updated Successfully");
			
			
		}
		
		return map;
	}
	
	
	
	@RequestMapping(value = {"/registration-form" })
	public ModelAndView testingForm(Model model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
	
		if(session.getAttribute("userId")!=null)
		{
			UserBean u=userService.searchById((int)session.getAttribute("userId"));
			ModelAndView map = new ModelAndView("registration-form");
			map.addObject("usersType", "STAFF");
			map.addObject("district", u.getDistrictBean().getDistrictCode());
			map.addObject("ulb", u.getUlbBean().getUlbCode());

			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}

		
	@RequestMapping(value = {"/citizen-form" })
	public ModelAndView testingFormWithoutindex(Model model) {
		ModelAndView map = new ModelAndView("registration-form");
		map.addObject("usersType", "CITIZEN");
		return map;
		
	}
	
	@RequestMapping(value = {"/registration-data" })
	@ResponseBody
	public ModelAndView saveTestingData(HttpServletRequest request, @ModelAttribute("petBean") HeadBean headBean, 
			@RequestParam("defectPicPP") MultipartFile defectPicPP,	@RequestParam("certificatePicPP") MultipartFile certificatePicPP,
			@RequestParam("frontPicPP") MultipartFile frontPicPP,	@RequestParam("backPicPP") MultipartFile backPicPP,
			@RequestParam("rightPicPP") MultipartFile rightPicPP,	@RequestParam("leftPicPP") MultipartFile leftPicPP,
			@RequestParam("ownerPicPP") MultipartFile ownerPicPP,@RequestParam("usersType") String usersType) {
		HttpSession session = request.getSession();
		ModelAndView map =null;
		
		if(usersType.equals("STAFF") && session.getAttribute("userId")!=null || usersType.equals("CITIZEN"))
			{
				List<MultipartFile> attachedfiles =  new ArrayList<>(0);
				attachedfiles.add(defectPicPP);
				attachedfiles.add(certificatePicPP);
				if(frontPicPP!=null)
				{
					attachedfiles.add(frontPicPP);

				}
				if(backPicPP!=null)
				{
					attachedfiles.add(backPicPP);

				}
				if(leftPicPP!=null)
				{
					attachedfiles.add(leftPicPP);

				}
				if(rightPicPP!=null)
				{
					attachedfiles.add(rightPicPP);

				}
				
				if(ownerPicPP!=null)
				{
					attachedfiles.add(ownerPicPP);

				}
				if(headBean.getFee()=="Yes")
					headBean.setApplicationStatus("Fee Received.Pending for Approval.");
				else
					headBean.setApplicationStatus("Applied");
				
				headBean.setMode(usersType);
				Date date = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				String[] imageType = { "DEFECT", "CERTIFICATE","FRONT","BACK","LEFT","RIGHT","OWNER"};
				headBean.setDateOfApplication(String.format(DATE_FORMAT, calendar.get(Calendar.YEAR),
						calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
				
				if(usersType.equals("STAFF"))
				{
					UserBean u=userService.searchById((int)session.getAttribute("userId"));
					headBean.setDistrictBean(u.getDistrictBean());
					headBean.setUlbBean(u.getUlbBean());
				}
				HeadBean savedHeadBean=headService.save(headBean);
				 int index = -1;
				 String imgPath=null;
					for (MultipartFile file : attachedfiles) {
						if (file == null || file.getSize() == 0) {

						} else {
							try {
								byte[] bytes = null;
								String ext = null;
								String name = null;
								index++;
								if (file != null) {
									bytes = file.getBytes();

									File dir = new File(IMAGES_DIR+"/"+savedHeadBean.getPetId());
									if (!dir.exists())
										dir.mkdirs();
									ext = file.getOriginalFilename()
											.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
									name = file.getOriginalFilename().substring(0,
											file.getOriginalFilename().lastIndexOf("."));
								}
								
								imgPath = System.currentTimeMillis() + "-" + imageType[index] + "-" + name + "." + ext;
						
								Path path = Paths.get(IMAGES_DIR+"/"+savedHeadBean.getPetId()+"/"+ imgPath);
								if(index==0)
								{
									savedHeadBean.setDefectPic(path.toString());
								}
								else if(index==1)
								{
									savedHeadBean.setCertificatePic(path.toString());
								}
								else if(index==2)
								{
									savedHeadBean.setFrontPic(path.toString());

								}
								else if(index==3)
								{
									savedHeadBean.setBackPic(path.toString());

								}
								else if(index==4)
								{
									savedHeadBean.setLeftPic(path.toString());

								}
								else if(index==5)
								{
									savedHeadBean.setRightPic(path.toString());

								}
								else if(index==6)
								{
									savedHeadBean.setOwnerPic(path.toString());

								}
								Files.write(path, bytes);

							} catch (IOException e) {
								e.printStackTrace();
							}

						}
					}
					
				headService.save(savedHeadBean);

			
			
			if(savedHeadBean.getPetId()>0)
			{
				map= new ModelAndView("registration-form");
				String msg = "Pet with id "+savedHeadBean.getPetId()+" has been registered successfully. Please pay registartion Fee.";
				boolean status = smsApiIntegrationService.smsCallService(savedHeadBean.getMobileNo(), msg);
				map.addObject("testingErrorMsg", "Pet with id "+savedHeadBean.getPetId()+" has been registered successfully");
				map.addObject("petId",savedHeadBean.getPetId());
				map.addObject("usersType", usersType);
				return map;
				
			}
			else
			{
				map = new ModelAndView("registration-form");
				map.addObject("usersType", usersType);
				map.addObject("testingErrorMsg", "Please Try Again.");
				
			}
			return map;
		
		}

		else
		{
		return new ModelAndView("login");
		}
		
	
	}

	
	@RequestMapping(value = "/report", headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView report(HttpServletRequest request) throws SQLException {
		HttpSession session = request.getSession();
		ModelAndView map = new ModelAndView("report");

		if(session.getAttribute("userId")!=null)
		{
		UserBean u=userService.searchById((int)session.getAttribute("userId"));
		map.addObject("usertype", u.getUserType());

		if((u.getUserType())>=1)
		{
			map.addObject("district", u.getDistrictBean().getDistrictCode());

			map.addObject("ulb", u.getUlbBean().getUlbCode());

		}
		
		
		}
		else
		{
		return new ModelAndView("login");
		}
		
		return map;
	}
	
	@ResponseBody
	@GetMapping(value = "/get-head-data")
		public List<HeadBean> getTestingData(@RequestParam("selectedDistrict") String selectedDistrict,@RequestParam("selectedULB") String selectedULB,@RequestParam("selectedLocality") String selectedLocality,@RequestParam("status") String status) {
		List<HeadBean> headDataList=null;
		try {
			if(selectedDistrict!="" && selectedLocality=="" && selectedULB=="" && status=="")
					headDataList = headService.getheadDataByDistrict(Integer.parseInt(selectedDistrict));
			else if(selectedDistrict=="" && selectedULB=="" && selectedLocality=="" && status!="")
				headDataList = headService.getheadDataByStatus(status);
			else if(selectedDistrict!="" && selectedULB!="" && selectedLocality=="" && status=="")
				headDataList = headService.getheadDataByDistrictandULB(Integer.parseInt(selectedDistrict),Integer.parseInt(selectedULB));
				else if(selectedDistrict!=""  && selectedULB!="" && selectedLocality!="" && status=="")
					headDataList = headService.getheadDataByDistrictULBAndLocality(Integer.parseInt(selectedDistrict),Integer.parseInt(selectedULB),Integer.parseInt(selectedLocality));
				else if(selectedDistrict!=""  && selectedULB!="" && selectedLocality!="" && status!="")
					headDataList = headService.getheadDataByDistrictULBAndLocalityAndStatus(Integer.parseInt(selectedDistrict),Integer.parseInt(selectedULB),Integer.parseInt(selectedLocality),status);
				else if(selectedDistrict!="" && selectedULB!="" && selectedLocality=="" && status!="")
					headDataList = headService.getheadDataByDistrictULBAndStatus(Integer.parseInt(selectedDistrict),Integer.parseInt(selectedULB),status);
				else
					headDataList = headService.getheadAllData();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return headDataList;
	}

	
	@RequestMapping(value = "/logout")
	public String adminLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userObj");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = {"/download-pet-license" })
	@ResponseBody
	public ModelAndView petLicense(HttpServletRequest request,@RequestParam("petId") int petId) {
		ModelAndView map = new ModelAndView("download-pet-license");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null)
		{	HeadBean h=headService.searchById(petId);
			map.addObject("pet", h);
			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}
	
	@RequestMapping(value = {"/edit-details" })
	@ResponseBody
	public ModelAndView editDetails(HttpServletRequest request,@RequestParam("petId") int petId) {
		ModelAndView map = new ModelAndView("edit-details");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null)
		{	HeadBean h=headService.searchById(petId);
			map.addObject("pet", h);
			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}
	
	@PostMapping(value = {"/edit-head-data" })
	@ResponseBody
	public ModelAndView saveHeadData(HttpServletRequest request, @ModelAttribute("petBean") HeadBean petBean,@RequestParam("petId") int petId,
			@RequestParam("defectPicPP") MultipartFile defectPicPP,	@RequestParam("certificatePicPP") MultipartFile certificatePicPP,
			@RequestParam("frontPicPP") MultipartFile frontPicPP,	@RequestParam("backPicPP") MultipartFile backPicPP,
			@RequestParam("rightPicPP") MultipartFile rightPicPP,	@RequestParam("leftPicPP") MultipartFile leftPicPP,
			@RequestParam("ownerPicPP") MultipartFile ownerPicPP) {
		HttpSession session = request.getSession();
		ModelAndView map = null;

		if(session.getAttribute("userId")!=null)
			
		{
			petBean.setPetId(petId);
			HeadBean savedBean=headService.searchById(petId);
			List<MultipartFile> attachedfiles =  new ArrayList<>(0);
			attachedfiles.add(defectPicPP);
			attachedfiles.add(certificatePicPP);
			attachedfiles.add(frontPicPP);
			attachedfiles.add(backPicPP);
			attachedfiles.add(leftPicPP);
			attachedfiles.add(rightPicPP);
			attachedfiles.add(ownerPicPP);
			if(defectPicPP==null || defectPicPP.getSize() == 0)
			{
				petBean.setDefectPic(savedBean.getDefectPic());
			}
			if(certificatePicPP==null || certificatePicPP.getSize() == 0)
			{
				petBean.setCertificatePic(savedBean.getCertificatePic());
			}

			if(frontPicPP==null || frontPicPP.getSize() == 0)
			{
				petBean.setFrontPic(savedBean.getFrontPic());
			}
			if(backPicPP==null || backPicPP.getSize()==0)
			{
				petBean.setBackPic(savedBean.getBackPic());
			}
			if(leftPicPP!=null || leftPicPP.getSize()==0)
			{
				petBean.setLeftPic(savedBean.getLeftPic());

			}
			if(rightPicPP!=null || rightPicPP.getSize()==0)
			{
				petBean.setRightPic(savedBean.getRightPic());
			}
			
			if(ownerPicPP!=null || ownerPicPP.getSize()==0)
			{
				petBean.setOwnerPic(savedBean.getOwnerPic());
			}
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String[] imageType = { "DEFECT", "CERTIFICATE","FRONT","BACK","LEFT","RIGHT","OWNER"};
			int index = -1;
			 String imgPath=null;
				for (MultipartFile file : attachedfiles) {
					if (file == null || file.getSize() == 0) {

					} else {
						try {
							byte[] bytes = null;
							String ext = null;
							String name = null;
							index++;
							if (file != null) {
								bytes = file.getBytes();

								File dir = new File(IMAGES_DIR+"/"+petBean.getPetId()+"/NEW");
								if (!dir.exists())
									dir.mkdirs();
								ext = file.getOriginalFilename()
										.substring(file.getOriginalFilename().lastIndexOf(".") + 1);
								name = file.getOriginalFilename().substring(0,
										file.getOriginalFilename().lastIndexOf("."));
							}
							
							imgPath = System.currentTimeMillis() + "-" + imageType[index] + "-" + name + "." + ext;
					
							Path path = Paths.get(IMAGES_DIR+"/"+petBean.getPetId()+"/NEW/"+ imgPath);
							if(index==0)
							{
								petBean.setDefectPic(path.toString());
							}
							else if(index==1)
							{
								petBean.setCertificatePic(path.toString());
							}
							else if(index==2)
							{
								petBean.setFrontPic(path.toString());

							}
							else if(index==3)
							{
								petBean.setBackPic(path.toString());

							}
							else if(index==4)
							{
								petBean.setLeftPic(path.toString());

							}
							else if(index==5)
							{
								petBean.setRightPic(path.toString());

							}
							else if(index==6)
							{
								petBean.setOwnerPic(path.toString());

							}
							Files.write(path, bytes);

						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				}

			if(savedBean.getApplicationStatus().equals("Send back with Objections") && savedBean.getFee().equals("No"))
				petBean.setApplicationStatus("Applied");
			else if(savedBean.getApplicationStatus().contentEquals("Send back with Objections") && savedBean.getFee().contentEquals("Yes"))
				petBean.setApplicationStatus("Fee Received.Pending for Approval.");
			headService.save(petBean);
			map= new ModelAndView("edit-details");

			map.addObject("testingErrorMsg", "Data updated Successfully");
			
			
		}
		
		return map;
	}
	
	
	@RequestMapping(value = {"/collect-fee-search" })
	public ModelAndView collectForm(Model model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
	
		if(session.getAttribute("userId")!=null)
		{
			ModelAndView map = new ModelAndView("collect-fee-search");
			map.addObject("district", userService.searchById((int)session.getAttribute("userId")).getDistrictBean().getDistrictCode());
			map.addObject("ulb", userService.searchById((int)session.getAttribute("userId")).getUlbBean().getUlbCode());

			map.addObject("userType", userService.searchById((int)session.getAttribute("userId")).getUserType());
			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}
	
	@RequestMapping(value = {"/collect-fee-online-search" })
	public ModelAndView collectFormOnline(Model model,HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
	
			ModelAndView map = new ModelAndView("collect-fee-online-search");
			
			return map;
		}
	

	@ResponseBody
	@GetMapping(value = "/get-pet-data")
		public List<HeadBean> getTestingData(@RequestParam("name") String name,@RequestParam("fatherName") String fatherName,
				@RequestParam("locality") String locality,@RequestParam("ulb") String ulb,@RequestParam("district") String district,@RequestParam("userType") int userType,@RequestParam("status") String status) {
		List<HeadBean> headDataList=null;
		try {
			if(userType==1)
			{
			if(name!="" && fatherName =="" && locality=="" && status=="")
				headDataList=headService.searchByName(name,district,ulb);
			else if(name=="" && fatherName !="" && locality=="" && status=="")
				headDataList=headService.searchByFatherName(fatherName,district,ulb);
			else if(name=="" && fatherName =="" && locality!="" && status=="")
				headDataList=headService.searchByLocality(locality,district,ulb);
			else if(name=="" && fatherName =="" && locality=="" && status!="")
				headDataList=headService.searchByStatus(status,district,ulb);
			else if(name!="" && fatherName =="" && locality!="" && status=="")
				headDataList=headService.searchByNameandLocality(name,locality,district,ulb);
			else if(name!="" && fatherName !="" && locality=="" && status=="")
				headDataList=headService.searchByNameandFatherName(name,fatherName,district,ulb);
			else if(name!="" && fatherName =="" && locality=="" && status!="")
				headDataList=headService.searchByNameandstatus(name,status,district,ulb);
			else if(name=="" && fatherName !="" && locality!="" && status=="")
				headDataList=headService.searchByFatherNameandLocality(fatherName ,locality,district,ulb);
			else if(name=="" && fatherName !="" && locality=="" && status!="")
				headDataList=headService.searchByFatherNameandStatus(fatherName ,status,district,ulb);
			else if(name!="" && fatherName !="" && locality!="" && status!="")
				headDataList=headService.searchByAllParameters(name,fatherName,locality,status,district,ulb);
			else
				headDataList=headService.searchAll(district,ulb);
			}
			else if(userType==2)
			{
				if(name!="" && fatherName =="" && locality=="")
					headDataList=headService.searchByNameForApproval(name,ulb);
				else if(name=="" && fatherName !="" && locality=="")
					headDataList=headService.searchByFatherNameForApproval(fatherName,ulb);
				else if(name=="" && fatherName =="" && locality!="")
					headDataList=headService.searchByLocalityForApproval(locality,ulb);
				else if(name!="" && fatherName =="" && locality!="")
					headDataList=headService.searchByNameandLocalityForApproval(name,locality,ulb);
				else if(name!="" && fatherName !="" && locality=="")
					headDataList=headService.searchByNameandFatherNameForApproval(name,fatherName,ulb);
				else if(name=="" && fatherName !="" && locality!="")
					headDataList=headService.searchByFatherNameandLocalityForApproval(fatherName ,locality,ulb);
				else if(name!="" && fatherName !="" && locality!="")
					headDataList=headService.searchByAllParametersForApproval(name,fatherName,locality,ulb);
				else
					headDataList=headService.searchAllForApproval(district,ulb);
			}
			else
			{
				if(district!="" && ulb=="" && name=="" && fatherName =="" && locality=="")
					headDataList=headService.getheadDataByDistrictOnline(Integer.parseInt(district));
				else if(district!="" && ulb!="" && name=="" && fatherName =="" && locality=="")					
					headDataList=headService.getheadDataByDistrictandULBOnline(Integer.parseInt(district),Integer.parseInt(ulb));
				else if(district!="" && ulb!="" && name=="" && fatherName =="" && locality!="")					
					headDataList=headService.getheadDataByDistrictULBAndLocalityOnline(Integer.parseInt(district),Integer.parseInt(ulb),Integer.parseInt(locality));
				else if(district!="" && ulb!="" && name!="" && fatherName =="" && locality!="")					
					headDataList=headService.getheadDataByDistrictULBLocalityNameOnline(district,ulb,locality,name);
				else if(district!="" && ulb!="" && name=="" && fatherName !="" && locality!="")					
					headDataList=headService.getheadDataByDistrictULBLocalityFNameOnline(district,ulb,locality,fatherName);
				else if(district!="" && ulb!="" && name!="" && fatherName !="" && locality!="")					
					headDataList=headService.getheadDataByDistrictULBLocalitynameFNameOnline(district,ulb,locality,name,fatherName);
				else if(district=="" && ulb=="" && name!="" && fatherName !="" && locality=="")					
					headDataList=headService.searchByNameandFatherNameOnline(name,fatherName);					
				else if(district=="" && ulb=="" && name!="" && fatherName =="" && locality=="")					
					headDataList=headService.searchByNameOnline(name);
				else if(district=="" && ulb=="" && name=="" && fatherName !="" && locality=="")					
					headDataList=headService.searchByFnameOnline(fatherName);
				
			}
				
			
			return headDataList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return headDataList;
	}
	
	
	@RequestMapping(value = {"/collect-fee" })
	@ResponseBody
	public ModelAndView collectFeee(HttpServletRequest request,@RequestParam("petId") int petId) {
		ModelAndView map = new ModelAndView("collect-fee");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null)
		{	HeadBean h=headService.searchById(petId);
			map.addObject("pet", h);
			map.addObject("userType", userService.searchById((int)session.getAttribute("userId")).getUserType());

			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}
	
	@RequestMapping(value = {"/collect-fee-online" })
	@ResponseBody
	public ModelAndView collectFeeeOnline(HttpServletRequest request,@RequestParam("petId") int petId) {
		ModelAndView map = new ModelAndView("collect-fee-online");
		HttpSession session = request.getSession();
		HeadBean h=headService.searchById(petId);
			map.addObject("pet", h);
			map.addObject("userType", 9);
		FeeBean feeBean=new FeeBean();
		feeBean.setAmount(Integer.parseInt(h.getUlbBean().getRegFee()));
		feeBean.setMode("ONLINE");
		feeBean.setStatus("Routed for payment");
		feeBean.setPurpose("Registration Fee");
		feeBean.setHeadBean(h);
		feeService.save(feeBean);
		session.setAttribute("amount", h.getUlbBean().getRegFee());
		session.setAttribute("s_order_id", "REG-"+h.getPetId());
			return map;
			}
	
	
	@RequestMapping(value = {"/view-details" })
	@ResponseBody
	public ModelAndView viewDetails(HttpServletRequest request,@RequestParam("petId") int petId) {
		ModelAndView map = new ModelAndView("view-details");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null)
		{	HeadBean h=headService.searchById(petId);
			map.addObject("pet", h);
			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}
	
	
	@RequestMapping(value = {"/approve-pet" })
	@ResponseBody
	public ModelAndView approvePet(HttpServletRequest request,@RequestParam("petId") int petId) {
		ModelAndView map = new ModelAndView("approve-pet");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null)
		{	HeadBean h=headService.searchById(petId);
			map.addObject("pet", h);
			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}

	
	
	@RequestMapping(value = {"/collect-feesave"})
	@ResponseBody
	public ModelAndView collectFeeSave(HttpServletRequest request, @ModelAttribute("feeBean") FeeBean feeBean,@RequestParam("petId") int petId,@RequestParam("userType") int userType) throws SQLException {
		HttpSession session = request.getSession();
		ModelAndView map = null;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if(session.getAttribute("userId")!=null && userType<=2)
		{
			HeadBean pet=headService.searchById(petId);

			String receiptNumber = generateReceiptNumber(feeBean,pet);
			feeBean.setHeadBean(pet);
			feeBean.setReceiptNumber(receiptNumber);
			feeBean.setMode("COUNTER");
			feeBean.setOrderId((String)pet.getPetId().toString());
			feeBean.setReceiptDate(String.format(DATE_FORMAT, calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
			feeBean.setUserBean(userService.searchById((int)session.getAttribute("userId")));
			feeService.save(feeBean);
			pet.setFee("Yes");
			pet.setApplicationStatus("Fee Received.Pending for Approval.");
			headService.save(pet);
			map= new ModelAndView("payment-success");
			map.addObject("pet",feeBean.getHeadBean());
			map.addObject("fee",feeBean);
			String msg = "Registration Fee for Pet registered with id "+feeBean.getHeadBean().getPetId()+"has been collected successfully.";
			boolean status = smsApiIntegrationService.smsCallService(feeBean.getHeadBean().getMobileNo(), msg);


			
		}
		else if(session.getAttribute("userId")==null && userType>2)
		{
			map=new ModelAndView("ccavRequestHandler");
			
		}
		else
		{
			map=new ModelAndView("login");
			
		}
		
		return map;
		
	}
	
	@RequestMapping(value = {"/approve-petsave"})
	@ResponseBody
	public ModelAndView approvepetsave(HttpServletRequest request,@RequestParam("comments") String comments,@RequestParam("petId") int petId) throws SQLException {
		HttpSession session = request.getSession();
		ModelAndView map = null;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if(session.getAttribute("userId")!=null)
		{
			HeadBean petBean=headService.searchById(petId);
			petBean.setApplicationStatus("Approved");
			petBean.setDateOfApproval(String.format(DATE_FORMAT, calendar.get(Calendar.YEAR),
						calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
			petBean.setComments(comments);
			petBean.setRegistrationNumber(generateRegistrationNumber(petBean));
			petBean.setValidUpto(String.format(DATE_FORMAT, calendar.get(Calendar.YEAR)+5,
					calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
			headService.save(petBean);
			String msg = "Pet registered with id "+petBean.getPetId()+"has been approved successfully.";
			boolean status = smsApiIntegrationService.smsCallService(petBean.getMobileNo(), msg);
			map= new ModelAndView("approve-success");
			map.addObject("pet",petBean);
	
		}
		return map;
		
	}
	
	@RequestMapping(value = {"/reject-pet"})
	@ResponseBody
	public ModelAndView rejectPet(HttpServletRequest request,@RequestParam("comments") String comments,@RequestParam("petId") int petId) throws SQLException {
		HttpSession session = request.getSession();
		ModelAndView map = null;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if(session.getAttribute("userId")!=null)
		{
			HeadBean petBean=headService.searchById(petId);

			petBean.setApplicationStatus("Rejected");
			petBean.setComments(comments);
			headService.save(petBean);
			String msg = "Pet registered with id "+petBean.getPetId()+"has been rejected.";
			boolean status = smsApiIntegrationService.smsCallService(petBean.getMobileNo(), msg);
			map= new ModelAndView("approve-pet");
			map.addObject("testingErrorMsg","Application has been rejected successfully.");
	
		}
		return map;
		
	}
	
	@RequestMapping(value = {"/send-back-pet"})
	@ResponseBody
	public ModelAndView sendBackPet(HttpServletRequest request,@RequestParam("comments") String comments,@RequestParam("petId") int petId) throws SQLException {
		HttpSession session = request.getSession();
		ModelAndView map = null;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if(session.getAttribute("userId")!=null)
		{
			HeadBean petBean=headService.searchById(petId);
			
			petBean.setApplicationStatus("Send back with Objections");
			petBean.setComments(comments);
			headService.save(petBean);
			String msg = "Pet registered with id "+petBean.getPetId()+"has been sent back to clerk with objections.";
			boolean status = smsApiIntegrationService.smsCallService(petBean.getMobileNo(), msg);
			map= new ModelAndView("approve-pet");
			map.addObject("testingErrorMsg","Application has been sent back to clerk successfully");
	
		}
		return map;
		
	}
	
	public String generateRegistrationNumber(HeadBean response) throws SQLException {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		@SuppressWarnings("deprecation")
		String currentDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH);
		String sequenceNumber = null;
		/*
		 * try { sequenceNumber = String.format("%06d",
		 * databaseSequenceProvider.getNextSequence(APP_NUMBER_SEQ_PREFIX)); } catch
		 * (SQLGrammarException e) {
		 * 
		 * databaseSequenceCreator.createSequence(APP_NUMBER_SEQ_PREFIX); sequenceNumber
		 * = String.format("%06d",
		 * databaseSequenceProvider.getNextSequence(APP_NUMBER_SEQ_PREFIX));
		 * 
		 * }
		 */
		sequenceNumber = String.format("%06d", response.getPetId());
		String ulbName=response.getDistrictBean().getDistrictName();
		return String.format(APP_NUMBER_FORMAT, currentDate,ulbName, sequenceNumber);
	}

	
	public String generateReceiptNumber(FeeBean response,HeadBean headBean) throws SQLException {
		int y = Year.now().getValue();
		String currentYear = (y + "-" + (y + 1)).toString();
		String ulbCode = headBean.getDistrictBean().getDistrictName();
				String sequenceNumber = null;
				
		List<FeeBean> fees=feeService.searchByPetId(headBean.getPetId());	
		if(fees.isEmpty())
		sequenceNumber = String.format("%06d", 1);
		else
		sequenceNumber = String.format("%06d", fees.size()+1);
		return String.format(RECEIPT_NUMBER_FORMAT_MONTHLY, ulbCode,currentYear,headBean.getPetId(),sequenceNumber);
		
	}
		@GetMapping(value = "/getAttachedDocuments/{picType}")
		@ResponseBody
		public void getAttachedDocument( @RequestParam("pet_id") int pet_id,@PathVariable("picType") String picType,HttpServletRequest request, HttpServletResponse response) throws IOException {
			HeadBean headBean = headService.searchById(pet_id);
			String pathimg=null;
			if(headBean.getDefectPic().contains(picType))
				pathimg=headBean.getDefectPic();
			else if(headBean.getCertificatePic().contains(picType))
				pathimg=headBean.getCertificatePic(); 
			else if(headBean.getFrontPic().contains(picType))
				pathimg=headBean.getFrontPic();
			else if(headBean.getBackPic().contains(picType))
				pathimg=headBean.getBackPic();
			else if(headBean.getRightPic().contains(picType))
				pathimg=headBean.getRightPic();
			else if(headBean.getLeftPic().contains(picType))
				pathimg=headBean.getLeftPic();
			else if(headBean.getOwnerPic().contains(picType))
				pathimg=headBean.getOwnerPic();
				response.setContentType("image/jpeg");
					Path path= Paths.get(pathimg);
					String pathToWeb = path.toString();
					File f = new File(pathToWeb);
					BufferedImage bi = ImageIO.read(f);
					OutputStream out = response.getOutputStream();
					ImageIO.write(bi, "jpg", out);
					out.close();
			
		
	}
		
	
		@SuppressWarnings("deprecation")
		@GetMapping(value = "/search_fee")
		@ResponseBody
		public List<FeeBean> getMonFeeReport(HttpServletRequest request,@RequestParam("fromDate") String fromDate
				,@RequestParam("toDate") String toDate) throws IOException {
			HttpSession session = request.getSession();
			List<FeeBean> response=new ArrayList<FeeBean>();
			Date from=new Date(Integer.parseInt(fromDate.split("-")[0])-1900, Integer.parseInt(fromDate.split("-")[1])-1, Integer.parseInt(fromDate.split("-")[2]));
			Date to=new Date(Integer.parseInt(toDate.split("-")[0])-1900, Integer.parseInt(toDate.split("-")[1])-1, Integer.parseInt(toDate.split("-")[2])); 
			if(session.getAttribute("userId")!=null)
			{
			UserBean employeeBean = userService.searchById((int)session.getAttribute("userId"));
		
				List<FeeBean> m=feeService.getAllPayments(employeeBean.getDistrictBean().getDistrictCode());
				for(FeeBean m1:m)
				{
				String s=m1.getReceiptDate();
				Date rd=new Date(Integer.parseInt(s.split("-")[0])-1900, Integer.parseInt(s.split("-")[1])-1, Integer.parseInt(s.split("-")[2]));

				if((rd.after(from) && rd.before(to)) || rd.equals(from) || rd.equals(to))
				{
					response.add(m1);
				}
				}
			}
			
			
			return response;
			
		
		}
		
		@RequestMapping(value = {"/ccavRequestHandler" })
		@ResponseBody
		public ModelAndView ccavRequestHandler(HttpServletRequest request,@RequestParam("petId") int petId,@RequestParam("amount") String amount,
				@RequestParam("order_id") String order_id,@RequestParam("merchant_id") String merchant_id
				,@RequestParam("tid") String tid) {
			ModelAndView map = new ModelAndView("ccavRequestHandler");
			HttpSession session = request.getSession();
			HeadBean h=headService.searchById(petId);
				map.addObject("pet", h);
				map.addObject("userType", 9);
				return map;
		}
		
		@RequestMapping(value = {"/ccavResponseHandler"})
		@ResponseBody
		public ModelAndView ccavResponseHandler(HttpServletRequest request) {
			ModelAndView map = new ModelAndView("ccavResponseHandler");
			HttpSession session = request.getSession();
				map.addObject("userType", 9);

				return map;
		}
		
		
		@RequestMapping(value = {"/report-fee" })
		public ModelAndView reportFee(Model model,HttpServletRequest request) throws Exception {
			HttpSession session = request.getSession();
		
			if(session.getAttribute("userId")!=null)
			{
				ModelAndView map = new ModelAndView("report-fee");
				map.addObject("usersType", "STAFF");
				return map;
			}
			else
			{
			
			return new ModelAndView("login");
		}
		}
		
		@RequestMapping(value = {"/collect-feeonlinesave"})
		@ResponseBody
		public ModelAndView collectFeeOnlineSave(HttpServletRequest request) throws SQLException {
			HttpSession session = request.getSession();
			ModelAndView map ;
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String rr_orderId=session.getAttribute("order_id").toString();
			String rr_statusMessage=session.getAttribute("status_message").toString();
			String rr_orderStatus=session.getAttribute("order_status").toString();
			String rr_transDate=session.getAttribute("trans_date").toString();
			String rr_bankRefNo=session.getAttribute("bank_ref_no").toString();
			String rr_paymentMode=session.getAttribute("payment_mode").toString();
			String rr_trackingId=session.getAttribute("tracking_id").toString();
			String rr_cardName=session.getAttribute("card_name").toString();
			String rr_amount=session.getAttribute("amount").toString();

			
			int petId=Integer.parseInt(rr_orderId.split("-")[1]);
			List<FeeBean> feeBean=feeService.searchbyorder(petId,"Routed for payment");
			HeadBean pet=headService.searchById(petId);
			List<FeeBean> tracking_idd=feeService.getTrackingId(rr_trackingId);
			List<FeeBean> order_idd=feeService.getOrderId(rr_orderId,"Completed");
			// to check uniqueness of order_id

			if(rr_orderStatus.equals("Success") && feeBean!=null && tracking_idd.size()==0 && order_idd.size()==0 && rr_orderId.equals(session.getAttribute("s_order_id").toString()))
			{
				
				String receiptNumber = generateReceiptNumber(feeBean.get(0),pet);
				feeBean.get(0).setReceiptNumber(receiptNumber);
				feeBean.get(0).setOrderId(rr_orderId);
				feeBean.get(0).setAmount(Integer.parseInt((rr_amount.split("\\."))[0]));
				feeBean.get(0).setBankRefNo(rr_bankRefNo);
				feeBean.get(0).setCardName(rr_cardName);
				feeBean.get(0).setOrderStatus(rr_orderStatus);
				feeBean.get(0).setTrackingId(rr_trackingId);
				feeBean.get(0).setPaymentMode(rr_paymentMode);
				feeBean.get(0).setTransDate(rr_transDate);
				feeBean.get(0).setStatusMessage(rr_statusMessage);
				feeBean.get(0).setReceiptDate(String.format(DATE_FORMAT, calendar.get(Calendar.YEAR),
						calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
				feeBean.get(0).setStatus("Completed");
				feeService.save(feeBean.get(0));
				pet.setFee("Yes");
				pet.setApplicationStatus("Fee Received.Pending for Approval.");
				headService.save(pet);
				String msg = "Registration Fee for Pet registered with id "+pet.getPetId()+"has been paid successfully.";
				boolean status = smsApiIntegrationService.smsCallService(pet.getMobileNo(), msg);
				map= new ModelAndView("payment-success");
				map.addObject("pet",pet);
				map.addObject("fee",feeBean.get(0));
			
			return map;
			}
			else
			{
				feeBean.get(0).setBankRefNo(rr_bankRefNo);
				feeBean.get(0).setCardName(rr_cardName);
				feeBean.get(0).setOrderId(rr_orderId);
				feeBean.get(0).setAmount(Integer.parseInt((rr_amount.split("\\."))[0]));
				feeBean.get(0).setOrderStatus(rr_orderStatus);
				feeBean.get(0).setTrackingId(rr_trackingId);
				feeBean.get(0).setPaymentMode(rr_paymentMode);
				feeBean.get(0).setTransDate(rr_transDate);
				feeBean.get(0).setStatusMessage(rr_statusMessage);
			feeBean.get(0).setStatus("Failed");
			feeService.save(feeBean.get(0));
			String msg = "Registration Fee payment for Pet registered with id "+pet.getPetId()+"has failed with mesage ."+rr_orderStatus;
			boolean status = smsApiIntegrationService.smsCallService(pet.getMobileNo(), msg);
				map= new ModelAndView("payment-fail");
				map.addObject("pet",pet);
				map.addObject("fee",feeBean);
				return map;
			}
			
		}
		

			

}
	