package com.covid.mis.controller;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JLabel;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.covid.mis.SendSms;
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
import com.covid.mis.repository.PaymentRepository;
import com.covid.mis.repository.ULBRepository;
import com.covid.mis.repository.UserRepository;
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
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
public class CovidMisController {
	private static final String RECEIPT_NUMBER_FORMAT_MONTHLY = "PL/%s/%s/%s/%s";
		private static final String APP_NUMBER_FORMAT = "PL/%s/%s/%s";
	private static final String DATE_FORMAT = "%02d-%02d-%04d";
    private static final Logger LOGGER = Logger.getLogger(CovidMisController.class);
    private static final Charset UTF_8 = StandardCharsets.UTF_8;
    private static final String OUTPUT_FORMAT = "%-20s:%s";


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
	PaymentRepository paymentrepository;
	
	@Autowired
	ULBRepository ulbrepository;
	
	@Autowired
	UserRepository userRepository;
	
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
	

	    private static byte[] digest(byte[] input) {
	        MessageDigest md;
	        try {
	            md = MessageDigest.getInstance("MD5");
	        } catch (NoSuchAlgorithmException e) {
	            throw new IllegalArgumentException(e);
	        }
	        byte[] result = md.digest(input);
	        return result;
	    }

	    private static String bytesToHex(byte[] bytes) {
	        StringBuilder sb = new StringBuilder();
	        for (byte b : bytes) {
	            sb.append(String.format("%02x", b));
	        }
	        return sb.toString();
	    }
	@ResponseBody
	@RequestMapping(value = {"/admin-login" })
	public ModelAndView Adminindex(@RequestParam("mobile") String mobile,@RequestParam("password") String password, HttpServletRequest request) {
		ModelAndView map = new ModelAndView("dashboard");
		ModelAndView lgmap = new ModelAndView("login");
		HttpSession session = request.getSession();
		UserBean user = null;
		byte[] md5InBytes = digest(password.getBytes(UTF_8));
		String passwordEncrypted= String.format(bytesToHex(md5InBytes));
		//long totalTestingRecords,totalCovidPRecords;
		try {
		//user = userService.getUserDatabyMobilePass(mobile,password);
		user = userService.getUserDatabyMobilePass(mobile,passwordEncrypted);

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
//			String msg = "Password has been reset to  " + label.getText();
//			smsApiIntegrationService.smsCallService(employeeBean.getMobileNumber(), msg,"");
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
//	  String msg = "OTP to reset password for your login is " +otp; 
//	  smsApiIntegrationService.smsCallService(mobileNo,msg,"");
	  
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
		public List<TypeBean> getType(@RequestParam("category") int category) {
		List<TypeBean> typeList=null;
		try {
			typeList = typeService.getType(category);
			return typeList;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return typeList;
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
	public ModelAndView saveTestingData(HttpServletRequest request,@ModelAttribute("petBean") HeadBean headBean, 
			@RequestParam("defectPicPP") MultipartFile defectPicPP,	@RequestParam("certificateFrontPicPP") MultipartFile certificateFrontPicPP,@RequestParam("certificateBackPicPP") MultipartFile certificateBackPicPP,
			@RequestParam("frontPicPP") MultipartFile frontPicPP,@RequestParam("ownerPicPP") MultipartFile ownerPicPP,@RequestParam("idproofownerPPFront") MultipartFile idproofownerPPFront,@RequestParam("idproofownerPPBack") MultipartFile idproofownerPPBack,@RequestParam("fitnesscertificatePP") MultipartFile fitnesscertificatePP,@RequestParam("usersType") String usersType){
		HttpSession session = request.getSession();
		ModelAndView map =null;
		
		if(usersType.equals("STAFF") && session.getAttribute("userId")!=null || usersType.equals("CITIZEN"))
			{
				List<MultipartFile> attachedfiles =  new ArrayList<>(0);
				attachedfiles.add(defectPicPP);
				attachedfiles.add(certificateFrontPicPP);
				attachedfiles.add(certificateBackPicPP);

				if(frontPicPP!=null)
				{
					attachedfiles.add(frontPicPP);

				}
//				if(backPicPP!=null)
//				{
//					attachedfiles.add(backPicPP);
//
//				}
//				if(leftPicPP!=null)
//				{
//					attachedfiles.add(leftPicPP);
//
//				}
//				if(rightPicPP!=null)
//				{
//					attachedfiles.add(rightPicPP);
//
//				}
				
				if(ownerPicPP!=null)
				{
					attachedfiles.add(ownerPicPP);

				}
				if(idproofownerPPFront!=null)
				{
					attachedfiles.add(idproofownerPPFront);

				}
				if(idproofownerPPBack!=null)
				{
					attachedfiles.add(idproofownerPPBack);

				}
				if(fitnesscertificatePP!=null)
				{
					attachedfiles.add(fitnesscertificatePP);

				}
				if(headBean.getFee()=="Yes")
					headBean.setApplicationStatus("Fee Received.Pending for Inspection.");
				else
					headBean.setApplicationStatus("Applied");
				
				headBean.setMode(usersType);
				Date date = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				String[] imageType = { "DEFECT", "CERTIFICATE","CERTIFICATEBACK","FRONT","OWNER","ID","IDBACK","FITNESS"};
				headBean.setDateOfApplication(String.format(DATE_FORMAT, calendar.get(Calendar.DAY_OF_MONTH),
						calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)));
				
				if(usersType.equals("STAFF"))
				{
					UserBean u=userService.searchById((int)session.getAttribute("userId"));
					headBean.setDistrictBean(u.getDistrictBean());
					headBean.setUlbBean(u.getUlbBean());
				}
				HeadBean savedHeadBean=headService.save(headBean);
				 int index = 0;
				 String imgPath=null;
					for (MultipartFile file : attachedfiles) {
						if (file == null || file.getSize() == 0) {

						} else {
							try {
								byte[] bytes = null;
								String ext = null;
								String name = null;
								
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
									savedHeadBean.setCertificateBackPic(path.toString());
								}
								else if(index==3)
								{
									savedHeadBean.setFrontPic(path.toString());

								}
//								else if(index==3)
//								{
//									savedHeadBean.setBackPic(path.toString());
//
//								}
//								else if(index==4)
//								{
//									savedHeadBean.setLeftPic(path.toString());
//
//								}
//								else if(index==5)
//								{
//									savedHeadBean.setRightPic(path.toString());
//
//								}
								else if(index==4)
								{
									savedHeadBean.setOwnerPic(path.toString());

								}
								else if(index==5)
								{
									savedHeadBean.setIdproofowner(path.toString());
								

								}
								else if(index==6)
								{
									savedHeadBean.setIdproofownerBack(path.toString());

								}
								else if(index==7)
								{
									savedHeadBean.setFitnesscertificate(path.toString());

								}
							
								Files.write(path, bytes);

							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
						index++;
					}
					
				headService.save(savedHeadBean);
			
			if(savedHeadBean.getPetId()>0)
			{
				map= collectFeeInt(savedHeadBean.getPetId());
				String msg = "Dear "+savedHeadBean.getHeadName()+", Application for Pet License has been received-Pet Id is "+savedHeadBean.getPetId()+" . Thanks";
				String template_id="1407163938742408568";
				//smsApiIntegrationService.smsCallService(savedHeadBean.getMobileNo(), msg,template_id);
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
			@RequestParam("defectPicPP") MultipartFile defectPicPP,	@RequestParam("certificateFrontPicPP") MultipartFile certificateFrontPicPP,@RequestParam("certificateBackPicPP") MultipartFile certificateBackPicPP,
			@RequestParam("frontPicPP") MultipartFile frontPicPP,@RequestParam("ownerPicPP") MultipartFile ownerPicPP,@RequestParam("idproofownerPPFront") MultipartFile idproofownerPPFront,@RequestParam("idproofownerPPBack") MultipartFile idproofownerPPBack,@RequestParam("fitnesscertificatePP") MultipartFile fitnesscertificatePP) {
		HttpSession session = request.getSession();
		ModelAndView map = null;

		if(session.getAttribute("userId")!=null)
			
		{
			petBean.setPetId(petId);
			HeadBean savedBean=headService.searchById(petId);
			List<MultipartFile> attachedfiles =  new ArrayList<>(0);
			attachedfiles.add(defectPicPP);
			attachedfiles.add(certificateFrontPicPP);
			attachedfiles.add(certificateBackPicPP);
            attachedfiles.add(frontPicPP);
			attachedfiles.add(ownerPicPP);
			attachedfiles.add(idproofownerPPFront);
			attachedfiles.add(idproofownerPPBack);
			attachedfiles.add(fitnesscertificatePP);

			
			if(defectPicPP==null || defectPicPP.getSize() == 0)
			{
				petBean.setDefectPic(savedBean.getDefectPic());
			}
			if(certificateFrontPicPP==null || certificateFrontPicPP.getSize() == 0)
			{
				petBean.setCertificatePic(savedBean.getCertificatePic());
			}
			if(certificateBackPicPP==null || certificateBackPicPP.getSize() == 0)
			{
				petBean.setCertificateBackPic(savedBean.getCertificateBackPic());
			}

			if(frontPicPP==null || frontPicPP.getSize() == 0)
			{
				petBean.setFrontPic(savedBean.getFrontPic());
			}
					
			if(ownerPicPP==null || ownerPicPP.getSize()==0)
			{
				petBean.setOwnerPic(savedBean.getOwnerPic());
			}
			if(idproofownerPPFront==null || idproofownerPPFront.getSize() == 0)
			{
				petBean.setIdproofowner(savedBean.getIdproofowner());
			}
			if(idproofownerPPBack==null || idproofownerPPBack.getSize() == 0)
			{
				petBean.setIdproofownerBack(savedBean.getIdproofownerBack());
			}
			
			if(fitnesscertificatePP==null || fitnesscertificatePP.getSize() == 0)
			{
				petBean.setFitnesscertificate(savedBean.getFitnesscertificate());
			}
			
			Date date = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			String[] imageType = { "DEFECT", "CERTIFICATE","CERTIFICATEBACK","FRONT","OWNER","ID","IDBACK","FITNESS"};
			int index = 0;
			 String imgPath=null;
				for (MultipartFile file : attachedfiles) {
					if (file == null || file.getSize() == 0) {

					} else {
						try {
							byte[] bytes = null;
							String ext = null;
							String name = null;
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
								petBean.setCertificateBackPic(path.toString());
							}
							else if(index==3)
							{
								petBean.setFrontPic(path.toString());

							}
							else if(index==4)
							{
								petBean.setOwnerPic(path.toString());

							}
							else if(index==5)
							{
								petBean.setIdproofowner(path.toString());

							}
							else if(index==6)
							{
								petBean.setIdproofownerBack(path.toString());

							}
							else if(index==7)
							{
								petBean.setFitnesscertificate(path.toString());

							}
							Files.write(path, bytes);

						} catch (IOException e) {
							e.printStackTrace();
						}

					}
					index++;

				}

			if(savedBean.getApplicationStatus().equals("Sent back with Objections") && savedBean.getFee().equals("No"))
				petBean.setApplicationStatus("Applied");
			else if(savedBean.getApplicationStatus().contentEquals("Sent back with Objections") && savedBean.getFee().contentEquals("Yes"))
				petBean.setApplicationStatus("Fee Received.Pending for Inspection.");
			petBean.setMode(savedBean.getMode());
			petBean.setFee(savedBean.getFee());
			petBean.setUsersType(savedBean.getUsersType());
			petBean.setDateOfApplication(savedBean.getDateOfApplication());
			headService.save(petBean);
			map= new ModelAndView("edit-details");

			//Send SMS after new Registration 
			SendSms.sendSms("Thank you for Edit details...."+new Date().toLocaleString(),savedBean.getMobileNo());
			//Send SMS after new Registration 
			
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
			else if(userType==3)
			{
				if(name!="" && fatherName =="" && locality=="")
					headDataList=headService.searchByNameForInspection(name,ulb);
				else if(name=="" && fatherName !="" && locality=="")
					headDataList=headService.searchByFatherNameForInspection(fatherName,ulb);
				else if(name=="" && fatherName =="" && locality!="")
					headDataList=headService.searchByLocalityForInspection(locality,ulb);
				else if(name!="" && fatherName =="" && locality!="")
					headDataList=headService.searchByNameandLocalityForInspection(name,locality,ulb);
				else if(name!="" && fatherName !="" && locality=="")
					headDataList=headService.searchByNameandFatherNameForInspection(name,fatherName,ulb);
				else if(name=="" && fatherName !="" && locality!="")
					headDataList=headService.searchByFatherNameandLocalityForInspection(fatherName ,locality,ulb);
				else if(name!="" && fatherName !="" && locality!="")
					headDataList=headService.searchByAllParametersForInspection(name,fatherName,locality,ulb);
				else
					headDataList=headService.searchAllForInspection(district,ulb);
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
	
	public ModelAndView collectFeeInt(int petId) {
		ModelAndView map = new ModelAndView("collect-fee");
		HeadBean h=headService.searchById(petId);
		map.addObject("pet", h);
	return map;
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
	public ModelAndView collectFeeeOnline(HttpServletRequest request,@RequestParam("petId") int petId){
		ModelAndView map = new ModelAndView("collect-fee-online");
		HttpSession session = request.getSession();
		HeadBean h=headService.searchById(petId);
		map.addObject("pet", h);
		map.addObject("userType", 9);
		session.setAttribute("amount", h.getUlbBean().getRegFee());
		session.setAttribute("s_order_id", "REG-"+h.getPetId());
		return map;
		}
	
	
	
	
	//creating order for payment
	@RequestMapping(value = {"/create_order"})
	@ResponseBody
	public String createOrder(@RequestBody Map<String, Object> data, Principal principal, HttpServletRequest request) throws Exception{
		System.out.println("Hey order Function excuted +++++++++++++++");
		System.out.println(data);  
		int amt = Integer.parseInt(data.get("amount").toString());
		int petId = Integer.parseInt(data.get("paymentpetid").toString());
		int ulbcode = Integer.parseInt(data.get("ulbcode").toString());
		RazorpayClient razorpay = new RazorpayClient("rzp_live_H2n9kGeN5lFKnU", "dCq9sPlSVvLpvz4D9QbfdShj");
//		RazorpayClient razorpay = new RazorpayClient("rzp_test_S4AA2WsFm8nw35", "puQMReguttIfiwrlv6gjEqT9");

		ULBBean ulbBean=ulbService.getUlbByCode(ulbcode);
		String accountNumber=ulbBean.getAccountNumber();
		//Creating new order
		HeadBean pet=new HeadBean();
		pet=headService.searchById(petId);

		
		JSONObject orderRequest = new JSONObject();
		orderRequest.put("amount",  +amt*100);
		orderRequest.put("payment_capture", "1");
		orderRequest.put("currency", "INR");
		JSONArray transfers = new JSONArray();
		JSONObject transfer = new JSONObject();
		transfer.put("amount",  +amt*100);
		transfer.put("currency", "INR");
		transfer.put("account", accountNumber);
		JSONObject notesData=new JSONObject();
        notesData.put("petId",petId);
        notesData.put("ulb",ulbBean.getUlbName());
        orderRequest.put("notes", notesData);
     	transfers.put(transfer);
     	orderRequest.put("transfers", transfers);
		FeeBean feeBean=new FeeBean();
		String receiptNumber = generateReceiptNumber(feeBean,pet);
		orderRequest.put("receipt", receiptNumber);

		Order order = razorpay.Orders.create(orderRequest);
		System.out.println(order);
		System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
		
		//save the order in database
			
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Integer s=(Integer.parseInt(order.get("amount").toString())/100);
		//String amm=String.valueOf(s);
		feeBean.setAmount(s);
		feeBean.setHeadBean(pet);
		feeBean.setReceiptNumber(receiptNumber);
		feeBean.setMode("ONLINE");
		feeBean.setStatus(order.get("status"));
		feeBean.setOrderId(order.get("id"));
		feeBean.setReceiptDate(String.format(DATE_FORMAT, calendar.get(Calendar.DAY_OF_MONTH),
				calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)));
		feeBean.setTransDate(new Date());
		feeBean.setUserBean(null);
		feeBean.setPaymentId(order.get(null));
		feeBean.setPurpose("Registration Fee");
		feeService.save(feeBean);
		//this.paymentrepository.save(paymentbean);
		
		//if you want you can save this to your data
		
		return order.toString();
		
	}
	
	@RequestMapping(value = {"/update_order"})
	@ResponseBody
	public ModelAndView updateOrder(@RequestBody Map<String, Object> data)
	{
		ModelAndView map = null;
		System.out.println("fjhfhfghfghfhUUUUUUUUUUUUUUUUUUUUUU");
		System.out.println(data);
		RazorpayClient razorpay = null;
		Order order=null;
		try {
			razorpay = new RazorpayClient("rzp_live_H2n9kGeN5lFKnU", "dCq9sPlSVvLpvz4D9QbfdShj");
//			razorpay = new RazorpayClient("rzp_test_S4AA2WsFm8nw35", "puQMReguttIfiwrlv6gjEqT9");

		} catch (RazorpayException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
			order = razorpay.Orders.fetch(data.get("order_id").toString());
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(order);


		JSONObject note=new JSONObject();
		note=order.get("notes");
		int petId=0;
		try {
			petId = Integer.parseInt(note.get("petId").toString());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HeadBean pet=new HeadBean();
		pet=headService.searchById(petId);
		FeeBean myorder=feeService.findByOrderId(data.get("order_id").toString());
		
		myorder.setPaymentId(data.get("payment_id").toString());
		myorder.setStatus(order.get("status").toString());
		if(order.get("status").toString().equalsIgnoreCase("paid") || order.get("status").toString().equalsIgnoreCase("captured")) {
		pet.setFee("Yes");
		pet.setApplicationStatus("Fee Received.Pending for Inspection.");
		headService.save(pet);
		map= new ModelAndView("payment-success");
		map.addObject("pet",myorder.getHeadBean());
		map.addObject("fee",myorder);
		map.addObject("purpose","save");

		
		}
		else
		{
			map.addObject("pet",myorder.getHeadBean());
			map.addObject("fee",myorder);
		map= new ModelAndView("payment-fail");	
		}
		
		feeService.save(myorder);
		
		
		
		return map;
		//return "redirect:/pet-license/collect-fee-online-search";
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

	
	
	@RequestMapping(value = {"/forward-application" })
	@ResponseBody
	public ModelAndView forwardPet(HttpServletRequest request,@RequestParam("petId") int petId) {
		ModelAndView map = new ModelAndView("forward-pet");
		HttpSession session = request.getSession();
		if(session.getAttribute("userId")!=null)
		{	HeadBean h=headService.searchById(petId);
			map.addObject("pet", h);
			map.addObject("testingErrorMsg", "");
			return map;
		}
		else
		{
		
		return new ModelAndView("login");
	}
	}

	
	
	@RequestMapping(value = {"/payment-success-online" })
	@ResponseBody
	public ModelAndView paymentSuccessOnline(HttpServletRequest request,@RequestParam("order") String order) {
		ModelAndView map = new ModelAndView("payment-success");
		FeeBean myorder=feeService.findByOrderId(order);
		map.addObject("pet",myorder.getHeadBean());
		map.addObject("fee",myorder);
		return map;
	}
	
	@RequestMapping(value = {"/collect-feesave"})
	@ResponseBody
	public ModelAndView collectFeeSave(HttpServletRequest request, @ModelAttribute("feeBean") FeeBean feeBean,@RequestParam("petId") int petId,@RequestParam("userType") int userType) throws SQLException {
		HttpSession session = request.getSession();
		ModelAndView map = null;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if(session.getAttribute("userId")!=null && userType<=3)
		{
			HeadBean pet=headService.searchById(petId);

			String receiptNumber = generateReceiptNumber(feeBean,pet);
			feeBean.setHeadBean(pet);
			feeBean.setReceiptNumber(receiptNumber);
			feeBean.setMode("COUNTER");
			feeBean.setStatus("paid");
			feeBean.setOrderId((String)pet.getPetId().toString());
			feeBean.setReceiptDate(String.format(DATE_FORMAT, calendar.get(Calendar.DAY_OF_MONTH),
					calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)));
			feeBean.setUserBean(userService.searchById((int)session.getAttribute("userId")));
			feeService.save(feeBean);
			pet.setFee("Yes");
			pet.setApplicationStatus("Fee Received.Pending for Inspection.");
			headService.save(pet);
			map= new ModelAndView("payment-success");
			map.addObject("pet",feeBean.getHeadBean());
			map.addObject("fee",feeBean);
			map.addObject("purpose","save");

			String msg ="Dear "+feeBean.getHeadBean().getHeadName()+", Registration fee of Rs. "+feeBean.getAmount()+" for Pet Id "+feeBean.getHeadBean().getPetId()+" has been received successfully. PMIDC";

			//smsApiIntegrationService.smsCallService(feeBean.getHeadBean().getMobileNo(), msg,"1407163938791927273");


			
		}
		else
		{
			map=new ModelAndView("login");
			
		}
		
		return map;
		
	}
	
	@RequestMapping(value = {"/download-receipt"})
	@ResponseBody
	public ModelAndView downloadReceipt(HttpServletRequest request, @RequestParam("petId") int petId) throws SQLException {
		HttpSession session = request.getSession();
		ModelAndView map = null;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if(session.getAttribute("userId")!=null)
		{
			HeadBean pet=headService.searchById(petId);
			List<FeeBean> feeBean=feeService.searchbyorder(petId,"paid");
			map = new ModelAndView("payment-success");
			map.addObject("pet",pet);
			map.addObject("fee",feeBean.get(0));
			map.addObject("purpose","print");
		
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
		int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		int CurrentMonth = (Calendar.getInstance().get(Calendar.MONTH)+1);
		
		String financiyalYearTo="";
		if (CurrentMonth<4) {
		    financiyalYearTo="31-03-"+(CurrentYear);
		} else {
		    financiyalYearTo="31-03-"+(CurrentYear+1);
		}
		if(session.getAttribute("userId")!=null)
		{
			HeadBean petBean=headService.searchById(petId);
			petBean.setRegistrationNumber(generateRegistrationNumber(petBean));
			petBean.setTokenNo(generateTokenNumber(petBean));
			petBean.setApplicationStatus("Approved");
			petBean.setDateOfApproval(String.format(DATE_FORMAT, calendar.get(Calendar.DAY_OF_MONTH),
					calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR)));
			petBean.setComments(comments);
			petBean.setValidUpto(financiyalYearTo);
			headService.save(petBean);
			String msg = "Dear "+petBean.getHeadName()+", Application with Pet Id "+petBean.getPetId()+" has been approved successfully. PMIDC";
			//smsApiIntegrationService.smsCallService(petBean.getMobileNo(), msg,"1407163938755834326");
			map= new ModelAndView("approve-success");
			map.addObject("pet",petBean);
	
		}
		return map;
		
	}
	@RequestMapping(value = {"/forward-petsave"})
	@ResponseBody
	public ModelAndView forwardpetsave(HttpServletRequest request,@RequestParam("comments") String comments,@RequestParam("petId") int petId) throws SQLException {
		HttpSession session = request.getSession();
		ModelAndView map = null;
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		if(session.getAttribute("userId")!=null)
		{
			HeadBean petBean=headService.searchById(petId);
			petBean.setApplicationStatus("Inspection Done.Pending for Approval.");
			petBean.setComments(comments);
			headService.save(petBean);
//			String msg = "Pet registered with id "+petBean.getPetId()+"has been forwarded successfully.";
//			smsApiIntegrationService.smsCallService(petBean.getMobileNo(), msg,"");
			map= new ModelAndView("forward-pet");
			map.addObject("testingErrorMsg","Application has been forwarded successfully.");
	
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
//			String msg = "Pet registered with id "+petBean.getPetId()+"has been rejected.";
//			smsApiIntegrationService.smsCallService(petBean.getMobileNo(), msg,"");
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
			
			petBean.setApplicationStatus("Sent back with Objections");
			petBean.setComments(comments);
			headService.save(petBean);
			String msg = "Dear "+petBean.getHeadName()+", Application for Pet License with Pet I'd "+petBean.getPetId()+" has been sent back with objections. Please visit concerned office. Thanks\r\n" + 
					"PMIDC";
			//smsApiIntegrationService.smsCallService(petBean.getMobileNo(), msg,"1407164446815138467");
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
		

		sequenceNumber = String.format("%06d",response.getPetId());
		String ulbName=response.getDistrictBean().getDistrictName();
		return String.format(APP_NUMBER_FORMAT, currentDate,ulbName, sequenceNumber);
	}

	
	
	public int generateTokenNumber(HeadBean response) throws SQLException {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		@SuppressWarnings("deprecation")
		String currentDate = calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH);
		int sequenceNumber = 0;
		int lastReg=0;
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
		
		List<HeadBean> list=headService.searchByULBApproved(response.getUlbBean().getUlbCode(),"Approved");
		if(!list.isEmpty())
		{
			lastReg=list.get(0).getTokenNo();
			sequenceNumber =lastReg+1;
		}
		else
			sequenceNumber = 1;
		return sequenceNumber;
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
			if(headBean.getDefectPic()!=null && headBean.getDefectPic().contains(picType))
				pathimg=headBean.getDefectPic();
			else if(headBean.getCertificatePic() !=null && headBean.getCertificatePic().contains(picType))
				pathimg=headBean.getCertificatePic(); 
			else if(headBean.getCertificateBackPic() !=null && headBean.getCertificateBackPic().contains(picType))
				pathimg=headBean.getCertificateBackPic();
			else if(headBean.getFrontPic()!=null && headBean.getFrontPic().contains(picType))
				pathimg=headBean.getFrontPic();
			else if(headBean.getBackPic()!=null && headBean.getBackPic().contains(picType))
				pathimg=headBean.getBackPic();
			else if(headBean.getRightPic()!=null && headBean.getRightPic().contains(picType))
				pathimg=headBean.getRightPic();
			else if(headBean.getLeftPic()!=null && headBean.getLeftPic().contains(picType))
				pathimg=headBean.getLeftPic();
			else if(headBean.getOwnerPic() !=null && headBean.getOwnerPic().contains(picType))
				pathimg=headBean.getOwnerPic();
			else if(headBean.getIdproofowner()!=null && headBean.getIdproofowner().contains(picType))
				pathimg=headBean.getIdproofowner();
			else if(headBean.getIdproofownerBack()!=null && headBean.getIdproofownerBack().contains(picType))
				pathimg=headBean.getIdproofownerBack();
			else if(headBean.getFitnesscertificate()!=null && headBean.getFitnesscertificate().contains(picType))
				pathimg=headBean.getFitnesscertificate();
			if(pathimg !=null) {
				response.setContentType("image/jpeg");
					Path path= Paths.get(pathimg);
					String pathToWeb = path.toString();
					File f = new File(pathToWeb);
					BufferedImage bi = ImageIO.read(f);
					OutputStream out = response.getOutputStream();
					ImageIO.write(bi, "jpg", out);
					out.close();
			}
		
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
				Date rd=new Date(Integer.parseInt(s.split("-")[2])-1900, Integer.parseInt(s.split("-")[1])-1, Integer.parseInt(s.split("-")[0]));

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
		@Scheduled(fixedRate  =21600000)
		@RequestMapping(value = {"/reconcile" })
		public void reconcile() {
			System.out.println("Started Reconcilation");

			   final Calendar threeDaysBackCalender = Calendar.getInstance();
		        threeDaysBackCalender.add(Calendar.DATE, -30);
		        final Calendar cal = Calendar.getInstance();
		        cal.add(Calendar.MINUTE, -30);
		        Date date=new Date(cal.getTimeInMillis());
				 List<FeeBean> reconcileList = feeService.getPendingOrders(date);
				 System.out.println(reconcileList);
			
			reconcileList=runReconcilation(reconcileList);
			for(FeeBean fee:reconcileList)
			{
				if(fee.getStatus()=="paid")
				{
				fee.getHeadBean().setFee("Yes");
				fee.getHeadBean().setApplicationStatus("Fee Received.Pending for Inspection.");
				headService.save(fee.getHeadBean());
				}
				feeService.save(fee);
			}
			System.out.println("Ended Reconcilation");
		}
		
		
		
	
		public FeeBean createOfflinePaymentRequest(final FeeBean onlinePayment) throws Exception {//EgwStatus [id=57, moduletype=OnlinePayment, description=Pending, code=ONLINE_STATUS_PENDING]
			final LinkedHashMap<String, String> fields = new LinkedHashMap<>(0);
			 Order order = null;
			 List<Payment> ordernew = null;
			LOGGER.debug("Inside createOfflinePaymentRequest");
			String razorpayresponsemessage ,razorpayerrormessage = null ,razorpaytxnresponsecode = null;
	        RazorpayClient razorpay = null;
	        try {
	    		razorpay = new RazorpayClient("rzp_live_H2n9kGeN5lFKnU", "dCq9sPlSVvLpvz4D9QbfdShj");
			} catch (RazorpayException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				order = razorpay.Orders.fetch(onlinePayment.getOrderId().toString());
	       		ordernew = razorpay.Orders.fetchPayments(onlinePayment.getOrderId().toString());

	       		JSONObject note=new JSONObject();
	    		note=order.get("notes");
	    		int petId=0;
				petId = Integer.parseInt(note.get("petId").toString());

	       		if(ordernew.isEmpty() ||(order.get("status")).equals("created")|| (order.get("status").equals("attempted")))
	       		{
	       		 onlinePayment.setStatus("failed");
	 			}
			}
			 catch (RazorpayException e) {
			  // Handle Exception
			  System.out.println(e.getMessage());
			}

			try {
				LOGGER.info("CollectionConstants.RAZORPAY_ORDER_INFO==="+onlinePayment.getOrderId());

				if(!ordernew.isEmpty())
	       		{
			  if(ordernew.get(0).get("status").equals("failed"))
				{
				  onlinePayment.setStatus("failed");
					feeService.save(onlinePayment);

				}
				else if((ordernew.get(0).get("status").equals("captured")) || (order.get("status")).equals("paid")||(ordernew.get(0).get("status").equals("paid")))
				{
					onlinePayment.setPaymentId(ordernew.get(0).get("id").toString());
					onlinePayment.setStatus("paid");
					

				}
	       		}
		
			LOGGER.debug(
					"receiptid=" + order.get("receipt"));
		} catch (final Exception exp) {
				LOGGER.error(exp);
				throw new Exception("Exception during create offline requests" + exp.getMessage());
			}
	       		
	       		return onlinePayment;
		}

		public List<FeeBean> runReconcilation(List<FeeBean> reconcileList) {
			 LOGGER.debug("Inside reconcileRAZORPAY");
		   
	 			  if (!reconcileList.isEmpty()) {
					  try {
			                for (FeeBean onlinePaymentObj : reconcileList) {
			                	onlinePaymentObj=createOfflinePaymentRequest(onlinePaymentObj);
			                }
			                }
					  catch (final Exception ex) {
			                LOGGER.error("RAZORPAY payment reconciliation failed" + ex);
			            }
				  }
	 			  
	 			  return reconcileList;
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
		
//		@RequestMapping(value = {"/collect-feeonlinesave"})
//		@ResponseBody
//		public ModelAndView collectFeeOnlineSave(HttpServletRequest request) throws SQLException {
//			HttpSession session = request.getSession();
//			ModelAndView map ;
//			Date date = new Date();
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(date);
//			String rr_orderId=session.getAttribute("order_id").toString();
//			String rr_statusMessage=session.getAttribute("status_message").toString();
//			String rr_orderStatus=session.getAttribute("order_status").toString();
//			String rr_transDate=session.getAttribute("trans_date").toString();
//			String rr_bankRefNo=session.getAttribute("bank_ref_no").toString();
//			String rr_paymentMode=session.getAttribute("payment_mode").toString();
//			String rr_trackingId=session.getAttribute("tracking_id").toString();
//			String rr_cardName=session.getAttribute("card_name").toString();
//			String rr_amount=session.getAttribute("amount").toString();
//
//			
//			int petId=Integer.parseInt(rr_orderId.split("-")[1]);
//			List<FeeBean> feeBean=feeService.searchbyorder(petId,"Routed for payment");
//			HeadBean pet=headService.searchById(petId);
//			List<FeeBean> tracking_idd=feeService.getTrackingId(rr_trackingId);
//			List<FeeBean> order_idd=feeService.getOrderId(rr_orderId,"Completed");
//			// to check uniqueness of order_id
//
//			if(rr_orderStatus.equals("Success") && feeBean!=null && tracking_idd.size()==0 && order_idd.size()==0 && rr_orderId.equals(session.getAttribute("s_order_id").toString()))
//			{
//				
//				String receiptNumber = generateReceiptNumber(feeBean.get(0),pet);
//				feeBean.get(0).setReceiptNumber(receiptNumber);
//				feeBean.get(0).setOrderId(rr_orderId);
//				feeBean.get(0).setAmount(Integer.parseInt((rr_amount.split("\\."))[0]));
//				feeBean.get(0).setBankRefNo(rr_bankRefNo);
//				feeBean.get(0).setCardName(rr_cardName);
//				feeBean.get(0).setOrderStatus(rr_orderStatus);
//				feeBean.get(0).setTrackingId(rr_trackingId);
//				feeBean.get(0).setPaymentMode(rr_paymentMode);
//				feeBean.get(0).setTransDate(rr_transDate);
//				feeBean.get(0).setStatusMessage(rr_statusMessage);
//				feeBean.get(0).setReceiptDate(String.format(DATE_FORMAT, calendar.get(Calendar.YEAR),
//						calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH)));
//				feeBean.get(0).setStatus("Completed");
//				feeService.save(feeBean.get(0));
//				pet.setFee("Yes");
//				pet.setApplicationStatus("Fee Received.Pending for Inspection.");
//				headService.save(pet);
//				String msg = "Registration Fee for Pet registered with id "+pet.getPetId()+"has been paid successfully.";
//				boolean status = smsApiIntegrationService.smsCallService(pet.getMobileNo(), msg);
//				map= new ModelAndView("payment-success");
//				map.addObject("pet",pet);
//				map.addObject("fee",feeBean.get(0));
//			
//			return map;
//			}
//			else
//			{
//				feeBean.get(0).setBankRefNo(rr_bankRefNo);
//				feeBean.get(0).setCardName(rr_cardName);
//				feeBean.get(0).setOrderId(rr_orderId);
//				feeBean.get(0).setAmount(Integer.parseInt((rr_amount.split("\\."))[0]));
//				feeBean.get(0).setOrderStatus(rr_orderStatus);
//				feeBean.get(0).setTrackingId(rr_trackingId);
//				feeBean.get(0).setPaymentMode(rr_paymentMode);
//				feeBean.get(0).setTransDate(rr_transDate);
//				feeBean.get(0).setStatusMessage(rr_statusMessage);
//			feeBean.get(0).setStatus("Failed");
//			feeService.save(feeBean.get(0));
//			String msg = "Registration Fee payment for Pet registered with id "+pet.getPetId()+"has failed with mesage ."+rr_orderStatus;
//			boolean status = smsApiIntegrationService.smsCallService(pet.getMobileNo(), msg);
//				map= new ModelAndView("payment-fail");
//				map.addObject("pet",pet);
//				map.addObject("fee",feeBean);
//				return map;
//			}
//			
//		}
		

			

}
	