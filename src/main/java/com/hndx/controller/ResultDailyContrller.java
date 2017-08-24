package com.hndx.controller;
import com.hndx.model.*;
import com.hndx.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class ResultDailyContrller {

    @Autowired
    PbDepartRepository  pbDepartRepository;
    @Autowired
    KqCardRecordRepository kqCardRecordRepository;
    @Autowired
    PbIcanteenRepository pbIcanteenRepository;
    @Autowired
    PbEmplyRepository pbEmplyRepository;



    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public String getClas(ModelMap modelMap) {
        List<PbDepartEntity> claList = pbDepartRepository.findByStatusEqualsAndParentIdEquals(0,8);
        modelMap.addAttribute("claList", claList);
        return "clas";
    }

    @RequestMapping(value = "/clDD/{dptid}/{mqDay}", method = RequestMethod.GET)
    public String getclDD(@PathVariable("dptid") Integer dptid,@PathVariable("mqDay") String mqDay,ModelMap modelMap) {
        ResultDaily resultDaily=new ResultDaily(dptid);
        List<PbDepartEntity> dptList=pbDepartRepository.readByStatusEqualsAndDepartIdEquals(0,dptid);

        resultDaily.setDeptName(dptList.iterator().next().getName());

        //获得日期
        //待用！ 引用传递的model数据。  public String addUserPost(@ModelAttribute("user") UserEntity userEntity)
        //String datestr = "2017-08-10 00:00:00.123";
        //Timestamp qts = Timestamp.valueOf(datestr);

        //resultDaily.setCtTime(qts);

        //改进，班级全体成员形成一个LIST或者iterator，用于计算人数，比对就餐人员，比对考勤人员（考勤比较复杂，就怕一个周期多次刷卡），
        //再列出未就餐和到课人员。
        //后期，在晚上11点，将所有班次本日记录保存到本地服务器（因为不会发生变更了）

        //班级人数
        List<PbEmplyEntity> emplyEntityList=pbEmplyRepository.readByDepartIdEqualsAndIsDeleteEquals(dptid,0);
        Integer stuCT =emplyEntityList.size();
        resultDaily.setPeoCT(stuCT);
        //日期处理：得到今日
        //Calendar calendar = Calendar.getInstance();
        //Date now=calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String tDay=mqDay;

        String qTime=tDay+" 00:00:01";
        Timestamp qts = Timestamp.valueOf(qTime);
        resultDaily.setCtTime(qts);

        //统计数据初始化
        List<String> noMor=new ArrayList<String>();
        Integer ctMor=0;
        List<String> noAfter=new ArrayList<String>();
        Integer ctAfter=0;

        List<String> noBF=new ArrayList<String>();
        Integer ctBF=0;
        List<String> noLun=new ArrayList<String>();
        Integer ctLun=0;
        List<String> noDin=new ArrayList<String>();
        Integer ctDin=0;


        //进行统计
        if (emplyEntityList.isEmpty())//判断班上是否有成员
        {return "clDD";}
        else {
            //遍历每一位成员
            for (PbEmplyEntity emplyEntity:emplyEntityList
             ) {
                //得到班级成员的编号
                Integer sysNo=emplyEntity.getSysNo();
                String emName=emplyEntity.getEmployeeName();
                //上午到课率统计
                String qbMornngTime=tDay+" 07:00:00";
                Timestamp qbmts = Timestamp.valueOf(qbMornngTime);
                String qeMoringTime=tDay+" 09:00:00";
                Timestamp qemts = Timestamp.valueOf(qeMoringTime);
                //得到该成员此时段的考勤记录
                List<KqCardRecordEntity> kqCardRecordEntityList=kqCardRecordRepository.readFirstByCardTimeBetweenAndSysNoEquals(qbmts,qemts,sysNo);
                if (kqCardRecordEntityList.isEmpty()){
                    //这是测试语句
                    resultDaily.setCtMorning(0.08);
                    //如果没有添加到未上课或迟到名单
                    noMor.add(emName);
                }
                else {
                    //如果有计数器加1
                    ctMor=ctMor+1;
                }
                //下午到课率统计
                String qbAferTime=tDay+" 13:30:00";
                String qeAfterTime=tDay+" 16:00:00";
                Timestamp qbats = Timestamp.valueOf(qbAferTime);
                Timestamp qeats = Timestamp.valueOf(qeAfterTime);
                List<KqCardRecordEntity> akqCardRecordEntityList=kqCardRecordRepository.readFirstByCardTimeBetweenAndSysNoEquals(qbats,qeats,sysNo);
                if (akqCardRecordEntityList.isEmpty()){
                    //添加到未上课或迟到名单
                    noAfter.add(emName);
                }
                else {
                    ctAfter=ctAfter+1;
                }
                //就餐情况统计
                //设定时间段
                String qicanAllbts=tDay+" 06:00:00";
                Timestamp qicanbmts = Timestamp.valueOf(qicanAllbts);
                String qicanAllets=tDay+" 22:00:00";
                Timestamp qicanemts = Timestamp.valueOf(qicanAllets);

                //获得该成员早餐记录
                Integer qmType=1;
                List<PbIcanteenEntity> pbIcanteenEntityList1=pbIcanteenRepository.readFirstByDealDateIsBetweenAndSysNoEqualsAndMealTypeEquals(qicanbmts,qicanemts,sysNo,qmType);
                if (pbIcanteenEntityList1.isEmpty()){
                    //添加到未上课或迟到名单
                    noBF.add(emName);
                }
                else {
                    ctBF=ctBF+1;
                }
                //中餐
                qmType=2;
                List<PbIcanteenEntity> pbIcanteenEntityList2=pbIcanteenRepository.readFirstByDealDateIsBetweenAndSysNoEqualsAndMealTypeEquals(qicanbmts,qicanemts,sysNo,qmType);
                if (pbIcanteenEntityList2.isEmpty()){
                    //添加到未上课或迟到名单
                    noLun.add(emName);
                }
                else {
                    ctLun=ctLun+1;
                }
                //晚餐
                qmType=3;
                List<PbIcanteenEntity> pbIcanteenEntityList3=pbIcanteenRepository.readFirstByDealDateIsBetweenAndSysNoEqualsAndMealTypeEquals(qicanbmts,qicanemts,sysNo,qmType);
                if (pbIcanteenEntityList3.isEmpty()){
                    //添加到未上课或迟到名单
                    noDin.add(emName);
                }
                else {
                    ctDin=ctDin+1;
                }

            }


        }
        //计算上午到课率
        double kqMor= (double)ctMor/stuCT;
        BigDecimal b = new BigDecimal(kqMor);
        kqMor = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //计算下午到课率
        double kqAft= (double)ctAfter/stuCT;
        BigDecimal b2 = new BigDecimal(kqAft);
        kqAft = b2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //计算早餐就餐率
        double jcBF= (double)ctBF/stuCT;
        BigDecimal b3 = new BigDecimal(jcBF);
        jcBF = b3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //计算中餐就餐率
        double jcLun= (double)ctLun/stuCT;
        BigDecimal b4 = new BigDecimal(jcLun);
        jcLun = b4.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        //计算晚餐就餐率
        double jcDin= (double)ctDin/stuCT;
        BigDecimal b5 = new BigDecimal(jcDin);
        jcDin = b5.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();



        resultDaily.setCtMorning(kqMor);
        resultDaily.setPeoMorning(noMor);
        resultDaily.setCtAfternoon(kqAft);
        resultDaily.setPeoAfternoon(noAfter);
        resultDaily.setCtBFast(jcBF);
        resultDaily.setPeoBFast(noBF);
        resultDaily.setCtLunch(jcLun);
        resultDaily.setPeoLunch(noLun);
        resultDaily.setCtDinner(jcDin);
        resultDaily.setPeoDinner(noDin);

        //早中晚餐，可以餐别 for 1-2-3 之类来实现











        modelMap.addAttribute("resultDaily", resultDaily);
        return "clDD";
    }


}
