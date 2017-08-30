package com.hndx.controller;
import com.hndx.model.*;
import com.hndx.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
//import java.lang.annotation.Repeatable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTask{

    @Autowired
    PbDepartRepository pbDepartRepository;
    @Autowired
    KqCardRecordRepository kqCardRecordRepository;
    @Autowired
    PbIcanteenRepository pbIcanteenRepository;
    @Autowired
    PbEmplyRepository pbEmplyRepository;
    @Autowired
    DxRecordRepository dxRecordRepository;
    @Scheduled(cron="0 00 23 * * ? ")
    public void addRcd() {
        try {
            //在这里写你要执行的内容
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<PbDepartEntity> pbDepartEntityList=pbDepartRepository.findByStatusEqualsAndParentIdEquals(0,8);
            if (pbDepartEntityList.isEmpty()){
                System.out.println("-------------当前没有班级--------------");
            }
            else{
                //获得当前时间
                String qTime = fmt.format(Calendar.getInstance().getTime());
                Timestamp qts = Timestamp.valueOf(qTime);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String tDay=sdf.format(Calendar.getInstance().getTime()); //今日，用来查询时间段的打卡记录

                //遍历当前每个班级，获得相关数据。
                for (PbDepartEntity pbDepartEntity:pbDepartEntityList) {
                    int dptid=pbDepartEntity.getDepartId();
                    String dptname=pbDepartEntity.getName();
                    //班级人数
                    List<PbEmplyEntity> emplyEntityList = pbEmplyRepository.readByDepartIdEqualsAndIsDeleteEquals(dptid, 0);
                    Integer stuCT = emplyEntityList.size();

                    //进行统计
                    if (emplyEntityList.isEmpty())//判断班上是否有成员
                    {
                        System.out.println("-------------当前班级没有成员--------------");
                    } else {
                        //统计数据初始化
                        String noMor = "";
                        Integer ctMor = 0;
                        String noAfter = "";
                        Integer ctAfter = 0;
                        String noNight = "";
                        Integer ctNight = 0;
                        String noBF = "";
                        Integer ctBF = 0;
                        String noLun = "";
                        Integer ctLun = 0;
                        String noDin = "";
                        Integer ctDin = 0;
                        //遍历每一位成员
                        for (PbEmplyEntity emplyEntity : emplyEntityList
                                ) {
                            //得到班级成员的编号
                            Integer sysNo = emplyEntity.getSysNo();
                            String emName = emplyEntity.getEmployeeName();
                            //上午到课率统计
                            String qbMornngTime = tDay + " 07:00:00";
                            Timestamp qbmts = Timestamp.valueOf(qbMornngTime);
                            String qeMoringTime = tDay + " 09:00:00";
                            Timestamp qemts = Timestamp.valueOf(qeMoringTime);
                            //得到该成员此时段的考勤记录
                            List<KqCardRecordEntity> kqCardRecordEntityList = kqCardRecordRepository.readFirstByCardTimeBetweenAndSysNoEquals(qbmts, qemts, sysNo);
                            if (kqCardRecordEntityList.isEmpty()) {
                                //这是测试语句
                                // dxRecordEntity.setCtMorning(0.08);
                                //如果没有添加到未上课或迟到名单
                                noMor = noMor + emName + ",";
                            } else {
                                //如果有计数器加1
                                ctMor = ctMor + 1;
                            }
                            //下午到课率统计
                            String qbAferTime = tDay + " 13:30:00";
                            String qeAfterTime = tDay + " 16:00:00";
                            Timestamp qbats = Timestamp.valueOf(qbAferTime);
                            Timestamp qeats = Timestamp.valueOf(qeAfterTime);
                            List<KqCardRecordEntity> akqCardRecordEntityList = kqCardRecordRepository.readFirstByCardTimeBetweenAndSysNoEquals(qbats, qeats, sysNo);
                            if (akqCardRecordEntityList.isEmpty()) {
                                //添加到未上课或迟到名单
                                noAfter = noAfter + emName + ",";
                            } else {
                                ctAfter = ctAfter + 1;
                            }
                            //晚上宿舍统计
                            String qbNightTime = tDay + " 22:00:00";
                            String qeNightTime = tDay + " 23:00:00";
                            Timestamp qbnts = Timestamp.valueOf(qbNightTime);
                            Timestamp qents = Timestamp.valueOf(qeNightTime);
                            List<KqCardRecordEntity> nkqCardRecordEntityList = kqCardRecordRepository.readFirstByCardTimeBetweenAndSysNoEquals(qbnts, qents, sysNo);
                            if (nkqCardRecordEntityList.isEmpty()) {
                                //添加到未上课或迟到名单
                                noNight = noNight + emName + ",";
                            } else {
                                ctNight = ctNight + 1;
                            }
                            //就餐情况统计
                            //设定时间段
                            String qicanAllbts = tDay + " 06:00:00";
                            Timestamp qicanbmts = Timestamp.valueOf(qicanAllbts);
                            String qicanAllets = tDay + " 22:00:00";
                            Timestamp qicanemts = Timestamp.valueOf(qicanAllets);

                            //获得该成员早餐记录
                            Integer qmType = 1;
                            List<PbIcanteenEntity> pbIcanteenEntityList1 = pbIcanteenRepository.readFirstByDealDateIsBetweenAndSysNoEqualsAndMealTypeEquals(qicanbmts, qicanemts, sysNo, qmType);
                            if (pbIcanteenEntityList1.isEmpty()) {
                                //添加到未上课或迟到名单
                                noBF = noBF + emName + ",";
                            } else {
                                ctBF = ctBF + 1;
                            }
                            //中餐
                            qmType = 2;
                            List<PbIcanteenEntity> pbIcanteenEntityList2 = pbIcanteenRepository.readFirstByDealDateIsBetweenAndSysNoEqualsAndMealTypeEquals(qicanbmts, qicanemts, sysNo, qmType);
                            if (pbIcanteenEntityList2.isEmpty()) {
                                //添加到未上课或迟到名单
                                noLun = noLun + emName + ",";
                            } else {
                                ctLun = ctLun + 1;
                            }
                            //晚餐
                            qmType = 3;
                            List<PbIcanteenEntity> pbIcanteenEntityList3 = pbIcanteenRepository.readFirstByDealDateIsBetweenAndSysNoEqualsAndMealTypeEquals(qicanbmts, qicanemts, sysNo, qmType);
                            if (pbIcanteenEntityList3.isEmpty()) {
                                //添加到未上课或迟到名单
                                noDin = noDin + emName + ",";
                            } else {
                                ctDin = ctDin + 1;
                            }
                        }

                        //计算上午到课率
                        double kqMor = (double) ctMor / stuCT;
                        BigDecimal b = new BigDecimal(kqMor);
                        kqMor = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        //计算下午到课率
                        double kqAft = (double) ctAfter / stuCT;
                        BigDecimal b2 = new BigDecimal(kqAft);
                        kqAft = b2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        //计算宿舍考勤率
                        double kqNight = (double) ctNight / stuCT;
                        BigDecimal b6 = new BigDecimal(kqNight);
                        kqNight = b6.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        //计算早餐就餐率
                        double jcBF = (double) ctBF / stuCT;
                        BigDecimal b3 = new BigDecimal(jcBF);
                        jcBF = b3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        //计算中餐就餐率
                        double jcLun = (double) ctLun / stuCT;
                        BigDecimal b4 = new BigDecimal(jcLun);
                        jcLun = b4.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        //计算晚餐就餐率
                        double jcDin = (double) ctDin / stuCT;
                        BigDecimal b5 = new BigDecimal(jcDin);
                        jcDin = b5.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                        // dxRecordEntity.setClDdid(clDid);
                        DxRecordEntity dxRecordEntity = new DxRecordEntity();
                        //全体无考勤就餐数据时
                        if (kqMor==0){noMor="无上午上课记录";}
                        if (kqAft==0){noAfter="无下午上课记录";}
                        if (jcBF==0){noBF="无早餐记录";}
                        if (jcLun==0){noLun="无中餐记录";}
                        if (jcDin==0){noDin="无晚餐记录";}
                        if (kqNight==0){noNight="无宿舍打卡记录";}

                        dxRecordEntity.setDeptId(dptid);
                        dxRecordEntity.setDeptName(dptname);
                        dxRecordEntity.setPeoCt(stuCT);
                        dxRecordEntity.setCtTime(qts);
                        dxRecordEntity.setCtMorning(kqMor);
                        dxRecordEntity.setPeoMorning(noMor);
                        dxRecordEntity.setCtAfternoon(kqAft);
                        dxRecordEntity.setPeoAfternoon(noAfter);
                        dxRecordEntity.setCtBFast(jcBF);
                        dxRecordEntity.setPeoBFast(noBF);
                        dxRecordEntity.setCtLunch(jcLun);
                        dxRecordEntity.setPeoLunch(noLun);
                        dxRecordEntity.setCtDinner(jcDin);
                        dxRecordEntity.setPeoDinner(noDin);
                        dxRecordEntity.setCtNight(kqNight);
                        dxRecordEntity.setPeoNight(noNight);

                        dxRecordRepository.saveAndFlush(dxRecordEntity);

                        System.out.println("------"+dptname+"-统计信息已保存-------");
                    }
                }

            }

            System.out.println("执行时间"+fmt.format(Calendar.getInstance().getTime()));
        } catch (Exception e) {
            System.out.println("-------------解析信息发生异常--------------");
        }
    }

}
