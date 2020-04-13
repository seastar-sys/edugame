package com.dimple.project.api.controller;

import com.dimple.common.constant.CommonConstant;
import com.dimple.common.utils.RedisUtils;
import com.dimple.common.utils.TokenUtils;
import com.dimple.framework.WxPay.HttpUtil;
import com.dimple.framework.WxPay.PayForUtil;
import com.dimple.framework.WxPay.WeChatConfig;
import com.dimple.framework.WxPay.XMLUtil;
import com.dimple.framework.web.controller.BaseController;
import com.dimple.framework.web.page.TableDataInfo;
import com.dimple.project.member.errorItem.entity.EduErrorItem;
import com.dimple.project.member.errorItem.service.EduErrorItemService;
import com.dimple.project.member.history.entity.EduHistory;
import com.dimple.project.member.history.service.EduHistoryService;
import com.dimple.project.member.itemBank.entity.EduItemBank;
import com.dimple.project.member.itemBank.service.EduItemBankService;
import com.dimple.project.member.order.entity.EduOrder;
import com.dimple.project.member.order.service.EduOrderService;
import com.dimple.project.member.punch.entity.EduPunch;
import com.dimple.project.member.punch.service.EduPunchService;
import com.dimple.project.member.user.entity.EduUser;
import com.dimple.project.member.user.service.EduUserService;
import com.google.code.kaptcha.Producer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.dimple.common.utils.SendSmsUtils;
import com.dimple.framework.web.domain.AjaxResult;
import org.apache.commons.lang.StringUtils;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {




  @Autowired
  StringRedisTemplate redisTemplate;


  @Resource(name = "captchaProducer")
  private Producer captchaProducer;

  @Resource(name = "captchaProducerMath")
  private Producer captchaProducerMath;

  private Logger logger = LoggerFactory.getLogger(ApiController.class);


  private static final int BLACK = 0xff000000;
  private static final int WHITE = 0xFFFFFFFF;


  @Resource
  private EduItemBankService eduItemBankService;

  @Autowired
  private EduUserService eduUserService;
  @Autowired
  private EduOrderService eduOrderService;
  @Autowired
  private EduHistoryService eduHistoryService;
  @Autowired
  private EduPunchService eduPunchService;
  @Autowired
  private EduErrorItemService eduErrorItemService;

  /***
   * 获取当前大关卡通关状态
   * @param request
   * @return
   */
  @RequestMapping("/getGradeState")
  public AjaxResult getGradeState(HttpServletRequest request) {
    AjaxResult json = new AjaxResult();
    if(!isOnle(request)){
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      int grade = Integer.parseInt(request.getParameter("Grade").trim());
      int gradeSmaill = Integer.parseInt(request.getParameter("GradeSmaill"));
      System.out.println("grade:"+grade);
      System.out.println("gradeSmaill:"+gradeSmaill);
      Map<String, Object> map =  eduHistoryService.getGradeState(user.getId(),grade,gradeSmaill);
      System.out.println(map);
      if(map!=null){
        json.put("code","0");
        json.put("msg",map.get("num"));
        return json;
      }else{
        json.put("code","0");
        json.put("msg",0);
        return json;
      }
    }else{
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
  }
  /***
   * 获取错题集
   * @param request
   * @return
   */
  @RequestMapping("/getErrorItemBank")
  public AjaxResult getErrorItemBank(HttpServletRequest request) {
    AjaxResult json = new AjaxResult();
    if(!isOnle(request)){
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      if(user.getLevels()==0){
        json.put("code","1");
        json.put("msg","您不是付费用户，暂无法获取课程信息");
        return json;
      }else{
        int Grade = Integer.parseInt(request.getParameter("Grade").trim());
        int GradeSmaill = Integer.parseInt(request.getParameter("GradeSmaill"));
        int Current = Integer.parseInt(request.getParameter("Current"));
        List<EduItemBank> list = this.eduErrorItemService.selectEduErrorItemAll(user.getId(),Grade,GradeSmaill,Current);
        if(list.size()<=0){
          json.put("code","0");
          json.put("msg","");
          return json;
        }else{
          json.put("code","0");
          json.put("msg",list);
          return json;
        }
      }
    }else{
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
  }
  /***
   * 上传学习记录
   * @param request
   * @return
   */
  @RequestMapping("/addHistory")
  public AjaxResult addHistory(HttpServletRequest request) {
    AjaxResult json = new AjaxResult();
    if(!isOnle(request)){
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      try{
        int Grade = Integer.parseInt(request.getParameter("Grade").trim());
        int GradeSmaill = Integer.parseInt(request.getParameter("GradeSmaill"));
        int Current = Integer.parseInt(request.getParameter("Current"));
        int costTime = Integer.parseInt(request.getParameter("costTime"));
        int right = Integer.parseInt(request.getParameter("right"));
        int total = Integer.parseInt(request.getParameter("total"));
        String error = request.getParameter("source");//错题集
        //添加错题之前删除错题记录
       // this.eduErrorItemService.deleteEduErrorItemList(user.getId(),Grade,GradeSmaill,Current);
        //添加错题
        if(!error.isEmpty()){
          String[] strarr = error.split(",");
          for(int i=0;i<strarr.length;i++){
            EduErrorItem e = new EduErrorItem();
            e.setUserId(user.getId());
            e.setChapter(Grade);
            e.setSection(GradeSmaill);
            e.setSubjectNumber(Current);
            e.setItemBankId(Integer.parseInt(strarr[i]));
            e.setUptime(new Date());
            this.eduErrorItemService.insertEduErrorItem(e);
          }
        }
        EduHistory eduHistory = new EduHistory();
        eduHistory.setUserId(user.getId());
        eduHistory.setChapter(Grade);
        eduHistory.setSection(GradeSmaill);
        eduHistory.setSubjectNumber(Current);
       List<EduHistory> list = eduHistoryService.selectEduHistory(eduHistory);
       if(list.size()>0){
         json.put("code","0");
         json.put("msg","您重新过关");
         return json;
       }else{
         eduHistory.setCostTime(costTime);//花费时间
         eduHistory.setTotalTime(180);//3分钟 180秒
         eduHistory.setTotalItem(total);//总题目
         eduHistory.setRightItem(right);//正确数量
         eduHistory.setUpdatTime(new Date());
         eduHistory.setStates(1);
         if(eduHistoryService.insertEduHistory(eduHistory)==1){
           json.put("code","0");
           json.put("msg","恭喜您过关");
           return json;
         }
       }
      }catch (Exception e){
        json.put("code","1");
        json.put("msg","请稍后再试！");
        return json;
      }
    }else {
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
    json.put("code","1");
    json.put("msg","请稍后再试！");
    return json;
  }

  /***
   * 获取题库
   * @param request
   * @return
   */
  @RequestMapping("/getItemBank")
  public AjaxResult getItemBank(HttpServletRequest request) {
    AjaxResult json = new AjaxResult();
    if(!isOnle(request)){
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      if(user.getLevels()==0){
        json.put("code","1");
        json.put("msg","您不是付费用户，暂无法获取课程信息");
        return json;
      }else{
        int Grade = Integer.parseInt(request.getParameter("Grade").trim());
        int GradeSmaill = Integer.parseInt(request.getParameter("GradeSmaill"));
        int Current = Integer.parseInt(request.getParameter("GradeSmaill"));
        EduItemBank eduItemBank = new EduItemBank();
        eduItemBank.setChapter(Grade);
        eduItemBank.setSection(GradeSmaill);
        eduItemBank.setSubjectNumber(Current);
        List<EduItemBank> list = this.eduItemBankService.selectEduItemBank(eduItemBank);
        if(list.size()<=0){
          json.put("code","0");
          json.put("msg","");
          return json;
        }else{
          json.put("code","0");
          json.put("msg",list);
          return json;
        }
      }
    }else{
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
  }


  /***
   * 获取学习记录
   * @param request
   * @return
   */
  @RequestMapping("/getStudy")
  public AjaxResult getStudy(HttpServletRequest request) {
    AjaxResult json = new AjaxResult();
    if(!isOnle(request)){
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      JSONObject data = new JSONObject();
      JSONArray jsonArray = new JSONArray();
      SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

      List<EduHistory> historyList = eduHistoryService.selectEduHistoryTody(user.getId());
      if(historyList.size()>0){
        for (int i=0;i<historyList.size();i++){
          EduHistory  history =  historyList.get(i);
          String s =  dateformat.format(history.getUpdatTime()) + "      "+history.getName()+"      "+history.getSubjectNumber()+"          "+history.getRightItem()+"颗          "+toHour(history.getCostTime())+"       ";
          jsonArray.add(s);
        }
      }else{
        jsonArray.add("暂无记录！");
      }
      Map<String,Object> today = eduHistoryService.selectEduHistoryStudy(user.getId());
      JSONObject my = new JSONObject();
      if(today==null){
        my.put("pass","0");
        my.put("time","0");
      }else{
        my.put("pass",today.get("pass"));
        my.put("time",today.get("time"));
      }
      data.put("count",my);
      data.put("list",jsonArray);
      json.put("code","0");
      json.put("msg",data);
      return json;
    }else{
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
  }

  /***
   * 跳转大关
   * @param request
   * @return
   */
  @RequestMapping("/jumpcheck")
  public AjaxResult jumpcheck(HttpServletRequest request){
    AjaxResult json = new AjaxResult();
    if(!isOnle(request)){
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      if(user.getLevels()==0){//非会员，提醒购买
        json.put("code","2");
        json.put("msg","请购买");
        return json;
      }else{
        if (new Date().after(user.getEndTime())){//到期会员提醒续费
          json.put("code","3");
          json.put("msg","已到期，请重新购买");
          return json;
        }else{
          //获取等级信息
          json.put("code","0");
          json.put("msg","正在跳转");
          return json;

          /*json.put("code","4");
          json.put("msg","请先完成上一关");
          return json;*/
          //判断当前关卡是否可以过
          //进入当前关卡，显示当前关数
        }
      }
    }else{
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
  }

  /***
   * 排行榜信息
   */
  @RequestMapping("/Ranking")
  public AjaxResult Ranking(HttpServletRequest request) {
    AjaxResult json = new AjaxResult();
    JSONObject data = new JSONObject();
    JSONObject my = new JSONObject();
    JSONObject todays = new JSONObject();
    JSONArray ran = new JSONArray();
    if (!isOnle(request)) {
      json.put("code", "100");
      json.put("msg", "请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      Map<String,Object> map = eduHistoryService.selectEduHistoryStudyCount(user.getId());
      if(map==null){
        my.put("no","暂无");
        my.put("rights","0颗");
        my.put("time","暂无");
      }else{
        BigDecimal s = (BigDecimal) map.get("time");
        int time = Integer.parseInt(s.toString());
        my.put("no",Integer.parseInt(map.get("rowNo").toString())+"名");
        my.put("rights",map.get("rights")+"颗");
        my.put("time",toDhmsStyle(time));
      }
      Map<String,Object> today = eduHistoryService.selectEduHistoryStudy(user.getId());
      if(today==null){
        todays.put("no","暂未上榜");
        todays.put("rights","0颗");
      }else{
        todays.put("no",Integer.parseInt(today.get("rowNo").toString())+"名");
        todays.put("rights",today.get("rights")+"颗");
      }

      List<Map<String,Object>> rankingList = eduHistoryService.selectEduHistoryStudyRanking();
      if(rankingList==null){
        for (int j=0;j<10;j++){
          JSONObject ing = new JSONObject();
          ing.put("name","虚位以待");
          ing.put("rights","");
          ran.add(ing);
        }
      }else{
        int s = rankingList.size();
        for(int i=0;i<s;i++){
          JSONObject ing = new JSONObject();
          ing.put("name",rankingList.get(i).get("nick"));
          ing.put("rights",rankingList.get(i).get("rights")+"颗");
          ran.add(ing);
        }
        for(int k=0;k<10-s;k++){
          JSONObject ing = new JSONObject();
          ing.put("name","虚位以待");
          ing.put("rights","");
          ran.add(ing);
        }
      }
      data.put("my",my);
      data.put("today",todays);
      data.put("ran",ran);

      json.put("code","0");
      json.put("msg",data);
      return json;
    }else{
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
  }

  /***
   * 根据用户信息查询打卡记录
   */
  @RequestMapping("/punchHistory")
  public AjaxResult punchHistory(HttpServletRequest request) {
    AjaxResult json = new AjaxResult();
    if (!isOnle(request)) {
      json.put("code", "100");
      json.put("msg", "请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      List<String> PuncHistory = eduPunchService.selectEduPuncHistory(user.getId());
      List<Integer> day = current(PuncHistory);
      System.out.println(day);
      json.put("code", "0");
      json.put("msg", day);
      return json;
    }else{
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
  }

  /***
   * 打卡
   * @param request
   * @return
   */
  @RequestMapping("/punch")
  public AjaxResult punch(HttpServletRequest request){
    SimpleDateFormat df = new SimpleDateFormat("yyyy 年 MM 月 dd 日");//设置日期格式
    AjaxResult json = new AjaxResult();
    JSONObject data = new JSONObject();
    if(!isOnle(request)){
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
    EduUser user = getEduUser(request);
    if(user!=null){
      Map<String,Object> map = eduHistoryService.selectEduHistoryStudy(user.getId());
      if(map==null){
        json.put("code","-1");
        json.put("msg","你今天还没有学习哦~");
        return json;
      }
      BigDecimal s = (BigDecimal) map.get("time");
      int time = Integer.parseInt(s.toString());
      if(time<60*20){
        json.put("code","1");
        json.put("msg","打卡失败！学习时长没有超过20分钟");
        return json;
      }
      //新增打卡记录
      EduPunch punch = new EduPunch();
      punch.setUpdatetime(new Date());
      punch.setUserId(user.getId());
      eduPunchService.insertEduPunch(punch);
      Long day = getDay(user.getCreateTime());
      data.put("time",df.format(new Date()));
      data.put("nick",getNick(day));
      data.put("day",day+"");
      json.put("code","0");
      json.put("msg",data);
      return json;
    }else{
      json.put("code","100");
      json.put("msg","请登录");
      return json;
    }
  }


  /***
   * 是否在线
   * @return
   */
  @RequestMapping("/onle")
  public AjaxResult onle(HttpServletRequest request){
    String token = request.getHeader("token");
    AjaxResult json = new AjaxResult();
    TokenUtils tokenUtils = new TokenUtils();
    if(tokenUtils.TokenOnle(token)){
      json.put("code","0");
      json.put("msg","token未失效");
      return json;
    }
    json.put("code","1");
    json.put("msg","token失效");
    return json;
  }


  /***
   * 退出登录
   * @return
   */
  @RequestMapping("/out")
  public void out(HttpServletRequest request){
    TokenUtils tokenUtils = new TokenUtils();
    tokenUtils.removeToken(request);
  }
  @RequestMapping("/login")
  public AjaxResult login(@RequestParam("user") String user,@RequestParam("code") String code,@RequestParam("pass") String pass,@RequestParam("random") String random) {
    AjaxResult json = new AjaxResult();
    String y = redisTemplate.opsForValue().get(random.split("\\.")[1]+"&random");
    if(y==null){//如果手机号key存在，则不能发送
      json.put("code","1");
      json.put("msg","验证码已失效！");
      return json;
    }
    if(!code.contains(y)){
      json.put("code","1");
      json.put("msg","验证码错误！");
      return json;
    }
    EduUser users = new EduUser();
    users.setPhnumber(user.trim().replaceAll(" +",""));
    List<EduUser> eduUserList = eduUserService.selectEduUser(users);
    if(eduUserList.size()==0){
      json.put("code","1");
      json.put("msg","账号或密码错误！");
      return json;
    }else{
      EduUser member = eduUserList.get(0);
      if(!member.getPass().equals(pass)){
        json.put("code","1");
        json.put("msg","账号或密码错误！");
        return json;
      }else{
        TokenUtils tokenUtils = new TokenUtils();
        String token = tokenUtils.createToken(member);
        if(token!=null){
          member.setToken(token);
          if(eduUserService.updateEduUser(member)==1){
            json.put("code","0");
            json.put("msg","登录成功");
            json.put("token",token);
            json.put("user",member.getNick());
            return json;
          }
        }
      }
    }
    json.put("code","1");
    json.put("msg","登录失败，请稍后再试！");
    return json;
  }


  /***
   * 是否在线
   * @param request
   * @return
   */
  public boolean isOnle(HttpServletRequest request){
    TokenUtils tokenUtils = new TokenUtils();
    return tokenUtils.TokenOnle(request.getHeader("token"));
  }
  /***
   * 是否在线
   * @param token
   * @return
   */
  public boolean isOnleString(String token){
    TokenUtils tokenUtils = new TokenUtils();
    return tokenUtils.TokenOnle(token);
  }
  /***
   * 获取登录用户信息
   * @param token
   * @return
   */
  public EduUser getEduUserString(String token){
    ArrayList<Map<Object, Object>> userList = (ArrayList<Map<Object, Object>>) RedisUtils.getRedisUtils().getValueOperations().get(token);
    if(userList.size()>0){
      Map<Object, Object> user = userList.get(0);
      int id = Integer.parseInt(user.get("id").toString());
      EduUser sec = new EduUser();
      sec.setId(id);
      List<EduUser> memberList = eduUserService.selectEduUser(sec);
      if(memberList.size()>0) {
        EduUser member = memberList.get(0);
        if(member!=null){
          return  member;
        }
      }
    }
    return null;
  }
  /***
   * 获取登录用户信息
   * @param request
   * @return
   */
  public EduUser getEduUser(HttpServletRequest request){
    ArrayList<Map<Object, Object>> userList = (ArrayList<Map<Object, Object>>) RedisUtils.getRedisUtils().getValueOperations().get(request.getHeader("token"));
    if(userList.size()>0){
      Map<Object, Object> user = userList.get(0);
      int id = Integer.parseInt(user.get("id").toString());
      EduUser sec = new EduUser();
      sec.setId(id);
      List<EduUser> memberList = eduUserService.selectEduUser(sec);
      if(memberList.size()>0) {
        EduUser member = memberList.get(0);
        if(member!=null){
          return  member;
        }
      }
    }
    return null;
  }

  /***
   * 用户注册
   * @param phoneNumber 手机号码
   * @param code 验证码
   * @param nick 昵称
   * @param grade 年级
   * @param pass 密码
   * @return
   */
  @RequestMapping("/reg")
  public AjaxResult reg(@RequestParam("phoneNumber") String phoneNumber,@RequestParam("code") String code,@RequestParam("nick") String nick,@RequestParam("grade") String grade,@RequestParam("pass") String pass) {
    AjaxResult json = new AjaxResult();
    String y = redisTemplate.opsForValue().get(phoneNumber+"&code");
    if(y==null){
      json.put("code","1");
      json.put("msg","验证码已失效！");
      return json;
    }else{
      if(code.contains(y)){
        EduUser user = new EduUser();
        user.setPhnumber(phoneNumber.trim().replaceAll(" +",""));
        user.setNick(nick.trim().replaceAll(" +",""));
        user.setGrade(grade.trim().replaceAll(" +",""));
        user.setState(0);
        user.setLevels(0);
        user.setPass(pass.trim().replaceAll(" +",""));
        if(eduUserService.insertEduUser(user)==1){
          json.put("code","0");
          json.put("msg","注册成功");
          return json;
        }else{
          json.put("code","1");
          json.put("msg","注册失败，请稍后再试！");
          return json;
        }
      }else{
        json.put("code","1");
        json.put("msg","验证码错误");
        return json;
      }
    }
  }

  /***
   *发送验证码
   * @param number 手机号
   * @return
   */
  @RequestMapping("/getSend")
  public AjaxResult getSend(@RequestParam("number") String number) {
    AjaxResult json = new AjaxResult();
    JSONObject code = new JSONObject();
    int c = (int)((Math.random()*9+1)*100000);
    String y = redisTemplate.opsForValue().get(number);
    if(y!=null){//如果手机号key存在，则不能发送
      json.put("code","1");
      json.put("msg","验证码发送频繁！");
      return json;
    }
    redisTemplate.opsForValue().set(number,c+"",60, TimeUnit.SECONDS);//生成一个60s的手机key
    redisTemplate.opsForValue().set(number+"&code",c+"",5, TimeUnit.MINUTES);//生成一个5分钟可以用的验证码
    code.put("code",c+"");
    boolean l = SendSmsUtils.send(number,"SMS_181720409",code.toString());
    if(l){
      json.put("code","0");
      json.put("msg","验证码已发送！");
      return json;
    }else{
      json.put("code","1");
      json.put("msg","验证码发送频繁！");
      return json;
    }
  }
  /**
   * 验证码生成
   */
  @GetMapping(value = "/captchaImage")
  public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) {
    ServletOutputStream out = null;
    try {
      HttpSession session = request.getSession();
      response.setDateHeader("Expires", 0);
      response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
      response.addHeader("Cache-Control", "post-check=0, pre-check=0");
      response.setHeader("Pragma", "no-cache");
      response.setContentType("image/jpeg");
      String type = request.getParameter("type");
      String random = request.getParameter("random").split("\\.")[1];
      String capStr = null;
      String code = null;
      BufferedImage bi = null;
      if (CommonConstant.math.equals(type)) {
        String capText = captchaProducerMath.createText();
        capStr = capText.substring(0, capText.lastIndexOf("@"));
        code = capText.substring(capText.lastIndexOf("@") + 1);
        bi = captchaProducerMath.createImage(capStr);
      } else if (CommonConstant.charC.equals(type)) {
        capStr = code = captchaProducer.createText();
        bi = captchaProducer.createImage(capStr);
      }
      redisTemplate.opsForValue().set(random+"&random",code,60, TimeUnit.SECONDS);//生成一个60s的手机key
      out = response.getOutputStream();
      ImageIO.write(bi, "jpg", out);
      out.flush();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (out != null) {
          out.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }
  /**
   * 获取微信支付的二维码地址
   *
   * @return
   * @throws Exception
   * @author chenp
   */
  @RequestMapping("/pay")
  public void getQRCode(HttpServletRequest request,HttpServletResponse response) throws Exception {
    EduOrder order = new EduOrder();
    String token = request.getParameter("token").replaceAll(" ","+");
    int money = Integer.parseInt(request.getParameter("money"));
    if(money!=1096&&money!=2080){
      money = 2080;
    }
    String ShopName = money==2080?"多学一门两年英语课程学习":"多学一门365天英语课程学习";
    if(!isOnleString(token)){
      return;
    }
    EduUser user = getEduUserString(token);
    if(user==null){
      return;
    }
    order.setPhnumber(user.getPhnumber());
    order.setUserId(user.getId());
    order.setNick(user.getNick());
    order.setState(0);
    String appid = WeChatConfig.APPID;//微信服务号的appid
    String mch_id = WeChatConfig.MCHID; //微信支付商户号
    String key = WeChatConfig.APIKEY; // 微信支付的API密钥
    String notify_url = WeChatConfig.WECHAT_NOTIFY_URL_PC;//回调地址【注意，这里必须要使用外网的地址】
    String ufdoder_url = WeChatConfig.UFDODER_URL;//微信下单API地址
    String trade_type = "NATIVE"; //类型【网页扫码支付】
    /**
     * 时间字符串
     */
    String currTime = PayForUtil.getCurrTime();
    String strTime = currTime.substring(8, currTime.length());
    String strRandom = PayForUtil.buildRandom(4) + "";
    String nonce_str = strTime + strRandom;
    /**
     * 参数封装
     */
    SortedMap<Object, Object> packageParams = new TreeMap<Object, Object>();
    packageParams.put("appid", appid);
    packageParams.put("mch_id", mch_id);
    packageParams.put("nonce_str", nonce_str);//随机字符串
    order.setNonceStr(nonce_str);
    packageParams.put("body", ShopName);//支付的商品名称
    order.setBody(ShopName);
    packageParams.put("out_trade_no", nonce_str);//商户订单号【备注：每次发起请求都需要随机的字符串，否则失败。】
    BigDecimal b1 = new BigDecimal(Double.toString(money));
    packageParams.put("total_fee", b1.multiply(BigDecimal.valueOf(100)).stripTrailingZeros().toPlainString());//支付金额
    order.setTotalFee(Integer.parseInt(b1.multiply(BigDecimal.valueOf(100)).stripTrailingZeros().toPlainString()));
    packageParams.put("spbill_create_ip", PayForUtil.localIp());//客户端主机
    packageParams.put("notify_url", notify_url);//微信回调
    packageParams.put("trade_type", trade_type);
    packageParams.put("attach", "");//额外的参数【业务类型+会员ID+支付类型】
    String sign = PayForUtil.createSign("UTF-8", packageParams, key);  //获取签名
    packageParams.put("sign", sign);
    order.setSign(sign);
    System.out.println("订单号："+nonce_str);
    String requestXML = PayForUtil.getRequestXml(packageParams);//将请求参数转换成String类型
    log.info("微信支付请求参数的报文" + requestXML);
    String resXml = HttpUtil.postData(ufdoder_url, requestXML);  //解析请求之后的xml参数并且转换成String类型
    Map map = XMLUtil.doXMLParse(resXml);
    log.info("微信支付响应参数的报文" + resXml);
    System.out.println(map);
    String urlCode = (String) map.get("code_url");
    if (StringUtils.isBlank(urlCode))
      return;
    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
    Map hints = new HashMap();
    BitMatrix bitMatrix = null;
    try {
      bitMatrix = multiFormatWriter.encode(urlCode, BarcodeFormat.QR_CODE, 250, 250, hints);
      BufferedImage image = toBufferedImage(bitMatrix);
      //输出二维码图片流
      try {
        ImageIO.write(image, "png", response.getOutputStream());
        response.getOutputStream().flush();
        eduOrderService.insertEduOrder(order);
      } catch (IOException e) {
        e.printStackTrace();
      }finally {
        try {
          if (response.getOutputStream() != null) {
            response.getOutputStream().close();
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } catch (WriterException e1) {
      e1.printStackTrace();
    }
    return;
  }

  @RequestMapping("/wxNotify")
  public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws JDOMException, IOException {
    EduOrder order = new EduOrder();
    System.out.println("微信支付回调");
    //读取参数
    InputStream inputStream;
    StringBuffer sb = new StringBuffer();
    inputStream = request.getInputStream();
    String s;
    BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    while ((s = in.readLine()) != null) {
      sb.append(s);
    }
    in.close();
    inputStream.close();
    //解析xml成map
    Map<String, String> m = new HashMap<>();
    m = XMLUtil.doXMLParse(sb.toString());
    log.info(m.toString());
    //过滤空 设置 TreeMap
    SortedMap<Object, Object> reParams = new TreeMap<>();
    Iterator<String> it = m.keySet().iterator();
    while (it.hasNext()) {
      String parameter = it.next();
      String parameterValue = m.get(parameter);
      String v = "";
      if (null != parameterValue) {
        v = parameterValue.trim();
      }
      reParams.put(parameter, v);
    }
    System.out.println("微信支付回调参数："+reParams);
    // 微信支付的API密钥
    String key = WeChatConfig.APIKEY; // key
    //验签
    if (PayForUtil.isTenpaySign("UTF-8", reParams, key)) {
      order.setNonceStr(reParams.get("nonce_str").toString());
      List<EduOrder> orderList = eduOrderService.selectEduOrder(order);
      if(orderList.size()>0){
        EduOrder o = orderList.get(0);
      String resXml = "";
      if ("SUCCESS".equals((String) reParams.get("result_code"))) {
        // 统一下单返回的参数
        String prepay_id = (String) reParams.get("prepay_id");//交易会话标识  2小时内有效
        String out_trade_no = (String) reParams.get("out_trade_no");
        //调用自己业务逻辑处理
        //返回参数
        String nonce_str1 = WeChatConfig.NONCE_STR;
        SortedMap<Object, Object> resParams = new TreeMap<Object, Object>();
        resParams.put("return_code", "SUCCESS"); // 必须
        resParams.put("return_msg", "OK");
        resParams.put("appid", WeChatConfig.APPID); // 必须
        resParams.put("mch_id", WeChatConfig.MCHID);
        resParams.put("nonce_str", nonce_str1); // 必须
        resParams.put("prepay_id", prepay_id); // 必须
        resParams.put("result_code", "SUCCESS"); // 必须
        resParams.put("err_code_des", "OK");
        String sign1 = PayForUtil.createSign("UTF-8", reParams, key);
        resParams.put("sign", sign1); //签名
        o.setState(1);
        EduUser user = new EduUser();
        user.setId(o.getUserId());
        List<EduUser> userList = eduUserService.selectEduUser(user);
        if(userList.size()>0){
          EduUser member = userList.get(0);
          if(member.getLevels()==0){//普通会员升级
            member.setLevels(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 6); //加一个月
            date = calendar.getTime();
            member.setEndTime(date);
          }else{
            member.setLevels(1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = member.getEndTime();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 6); //加1年
            date = calendar.getTime();
            member.setEndTime(date);
          }
          eduUserService.updateEduUser(member);
          eduOrderService.updateEduOrder(o);
        }
        resXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
        log.info(resXml);
      } else {
        log.info("支付失败,错误信息：" + reParams.get("err_code"));
        resXml = "<xml><return_code><![CDATA[FAIL]]></return_code><return_msg><![CDATA[报文为空]]></return_msg></xml>";
      }
      BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
      out.write(resXml.getBytes());
      out.flush();
      out.close();
    } else {
      log.info("通知签名验证失败");
    }
    }
  }

  /***
   * 查询是否重复
   * @param type
   * @param val
   * @return
   */
  @RequestMapping("/queryUser")
  public AjaxResult login(@RequestParam("type") String type,@RequestParam("val") String val) {
    AjaxResult json = new AjaxResult();
    if(!type.replaceAll(" +","").contains("user") && !type.replaceAll(" +","").contains("number")){
      json.put("code","1");
      json.put("msg","请检查参数");
      return json;
    }
    if(type.replaceAll(" +","").contains("user")){
      EduUser user = new EduUser();
      user.setNick(val.replaceAll(" +",""));
      List<EduUser> eduUserList = eduUserService.selectEduUser(user);
      if(eduUserList.size()==0){
        json.put("code","0");
        json.put("msg",val.replaceAll(" +","")+":用户名/孩子昵称可用！");
        return json;
      }else{
        json.put("code","1");
        json.put("msg","用户名已被注册！");
        return json;
      }
    }
    if(type.contains("number")){
      EduUser user = new EduUser();
      user.setPhnumber(val.replaceAll(" +",""));
      user.setState(0);
      List<EduUser> eduUserList = eduUserService.selectEduUser(user);
      if(eduUserList.size()==0){
        json.put("code","0");
        json.put("msg",val+":手机号可用！");
        return json;
      }else{
        json.put("code","1");
        json.put("msg","手机号已被注册！");
        return json;
      }
    }
    json.put("code","1");
    json.put("msg","请检查参数");
    return json;
  }

  /***
   * 根据日期，查询是第几天
   * @return
   */
  public List<Integer> current(List<String> days){
    List<Integer> list = new ArrayList<>();
    for(int j=0;j<days.size();j++){
      Integer year = Integer.parseInt(days.get(j).substring(0,4));
      Integer month = Integer.parseInt(days.get(j).substring(4,6));
      Integer day = Integer.parseInt(days.get(j).substring(6,8));
      int run = 0 ;//是否是闰年 1是闰年
      if(year%4!=0){
        run = 1;
      }
      for(int i=1; i<month; i++) {
        if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) {
          day += 31;
        } else if(i==4 || i==6 || i==9 || i==11) {
          day += 30;
        } else if(i==2 && (run==0)) {
          day += 29;
        } else {
          day += 28;
        }
      }
      list.add(day);

    }
    return  list;
  }
  /**
   * 随机生成账号
   * @return
   */
  public static String uuid(){
    int first = new Random().nextInt(9);
    int rnd = UUID.randomUUID().toString().hashCode();
    if(rnd < 0){
      rnd = -rnd;
    }
    return first+String.format("%010d", rnd);
  }
  public static String getChar(int length) {
    char[] ss = new char[length];
    int i=0;
    while(i<length) {
      int f = (int) (Math.random()*3);
      if(f==0)
        ss[i] = (char) ('A'+Math.random()*26);
      else if(f==1)
        ss[i] = (char) ('a'+Math.random()*26);
      else
        ss[i] = (char) ('0'+Math.random()*10);
      i++;
    }
    String str=new String(ss);
    return str;
  }
  /**
   * 类型转换
   *
   * @param matrix
   * @return
   * @author chenp
   */
  public static BufferedImage toBufferedImage(BitMatrix matrix) {
    int width = matrix.getWidth();
    int height = matrix.getHeight();
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setRGB(x, y, matrix.get(x, y) == true ? BLACK : WHITE);
      }
    }
    return image;
  }

  /**
   * 根据注册天数获取称号
   * @param time
   * @return
   */
  public static String getNick(Long time){
    //1.3.7.15.30.
    //60.90.120.150.180.210.240.270.300.330.365
    //初来乍到，初学乍练,初窥门径,略知一二,驾轻就熟,
    //融会贯通,登堂入室,炉火纯青,出类拔萃,技冠群雄,
    //出神入化,登峰造极,震古铄今,威镇寰宇,天人合一,
    // 返璞归真
   String nick ="初来乍到";
    Long day = time;
    if(day<3){
      nick ="初来乍到";
    }
    if(day>=3&&day<7){
      nick ="初学乍练";
    }
    if(day>=7&&day<15){
      nick ="初窥门径";
    }
    if(day>=15&&day<30){
      nick ="略知一二";
    }
    if(day>=30&&day<60){
      nick ="驾轻就熟";
    }
    if(day>=60&&day<90){
      nick ="融会贯通";
    }
    if(day>=90&&day<120){
      nick ="登堂入室";
    }
    if(day>=120&&day<150){
      nick ="炉火纯青";
    }
    if(day>=150&&day<180){
      nick ="出类拔萃";
    }
    if(day>=180&&day<210){
      nick ="技冠群雄";
    }
    if(day>=210&&day<240){
      nick ="出神入化";
    }
    if(day>=240&&day<270){
      nick ="登峰造极";
    }
    if(day>=270&&day<300){
      nick ="震古铄今";
    }
    if(day>=300&&day<330){
      nick ="威镇寰宇";
    }
    if(day>=330&&day<365){
      nick ="天人合一";
    }
    if(day>=365){
      nick ="返璞归真";
    }
    return nick;
  }
  /*
    判读时间差距，两个时间相差多少天，时，分，秒
     */
  public Long getDay(Date date) {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Long days = null;
    try {
      Date currentTime = dateFormat.parse(dateFormat.format(new Date()));//现在系统当前时间
      Date pastTime = date;
      long diff = currentTime.getTime() - pastTime.getTime();
      days = diff / (1000 * 60 * 60 * 24);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return days;
  }
  public static String toDhmsStyle(long allSeconds) {
    String DateTimes = null;

    long days = allSeconds / (60 * 60 * 24);
    long hours = (allSeconds % (60 * 60 * 24)) / (60 * 60);
    long minutes = (allSeconds % (60 * 60)) / 60;
    long seconds = allSeconds % 60;

    if (days > 0) {
      DateTimes = days + "天" + hours + "时" + minutes + "分";
    } else if (hours > 0) {
      DateTimes = hours + "时" + minutes + "分";
    } else if (minutes > 0) {
      DateTimes = minutes + "分";
    }

    return DateTimes;
  }

  public static String toHour(long allSeconds) {
    String DateTimes = null;
    long hours = (allSeconds % (60 * 60 * 24)) / (60 * 60);
    long minutes = (allSeconds % (60 * 60)) / 60;
    long seconds = allSeconds % 60;
    if (hours > 0) {
      DateTimes = hours + "时" + minutes + "分";
    } else if (minutes > 0) {
      DateTimes = minutes + "分" + seconds +"秒";
    }else{
      DateTimes = seconds +"秒";
    }
    return DateTimes;
  }


}